// SimilaridadExplainRequest.java
package pe.edu.upc.selecia_backend.dtos;

import java.util.Map;

public class SimilaridadExplainRequest {
    private Map<String, String> puesto;
    private Map<String, String> candidato;

    public SimilaridadExplainRequest(Map<String, String> puesto, Map<String, String> candidato) {
        this.puesto = puesto; this.candidato = candidato;
    }

    public Map<String, String> getPuesto() { return puesto; }
    public void setPuesto(Map<String, String> puesto) { this.puesto = puesto; }

    public Map<String, String> getCandidato() { return candidato; }
    public void setCandidato(Map<String, String> candidato) { this.candidato = candidato; }
}
