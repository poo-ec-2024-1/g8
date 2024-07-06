package Entity;
public class Usuario {

    private String nome;
    private int genero;
    private String login;
    private String senha;

    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getGenero() {
        return genero;
    }
    public void setGenero(int genero) {
        this.genero = genero;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
