package pe.edu.upc.selecia_backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idempresa;

    @Column(length = 150, nullable = false)
    private String razonSocial;

    @Column(length = 11, nullable = false)
    private String ruc;

    @Column(length = 255)
    private String descripcion;

    public Empresa() {

    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public Empresa(Integer idempresa, String razonSocial, String ruc, String descripcion) {
        this.idempresa = idempresa;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.descripcion = descripcion;
    }

    public void setIdempresa(Integer id_empresa) {
        this.idempresa = id_empresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}