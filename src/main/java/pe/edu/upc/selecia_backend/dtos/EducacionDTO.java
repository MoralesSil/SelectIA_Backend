package pe.edu.upc.selecia_backend.dtos;

import java.sql.Date;

public class EducacionDTO {
    private Integer idEducacion;
    private String institucion;
    private String titulo;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private Integer perfilPostulanteId; // Solo el id del perfil para evitar ciclos o información redundante

    // Getters y setters

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPerfilPostulanteId() {
        return perfilPostulanteId;
    }

    public void setPerfilPostulanteId(Integer perfilPostulanteId) {
        this.perfilPostulanteId = perfilPostulanteId;
    }
}
