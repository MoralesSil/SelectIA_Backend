package pe.edu.upc.selecia_backend.dtos;

public class RolDTO {
    private Integer idRol;
    private String rol;
    private Integer usuarioId; // Puede ser null

    // Constructor vacío
    public RolDTO() {}

    // Constructor con argumentos
    public RolDTO(Integer idRol, String rol, Integer usuarioId) {
        this.idRol = idRol;
        this.rol = rol;
        this.usuarioId = usuarioId;
    }

    // Getters y setters
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
