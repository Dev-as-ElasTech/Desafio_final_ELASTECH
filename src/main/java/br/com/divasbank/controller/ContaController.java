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
@RequestMapping("conta")
public class ContaController {

    @Autowired
    ContaService contaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Conta>> listarTodas() {
       return ResponseEntity.ok(contaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> listarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contaService.listarPorId(id));
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }

    }


}
