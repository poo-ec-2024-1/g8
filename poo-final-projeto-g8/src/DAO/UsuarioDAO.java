package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexao.Conexao;
import Entity.Usuario;

// Método para cadastro de usuário no banco de dados

public class UsuarioDAO {
    
    public void cadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO usuario (GENERO, LOGIN, SENHA, NOME) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, usuario.getGenero());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getNome());

            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
