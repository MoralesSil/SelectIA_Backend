package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "puesto_de_trabajo")
public class PuestoDeTrabajo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_puesto;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 255)
    private String requisitos;

    @Column(length = 100)
    private String lugar;

    @Column(name = "embedding_vector", columnDefinition = "json")
    private String embeddingVector;


    @ManyToOne
    @JoinColumn(name = "empresa_id_empresa")
    private Empresa empresa;

    public PuestoDeTrabajo(Integer id_puesto, String descripcion, String requisitos, String lugar, String embeddingVector, Empresa empresa) {
        this.id_puesto = id_puesto;
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

    public Integer getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(Integer id_puesto) {
        this.id_puesto = id_puesto;
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
