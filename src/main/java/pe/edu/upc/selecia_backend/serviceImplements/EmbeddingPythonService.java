package pe.edu.upc.selecia_backend.serviceImplements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class EmbeddingPythonService {

    private final WebClient webClient =
            WebClient.create("https://sbert-production.up.railway.app");

    // ===== Embedding simple =====
    public List<Double> getEmbedding(String text) {
        EmbeddingRequest req = new EmbeddingRequest(text);
        EmbeddingResponse resp = webClient.post()
                .uri("/embedding")
                .body(Mono.just(req), EmbeddingRequest.class)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .block();
        return resp != null ? resp.getEmbedding() : List.of();
    }

    // ===== Similaridad explicable (SBERT + equivalencias en el micro) =====
    public SimilaridadExplainResponse similaridadExplicable(Map<String, String> puesto,
                                                            Map<String, String> candidato) {
        SimilaridadExplainRequest req = new SimilaridadExplainRequest(puesto, candidato);
        return webClient.post()
                .uri("/similaridad_explicable")
                .body(Mono.just(req), SimilaridadExplainRequest.class)
                .retrieve()
                .bodyToMono(SimilaridadExplainResponse.class)
                .block();
    }

    /* =================== Clases internas =================== */

    // ---- /embedding ----
    public static class EmbeddingRequest {
        private String text;
        public EmbeddingRequest() {}
        public EmbeddingRequest(String t) { this.text = t; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EmbeddingResponse {
        private List<Double> embedding;
        public List<Double> getEmbedding() { return embedding; }
        public void setEmbedding(List<Double> embedding) { this.embedding = embedding; }
    }

    // ---- /similaridad_explicable ----
    public static class SimilaridadExplainRequest {
        private Map<String, String> puesto;
        private Map<String, String> candidato;

        public SimilaridadExplainRequest() {}
        public SimilaridadExplainRequest(Map<String, String> puesto, Map<String, String> candidato) {
            this.puesto = puesto; this.candidato = candidato;
        }
        public Map<String, String> getPuesto() { return puesto; }
        public void setPuesto(Map<String, String> puesto) { this.puesto = puesto; }
        public Map<String, String> getCandidato() { return candidato; }
        public void setCandidato(Map<String, String> candidato) { this.candidato = candidato; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SimilaridadExplainResponse {
        private Map<String, Double> resultados;    // { experiencia: 82.4, ..., TOTAL: 85.2 }
        private Map<String, String> explicaciones; // { educacion: "Ajustada a 90% porque ...", ... }

        public Map<String, Double> getResultados() { return resultados; }
        public void setResultados(Map<String, Double> resultados) { this.resultados = resultados; }
        public Map<String, String> getExplicaciones() { return explicaciones; }
        public void setExplicaciones(Map<String, String> explicaciones) { this.explicaciones = explicaciones; }
    }
}
