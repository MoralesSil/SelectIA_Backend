package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Habilidad;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;

public class HabilidadPostulanteDTO {
    private Integer id;
    private PerfilPostulante perfilPostulante; // Solo el id para evitar ciclos
    private String nivel;
    private Habilidad habilidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PerfilPostulante getPerfilPostulante() {
        return perfilPostulante;
    }

    public void setPerfilPostulante(PerfilPostulante perfilPostulante) {
        this.perfilPostulante = perfilPostulante;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
}
