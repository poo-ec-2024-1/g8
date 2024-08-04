
 
import java.util.HashMap;
import java.util.Map;

// Classe para representar um hemograma
class Hemograma {
    Map<String, Double> valores;

    public Hemograma() {
        this.valores = new HashMap<>();
    }

    // Adicionar um valor ao hemograma
    public void adicionarValor(String parametro, double valor) {
        this.valores.put(parametro, valor);
    }

    // Obter um valor do hemograma
    public double obterValor(String parametro) {
        return this.valores.get(parametro);
    }
}

//
