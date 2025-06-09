package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ideducacion;

    @Column(length = 150)
    private String institucion;

    @Column(length = 100)
    private String titulo;

    @Column(name = "fechainicio")
    private java.sql.Date fechaInicio;

    @Column(name = "fechafin")
    private java.sql.Date fechaFin;

    @Column(length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idperfil")
    private PerfilPostulante perfilPostulante;

    public Educacion() {

    }
    public Educacion(Integer ideducacion, String institucion, String titulo, Date fechaInicio, Date fechaFin, String estado, PerfilPostulante perfilPostulante) {
        this.ideducacion = ideducacion;
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

    public Integer getIdeducacion() {
        return ideducacion;
    }

    public void setIdeducacion(Integer id_educacion) {
        this.ideducacion = id_educacion;
    }
}

