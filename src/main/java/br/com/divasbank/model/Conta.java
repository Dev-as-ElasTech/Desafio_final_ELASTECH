package br.com.divasbank.model;

public class Conta {
    private Integer idConta;
    private Integer numero;
    private Integer digito;
    private Double saldo;
    private Boolean verificaChequeEspecial;
    private Double chequeEspecial;


    public Conta(Integer idConta, Integer numero, Integer digito, Double saldo, Boolean verificaChequeEspecial, Double chequeEspecial) {
        this.idConta = idConta;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.verificaChequeEspecial = verificaChequeEspecial;
        this.chequeEspecial = chequeEspecial;
    }

    public Integer getIdConta() {
        return idConta;
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
}
