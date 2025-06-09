package pe.edu.upc.selecia_backend.dtos;

public class HabilidadDTO {
    private Integer id;
    private String habilidad;

    // Constructor vacío
    public HabilidadDTO() {
    }

    // Constructor con argumentos
    public HabilidadDTO(Integer id, String habilidad) {
        this.id = id;
        this.habilidad = habilidad;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
