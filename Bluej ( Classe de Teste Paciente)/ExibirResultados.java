import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ExibirResultados {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/ikerm/Desktop/ProjetoPOO-copy/pacientes.db";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Exibir todos os resultados");
        System.out.println("2. Exibir resultados de um ID específico");
        System.out.print("Digite o número correspondente à sua escolha (1 ou 2): ");
        int opcao = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(url)) {
            if (opcao == 1) {
                // Exibir todos os resultados
                String sql = "SELECT * FROM paciente";
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        int idade = rs.getInt("idade");
                        String sexo = rs.getString("sexo");
                        String resultados = rs.getString("resultados");

                        System.out.println("ID: " + id);
                        System.out.println("Nome: " + nome);
                        System.out.println("Idade: " + idade);
                        System.out.println("Sexo: " + sexo);
                        System.out.println("Resultados: " + resultados);
                        System.out.println(); // Quebra de linha entre registros
                    }
                }
            } else if (opcao == 2) {
                // Solicitar ID do usuário
                System.out.print("Digite o ID do paciente para consulta: ");
                int id = scanner.nextInt();

                // Exibir resultado para o ID especificado
                String sql = "SELECT * FROM paciente WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, id);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            String nome = rs.getString("nome");
                            int idade = rs.getInt("idade");
                            String sexo = rs.getString("sexo");
                            String resultados = rs.getString("resultados");

                            System.out.println("ID: " + id);
                            System.out.println("Nome: " + nome);
                            System.out.println("Idade: " + idade);
                            System.out.println("Sexo: " + sexo);
                            System.out.println("Resultados: " + resultados);
                        } else {
                            System.out.println("Nenhum paciente encontrado com o ID especificado.");
                        }
                    }
                }
            } else {
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
