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

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> listarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public List<Transacao> listarPorNumeroConta(Long numeroContaOrigem) {
        return transacaoRepository. encontrarTransacoesPorNumeroContaOrigem(numeroContaOrigem);
    }

    public void cadastrar(Transacao transacao) {
        transacaoRepository.save(transacao);
    }

    public void verificaTransferencia(Transacao transacao) throws Exception {
        Conta contaOrigem = contaService.acharNumeroConta(transacao.getNumeroContaOrigem());
        Conta contaDestino = contaService.acharNumeroConta(transacao.getNumeroContaDestino());

        if (contaOrigem == null){
            throw new Exception("A transferênia não pode ser efetuada: Informe um valor válido para conta de origem.");
        }

        if (contaDestino == null){
            throw new Exception("A transferênia não pode ser efetuada: Informe um valor válido para conta de destino.");
        }

        if (contaOrigem.getAtivo() == false){
            throw new Exception("A transferênia não pode ser efetuada: Conta de origem está inativa.");
        }

        if (contaDestino.getAtivo() == false){
            throw new Exception("A transferênia não pode ser efetuada: Conta de destino está inativa.");
        }

        if(transacao.getValor() <= 1){
            throw new Exception("A transferênia não pode ser efetuada: Informe um valor maior que zero.");
        }

        if(contaOrigem.getSaldo() <= transacao.getValor()){
            throw new Exception("A transferênia não pode ser efetuada: Conta de origem não tem saldo sufuciente.");
        }
    }

    public void transferir(Transacao transacao) throws Exception {
        Conta contaOrigem = contaService.acharNumeroConta(transacao.getNumeroContaOrigem());
        Conta contaDestino = contaService.acharNumeroConta(transacao.getNumeroContaDestino());

        this.verificaTransferencia(transacao);

        contaOrigem.setSaldo(contaOrigem.getSaldo() - transacao.getValor());
        contaDestino.setSaldo(contaDestino.getSaldo() + transacao.getValor());
        transacaoRepository.save(transacao);
    }
 }
