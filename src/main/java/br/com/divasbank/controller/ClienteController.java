package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/cliente")
    public List<Cliente> listarTodos() {

        return null;
    }

    @GetMapping("/cliente/id")
    public Cliente listarPorId() {

        return null;
    }

    @PostMapping("/cliente")
    public Cliente cadastrar() {

        return null;
    }

    @PutMapping("/cliente/id")
    public Cliente editar(){

        return null;
    }

    @PutMapping("/cliente/id")
    public Cliente inativar(){

        return null;
    }

}
