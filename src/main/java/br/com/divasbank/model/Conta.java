package br.com.divasbank.model;

import java.util.List;

public class Conta {
    private Long id;
    private Integer numero;
    private Integer digito;
    private Double saldo;
    private Boolean verificaChequeEspecial;
    private Double chequeEspecial;
    private Boolean ativo;
    private List<Transacao> listaTransacoes;


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

    public Long getIdConta() {
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
}
