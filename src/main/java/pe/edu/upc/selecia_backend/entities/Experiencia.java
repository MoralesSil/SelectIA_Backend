package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "experiencia")
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_experiencia;

    @Column(length = 150)
    private String empresa;

    @Column(length = 100)
    private String puesto;

    @Column(name = "fecha_inicio")
    private java.sql.Date fechaInicio;

    @Column(name = "fecha_fin")
    private java.sql.Date fechaFin;



    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "perfil_postulante_id_perfil")
    private PerfilPostulante perfilPostulante;

    public Experiencia() {

    }

    public Experiencia(Integer id_experiencia, String empresa, String puesto, Date fechaInicio, Date fechaFin, String descripcion, PerfilPostulante perfilPostulante) {
        this.id_experiencia = id_experiencia;
        this.empresa = empresa;
        this.puesto = puesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.perfilPostulante = perfilPostulante;
    }

    public Integer getId_experiencia() {
        return id_experiencia;
    }

    public void setId_experiencia(Integer id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PerfilPostulante getPerfilPostulante() {
        return perfilPostulante;
    }

    public void setPerfilPostulante(PerfilPostulante perfilPostulante) {
        this.perfilPostulante = perfilPostulante;
    }
}
