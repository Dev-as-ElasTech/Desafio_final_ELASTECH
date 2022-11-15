package br.com.divasbank.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transacao {

    @Id
    @GeneratedValue
    private Long id;
    private Double valor;
    private String dataTransacao;

    private String tipoTransacao;

    @OneToOne
    Conta contaOrigem;
    @OneToOne
    Conta contaDestino;

    @ManyToOne
    Conta conta;

    public Transacao() {
    }

    public Transacao(Long id, Double valor, String dataTransacao, String tipoTransacao, Conta contaOrigem, Conta contaDestino) {
        this.id = id;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
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
