package Controller;

import DAO.UsuarioDAO;
import Entity.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private ComboBox<String> cbGenero;

    @FXML
    private void handleRegister() {
        String nome = txtNome.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        int genero = cbGenero.getSelectionModel().getSelectedIndex();

        Usuario usuario = new Usuario();
        usuario.setGenero(genero);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setNome(nome);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrarUsuario(usuario);

        System.out.println("Usuário registrado com sucesso!");
    }

    @FXML
    private void handleViewHemograma() {
        // Lógica para visualizar os resultados do hemograma
        System.out.println("Visualizar Hemograma!");
    }
}
