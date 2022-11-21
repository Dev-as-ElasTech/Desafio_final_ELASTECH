package br.com.divasbank.repository;

import br.com.divasbank.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
       @Query(value = "SELECT * FROM transacao as t WHERE numero_conta_origem = ?1" , nativeQuery = true)
       List<Transacao> encontrarTransacoesPorNumeroContaOrigem(Long numeroContaOrigem);
}
