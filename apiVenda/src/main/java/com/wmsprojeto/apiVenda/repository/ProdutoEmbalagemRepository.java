package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
}
