package br.com.divasbank.controller;


import br.com.divasbank.model.Transacao;
import br.com.divasbank.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> listarTodas() {
        return transacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public String listarPorId(@PathVariable Long id) {

        return "Listado por Id";
    }
    @GetMapping("/{idCliente}")
    public String listarPorCliente(@PathVariable Long idCliente) {

        return "Listado por cliente";
    }

//    @PostMapping
//    public String cadastrar(@RequestBody Transacao transacao) {
//        System.out.println(transacao.getValor());
//        return "Transação Realizada!";
//    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Transacao transacao) {
        try {
            transacaoService.cadastrar(transacao);
            return new ResponseEntity<>("Transação efetuada com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }


}

