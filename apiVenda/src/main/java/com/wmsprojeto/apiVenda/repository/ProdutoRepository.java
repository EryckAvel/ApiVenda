package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
