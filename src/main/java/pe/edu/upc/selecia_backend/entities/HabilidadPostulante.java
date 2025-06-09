package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "habilidadpostulante")
public class HabilidadPostulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idperfil")
    private PerfilPostulante perfilPostulante;

    @Column(length = 50)
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "habilidadid")
    private Habilidad habilidad;

    public HabilidadPostulante() {

    }

    public Integer getId() {
        return id;
    }

    public HabilidadPostulante(Integer id, PerfilPostulante perfilPostulante, String nivel, Habilidad habilidad) {
        this.id = id;
        this.perfilPostulante = perfilPostulante;
        this.nivel = nivel;
        this.habilidad = habilidad;
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
