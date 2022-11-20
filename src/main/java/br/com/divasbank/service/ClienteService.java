package br.com.divasbank.service;

import br.com.divasbank.exceptionhandler.ClientNotFoundException;
import br.com.divasbank.model.Cliente;
import br.com.divasbank.model.Conta;
import br.com.divasbank.model.Endereco;
import br.com.divasbank.repository.ClienteRepository;
import br.com.divasbank.repository.ContaRepository;
import br.com.divasbank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

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

    public List<Cliente> listarTodosAtivos() {
        return clienteRepository.listarTodosClientesAtivos();
    }


    public Cliente listarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow( () -> new ClientNotFoundException());
    }

    public void cadastrar(Cliente cliente) {
        Conta contaNova = contaRepository.save(cliente.getConta());
        cliente.setConta(contaNova);
        Endereco endereco = enderecoRepository.save(cliente.getEndereco());
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    public void editar(Long id, Cliente cliente) {
        listarClientePorId(id); //para que esse método inclua o erro de ClientNotFoundException
        Optional<Cliente> clienteBd = clienteRepository.findById(id);

        if (clienteBd.isPresent()) {
            clienteBd.get().setNome(cliente.getNome());
            clienteRepository.save(cliente);
        }
    }
    public void inativar(Cliente cliente) {
            listarClientePorId(cliente.getId()); //para que esse método inclua o erro de ClientNotFoundException
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
        }
    }


