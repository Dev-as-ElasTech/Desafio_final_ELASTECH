package br.com.divasbank.controller;

import br.com.divasbank.model.Endereco;
import br.com.divasbank.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Optional<Endereco>> listarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.listarEnderecoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editar(@PathVariable Long id, @RequestBody Endereco endereco) {
        endereco.setIdEndereco(id);
        enderecoService.editar(id, endereco);
        return ResponseEntity.ok(endereco);
    }

}
