package com.emprestimolivro.api_emprestimolivro.controller;

import com.emprestimolivro.api_emprestimolivro.service.EmprestimoLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController()
@RequestMapping("/api")
public class EmprestimoLivroController {

    @Autowired
    private EmprestimoLivroService emprestimoLivroService;

    public double verificarEmprestimo(LocalDate dataAquisicaoLivro, LocalDate dataDevolucaoLivro) {
        return emprestimoLivroService.verificarEmprestimo(dataAquisicaoLivro, dataDevolucaoLivro);
    }
}
