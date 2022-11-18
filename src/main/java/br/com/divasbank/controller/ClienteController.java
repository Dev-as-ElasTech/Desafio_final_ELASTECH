package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Conta;
import br.com.divasbank.service.ClienteService;
import br.com.divasbank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ContaService contaService;

    private Conta conta;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarClientePorId(id).get());
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Cliente cliente) {
        try {
            clienteService.cadastrar(cliente);
            return new ResponseEntity<>("Cliente cadastrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        clienteService.editar(id, cliente );
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("inativar/{id}")
    public ResponseEntity<Cliente> inativar(@PathVariable Long id){
        Optional<Cliente> clienteBd = clienteService.listarClientePorId(id);
        clienteService.inativar(id, clienteBd.get());
        return ResponseEntity.ok(clienteBd.get());
    }

}
