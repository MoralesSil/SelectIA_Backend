package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.Empresa;

public class PuestoDeTrabajoDTO {
    private Integer idPuesto;
    private String titulo;
    private String pais;
    private String departamento;
    private String distrito;
    private String categoria;
    private String jornada;
    private String modalidad;
    private double salario;
    private int vacante;
    private String descripcion;
    private String requisitos;
    private Empresa empresa;

    public PuestoDeTrabajoDTO() {
    }

    public PuestoDeTrabajoDTO(Integer idPuesto, String titulo, String pais, String departamento, String distrito, String categoria, String jornada, String modalidad, double salario, int vacante, String descripcion, String requisitos, Empresa empresa) {
        this.idPuesto = idPuesto;
        this.titulo = titulo;
        this.pais = pais;
        this.departamento = departamento;
        this.distrito = distrito;
        this.categoria = categoria;
        this.jornada = jornada;
        this.modalidad = modalidad;
        this.salario = salario;
        this.vacante = vacante;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
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
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getVacante() {
        return vacante;
    }

    public void setVacante(int vacante) {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
