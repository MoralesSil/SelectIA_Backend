package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "notificaciones")
public class Notificaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_notificacion;

    @Column(length = 255)
    private String descripcion;

    @Column
    private Integer tipo;

    @Column
    private Integer estado;



    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    public Notificaciones() {

    }

    public Notificaciones(Integer id_notificacion, String descripcion, Integer tipo, Integer estado, Usuario usuario) {
        this.id_notificacion = id_notificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getId_notificacion() {
        return id_notificacion;
    }

    public void setId_notificacion(Integer id_notificacion) {
        this.id_notificacion = id_notificacion;
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

