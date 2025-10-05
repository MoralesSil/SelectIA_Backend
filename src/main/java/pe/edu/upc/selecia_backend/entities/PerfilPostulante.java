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

    @Column(name = "setEmbEducacion", columnDefinition = "text")
    private String setEmbEducacion;

    @Column(name = "setEmbExperiencia", columnDefinition = "text")
    private String setEmbExperiencia;

    @Column(name = "setEmbHabTec", columnDefinition = "text")
    private String setEmbHabTec;

    @Column(name = "setEmbHabBlandas", columnDefinition = "text")
    private String setEmbHabBlandas;

    @Column(name = "setcertificaciones", columnDefinition = "text")
    private String setcertificaciones;

    @Column(name = "habilidadesTecnicas", columnDefinition = "text")
    private String habilidadesTecnicas;

    @Column(name = "habilidadesBlandas", columnDefinition = "text")
    private String habilidadesBlandas;

    @Column(name = "Experiencia", columnDefinition = "text")
    private String Experiencia;

    @Column(name = "Educación", columnDefinition = "text")
    private String Educacion;

    @Column(name = "certificaciones", columnDefinition = "text")
    private String certificaciones;


    public PerfilPostulante() {

    }

    public PerfilPostulante(Integer idperfil, Usuario usuario, String cvUrl, String textoExtraido, String setEmbEducacion, String setEmbExperiencia, String setEmbHabTec, String setEmbHabBlandas, String setcertificaciones, String habilidadesTecnicas, String habilidadesBlandas, String experiencia, String educacion, String certificaciones) {
        this.idperfil = idperfil;
        this.usuario = usuario;
        this.cvUrl = cvUrl;
        this.textoExtraido = textoExtraido;
        this.setEmbEducacion = setEmbEducacion;
        this.setEmbExperiencia = setEmbExperiencia;
        this.setEmbHabTec = setEmbHabTec;
        this.setEmbHabBlandas = setEmbHabBlandas;
        this.setcertificaciones = setcertificaciones;
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.habilidadesBlandas = habilidadesBlandas;
        Experiencia = experiencia;
        Educacion = educacion;
        this.certificaciones = certificaciones;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
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

    public String getTextoExtraido() {
        return textoExtraido;
    }

    public void setTextoExtraido(String textoExtraido) {
        this.textoExtraido = textoExtraido;
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

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
}

