package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Usuario;

public class PerfilPostulanteDTO {
    private Integer idPerfil;
    private Integer idUsuario;
    private String cvUrl;
    private String textoExtraido;
    private String Habilidades;
    private String Educacion;
    private String Experiencia;
    private String embeddingVector;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmbeddingVector() {
        return embeddingVector;
    }

    public void setEmbeddingVector(String embeddingVector) {
        this.embeddingVector = embeddingVector;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }

    public String getEducacion() {
        return Educacion;
    }

    public void setEducacion(String educacion) {
        Educacion = educacion;
    }

    public String getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(String habilidades) {
        Habilidades = habilidades;
    }

    public String getTextoExtraido() {
        return textoExtraido;
    }

    public void setTextoExtraido(String textoExtraido) {
        this.textoExtraido = textoExtraido;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }


    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
}
