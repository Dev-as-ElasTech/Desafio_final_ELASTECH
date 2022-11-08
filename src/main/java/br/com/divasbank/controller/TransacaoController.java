package br.com.divasbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    @GetMapping("/transferencia")
    public  String hello() {
        return "Olá transferencia";
    }
}
