package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "notificaciones")
public class Notificaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idnotificacion;

    @Column(length = 255)
    private String descripcion;

    @Column
    private Integer tipo;

    @Column
    private Integer estado;



    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Notificaciones() {

    }

    public Notificaciones(Integer idnotificacion, String descripcion, Integer tipo, Integer estado, Usuario usuario) {
        this.idnotificacion = idnotificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getIdnotificacion() {
        return idnotificacion;
    }

    public void setIdnotificacion(Integer id_notificacion) {
        this.idnotificacion = id_notificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

