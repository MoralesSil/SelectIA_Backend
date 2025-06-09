package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "oferta_laboral")
public class OfertaLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_oferta;

    @Column
    private Integer vacantes;

    @ManyToOne
    @JoinColumn(name = "puesto_de_trabajo_id_puesto")
    private PuestoDeTrabajo puestoDeTrabajo;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "fecha_creacion")
    private java.sql.Date fechaCreacion;

    @Column(name = "fecha_culminacion")
    private java.sql.Date fechaCulminacion;

    @ManyToOne
    @JoinColumn(name = "perfil_reclutador_id_reclutador")
    private PerfilReclutador perfilReclutador;

    public OfertaLaboral() {

    }

    public Integer getId_oferta() {
        return id_oferta;
    }

    public OfertaLaboral(Integer id_oferta, Integer vacantes, PuestoDeTrabajo puestoDeTrabajo, Boolean estado, Date fechaCreacion, Date fechaCulminacion, PerfilReclutador perfilReclutador) {
        this.id_oferta = id_oferta;
        this.vacantes = vacantes;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCulminacion = fechaCulminacion;
        this.perfilReclutador = perfilReclutador;
    }

    public void setId_oferta(Integer id_oferta) {
        this.id_oferta = id_oferta;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public PuestoDeTrabajo getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(PuestoDeTrabajo puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(Date fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }

    public PerfilReclutador getPerfilReclutador() {
        return perfilReclutador;
    }

    public void setPerfilReclutador(PerfilReclutador perfilReclutador) {
        this.perfilReclutador = perfilReclutador;
    }
}
