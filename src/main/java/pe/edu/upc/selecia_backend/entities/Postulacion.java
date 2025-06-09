package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "postulacion")
public class Postulacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpostulacion;

    @Column(name = "fechapostulacion")
    private java.sql.Date fechaPostulacion;

    @ManyToOne
    @JoinColumn(name = "idperfil")
    private PerfilPostulante perfilPostulante;

    @ManyToOne
    @JoinColumn(name = "idoferta")
    private OfertaLaboral ofertaLaboral;

    @Column
    private Boolean estado;

    public Postulacion(Integer idpostulacion, Date fechaPostulacion, PerfilPostulante perfilPostulante, OfertaLaboral ofertaLaboral, Boolean estado) {
        this.idpostulacion = idpostulacion;
        this.fechaPostulacion = fechaPostulacion;
        this.perfilPostulante = perfilPostulante;
        this.ofertaLaboral = ofertaLaboral;
        this.estado = estado;
    }

    public Postulacion() {

    }

    public Integer getIdpostulacion() {
        return idpostulacion;
    }

    public void setIdpostulacion(Integer id_postulacion) {
        this.idpostulacion = id_postulacion;
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

}
