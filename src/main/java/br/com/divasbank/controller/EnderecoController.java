package br.com.divasbank.controller;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Endereco;
import br.com.divasbank.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> listarEnderecoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enderecoService.listarEnderecoPorId(id));
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editar(@PathVariable Long id, @RequestBody Endereco endereco) throws Exception {
        endereco.setIdEndereco(id);
        enderecoService.editar(id, endereco);
        Optional<Endereco> enderecoBd = Optional.ofNullable(enderecoService.listarEnderecoPorId(id));
        return ResponseEntity.ok(enderecoBd.get());
    }

}
