package br.com.divasbank.service;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Conta;
import br.com.divasbank.model.Endereco;
import br.com.divasbank.repository.ClienteRepository;
import br.com.divasbank.repository.ContaRepository;
import br.com.divasbank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void cadastrar(Cliente cliente) {
        Conta contaNova = contaRepository.save(cliente.getConta());
        cliente.setConta(contaNova);
        Endereco endereco = enderecoRepository.save(cliente.getEndereco());
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    public void editar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            clienteRepository.save(cliente);
        }
    }
    public void inativar(Long id, Cliente cliente) {
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
        }
    }


