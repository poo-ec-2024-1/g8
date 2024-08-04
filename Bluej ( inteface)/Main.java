import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;

public class Main extends Application {

    private PacienteRepository pacienteRepository;
    private ValoresReferencia valoresReferencia;

    @Override
    public void start(Stage primaryStage) {
        try {
            String databasePath = System.getProperty("user.dir") + "/pacientes.db";
            Database db = new Database(databasePath);
            pacienteRepository = new PacienteRepository(db.getConnection());
            valoresReferencia = new ValoresReferencia();

            primaryStage.setTitle("Sistema de Hemograma");

            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(10);
            grid.setHgap(10);

            // Campos de entrada do paciente
            Label nameLabel = new Label("Nome:");
            GridPane.setConstraints(nameLabel, 0, 0);
            TextField nameInput = new TextField();
            GridPane.setConstraints(nameInput, 1, 0);

            Label ageLabel = new Label("Idade:");
            GridPane.setConstraints(ageLabel, 0, 1);
            TextField ageInput = new TextField();
            GridPane.setConstraints(ageInput, 1, 1);

            Label genderLabel = new Label("Sexo (m/f):");
            GridPane.setConstraints(genderLabel, 0, 2);
            TextField genderInput = new TextField();
            GridPane.setConstraints(genderInput, 1, 2);

            // Escolha da categoria de referência
            Label categoryLabel = new Label("Categoria de Referência:");
            GridPane.setConstraints(categoryLabel, 0, 3);
            ComboBox<String> categoryChoice = new ComboBox<>();
            categoryChoice.getItems().addAll( "Criança (0 a 11 anos)", "Adolescente (12 a 17 anos)","Masculino Adulto (18 a 59 anos)", "Feminino Adulto (18 a 59 anos)", "Masculino Indoso (60 anos ou mais)", "Feminino Idoso (60 anos ou mais)");
            GridPane.setConstraints(categoryChoice, 1, 3);

            // Campos de entrada do hemograma
            Label hemogramLabel = new Label("Dados do Hemograma:");
            GridPane.setConstraints(hemogramLabel, 0, 4);
            GridPane.setColumnSpan(hemogramLabel, 2);

            // Lista de parâmetros do hemograma
            String[] parametros = {
                "Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados",
                "Hemoglobina Celular Média",
                "Hematócrito",
                "Volume Celular Médio",
                "Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes",
                "Contagem Diferencial de Glóbulos Brancos - Basófilos",
                "Amplitude de Distribuição dos Eritrócitos",
                "Contagem Diferencial de Glóbulos Brancos - Linfócitos",
                "Hemoglobina",
                "Contagem Diferencial de Glóbulos Brancos - Monócitos",
                "Contagem de Glóbulos Vermelhos",
                "Concentração de Hemoglobina Celular",
                "Contagem de Glóbulos Brancos",
                "Contagem Diferencial de Glóbulos Brancos - Eosinófilos",
                "Contagem de Plaquetas"
            };

            // Campos de entrada para cada parâmetro
            TextField[] hemogramInputs = new TextField[parametros.length];
            for (int i = 0; i < parametros.length; i++) {
                Label label = new Label(parametros[i] + ":");
                GridPane.setConstraints(label, 0, 5 + i);
                TextField input = new TextField();
                GridPane.setConstraints(input, 1, 5 + i);
                grid.getChildren().addAll(label, input);
                hemogramInputs[i] = input;
            }

            // Botão para processar dados
            Button processButton = new Button("Processar");
            GridPane.setConstraints(processButton, 0, 5 + parametros.length);
            GridPane.setColumnSpan(processButton, 2);

            // Área de resultado
            TextArea resultArea = new TextArea();
            resultArea.setEditable(false);
            GridPane.setConstraints(resultArea, 0, 6 + parametros.length);
            GridPane.setColumnSpan(resultArea, 2);

            processButton.setOnAction(e -> {
                try {
                    String nome = nameInput.getText();
                    int idade = Integer.parseInt(ageInput.getText());
                    char sexo = genderInput.getText().charAt(0);
                    String categoria = categoryChoice.getValue();

                    Paciente paciente = new Paciente(nome, idade, sexo);
                    pacienteRepository.create(paciente);

                    Hemograma hemograma = new Hemograma();
                    for (int i = 0; i < parametros.length; i++) {
                        String parametro = parametros[i];
                        double valor = Double.parseDouble(hemogramInputs[i].getText());
                        hemograma.adicionarValor(parametro, valor);
                    }

                    // Comparação com os valores de referência e armazenamento dos resultados
                    StringBuilder resultados = new StringBuilder();
                    Map<String, FaixaValores> valoresReferenciaUsuario = valoresReferencia.obterValores(categoria);
                    if (valoresReferenciaUsuario == null) {
                        resultArea.setText("Erro: Categoria de referência não encontrada.");
                        return;
                    }
                    for (String parametro : hemograma.valores.keySet()) {
                        double valor = hemograma.obterValor(parametro);
                        FaixaValores faixaValores = valoresReferenciaUsuario.get(parametro);
                        if (faixaValores == null) {
                            resultados.append(parametro).append(": Valor de referência não encontrado.\n");
                        } else if (valor < faixaValores.getMin() || valor > faixaValores.getMax()) {
                            resultados.append(parametro).append(" fora do valor de referência: ").append(valor).append(" ")
                                .append(faixaValores.getUnidade()).append(" (Valor de referência: ")
                                .append(faixaValores.getMin()).append(" - ").append(faixaValores.getMax()).append(" ")
                                .append(faixaValores.getUnidade()).append(")\n");
                        }
                    }

                    // Salvando os resultados no paciente
                    paciente.setResultados(resultados.toString());
                    pacienteRepository.update(paciente);

                    // Exibindo os resultados armazenados
                    Paciente pacienteFromDb = pacienteRepository.read(paciente.getId());
                    resultArea.setText("Resultados armazenados:\n" + pacienteFromDb.getResultados());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultArea.setText("Erro: " + ex.getMessage());
                }
            });

            grid.getChildren().addAll(nameLabel, nameInput, ageLabel, ageInput, genderLabel, genderInput, categoryLabel, categoryChoice, hemogramLabel, processButton, resultArea);

            Scene scene = new Scene(grid, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            // Trate o erro conforme necessário
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
