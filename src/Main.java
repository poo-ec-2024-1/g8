
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Método para obter a categoria de referência do usuário
    public static String obterCategoriaReferencia(Scanner scanner) {
        System.out.println("Escolha a categoria de referência para comparação:");
        System.out.println("1. Homem adulto");
        System.out.println("2. Mulher adulta");
        System.out.println("3. Criança");
        System.out.println("4. Adolescente");
        System.out.println("5. Homem idoso");
        System.out.println("6. Mulher idosa");
        System.out.print("Digite o número correspondente à sua escolha (1 a 6): ");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                return "Adulto-Masculino";
            case 2:
                return "Adulto-Feminino";
            case 3:
                return "Criança";
            case 4:
                return "Adolescente";
            case 5:
                return "Idoso-Masculino";
            case 6:
                return "Idoso-Feminino";
            default:
                System.out.println("Escolha inválida. Usando padrão Homem adulto.");
                return "Adulto-Masculino";
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Especificando o caminho do banco de dados
        String databasePath = System.getProperty("user.dir") + "/pacientes.db";
        Database db = new Database(databasePath);
        PacienteRepository pacienteRepository = new PacienteRepository(db.getConnection());

        // Criando um novo paciente
        System.out.print("Nome do paciente: ");
        String nome = scanner.next();
        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        System.out.print("Sexo do paciente (m/f): ");
        char sexo = scanner.next().charAt(0);

        Paciente paciente = new Paciente(nome, idade, sexo);
        pacienteRepository.create(paciente);

        // Criação dos valores de referência
        ValoresReferencia valoresReferencia = new ValoresReferencia();

        // Obtendo a categoria de referência do usuário
        String categoria = obterCategoriaReferencia(scanner);

        // Solicitar dados do hemograma
        Hemograma hemograma = new Hemograma();
        System.out.println("Insira os dados do hemograma:");
        for (String parametro : valoresReferencia.obterValores(categoria).keySet()) {
            System.out.print(parametro + ": ");
            double valor = scanner.nextDouble();
            hemograma.adicionarValor(parametro, valor);
        }

        // Comparação com os valores de referência e armazenamento dos resultados
        StringBuilder resultados = new StringBuilder();
        Map<String, FaixaValores> valoresReferenciaUsuario = valoresReferencia.obterValores(categoria);
        for (String parametro : hemograma.valores.keySet()) {
            double valor = hemograma.obterValor(parametro);
            FaixaValores faixaValores = valoresReferenciaUsuario.get(parametro);
            if (valor < faixaValores.getMin() || valor > faixaValores.getMax()) {
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
        System.out.println("Resultados armazenados:\n" + pacienteFromDb.getResultados());

        // Fechando a conexão com o banco de dados
        pacienteRepository.close();
        db.close();
        scanner.close();
    }
}
