package pe.edu.upc.selecia_backend.dtos;

public class NotificacionesDTO {
    private Integer idNotificacion;
    private String descripcion;
    private Integer tipo;
    private Integer estado;
    private Integer usuarioId; // Solo el id del usuario asociado

    // Constructor vacío
    public NotificacionesDTO() {}

    // Constructor con argumentos
    public NotificacionesDTO(Integer idNotificacion, String descripcion, Integer tipo, Integer estado, Integer usuarioId) {
        this.idNotificacion = idNotificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    // Getters y setters
    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
