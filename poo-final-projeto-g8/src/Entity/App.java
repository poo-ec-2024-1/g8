package Entity; 
import DAO.UsuarioDAO;

// Classe para cadastrar usuários no banco de dados MySql

public class App {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setGenero(1); 
        usuario.setLogin("Iker");
        usuario.setSenha("senha123");
        usuario.setNome("Iker Marciel_a");
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrarUsuario(usuario);
    }
}
