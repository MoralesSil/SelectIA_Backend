package pe.edu.upc.selecia_backend.dtos;

public class HabilidadPostulanteDTO {
    private Integer id;
    private Integer perfilPostulanteId; // Solo el id para evitar ciclos
    private String nivel;
    private Integer habilidadId;        // Solo el id, pero puedes agregar el nombre si lo necesitas
    private String habilidadNombre;     // (opcional, para mostrar el nombre de la habilidad)

    // Constructor vacío
    public HabilidadPostulanteDTO() {
    }

    // Constructor con argumentos
    public HabilidadPostulanteDTO(Integer id, Integer perfilPostulanteId, String nivel, Integer habilidadId, String habilidadNombre) {
        this.id = id;
        this.perfilPostulanteId = perfilPostulanteId;
        this.nivel = nivel;
        this.habilidadId = habilidadId;
        this.habilidadNombre = habilidadNombre;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerfilPostulanteId() {
        return perfilPostulanteId;
    }

    public void setPerfilPostulanteId(Integer perfilPostulanteId) {
        this.perfilPostulanteId = perfilPostulanteId;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Integer habilidadId) {
        this.habilidadId = habilidadId;
    }

    public String getHabilidadNombre() {
        return habilidadNombre;
    }

    public void setHabilidadNombre(String habilidadNombre) {
        this.habilidadNombre = habilidadNombre;
    }
}
