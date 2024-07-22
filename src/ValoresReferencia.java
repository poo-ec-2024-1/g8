
 
import java.util.HashMap;
import java.util.Map;

// Classe para armazenar os valores referência por idade e gênero
class ValoresReferencia {
    private Map<String, Map<String, FaixaValores>> valores;

    public ValoresReferencia() {
        this.valores = new HashMap<>();
        
        // Adicionando os valores de referência para um homem adulto
        Map<String, FaixaValores> valoresHomemAdulto = new HashMap<>();
        // Valores para eritrograma em homem adulto
        valoresHomemAdulto.put("Hemoglobina", new FaixaValores(13.0, 18.0, "g/dL"));
        valoresHomemAdulto.put("Hematócrito", new FaixaValores(38, 52, "%"));
        valoresHomemAdulto.put("Volume Celular Médio", new FaixaValores(80.0, 100.0, "fL"));
        valoresHomemAdulto.put("Hemoglobina Celular Média", new FaixaValores(27.0, 32.0, "pg"));
        valoresHomemAdulto.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 36.0, "g/dL"));
        valoresHomemAdulto.put("Contagem de Glóbulos Vermelhos", new FaixaValores(4.2, 5.9, "milhões/µL"));
        valoresHomemAdulto.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10, 16, "%"));
        // Valores para leucograma em homem adulto
        valoresHomemAdulto.put("Contagem de Glóbulos Brancos", new FaixaValores(4000, 11000, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 800, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1600, 8000, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(900, 4000, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 1000, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 500, "/µL"));
        valoresHomemAdulto.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em homem adulto
        valoresHomemAdulto.put("Contagem de Plaquetas", new FaixaValores(140000, 450000, "/µL"));

        this.valores.put("Adulto-Masculino", valoresHomemAdulto);
        
        // Adicionando os valores de referência para uma mulher adulta
        Map<String, FaixaValores> valoresMulherAdulta = new HashMap<>();
        // Valores para eritrograma em mulher adulta
        valoresMulherAdulta.put("Hemoglobina", new FaixaValores(12.0, 16.0, "g/dL"));
        valoresMulherAdulta.put("Hematócrito", new FaixaValores(35, 47, "%"));
        valoresMulherAdulta.put("Volume Celular Médio", new FaixaValores(80.0, 100.0, "fL"));
        valoresMulherAdulta.put("Hemoglobina Celular Média", new FaixaValores(27.0, 32.0, "pg"));
        valoresMulherAdulta.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 36.0, "g/dL"));
        valoresMulherAdulta.put("Contagem de Glóbulos Vermelhos", new FaixaValores(3.9, 5.4, "milhões/µL"));
        valoresMulherAdulta.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10, 16, "%"));
        // Valores para leucograma em mulher adulta
        valoresMulherAdulta.put("Contagem de Glóbulos Brancos", new FaixaValores(4000, 11000, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 800, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1600, 8000, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(900, 4000, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 1000, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 500, "/µL"));
        valoresMulherAdulta.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em mulher adulta
        valoresMulherAdulta.put("Contagem de Plaquetas", new FaixaValores(150000, 450000, "/µL"));

        this.valores.put("Adulto-Feminino", valoresMulherAdulta);

        // Adicionando os valores de referência para uma criança
        Map<String, FaixaValores> valoresCrianca = new HashMap<>();
        // Valores para eritrograma em criança
        valoresCrianca.put("Hemoglobina", new FaixaValores(14.0, 22.0, "g/dL"));
        valoresCrianca.put("Hematócrito", new FaixaValores(45, 77, "%"));
        valoresCrianca.put("Volume Celular Médio", new FaixaValores(92, 120, "fL"));
        valoresCrianca.put("Hemoglobina Celular Média", new FaixaValores(31, 37, "pg"));
        valoresCrianca.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 37.0, "g/dL"));
        valoresCrianca.put("Contagem de Glóbulos Vermelhos", new FaixaValores(4.0, 7.0, "milhões/µL"));
        valoresCrianca.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10.0, 16.0, "%"));
        // Valores para leucograma em criança
        valoresCrianca.put("Contagem de Glóbulos Brancos", new FaixaValores(4000, 11000, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 800, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1600, 8000, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(900, 4000, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 1000, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 500, "/µL"));
        valoresCrianca.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em criança
        valoresCrianca.put("Contagem de Plaquetas", new FaixaValores(150000, 450000, "/µL"));

        this.valores.put("Criança", valoresCrianca);

        // Adicionando os valores de referência para um adolescente
        Map<String, FaixaValores> valoresAdolescente = new HashMap<>();
        // Valores para eritrograma em adolescente
        valoresAdolescente.put("Hemoglobina", new FaixaValores(12.0, 15.5, "g/dL"));
        valoresAdolescente.put("Hematócrito", new FaixaValores(36, 46, "%"));
        valoresAdolescente.put("Volume Celular Médio", new FaixaValores(80.0, 100.0, "fL"));
        valoresAdolescente.put("Hemoglobina Celular Média", new FaixaValores(27.0, 32.0, "pg"));
        valoresAdolescente.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 36.0, "g/dL"));
        valoresAdolescente.put("Contagem de Glóbulos Vermelhos", new FaixaValores(4.0, 5.5, "milhões/µL"));
        valoresAdolescente.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10, 16, "%"));
        // Valores para leucograma em adolescente
        valoresAdolescente.put("Contagem de Glóbulos Brancos", new FaixaValores(4000, 11000, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 800, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1600, 8000, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(900, 4000, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 1000, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 500, "/µL"));
        valoresAdolescente.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em adolescente
        valoresAdolescente.put("Contagem de Plaquetas", new FaixaValores(150000, 400000, "/µL"));

        this.valores.put("Adolescente", valoresAdolescente);

        // Adicionando os valores de referência para um homem idoso
        Map<String, FaixaValores> valoresHomemIdoso = new HashMap<>();
        // Valores para eritrograma em homem idoso
        valoresHomemIdoso.put("Hemoglobina", new FaixaValores(12.0, 15.5, "g/dL"));
        valoresHomemIdoso.put("Hematócrito", new FaixaValores(36, 46, "%"));
        valoresHomemIdoso.put("Volume Celular Médio", new FaixaValores(80.0, 100.0, "fL"));
        valoresHomemIdoso.put("Hemoglobina Celular Média", new FaixaValores(27.0, 32.0, "pg"));
        valoresHomemIdoso.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 36.0, "g/dL"));
        valoresHomemIdoso.put("Contagem de Glóbulos Vermelhos", new FaixaValores(4.0, 5.5, "milhões/µL"));
        valoresHomemIdoso.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10, 16, "%"));
        // Valores para leucograma em homem idoso
        valoresHomemIdoso.put("Contagem de Glóbulos Brancos", new FaixaValores(4000, 10000, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 700, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1500, 7000, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(800, 3000, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 800, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 400, "/µL"));
        valoresHomemIdoso.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em homem idoso
        valoresHomemIdoso.put("Contagem de Plaquetas", new FaixaValores(140000, 400000, "/µL"));

        this.valores.put("Idoso-Masculino", valoresHomemIdoso);

        // Adicionando os valores de referência para uma mulher idosa
        Map<String, FaixaValores> valoresMulherIdosa = new HashMap<>();
        // Valores para eritrograma em mulher idosa
        valoresMulherIdosa.put("Hemoglobina", new FaixaValores(11.5, 15.0, "g/dL"));
        valoresMulherIdosa.put("Hematócrito", new FaixaValores(34, 44, "%"));
        valoresMulherIdosa.put("Volume Celular Médio", new FaixaValores(80.0, 100.0, "fL"));
        valoresMulherIdosa.put("Hemoglobina Celular Média", new FaixaValores(27.0, 32.0, "pg"));
        valoresMulherIdosa.put("Concentração de Hemoglobina Celular", new FaixaValores(31.0, 36.0, "g/dL"));
        valoresMulherIdosa.put("Contagem de Glóbulos Vermelhos", new FaixaValores(3.8, 5.2, "milhões/µL"));
        valoresMulherIdosa.put("Amplitude de Distribuição dos Eritrócitos", new FaixaValores(10, 16, "%"));
        // Valores para leucograma em mulher idosa
        valoresMulherIdosa.put("Contagem de Glóbulos Brancos", new FaixaValores(3800, 10000, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", new FaixaValores(0, 600, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", new FaixaValores(1400, 7000, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Linfócitos", new FaixaValores(800, 3500, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Monócitos", new FaixaValores(100, 700, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", new FaixaValores(0, 400, "/µL"));
        valoresMulherIdosa.put("Contagem Diferencial de Glóbulos Brancos - Basófilos", new FaixaValores(0, 200, "/µL"));
        // Valores para plaquetas em mulher idosa
        valoresMulherIdosa.put("Contagem de Plaquetas", new FaixaValores(150000, 400000, "/µL"));

        this.valores.put("Idoso-Feminino", valoresMulherIdosa);
    }

    // Método para obter os valores referência de uma determinada categoria
    public Map<String, FaixaValores> obterValores(String categoria) {
        return this.valores.get(categoria);
    }
}

// Classe para representar a faixa de valores
class FaixaValores {
    private double min;
    private double max;
    private String unidade;

    public FaixaValores(double min, double max, String unidade) {
        this.min = min;
        this.max = max;
        this.unidade = unidade;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public String getUnidade() {
        return unidade;
    }
}

