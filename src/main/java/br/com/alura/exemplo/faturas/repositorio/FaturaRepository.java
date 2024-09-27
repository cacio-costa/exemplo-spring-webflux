package br.com.alura.exemplo.faturas.repositorio;

import br.com.alura.exemplo.faturas.modelo.Fatura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface FaturaRepository extends ReactiveMongoRepository<Fatura, String> {

    Flux<Fatura> findByClienteId(String clienteId);
    Flux<Fatura> findByPaga(boolean paga);

}