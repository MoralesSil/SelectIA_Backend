// src/main/java/pe/edu/upc/selecia_backend/util/EmbeddingUtils.java
package pe.edu.upc.selecia_backend.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class EmbeddingUtils {
    public static List<Double> parseEmbedding(String embeddingVectorJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(embeddingVectorJson, new TypeReference<List<Double>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
