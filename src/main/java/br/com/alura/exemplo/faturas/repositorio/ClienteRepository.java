package br.com.alura.exemplo.faturas.repositorio;

import br.com.alura.exemplo.faturas.modelo.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {

    Flux<Cliente> findByPlano(String plano);

}
