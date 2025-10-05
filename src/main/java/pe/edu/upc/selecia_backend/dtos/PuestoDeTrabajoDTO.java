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
    private Double salario;
    private String descripcion;
    private String requisitos;
    private Empresa empresa;

    // ===== NUEVOS CAMPOS PARA COMPARACIÓN =====
    private String experiencia;
    private String educacion;
    private String habilidadesTecnicas;
    private String habilidadesBlandas;
    private String certificaciones;

    // ===== NUEVOS CAMPOS DE EMBEDDINGS =====
    private String setEmbExperiencia;
    private String setEmbEducacion;
    private String setEmbHabTec;
    private String setEmbHabBlandas;
    private String setEmbCertificaciones;

    public PuestoDeTrabajoDTO() {
    }

    public PuestoDeTrabajoDTO(Integer idPuesto, String titulo, String pais, String departamento, String distrito,
                              String categoria, String jornada, String modalidad, Double salario,
                              String descripcion, String requisitos, Empresa empresa,
                              String experiencia, String educacion,
                              String habilidadesTecnicas, String habilidadesBlandas, String certificaciones,
                              String setEmbExperiencia, String setEmbEducacion,
                              String setEmbHabTec, String setEmbHabBlandas, String setEmbCertificaciones) {
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
        this.empresa = empresa;
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
    }

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

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }

    // ===== NUEVOS GETTERS/SETTERS =====
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
}
