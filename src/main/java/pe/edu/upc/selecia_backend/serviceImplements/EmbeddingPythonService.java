package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class EmbeddingPythonService {

    private final WebClient webClient = WebClient.create("http://localhost:8000");

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
    public List<Double> getSimilarities(String jdText, List<List<Double>> candidateEmbeddings) {
        SimilarityRequest req = new SimilarityRequest(jdText, candidateEmbeddings);
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
        public String jd_text; public List<List<Double>> candidates;
        public SimilarityRequest(String jd, List<List<Double>> cands) {
            this.jd_text = jd; this.candidates = cands;
        }
    }
    static class SimilarityResponse { public List<Double> scores; }
}
