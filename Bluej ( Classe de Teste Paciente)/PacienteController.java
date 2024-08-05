
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PacienteController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField idadeField;

    @FXML
    private TextField sexoField;

    @FXML
    private TableView<Paciente> pacienteTable;

    @FXML
    private TableColumn<Paciente, Integer> idColumn;

    @FXML
    private TableColumn<Paciente, String> nomeColumn;

    @FXML
    private TableColumn<Paciente, Integer> idadeColumn;

    @FXML
    private TableColumn<Paciente, String> sexoColumn;

    @FXML
    private TableColumn<Paciente, String> resultadosColumn;

    private PacienteRepository pacienteRepository;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        resultadosColumn.setCellValueFactory(new PropertyValueFactory<>("resultados"));

        try {
            String databasePath = System.getProperty("user.dir") + "/pacientes.db";
            Database db = new Database(databasePath);
            pacienteRepository = new PacienteRepository(db.getConnection());
            carregarPacientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void adicionarPaciente() {
        try {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            char sexo = sexoField.getText().charAt(0);

            Paciente paciente = new Paciente(nome, idade, sexo);
            pacienteRepository.create(paciente);
            pacienteTable.getItems().add(paciente);

            nomeField.clear();
            idadeField.clear();
            sexoField.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarPacientes() {
        try {
            for (Paciente paciente : pacienteRepository.obterTodosPacientes()) {
                pacienteTable.getItems().add(paciente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
