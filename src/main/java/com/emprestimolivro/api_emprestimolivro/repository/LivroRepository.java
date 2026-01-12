package com.emprestimolivro.api_emprestimolivro.repository;

import com.emprestimolivro.api_emprestimolivro.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
