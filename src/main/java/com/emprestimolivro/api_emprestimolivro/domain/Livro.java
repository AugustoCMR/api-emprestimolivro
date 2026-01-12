package com.emprestimolivro.api_emprestimolivro.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {

    @Id
    private Long id;
    private boolean disponivel;

    public boolean isDisponivel() {
        return disponivel;
    }
}
