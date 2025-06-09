package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "puesto_de_trabajo")
public class PuestoDeTrabajo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPuesto;

    @Column(name = "descripcion",columnDefinition = "text")
    private String descripcion;

    @Column(name = "requisitos",columnDefinition = "text")
    private String requisitos;

    @Column(name = "lugar",length = 100)
    private String lugar;

    @Column(name = "embeddingvector",columnDefinition = "text")
    private String embeddingVector;


    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public PuestoDeTrabajo(Integer idPuesto, String descripcion, String requisitos, String lugar, String embeddingVector, Empresa empresa) {
        this.idPuesto = idPuesto;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.lugar = lugar;
        this.embeddingVector = embeddingVector;
        this.empresa = empresa;
    }

    public String getEmbeddingVector() {
        return embeddingVector;
    }

    public void setEmbeddingVector(String embeddingVector) {
        this.embeddingVector = embeddingVector;
    }

    public PuestoDeTrabajo() {

    }

    public Integer getidPuesto() {
        return idPuesto;
    }

    public void setidPuesto(Integer id_puesto) {
        this.idPuesto = id_puesto;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
