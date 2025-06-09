package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Empresa;
import pe.edu.upc.selecia_backend.entities.Usuario;

public class PerfilReclutadorDTO {
    private Integer idReclutador;
    private Usuario usuario;
    private Empresa empresa;

    public Integer getIdReclutador() {
        return idReclutador;
    }

    public void setIdReclutador(Integer idReclutador) {
        this.idReclutador = idReclutador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
