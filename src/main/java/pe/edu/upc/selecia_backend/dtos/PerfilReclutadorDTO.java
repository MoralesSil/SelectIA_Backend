package pe.edu.upc.selecia_backend.dtos;

public class PerfilReclutadorDTO {
    private Integer idReclutador;
    private Integer usuarioId;
    private Integer empresaId;

    // Constructor vacío
    public PerfilReclutadorDTO() {}

    // Constructor con argumentos
    public PerfilReclutadorDTO(Integer idReclutador, Integer usuarioId, Integer empresaId) {
        this.idReclutador = idReclutador;
        this.usuarioId = usuarioId;
        this.empresaId = empresaId;
    }

    // Getters y setters
    public Integer getIdReclutador() {
        return idReclutador;
    }

    public void setIdReclutador(Integer idReclutador) {
        this.idReclutador = idReclutador;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }
}
