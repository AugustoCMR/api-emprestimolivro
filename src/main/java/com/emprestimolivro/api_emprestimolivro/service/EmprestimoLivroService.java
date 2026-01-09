package com.emprestimolivro.api_emprestimolivro.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EmprestimoLivroService {
    public double verificarEmprestimo(LocalDate dataAquisicaoLivro, LocalDate dataDevolucaoLivro) {
        long diferencaDias = ChronoUnit.DAYS.between(dataAquisicaoLivro, dataDevolucaoLivro);

        if(diferencaDias <= 3) {
            return 0.00;
        }

        double valorMulta = 10.00;

        return (diferencaDias - 3) * valorMulta;
    }
}
