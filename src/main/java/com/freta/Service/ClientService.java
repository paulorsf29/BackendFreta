package com.freta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freta.Entity.ClientEntity;
import com.freta.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity salvarCliente(ClientEntity client) {
        return clientRepository.save(client);
    }

    public List<ClientEntity> listarTodos() {
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> buscarPorId(Long id) {
        return clientRepository.findById(id);
    }

    public ClientEntity atualizarCliente(Long id, ClientEntity clienteAtualizado) {
        return clientRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setSenha(clienteAtualizado.getSenha());
            return clientRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletarCliente(Long id) {
        clientRepository.deleteById(id);
    }
}
