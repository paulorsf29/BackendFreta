package com.freta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.freta.Entity.ClientEntity;
import com.freta.Service.ClientService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Cadastrar um novo cliente", description = "Esse endpoint cria um novo cliente.")
    @PostMapping
    public ResponseEntity<ClientEntity> cadastrarCliente(@RequestBody ClientEntity cliente) {
        ClientEntity novoCliente = clientService.salvarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @Operation(summary = "Listar todos os clientes", description = "Esse endpoint retorna todos os clientes cadastrados.")
    @GetMapping
    public ResponseEntity<List<ClientEntity>> listarClientes() {
        List<ClientEntity> clientes = clientService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Buscar cliente por ID", description = "Esse endpoint busca um cliente pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> buscarClientePorId(@PathVariable Long id) {
        return clientService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar dados de um cliente", description = "Esse endpoint atualiza os dados de um cliente existente.")
    @PutMapping("/{id}")
    public ResponseEntity<ClientEntity> atualizarCliente(@PathVariable Long id, @RequestBody ClientEntity cliente) {
        ClientEntity clienteAtualizado = clientService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @Operation(summary = "Deletar um cliente", description = "Esse endpoint deleta um cliente com base no ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clientService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}