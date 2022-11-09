package br.com.divasbank.controller;

import br.com.divasbank.model.Endereco;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    @GetMapping("/endereco")
    public List<Endereco> listarTodos() {

        return null;
    }

    @GetMapping("/endereco/id")
    public Endereco listarEnderecoPorId() {

        return null;
    }

    @GetMapping("/endereco/idCliente")
    public Endereco listarEnderecoPorCliente() {

        return null;
    }

    @PostMapping("/endereco")
    public Endereco cadastrar() {

        return null;
    }

    @PutMapping("/endereco/id")
    public Endereco editar(){

        return null;
    }

    @DeleteMapping("/endereco/id")
    public Endereco deletar(){

        return null;
    }
}
