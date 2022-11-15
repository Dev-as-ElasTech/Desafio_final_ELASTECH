package br.com.divasbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Conta {

    @Id
    @GeneratedValue
    private Long id;
    private Integer numero;
    private Integer digito;
    private Double saldo;
    private Boolean verificaChequeEspecial;
    private Double chequeEspecial;
    private Boolean ativo;

    @OneToMany (mappedBy="conta")
    @JsonIgnore
    private List<Transacao> listaTransacoes;

    public Conta() {
    }

    public Conta(Long id, Integer numero, Integer digito, Double saldo, Boolean verificaChequeEspecial, Double chequeEspecial, Boolean ativo, List<Transacao> listaTransacoes) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.verificaChequeEspecial = verificaChequeEspecial;
        this.chequeEspecial = chequeEspecial;
        this.ativo = ativo;
        this.listaTransacoes = listaTransacoes;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getVerificaChequeEspecial() {
        return verificaChequeEspecial;
    }

    public void setVerificaChequeEspecial(Boolean verificaChequeEspecial) {
        this.verificaChequeEspecial = verificaChequeEspecial;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public List<Transacao> getListaTransacoes() {
        return listaTransacoes;
    }

    public void setListaTransacoes(List<Transacao> listaTransacoes) {
        this.listaTransacoes = listaTransacoes;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
