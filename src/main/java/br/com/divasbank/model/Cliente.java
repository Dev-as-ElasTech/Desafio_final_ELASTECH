package br.com.divasbank.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false,length = 255)
    @NotNull
    private String nome;

    @Column(nullable = false,length = 14, unique = true, updatable = false)
    @NotNull
    private String cpf;

    @Column(nullable = false, length = 100, unique = true)
    @NotNull
    private String email;

    @Column(nullable = false, length = 12)
    @NotNull
    private String dataNascimento;

    @Column(nullable = false)
    @NotNull
    private String telefone;

    @Column(nullable = false)
    @NotNull
    private Double rendaMensal;

    @Column(insertable = true, updatable = false)
    @NotNull
    private Integer agencia = 1;

    @Column(nullable=false)
    @NotNull
    private Boolean ativo = true;

    @OneToOne
    Conta conta;

    @OneToOne
    Endereco endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String email, String dataNascimento, String telefone, Double rendaMensal, Integer agencia, Boolean ativo, Conta conta, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.ativo = ativo;
        this.conta = conta;
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



