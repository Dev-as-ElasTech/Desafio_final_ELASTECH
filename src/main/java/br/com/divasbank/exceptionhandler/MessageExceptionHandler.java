package br.com.divasbank.exceptionhandler;

import java.util.Date;

public class MessageExceptionHandler {

    private Date timestamp;
    private Integer status;
    private String mensagem;

    public MessageExceptionHandler(Date timestamp, Integer status, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensagem = mensagem;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
