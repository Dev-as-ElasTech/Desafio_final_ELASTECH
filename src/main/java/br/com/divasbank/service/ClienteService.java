package br.com.divasbank.service;

import br.com.divasbank.model.Cliente;
import br.com.divasbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente editar(Cliente cliente) {
        listarClientePorId(cliente.getId());
        return clienteRepository.save(cliente);
    }

    public Cliente inativar(Cliente cliente) {
        listarClientePorId(cliente.getId());
        cliente.setAtivo(false);
        return clienteRepository.save(cliente);
    }

}
