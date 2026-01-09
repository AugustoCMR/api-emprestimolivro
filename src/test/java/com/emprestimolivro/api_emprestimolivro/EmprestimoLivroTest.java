package com.emprestimolivro.api_emprestimolivro;

import com.emprestimolivro.api_emprestimolivro.controller.EmprestimoLivroController;
import com.emprestimolivro.api_emprestimolivro.service.EmprestimoLivroService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class EmprestimoLivroTest {

    @Spy
    private EmprestimoLivroService emprestimoLivroService;

    @InjectMocks
    private EmprestimoLivroController emprestimoLivroController;

    @Test
    @DisplayName("Cálculo de multa")
    void calcularMulta() {
        LocalDate dataAquisicaoLivro = LocalDate.of(2026, 01, 04);
        LocalDate dataDevolucaoLivro = LocalDate.of(2026, 01, 10);

        double valorMulta = emprestimoLivroController.verificarEmprestimo(dataAquisicaoLivro, dataDevolucaoLivro);

        assertThat(valorMulta).isEqualByComparingTo(30.00);
    }
}
