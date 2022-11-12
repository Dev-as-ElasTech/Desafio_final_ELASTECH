package br.com.divasbank.controller;

import br.com.divasbank.model.Conta;
import br.com.divasbank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public String listarTodas() {

        return "Listar Todas as Contas";
    }

    @GetMapping("/{id}")
    public String listarPorId(@PathVariable Long id) {

        return "Listar contas por Id";
    }

    @PostMapping
    public String cadastrar(@RequestBody Conta conta) {

        return "Cadastro de Conta";
    }

    @PutMapping("/{id}")
    public String inativar(@PathVariable Long id, @RequestBody Conta conta) {

        return "Inativar Conta";
    }
}
