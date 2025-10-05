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

    @Column(name = "pais")
    private String pais;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "jornada")
    private String jornada;

    @Column(name = "modalidad")
    private String modalidad;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "requisitos", columnDefinition = "text")
    private String requisitos;

    // ====== CAMPOS DE TEXTO COMPARABLES ======
    @Column(name = "experiencia", columnDefinition = "text")
    private String experiencia;

    @Column(name = "educacion", columnDefinition = "text")
    private String educacion;

    @Column(name = "habilidades_tecnicas", columnDefinition = "text")
    private String habilidadesTecnicas;

    @Column(name = "habilidades_blandas", columnDefinition = "text")
    private String habilidadesBlandas;

    @Column(name = "certificaciones", columnDefinition = "text")
    private String certificaciones;

    // ====== EMBEDDINGS POR CAMPO ======
    @Column(name = "setEmbExperiencia", columnDefinition = "text")
    private String setEmbExperiencia;

    @Column(name = "setEmbEducacion", columnDefinition = "text")
    private String setEmbEducacion;

    @Column(name = "setEmbHabTec", columnDefinition = "text")
    private String setEmbHabTec;

    @Column(name = "setEmbHabBlandas", columnDefinition = "text")
    private String setEmbHabBlandas;

    @Column(name = "setEmbCertificaciones", columnDefinition = "text")
    private String setEmbCertificaciones;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public PuestoDeTrabajo() {
    }

    public PuestoDeTrabajo(Integer idPuesto, String titulo, String pais, String departamento, String distrito,
                           String categoria, String jornada, String modalidad, Double salario,
                           String descripcion, String requisitos,
                           String experiencia, String educacion,
                           String habilidadesTecnicas, String habilidadesBlandas, String certificaciones,
                           String setEmbExperiencia, String setEmbEducacion,
                           String setEmbHabTec, String setEmbHabBlandas, String setEmbCertificaciones,
                           Empresa empresa) {
        this.idPuesto = idPuesto;
        this.titulo = titulo;
        this.pais = pais;
        this.departamento = departamento;
        this.distrito = distrito;
        this.categoria = categoria;
        this.jornada = jornada;
        this.modalidad = modalidad;
        this.salario = salario;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.experiencia = experiencia;
        this.educacion = educacion;
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.habilidadesBlandas = habilidadesBlandas;
        this.certificaciones = certificaciones;
        this.setEmbExperiencia = setEmbExperiencia;
        this.setEmbEducacion = setEmbEducacion;
        this.setEmbHabTec = setEmbHabTec;
        this.setEmbHabBlandas = setEmbHabBlandas;
        this.setEmbCertificaciones = setEmbCertificaciones;
        this.empresa = empresa;
    }

    // Getters y Setters
    public Integer getIdPuesto() { return idPuesto; }
    public void setIdPuesto(Integer idPuesto) { this.idPuesto = idPuesto; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getJornada() { return jornada; }
    public void setJornada(String jornada) { this.jornada = jornada; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRequisitos() { return requisitos; }
    public void setRequisitos(String requisitos) { this.requisitos = requisitos; }

    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }

    public String getEducacion() { return educacion; }
    public void setEducacion(String educacion) { this.educacion = educacion; }

    public String getHabilidadesTecnicas() { return habilidadesTecnicas; }
    public void setHabilidadesTecnicas(String habilidadesTecnicas) { this.habilidadesTecnicas = habilidadesTecnicas; }

    public String getHabilidadesBlandas() { return habilidadesBlandas; }
    public void setHabilidadesBlandas(String habilidadesBlandas) { this.habilidadesBlandas = habilidadesBlandas; }

    public String getCertificaciones() { return certificaciones; }
    public void setCertificaciones(String certificaciones) { this.certificaciones = certificaciones; }

    public String getSetEmbExperiencia() { return setEmbExperiencia; }
    public void setSetEmbExperiencia(String setEmbExperiencia) { this.setEmbExperiencia = setEmbExperiencia; }

    public String getSetEmbEducacion() { return setEmbEducacion; }
    public void setSetEmbEducacion(String setEmbEducacion) { this.setEmbEducacion = setEmbEducacion; }

    public String getSetEmbHabTec() { return setEmbHabTec; }
    public void setSetEmbHabTec(String setEmbHabTec) { this.setEmbHabTec = setEmbHabTec; }

    public String getSetEmbHabBlandas() { return setEmbHabBlandas; }
    public void setSetEmbHabBlandas(String setEmbHabBlandas) { this.setEmbHabBlandas = setEmbHabBlandas; }

    public String getSetEmbCertificaciones() { return setEmbCertificaciones; }
    public void setSetEmbCertificaciones(String setEmbCertificaciones) { this.setEmbCertificaciones = setEmbCertificaciones; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}
