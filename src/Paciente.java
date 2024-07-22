
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "paciente")
public class Paciente {

    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(canBeNull = false)
    private String nome;
    
    @DatabaseField(canBeNull = false)
    private int idade;
    
    @DatabaseField(canBeNull = false)
    private char sexo; // 'm' para masculino e 'f' para feminino
    
    @DatabaseField(canBeNull = true)
    private String resultados;

    // Construtor padrão obrigatório para ORMLite
    public Paciente() {
    }
    
    public Paciente(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    // Getters e Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                ", resultados='" + resultados + '\'' +
                '}';
    }
}
