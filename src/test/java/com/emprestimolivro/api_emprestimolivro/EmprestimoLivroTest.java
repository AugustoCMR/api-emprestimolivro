package com.emprestimolivro.api_emprestimolivro;

import com.emprestimolivro.api_emprestimolivro.controller.EmprestimoLivroController;
import com.emprestimolivro.api_emprestimolivro.domain.Emprestimo;
import com.emprestimolivro.api_emprestimolivro.domain.Livro;
import com.emprestimolivro.api_emprestimolivro.repository.EmprestimoRepository;
import com.emprestimolivro.api_emprestimolivro.repository.LivroRepository;
import com.emprestimolivro.api_emprestimolivro.service.EmprestimoLivroService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmprestimoLivroTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private EmprestimoLivroService emprestimoLivroService;

    @Test
    @DisplayName("Cálculo de empréstimo com multa")
    void calcularMulta() {
        LocalDate dataAquisicaoLivro = LocalDate.of(2026, 01, 04);
        LocalDate dataDevolucaoLivro = LocalDate.of(2026, 01, 10);

        double valorMulta = emprestimoLivroService.calcularEmprestimo(dataAquisicaoLivro, dataDevolucaoLivro);

        assertThat(valorMulta).isEqualByComparingTo(90.00);
    }

    @Test
    @DisplayName("Cálculo de empréstimo sem multa")
    void calcularEmprestimo() {
        LocalDate dataAquisicaoLivro = LocalDate.of(2026, 01, 04);
        LocalDate dataDevolucaoLivro = LocalDate.of(2026, 01, 07);

        double valorMulta = emprestimoLivroService.calcularEmprestimo(dataAquisicaoLivro, dataDevolucaoLivro);

        assertThat(valorMulta).isEqualByComparingTo(30.00);
    }

    @Test
    @DisplayName("Cadastrar empréstimo de livro - Sucesso")
    void cadastrarEmprestimo() {
        Long livroId = 2L;
        Livro livro = new Livro();

        when(livroRepository.findById(livroId)).thenReturn(Optional.of(livro));

        Emprestimo resultado = emprestimoLivroService.cadastrarEmprestimo(livroId);

        assertNotNull(resultado, "O empréstimo retornado não deveria ser nulo");
    }
}
