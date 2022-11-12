package br.com.divasbank.model;

import javax.persistence.*;

@Entity
public class Transacao {

    @Id
    @GeneratedValue
    private Long id;
    private Double valor;
    private String dataTransferencia;

    //colocamos as duas annotations abaixo conforme orientação do IntelliJ, para resolver erro e dar push
    @Embedded
    @ManyToOne
    Conta contaOrigem, contaDestino ;

    public Transacao() {
    }

    public Transacao(Long id, Double valor, String dataTransferencia, Conta contaOrigem, Conta contaDestino) {
        this.id = id;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public void saque() {
        System.out.println("Saque realizado com Sucesso");
    }

    public void deposito() {
        System.out.println("Deposito realizado com Sucesso");
    }

    public void transferencia() {
        System.out.println("Transferencia realizada com Sucesso");
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

    public String getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(String dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
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
}
