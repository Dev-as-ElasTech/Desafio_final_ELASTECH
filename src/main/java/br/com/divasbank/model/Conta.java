package br.com.divasbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numero;
    private Integer digito;
    private Double saldo;
    private Boolean verificaChequeEspecial;
    private Double chequeEspecial;
    private Boolean ativo;

//
//    @OneToMany(mappedBy="contaOrigem")
//    @JsonIgnore
//    private List<Transacao> listaTransacoesOrigem;
//
//    @OneToMany(mappedBy="contaDestino")
//    @JsonIgnore
//    private List<Transacao> listaTransacoesDestino;

    public Conta() {
    }

    public Conta(Long id, Long numero, Integer digito, Double saldo, Boolean verificaChequeEspecial, Double chequeEspecial, Boolean ativo, List<Transacao> listaTransacoesOrigem, List<Transacao> listaTransacoesDestino) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.verificaChequeEspecial = verificaChequeEspecial;
        this.chequeEspecial = chequeEspecial;
        this.ativo = ativo;
//        this.listaTransacoesOrigem = listaTransacoesOrigem;
//        this.listaTransacoesDestino = listaTransacoesDestino;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
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

//    public List<Transacao> getListaTransacoesOrigem() {
//        return listaTransacoesOrigem;
//    }
//
//    public void setListaTransacoesOrigem(List<Transacao> listaTransacoesOrigem) {
//        this.listaTransacoesOrigem = listaTransacoesOrigem;
//    }
//
//    public List<Transacao> getListaTransacoesDestino() {
//        return listaTransacoesDestino;
//    }
//
//    public void setListaTransacoesDestino(List<Transacao> listaTransacoesDestino) {
//        this.listaTransacoesDestino = listaTransacoesDestino;
//    }

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
