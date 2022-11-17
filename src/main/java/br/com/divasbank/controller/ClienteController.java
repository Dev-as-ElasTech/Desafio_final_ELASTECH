package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Transacao;
import br.com.divasbank.service.ClienteService;
import org.apache.coyote.Response;
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

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> listarPorId(@PathVariable Long id) {
//        try {
//            Optional<Cliente> cliente = clienteService.listarClientePorId(id);
//            return ResponseEntity.ok().body(cliente).getBody();
//        } catch (Exception e){
//            String msg = e.getMessage();
//            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>("Cliente encontrado", HttpStatus.OK);
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
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody Cliente cliente){
        try {
            cliente.setId(id);
            clienteService.editar(cliente);
            return new ResponseEntity<>("Cliente atualizado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public String inativar(@PathVariable Long id, @RequestBody Cliente cliente){

        return "inativar cliente";
    }

}
