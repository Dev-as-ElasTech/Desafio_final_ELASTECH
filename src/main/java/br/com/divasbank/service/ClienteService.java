package br.com.divasbank.service;

import br.com.divasbank.exceptionhandler.ClientNotFoundException;
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

    public List<Cliente> listarTodosAtivos() {
        return clienteRepository.listarTodosClientesAtivos();
    }


    public Cliente listarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow( () -> new ClientNotFoundException());
    }

    public Cliente cadastrar(Cliente cliente) throws Exception {
        Conta contaNova = contaRepository.save(cliente.getConta());
        cliente.setConta(contaNova);
        Endereco endereco = enderecoRepository.save(cliente.getEndereco());
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
        return cliente;
    }

    public void editar(Long id, Cliente cliente) {
        listarClientePorId(id); //para que esse método inclua o erro de ClientNotFoundException
        Optional<Cliente> clienteBd = clienteRepository.findById(id);

        if (clienteBd.isPresent()) {
            Cliente c = clienteBd.get();
            if (cliente.getNome() != null) {
                c.setNome(cliente.getNome()); }

            clienteRepository.save(c);
        }
    }
    public void inativar(Cliente cliente) {
            listarClientePorId(cliente.getId()); //para que esse método inclua o erro de ClientNotFoundException
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
        }
    }


