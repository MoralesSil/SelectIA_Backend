package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    @Column(length = 50, nullable = false)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = true)
    private Usuario usuario;

    public Rol(Integer id_rol, String rol, Usuario usuario) {
        this.id_rol = id_rol;
        this.rol = rol;
        this.usuario = usuario;
    }

    public Rol() {

    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}