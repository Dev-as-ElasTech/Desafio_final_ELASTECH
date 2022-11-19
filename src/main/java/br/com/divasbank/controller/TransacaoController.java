package br.com.divasbank.controller;


import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Transacao;
import br.com.divasbank.service.TransacaoService;
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
    public ResponseEntity<List<Transacao>> listarTodas() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    @GetMapping("/{id}")
   public ResponseEntity<Transacao> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.listarPorId(id).get());
    }

    @GetMapping("/extrato/{id}")
    public ResponseEntity<List<Transacao>> extratoTransacaoPorConta(@PathVariable Long id) {

        return ResponseEntity.ok(transacaoService.listarPorIdConta(id));
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<String> cadastrar(@RequestBody Transacao transacao) {
//        try {
//            transacaoService.cadastrar(transacao);
//            return new ResponseEntity<>("Transação efetuada com sucesso", HttpStatus.CREATED);
//        } catch (Exception e) {
//            String msg = e.getMessage();
//            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/efetuar")
    public void efetuarTransacao(@RequestBody Transacao transacao) {
          transacaoService.transferir(transacao);
    }



}

