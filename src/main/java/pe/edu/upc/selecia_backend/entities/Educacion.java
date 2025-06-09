package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_educacion;

    @Column(length = 150)
    private String institucion;

    @Column(length = 100)
    private String titulo;

    @Column(name = "fecha_inicio")
    private java.sql.Date fechaInicio;

    @Column(name = "fecha_fin")
    private java.sql.Date fechaFin;

    @Column(length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "perfil_postulante_id_perfil")
    private PerfilPostulante perfilPostulante;

    public Educacion() {

    }
    public Educacion(Integer id_educacion, String institucion, String titulo, Date fechaInicio, Date fechaFin, String estado, PerfilPostulante perfilPostulante) {
        this.id_educacion = id_educacion;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.perfilPostulante = perfilPostulante;
    }



    public PerfilPostulante getPerfilPostulante() {
        return perfilPostulante;
    }

    public void setPerfilPostulante(PerfilPostulante perfilPostulante) {
        this.perfilPostulante = perfilPostulante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Integer getId_educacion() {
        return id_educacion;
    }

    public void setId_educacion(Integer id_educacion) {
        this.id_educacion = id_educacion;
    }
}

