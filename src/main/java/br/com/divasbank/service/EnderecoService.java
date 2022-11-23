package br.com.divasbank.service;


import br.com.divasbank.model.Endereco;
import br.com.divasbank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco listarEnderecoPorId(Long id) throws Exception {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isPresent()){
            return endereco.get();
        } else {
            throw new Exception("Endereço não encontrado,informe um id válido.");
        }
    }

    public void editar(Long id, Endereco endereco) throws Exception {
        listarEnderecoPorId(id);
        Optional<Endereco> enderecoBd = enderecoRepository.findById(id);

        if (enderecoBd.isPresent()) {
            Endereco e = enderecoBd.get();
            if (endereco.getRua() != null) {
                e.setRua(endereco.getRua());
            }
            if (endereco.getNumero() != null) {
                e.setNumero(endereco.getNumero());
            }
            if (endereco.getBairro() != null) {
                e.setBairro(endereco.getBairro());
            }
            if (endereco.getCidade() != null) {
                e.setCidade(endereco.getCidade());
            }
            if (endereco.getEstado() != null) {
                e.setEstado(endereco.getEstado());
            }
            if (endereco.getCep() != null) {
                e.setCep(endereco.getCep());
            }
            if (endereco.getPais() != null) {
                e.setPais(endereco.getPais());
            }
            enderecoRepository.save(e);
        }
    }

}
