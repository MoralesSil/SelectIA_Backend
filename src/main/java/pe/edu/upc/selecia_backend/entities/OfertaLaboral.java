package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ofertalaboral")
public class OfertaLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idoferta;

    @Column
    private Integer vacantes;

    @ManyToOne
    @JoinColumn(name = "idPuesto")
    private PuestoDeTrabajo puestoDeTrabajo;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "fechacreacion")
    private java.sql.Date fechaCreacion;

    @Column(name = "fechaculminacion")
    private java.sql.Date fechaCulminacion;

    @ManyToOne
    @JoinColumn(name = "idreclutador")
    private PerfilReclutador perfilReclutador;

    public OfertaLaboral() {

    }

    public Integer getIdoferta() {
        return idoferta;
    }

    public OfertaLaboral(Integer idoferta, Integer vacantes, PuestoDeTrabajo puestoDeTrabajo, Boolean estado, Date fechaCreacion, Date fechaCulminacion, PerfilReclutador perfilReclutador) {
        this.idoferta = idoferta;
        this.vacantes = vacantes;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCulminacion = fechaCulminacion;
        this.perfilReclutador = perfilReclutador;
    }

    public void setIdoferta(Integer id_oferta) {
        this.idoferta = id_oferta;
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
