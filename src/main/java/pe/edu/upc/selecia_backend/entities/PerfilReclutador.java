package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "perfil_reclutador")
public class PerfilReclutador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reclutador;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id_empresa")
    private Empresa empresa;

    public PerfilReclutador(Integer id_reclutador, Usuario usuario, Empresa empresa) {
        this.id_reclutador = id_reclutador;
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

    public Integer getId_reclutador() {
        return id_reclutador;
    }

    public void setId_reclutador(Integer id_reclutador) {
        this.id_reclutador = id_reclutador;
    }
}
