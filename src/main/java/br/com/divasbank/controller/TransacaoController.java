package br.com.divasbank.controller;

import br.com.divasbank.model.Transacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransacaoController {

    @GetMapping("/tranferencia")
    public List<Transacao> listarTodas() {

        return null;
    }

    @GetMapping("/tranferencia/id")
    public Transacao listarPorId() {

        return null;
    }
    @GetMapping("/tranferencia/idCliente")
    public List<Transacao> listarPorCliente() {

        return null;
    }

    @PostMapping("/tranferencia")
    public Transacao cadastrar() {

        return null;
    }

}
