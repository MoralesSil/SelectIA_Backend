package pe.edu.upc.selecia_backend.dtos;

import java.sql.Date;

public class PostulacionDTO {
    private Integer idPostulacion;
    private Date fechaPostulacion;
    private Integer perfilPostulanteId;
    private Integer ofertaLaboralId;
    private Boolean estado;
    private Integer score;

    // Constructor vacío
    public PostulacionDTO() {}

    // Constructor con argumentos
    public PostulacionDTO(Integer idPostulacion, Date fechaPostulacion, Integer perfilPostulanteId, Integer ofertaLaboralId, Boolean estado, Integer score) {
        this.idPostulacion = idPostulacion;
        this.fechaPostulacion = fechaPostulacion;
        this.perfilPostulanteId = perfilPostulanteId;
        this.ofertaLaboralId = ofertaLaboralId;
        this.estado = estado;
        this.score = score;
    }

    // Getters y setters

    public Integer getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(Integer idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Integer getPerfilPostulanteId() {
        return perfilPostulanteId;
    }

    public void setPerfilPostulanteId(Integer perfilPostulanteId) {
        this.perfilPostulanteId = perfilPostulanteId;
    }

    public Integer getOfertaLaboralId() {
        return ofertaLaboralId;
    }

    public void setOfertaLaboralId(Integer ofertaLaboralId) {
        this.ofertaLaboralId = ofertaLaboralId;
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
