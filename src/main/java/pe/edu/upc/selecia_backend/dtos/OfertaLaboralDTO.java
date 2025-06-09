package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.PerfilReclutador;
import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;

import java.sql.Date;

public class OfertaLaboralDTO {
    private Integer idOferta;
    private Integer vacantes;
    private PuestoDeTrabajo puestoDeTrabajo;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaCulminacion;
    private PerfilReclutador perfilReclutador;

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
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
