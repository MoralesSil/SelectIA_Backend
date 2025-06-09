package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    @Column(length = 50, nullable = false)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = true)
    private Usuario usuario;

    public Rol(Integer idrol, String rol, Usuario usuario) {
        this.idrol = idrol;
        this.rol = rol;
        this.usuario = usuario;
    }

    public Rol() {

    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer id_rol) {
        this.idrol = id_rol;
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