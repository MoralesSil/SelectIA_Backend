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

    @Column(nullable = true)
    private String tipodeDocuemnto;

    @Column(nullable = true)
    private String distrito;

    @Column(nullable = true)
    private String departamento;

    @Column(nullable = true)
    private String pais;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String linkedin;

    @Column(nullable = true)
    private String redSocialPrincipal;

    @Column(nullable = true)
    private Integer numeroDocumento;

    @Column(nullable = true)
    private java.sql.Date fechadeNacimiento;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private List<Rol> roles;

    public Usuario(Integer idusuario, String username, String nombres, String apellidos, Boolean enabled, String correo, String contraseña, Boolean estado, Date fechaRegistro, String telefono, String imagenUrl, String tipodeDocuemnto, String distrito, String departamento, String pais, String direccion, String linkedin, String redSocialPrincipal, Integer numeroDocumento, Date fechadeNacimiento, List<Rol> roles) {
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
        this.tipodeDocuemnto = tipodeDocuemnto;
        this.distrito = distrito;
        this.departamento = departamento;
        this.pais = pais;
        this.direccion = direccion;
        this.linkedin = linkedin;
        this.redSocialPrincipal = redSocialPrincipal;
        this.numeroDocumento = numeroDocumento;
        this.fechadeNacimiento = fechadeNacimiento;
        this.roles = roles;
    }

    public Usuario() {

    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getTipodeDocuemnto() {
        return tipodeDocuemnto;
    }

    public void setTipodeDocuemnto(String tipodeDocuemnto) {
        this.tipodeDocuemnto = tipodeDocuemnto;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getRedSocialPrincipal() {
        return redSocialPrincipal;
    }

    public void setRedSocialPrincipal(String redSocialPrincipal) {
        this.redSocialPrincipal = redSocialPrincipal;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer númeroDocumento) {
        this.numeroDocumento = númeroDocumento;
    }

    public Date getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(Date fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
