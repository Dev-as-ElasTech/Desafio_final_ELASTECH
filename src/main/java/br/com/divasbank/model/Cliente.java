package br.com.divasbank.model;

import java.util.List;

public class Cliente {
    private Integer idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    private Integer telefone;
    private Double rendaMensal;
    private Integer agencia;
    Conta conta;
    List<Endereco> listaEndereco;

    public Cliente(Integer idCliente, String nome, String cpf, String email, String dataNascimento, Integer telefone, Double rendaMensal, Integer agencia, Conta conta, List<Endereco> listaEndereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.conta = conta;
        this.listaEndereco = listaEndereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

 }



