package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "perfilpostulante")
public class PerfilPostulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idperfil;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Column(name = "cvurl")
    private String cvUrl;

    @Column(name = "textoextraido", columnDefinition = "text")
    private String textoExtraido;

    @Column(name = "embeddingvector", columnDefinition = "text")
    private String embeddingVector;

    @Column(name = "Habilidades", columnDefinition = "text")
    private String Habilidades;

    @Column(name = "Experiencia", columnDefinition = "text")
    private String Experiencia;

    @Column(name = "Educación", columnDefinition = "text")
    private String Educacion;


    public PerfilPostulante() {

    }

    public PerfilPostulante(Integer idperfil, Usuario usuario, String cvUrl, String textoExtraido, String embeddingVector, String habilidades, String experiencia, String educacion) {
        this.idperfil = idperfil;
        this.usuario = usuario;
        this.cvUrl = cvUrl;
        this.textoExtraido = textoExtraido;
        this.embeddingVector = embeddingVector;
        this.Habilidades = habilidades;
        this.Experiencia = experiencia;
        this.Educacion = educacion;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer id_perfil) {
        this.idperfil = id_perfil;
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

    public String getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(String habilidades) {
        Habilidades = habilidades;
    }

    public String getEducacion() {
        return Educacion;
    }

    public void setEducacion(String educación) {
        Educacion = educación;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
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

