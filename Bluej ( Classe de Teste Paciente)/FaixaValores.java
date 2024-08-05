public class FaixaValores {
    private double minimo;
    private double maximo;
    private String unidade;

    public FaixaValores(double minimo, double maximo, String unidade) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.unidade = unidade;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public String getUnidade() {
        return unidade;
    }
}
