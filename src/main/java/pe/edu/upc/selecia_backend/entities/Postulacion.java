package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "postulacion")
public class Postulacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_postulacion;

    @Column(name = "fecha_postulacion")
    private java.sql.Date fechaPostulacion;

    @ManyToOne
    @JoinColumn(name = "perfil_postulante_id_perfil")
    private PerfilPostulante perfilPostulante;

    @ManyToOne
    @JoinColumn(name = "oferta_laboral_id_oferta")
    private OfertaLaboral ofertaLaboral;

    @Column
    private Boolean estado;

    @Column
    private Integer score;

    public Postulacion(Integer id_postulacion, Date fechaPostulacion, PerfilPostulante perfilPostulante, OfertaLaboral ofertaLaboral, Boolean estado, Integer score) {
        this.id_postulacion = id_postulacion;
        this.fechaPostulacion = fechaPostulacion;
        this.perfilPostulante = perfilPostulante;
        this.ofertaLaboral = ofertaLaboral;
        this.estado = estado;
        this.score = score;
    }

    public Postulacion() {

    }

    public Integer getId_postulacion() {
        return id_postulacion;
    }

    public void setId_postulacion(Integer id_postulacion) {
        this.id_postulacion = id_postulacion;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public PerfilPostulante getPerfilPostulante() {
        return perfilPostulante;
    }

    public void setPerfilPostulante(PerfilPostulante perfilPostulante) {
        this.perfilPostulante = perfilPostulante;
    }

    public OfertaLaboral getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(OfertaLaboral ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
