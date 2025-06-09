package pe.edu.upc.selecia_backend.dtos;

import java.sql.Date;

public class OfertaLaboralDTO {
    private Integer idOferta;
    private Integer vacantes;
    private Integer puestoDeTrabajoId;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaCulminacion;
    private Integer perfilReclutadorId;

    // Constructor vacío
    public OfertaLaboralDTO() {}

    // Constructor con argumentos
    public OfertaLaboralDTO(Integer idOferta, Integer vacantes, Integer puestoDeTrabajoId, Boolean estado, Date fechaCreacion, Date fechaCulminacion, Integer perfilReclutadorId) {
        this.idOferta = idOferta;
        this.vacantes = vacantes;
        this.puestoDeTrabajoId = puestoDeTrabajoId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCulminacion = fechaCulminacion;
        this.perfilReclutadorId = perfilReclutadorId;
    }

    // Getters y setters
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

    public Integer getPuestoDeTrabajoId() {
        return puestoDeTrabajoId;
    }

    public void setPuestoDeTrabajoId(Integer puestoDeTrabajoId) {
        this.puestoDeTrabajoId = puestoDeTrabajoId;
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

    public Integer getPerfilReclutadorId() {
        return perfilReclutadorId;
    }

    public void setPerfilReclutadorId(Integer perfilReclutadorId) {
        this.perfilReclutadorId = perfilReclutadorId;
    }
}
