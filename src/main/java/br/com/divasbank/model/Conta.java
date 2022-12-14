package br.com.divasbank.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Random;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=4, unique=true, updatable=false, nullable=false)
    private Long numero = new Random().nextLong(9999);
    @Column(precision=1, updatable=false, nullable=false)
    private Integer digito = new Random().nextInt(9);
    @NotNull
    @Column(nullable=false)
    private Double saldo = 0d;

    @NotNull
    private Boolean ativo = true;


    public Conta() {
    }

    public Conta(Long id, Long numero, Integer digito, Double saldo, Boolean ativo) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
