package pe.edu.upc.selecia_backend.dtos;

public class PuestoDeTrabajoDTO {
    private Integer idPuesto;
    private String descripcion;
    private String requisitos;
    private String lugar;
    private Integer empresaId;

    // Constructor vacío
    public PuestoDeTrabajoDTO() {}

    // Constructor con argumentos
    public PuestoDeTrabajoDTO(Integer idPuesto, String descripcion, String requisitos, String lugar, Integer empresaId) {
        this.idPuesto = idPuesto;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.lugar = lugar;
        this.empresaId = empresaId;
    }

    // Getters y setters
    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }
}
