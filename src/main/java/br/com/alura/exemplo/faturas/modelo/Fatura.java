package br.com.alura.exemplo.faturas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "faturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fatura {
    @Id
    private String id;
    private String clienteId;
    private Double valor;
    private String mesReferencia;
    private boolean paga;

    // Construtores, getters e setters
}