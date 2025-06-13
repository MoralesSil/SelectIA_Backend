package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Empresa;
import pe.edu.upc.selecia_backend.entities.Usuario;

public class PerfilReclutadorDTO {
    private Integer idReclutador;
    private Integer idUsuario;
    private Empresa empresa;

    public Integer getIdReclutador() {
        return idReclutador;
    }

    public void setIdReclutador(Integer idReclutador) {
        this.idReclutador = idReclutador;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
