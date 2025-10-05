// SimilaridadExplainResponse.java
package pe.edu.upc.selecia_backend.dtos;

import java.util.Map;

public class SimilaridadExplainResponse {
    private Map<String, Double> resultados;
    private Map<String, String> explicaciones;

    public Map<String, Double> getResultados() { return resultados; }
    public void setResultados(Map<String, Double> resultados) { this.resultados = resultados; }

    public Map<String, String> getExplicaciones() { return explicaciones; }
    public void setExplicaciones(Map<String, String> explicaciones) { this.explicaciones = explicaciones; }
}
