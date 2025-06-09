package pe.edu.upc.selecia_backend.dtos;

public class PerfilPostulanteDTO {
    private Integer idPerfil;
    private Integer usuarioId;
    private String cvUrl;
    private String textoExtraido;
    private String embeddingVector;

    // Constructor vacío
    public PerfilPostulanteDTO() {}

    // Constructor con argumentos
    public PerfilPostulanteDTO(Integer idPerfil, Integer usuarioId, String cvUrl, String textoExtraido, String embeddingVector) {
        this.idPerfil = idPerfil;
        this.usuarioId = usuarioId;
        this.cvUrl = cvUrl;
        this.textoExtraido = textoExtraido;
        this.embeddingVector = embeddingVector;
    }

    // Getters y setters
    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public String getTextoExtraido() {
        return textoExtraido;
    }

    public void setTextoExtraido(String textoExtraido) {
        this.textoExtraido = textoExtraido;
    }

    public String getEmbeddingVector() {
        return embeddingVector;
    }

    public void setEmbeddingVector(String embeddingVector) {
        this.embeddingVector = embeddingVector;
    }
}
