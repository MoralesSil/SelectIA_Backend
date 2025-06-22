package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;

import java.sql.Date;

public class VerPostulacionDTO {
    private Integer idPostulacion;
    private Date fechaPostulacion;
    private OfertaLaboral ofertaLaboral;
    private Boolean estado;

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
