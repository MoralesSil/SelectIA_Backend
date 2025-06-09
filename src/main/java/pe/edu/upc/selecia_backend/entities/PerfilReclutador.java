package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "perfilreclutador")
public class PerfilReclutador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreclutador;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public PerfilReclutador(Integer idreclutador, Usuario usuario, Empresa empresa) {
        this.idreclutador = idreclutador;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public PerfilReclutador() {

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdreclutador() {
        return idreclutador;
    }

    public void setIdreclutador(Integer id_reclutador) {
        this.idreclutador = id_reclutador;
    }
}
