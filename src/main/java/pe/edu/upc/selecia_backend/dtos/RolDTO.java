package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Usuario;

public class RolDTO {
    private Integer idRol;
    private String rol;
    private Usuario usuario; // Puede ser null

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
