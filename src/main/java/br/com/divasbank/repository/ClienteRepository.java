package br.com.divasbank.repository;

import br.com.divasbank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.ativo = 1")
    List<Cliente> listarTodosClientesAtivos();

}
