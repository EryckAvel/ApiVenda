package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome=:nome")
    Optional<Produto> findByNome(String nome);
}
