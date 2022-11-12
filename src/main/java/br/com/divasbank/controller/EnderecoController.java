package br.com.divasbank.controller;

import br.com.divasbank.model.Endereco;
import br.com.divasbank.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public String listarTodos() {

        return "Listar todos os endereços";
    }

    @GetMapping("/{id}")
    public String listarEnderecoPorId(@PathVariable Long id) {

        return "Listar Endereço por Id";
    }

    @GetMapping("/{idClinte}")
    public String listarEnderecoPorCliente(@PathVariable Long idCliente) {

        return "Listar Endereços por Cliente";
    }

    @PostMapping
    public String cadastrar(@RequestBody Endereco endereco) {

        return "Cadastrar Endereço";
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable Long id, @RequestBody Endereco endereco) {

        return "Editar Endereço";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        System.out.println(id);
        return "Deletar Endereço";
    }
}
