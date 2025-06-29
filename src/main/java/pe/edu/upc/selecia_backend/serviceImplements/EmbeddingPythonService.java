package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class EmbeddingPythonService {

    private final WebClient webClient = WebClient.create("https://sbert-microservicio-490119044745.us-central1.run.app");

    // Obtiene el embedding para un texto
    public List<Double> getEmbedding(String text) {
        EmbeddingRequest req = new EmbeddingRequest(text);
        EmbeddingResponse resp = webClient.post()
                .uri("/embedding")
                .body(Mono.just(req), EmbeddingRequest.class)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .block();
        return resp.embedding;
    }

    // Pide la similitud con todos los candidatos
    public List<Double> getSimilaritiesWithEmbedding(List<Double> embeddingPuesto, List<List<Double>> embeddingsCandidatos) {
        SimilarityRequest req = new SimilarityRequest(embeddingPuesto, embeddingsCandidatos);
        SimilarityResponse resp = webClient.post()
                .uri("/similarity")
                .body(Mono.just(req), SimilarityRequest.class)
                .retrieve()
                .bodyToMono(SimilarityResponse.class)
                .block();
        return resp.scores;
    }

    // Clases internas para request/response
    static class EmbeddingRequest { public String text; public EmbeddingRequest(String t) { this.text = t; } }
    static class EmbeddingResponse { public List<Double> embedding; }
    static class SimilarityRequest {
        public List<Double> jd_embedding; // <--- CAMBIA EL NOMBRE Y EL TIPO
        public List<List<Double>> candidates;
        public SimilarityRequest(List<Double> jd_embedding, List<List<Double>> candidates) {
            this.jd_embedding = jd_embedding;
            this.candidates = candidates;
        }
    }

    static class SimilarityResponse { public List<Double> scores; }
}
