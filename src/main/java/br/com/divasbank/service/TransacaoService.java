package br.com.divasbank.service;

import br.com.divasbank.model.Conta;
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

    @Autowired
    ContaService contaService;
    @Autowired
    private ContaService contaservice;

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

    public void transferir(Transacao transacao) {
        Conta contaOrigem = contaService.listarPorId((transacao.getIdContaOrigem()));
        Conta contaDestino = contaService.acharNumeroConta(transacao.getNumeroContaDestino());

        contaOrigem.setSaldo(contaOrigem.getSaldo() - transacao.getValor());
        contaDestino.setSaldo(contaDestino.getSaldo() + transacao.getValor());
        transacaoRepository.save(transacao);

    }
}
