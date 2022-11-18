package br.com.divasbank.repository;

import br.com.divasbank.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query(value = "SELECT * FROM Conta c WHERE c.numero = ?1", nativeQuery = true)
    Conta findByNumeroConta(Long numero);
 }
