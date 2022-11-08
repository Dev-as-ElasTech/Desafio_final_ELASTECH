package br.com.divasbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @GetMapping("/endereco")
    public  String hello() {
        return "Olá endereco";
    }
}
