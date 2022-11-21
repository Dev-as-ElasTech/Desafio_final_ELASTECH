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

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Cliente>> listarTodosAtivos() {
        return ResponseEntity.ok(clienteService.listarTodosAtivos());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarClientePorId(id));
    }


    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) throws Exception {
            Cliente novoCliente = clienteService.cadastrar(cliente);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        clienteService.editar(id, cliente );
        Optional<Cliente> clienteBd = Optional.ofNullable(clienteService.listarClientePorId(id));
        return ResponseEntity.ok(clienteBd.get());
    }

    @PutMapping("inativar/{id}")
    public ResponseEntity<Cliente> inativar(@PathVariable Long id){
        Optional<Cliente> clienteBd = Optional.ofNullable(clienteService.listarClientePorId(id));
        clienteService.inativar(clienteBd.get());
        contaService.inativar(clienteBd.get().getConta());
        return ResponseEntity.ok(clienteBd.get());
    }

}
