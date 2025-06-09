package pe.edu.upc.selecia_backend.dtos;

import java.sql.Date;

public class ExperienciaDTO {
    private Integer idExperiencia;
    private String empresa;
    private String puesto;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private Integer perfilPostulanteId; // Solo el id para evitar incluir toda la entidad

    // Getters y setters

    public Integer getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Integer idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPerfilPostulanteId() {
        return perfilPostulanteId;
    }

    public void setPerfilPostulanteId(Integer perfilPostulanteId) {
        this.perfilPostulanteId = perfilPostulanteId;
    }
}
