package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "puesto_de_trabajo")
public class PuestoDeTrabajo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPuesto;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "Pais")
    private String Pais;

    @Column(name = "Departamento")
    private String Departamento;

    @Column(name = "Distrito")
    private String Distrito;

    @Column(name = "Categoria")
    private String Categoria;

    @Column(name = "Jornada")
    private String Jornada;

    @Column(name = "Modalidad")
    private String Modalidad;

    @Column(name = "Salario")
    private Double Salario;

    @Column(name = "vacante")
    private Integer vacante;

    @Column(name = "descripcion",columnDefinition = "text")
    private String descripcion;

    @Column(name = "requisitos",columnDefinition = "text")
    private String requisitos;


    @Column(name = "embeddingvector",columnDefinition = "text")
    private String embeddingVector;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public PuestoDeTrabajo() {
    }

    public PuestoDeTrabajo(Integer idPuesto, String titulo, String pais, String departamento, String distrito, String categoria, String jornada, String modalidad, Double salario, Integer vacante, String descripcion, String requisitos, String embeddingVector, Empresa empresa) {
        this.idPuesto = idPuesto;
        this.titulo = titulo;
        Pais = pais;
        Departamento = departamento;
        Distrito = distrito;
        Categoria = categoria;
        Jornada = jornada;
        Modalidad = modalidad;
        Salario = salario;
        this.vacante = vacante;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.embeddingVector = embeddingVector;
        this.empresa = empresa;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getJornada() {
        return Jornada;
    }

    public void setJornada(String jornada) {
        Jornada = jornada;
    }

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String modalidad) {
        Modalidad = modalidad;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

    public Integer getVacante() {
        return vacante;
    }

    public void setVacante(Integer vacante) {
        this.vacante = vacante;
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

    public String getEmbeddingVector() {
        return embeddingVector;
    }

    public void setEmbeddingVector(String embeddingVector) {
        this.embeddingVector = embeddingVector;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
