package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String listarTodos() {

        return "Listando todos os clientes";
    }

    @GetMapping("/{id}")
    public String listarPorId(@PathVariable Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(100L);
        cliente.setNome("Maria");
        cliente.setCpf("000.000.000-00");
        cliente.setEmail("maria@email");
        cliente.setDataNascimento("01/01/1986");
        System.out.println(cliente.getNome());
        return "Listando clientes por id";
    }

    @PostMapping
    public String cadastrar(@RequestBody Cliente cliente) {
        System.out.println(cliente.getNome());
        return "Cliente cadastrado";
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable Long id, @RequestBody Cliente cliente){
        System.out.println(cliente.getNome());
        return "Editar Cliente";
    }

    @PatchMapping("/{id}")
    public String inativar(@PathVariable Long id, @RequestBody Cliente cliente){

        return "inativar cliente";
    }

}
