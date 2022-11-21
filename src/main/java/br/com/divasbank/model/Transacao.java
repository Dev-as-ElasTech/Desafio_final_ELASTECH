package br.com.divasbank.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@DynamicUpdate
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable=false)
    private Double valor;


    @NotNull
    @Column(nullable=false, length = 60)
    private String tipoTransacao = "transferencia";
    @NotNull
    @Column(nullable=false)
    private Long numeroContaOrigem;
    @NotNull
    @Column(nullable=false)
    private Long numeroContaDestino;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

    public Transacao() {
    }

    public Transacao(Long id, Double valor, String tipoTransacao, Long numeroContaOrigem, Long numeroContaDestino, Date data) {
        this.id = id;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.numeroContaOrigem = numeroContaOrigem;
        this.numeroContaDestino = numeroContaDestino;
        this.data = data;
    }

    public Long getIdTransacao() {

        return id;
    }

    public void setIdTransacao(Long id) {

        this.id = id;
    }

    public Double getValor() {

        return valor;
    }

    public void setValor(Double valor) {

        this.valor = valor;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(Long numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public Long getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public void setNumeroContaOrigem(Long numeroContaOrigem) {
        this.numeroContaOrigem = numeroContaOrigem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

