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
    private double Salario;

    @Column(name = "vacante")
    private int vacante;

    @Column(name = "descripcion",columnDefinition = "text")
    private String descripcion;

    @Column(name = "requisitos",columnDefinition = "text")
    private String requisitos;


    @Column(name = "embeddingvector",columnDefinition = "text")
    private String embeddingVector;



    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public int getVacante() {
        return vacante;
    }

    public PuestoDeTrabajo(Integer idPuesto, String titulo, String pais, String departamento, String distrito, String categoria, String jornada, String modalidad, double salario, int vacante, String descripcion, String requisitos, String embeddingVector, Empresa empresa) {
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

    public void setVacante(int vacante) {
        this.vacante = vacante;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String modalidad) {
        Modalidad = modalidad;
    }

    public String getJornada() {
        return Jornada;
    }

    public void setJornada(String jornada) {
        Jornada = jornada;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
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


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
