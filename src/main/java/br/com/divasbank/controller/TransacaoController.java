package br.com.divasbank.controller;


import br.com.divasbank.model.Transacao;
import br.com.divasbank.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @GetMapping
    public String listarTodas() {

        return "Todas as transações";
    }

    @GetMapping("/{id}")
    public String listarPorId(@PathVariable Long id) {

        return "Listado por Id";
    }
    @GetMapping("/{idCliente}")
    public String listarPorCliente(@PathVariable Long idCliente) {

        return "Listado por cliente";
    }

    @PostMapping
    public String cadastrar(@RequestBody Transacao transacao) {
        System.out.println(transacao.getValor());
        return "Transação Realizada!";
    }

}
