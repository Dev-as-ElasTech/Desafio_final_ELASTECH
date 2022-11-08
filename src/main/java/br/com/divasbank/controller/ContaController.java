package br.com.divasbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @GetMapping("/conta")
    public  String hello() {
        return "Olá Conta";
    }
}
