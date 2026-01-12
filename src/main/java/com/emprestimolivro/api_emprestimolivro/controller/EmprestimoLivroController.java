package com.emprestimolivro.api_emprestimolivro.controller;

import com.emprestimolivro.api_emprestimolivro.domain.Emprestimo;
import com.emprestimolivro.api_emprestimolivro.repository.EmprestimoRepository;
import com.emprestimolivro.api_emprestimolivro.service.EmprestimoLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController()
@RequestMapping("/api")
public class EmprestimoLivroController {

    @Autowired
    private EmprestimoLivroService emprestimoLivroService;

    @GetMapping("/emprestimo")
    public double calcularEmprestimo(@RequestParam LocalDate dataAquisicaoLivro, @RequestParam LocalDate dataDevolucaoLivro) {
        return emprestimoLivroService.calcularEmprestimo(dataAquisicaoLivro, dataDevolucaoLivro);
    }

    @PostMapping("/cadastrar")
    public Emprestimo cadastrarEmprestimo(@RequestParam Long livroId) {
        return emprestimoLivroService.cadastrarEmprestimo(livroId);
    }


}
