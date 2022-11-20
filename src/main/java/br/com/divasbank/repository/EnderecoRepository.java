package br.com.divasbank.repository;

import br.com.divasbank.model.Endereco;
import br.com.divasbank.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
