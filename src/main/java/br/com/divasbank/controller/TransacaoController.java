package br.com.divasbank.controller;


import br.com.divasbank.model.Transacao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transferencia")
public class TransacaoController {

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
