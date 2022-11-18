package br.com.divasbank.service;

import br.com.divasbank.model.Conta;
import br.com.divasbank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> listarTodos() {
        return contaRepository.findAll();
    }

//    public Optional<Conta> listarPorId(Long id) {
//       return contaRepository.findById(id);
//    }

    public Conta listarPorId(Long id_conta){
        Optional<Conta> conta = contaRepository.findById(id_conta);
        return conta.get();
    }

    public Conta cadastrar(Conta conta) {
       return contaRepository.save(conta);
    }

    public Conta acharNumeroConta(Long numero){
        return contaRepository.findByNumeroConta(numero);
    }

    public Conta inativar(Conta conta) {
        listarPorId(conta.getId());
        conta.setAtivo(false);
        return contaRepository.save(conta);
    }
}
