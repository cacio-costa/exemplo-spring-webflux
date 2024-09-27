package br.com.alura.exemplo.faturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import br.com.alura.exemplo.faturas.modelo.Fatura;
import br.com.alura.exemplo.faturas.repositorio.FaturaRepository;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    @Autowired
    private FaturaRepository faturaRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Fatura> createFatura(@RequestBody Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    @PutMapping("/{id}/pagar")
    public Mono<Fatura> pagarFatura(@PathVariable String id) {
        return faturaRepository.findById(id)
                .flatMap(fatura -> {
                    fatura.setPaga(true);
                    return faturaRepository.save(fatura);
                });
    }

    @GetMapping("/pendentes")
    public Flux<Fatura> getFaturasPendentes() {
        return faturaRepository.findByPaga(false);
    }
}