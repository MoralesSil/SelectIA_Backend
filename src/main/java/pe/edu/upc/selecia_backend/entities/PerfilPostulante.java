package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "perfil_postulante")
public class PerfilPostulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_perfil;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @Column(name = "cv_url", length = 255)
    private String cvUrl;

    @Column(name = "texto_extraido", columnDefinition = "text")
    private String textoExtraido;

    @Column(name = "embedding_vector", columnDefinition = "json")
    private String embeddingVector;

    public PerfilPostulante() {

    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public PerfilPostulante(Integer id_perfil, Usuario usuario, String cvUrl, String textoExtraido, String embeddingVector) {
        this.id_perfil = id_perfil;
        this.usuario = usuario;
        this.cvUrl = cvUrl;
        this.textoExtraido = textoExtraido;
        this.embeddingVector = embeddingVector;
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

