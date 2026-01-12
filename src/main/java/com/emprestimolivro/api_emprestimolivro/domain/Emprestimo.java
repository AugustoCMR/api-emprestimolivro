package com.emprestimolivro.api_emprestimolivro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    private Long id;
    private LocalDate dataAquisicao;
    private LocalDate dataDevolucao;
    private Long livroId;

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }
}
