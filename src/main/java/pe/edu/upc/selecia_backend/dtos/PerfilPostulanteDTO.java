package pe.edu.upc.selecia_backend.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.selecia_backend.entities.Usuario;

public class PerfilPostulanteDTO {
    private Integer idPerfil;
    private Integer idUsuario;
    private String cvUrl;
    private String textoExtraido;
    private String habilidadesTecnicas;
    private String habilidadesBlandas;
    private String Educacion;
    private String Experiencia;
    private String certificaciones;
    private String setEmbEducacion;
    private String setEmbExperiencia;
    private String setEmbHabTec;
    private String setEmbHabBlandas;
    private String setcertificaciones;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    public String getSetEmbEducacion() {
        return setEmbEducacion;
    }

    public void setSetEmbEducacion(String setEmbEducacion) {
        this.setEmbEducacion = setEmbEducacion;
    }

    public String getSetEmbExperiencia() {
        return setEmbExperiencia;
    }

    public void setSetEmbExperiencia(String setEmbExperiencia) {
        this.setEmbExperiencia = setEmbExperiencia;
    }

    public String getSetEmbHabTec() {
        return setEmbHabTec;
    }

    public void setSetEmbHabTec(String setEmbHabTec) {
        this.setEmbHabTec = setEmbHabTec;
    }

    public String getSetEmbHabBlandas() {
        return setEmbHabBlandas;
    }

    public void setSetEmbHabBlandas(String setEmbHabBlandas) {
        this.setEmbHabBlandas = setEmbHabBlandas;
    }

    public String getSetcertificaciones() {
        return setcertificaciones;
    }

    public void setSetcertificaciones(String setcertificaciones) {
        this.setcertificaciones = setcertificaciones;
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

    public String getHabilidadesTecnicas() {
        return habilidadesTecnicas;
    }

    public void setHabilidadesTecnicas(String habilidadesTecnicas) {
        this.habilidadesTecnicas = habilidadesTecnicas;
    }

    public String getHabilidadesBlandas() {
        return habilidadesBlandas;
    }

    public void setHabilidadesBlandas(String habilidadesBlandas) {
        this.habilidadesBlandas = habilidadesBlandas;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
}
