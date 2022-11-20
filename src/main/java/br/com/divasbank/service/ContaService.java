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

    public Conta listarPorId(Long id_conta) throws Exception {
        Optional<Conta> conta = contaRepository.findById(id_conta);
        if(conta.isPresent()){
            return conta.get();
        } else {
            throw new Exception("Conta não encontrada,informe um id válido.");
        }
    }

    public Conta acharNumeroConta(Long numero){
        return contaRepository.findByNumeroConta(numero);
    }

    public Conta inativar(Conta conta) {
       conta.setAtivo(false);
        return contaRepository.save(conta);
    }
}
