package com.emprestimolivro.api_emprestimolivro.repository;

import com.emprestimolivro.api_emprestimolivro.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
