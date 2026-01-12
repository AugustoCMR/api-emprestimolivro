package com.emprestimolivro.api_emprestimolivro.service;

import com.emprestimolivro.api_emprestimolivro.domain.Emprestimo;
import com.emprestimolivro.api_emprestimolivro.domain.Livro;
import com.emprestimolivro.api_emprestimolivro.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EmprestimoLivroService {

    private final LivroRepository livroRepository;

    public EmprestimoLivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public double calcularEmprestimo(LocalDate dataAquisicaoLivro, LocalDate dataDevolucaoLivro) {

        double valorEmprestimo = 10.00;

        long diferencaDias = ChronoUnit.DAYS.between(dataAquisicaoLivro, dataDevolucaoLivro);

        if(diferencaDias <= 3) {
            return valorEmprestimo * diferencaDias;
        }

        double valorTotalEmprestimo = valorEmprestimo * diferencaDias;

        double valorMulta = calcularMulta(diferencaDias);

        return valorMulta + valorTotalEmprestimo;
    }

    public Emprestimo cadastrarEmprestimo(Long livroId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivroId(livroId);
        emprestimo.setDataAquisicao(LocalDate.now());

        return emprestimo;
    }

    private double calcularMulta(long diferencaDias) {
        double valorMulta = 10.00;

        return (diferencaDias - 3) * valorMulta;
    }
}
