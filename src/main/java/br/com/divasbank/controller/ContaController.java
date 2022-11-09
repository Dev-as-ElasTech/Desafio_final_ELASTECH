package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Conta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaController {

    @GetMapping("/conta")
    public List<Conta> listarTodos() {

        return null;
    }

    @GetMapping("/conta/id")
    public Conta listarPorId() {

        return null;
    }

    @PostMapping("/conta")
    public Conta cadastrar() {

        return null;
    }

    @PutMapping("/conta/id")
    public Conta inativar(){

        return null;
    }
}
