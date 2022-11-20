package br.com.divasbank.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;

    private String dataTransacao;

    private String tipoTransacao;

    private Long numeroContaOrigem;

    private Long numeroContaDestino;

    public Transacao() {
    }

    public Transacao(Long id, Double valor, String dataTransacao, String tipoTransacao, Long idContaOrigem, Long numeroContaOrigem, Long numeroContaDestino) {
        this.id = id;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.numeroContaOrigem = numeroContaOrigem;
        //this.idContaOrigem = idContaOrigem;
        this.numeroContaDestino = numeroContaDestino;
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

//    public Long getIdContaOrigem() {
//        return idContaOrigem;
//    }
//
//    public void setIdContaOrigem(Long idContaorigem) {
//        this.idContaOrigem = idContaorigem;
//    }

    public Long getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(Long numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
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

    public Long getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public void setNumeroContaOrigem(Long numeroContaOrigem) {
        this.numeroContaOrigem = numeroContaOrigem;
    }
}
