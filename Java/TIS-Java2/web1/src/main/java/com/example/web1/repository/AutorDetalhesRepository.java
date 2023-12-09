package com.example.web1.repository;

import com.example.web1.model.AutorDetalhes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDetalhesRepository extends JpaRepository<AutorDetalhes, Long> {
}
