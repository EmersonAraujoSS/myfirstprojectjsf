package br.com.avancard.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.ForeignKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numeroNotaFiscal;
    private String empresaOrigem;
    private String empresaDestino;
    @ManyToOne(optional = false)
    @ForeignKey(name = "usuario_fk")
    private Pessoa usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getEmpresaOrigem() {
        return empresaOrigem;
    }

    public void setEmpresaOrigem(String empresaOrigem) {
        this.empresaOrigem = empresaOrigem;
    }

    public String getEmpresaDestino() {
        return empresaDestino;
    }

    public void setEmpresaDestino(String empresaDestino) {
        this.empresaDestino = empresaDestino;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
