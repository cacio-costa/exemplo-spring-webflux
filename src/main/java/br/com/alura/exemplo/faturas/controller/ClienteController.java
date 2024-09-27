package br.com.alura.exemplo.faturas.controller;

import br.com.alura.exemplo.faturas.modelo.Cliente;
import br.com.alura.exemplo.faturas.modelo.Fatura;
import br.com.alura.exemplo.faturas.repositorio.ClienteRepository;
import br.com.alura.exemplo.faturas.repositorio.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FaturaRepository faturaRepository;

    @GetMapping
    public Flux<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> getClienteById(@PathVariable String id) {
        return clienteRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}/faturas")
    public Flux<Fatura> getFaturasDoCliente(@PathVariable String id) {
        return faturaRepository.findByClienteId(id);
    }

    @GetMapping("/plano/{plano}")
    public Flux<Cliente> getClientesPorPlano(@PathVariable String plano) {
        return clienteRepository.findByPlano(plano);
    }

}