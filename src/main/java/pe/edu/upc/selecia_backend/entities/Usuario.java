package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    @Column(length = 255, nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = true)
    private java.sql.Date fechaRegistro;

    @Column(length = 11)
    private String telefono;

    @Column(nullable = true)
    private String imagenUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private List<Rol> roles;

    public Usuario(Integer idusuario, String username, String nombres, String apellidos, Boolean enabled, String correo, String contraseña, Boolean estado, Date fechaRegistro, String telefono, String imagenUrl, List<Rol> roles) {
        this.idusuario = idusuario;
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.enabled = enabled;
        this.correo = correo;
        this.contraseña = contraseña;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
        this.imagenUrl = imagenUrl;
        this.roles = roles;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario() {

    }

    public Integer getidusuario() {
        return idusuario;
    }

    public void setidusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getfechaRegistro() {
        return fechaRegistro;
    }

    public void setfechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
