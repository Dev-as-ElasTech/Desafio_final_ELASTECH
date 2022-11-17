package br.com.divasbank.service;

import br.com.divasbank.model.Transacao;
import br.com.divasbank.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> listarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

//    public void listarPorIdCliente() {
//
//    }

    public Transacao cadastrar(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
}
