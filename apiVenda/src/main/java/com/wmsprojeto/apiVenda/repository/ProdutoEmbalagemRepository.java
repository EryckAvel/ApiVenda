package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
    Optional<ProdutoEmbalagem> findByCodbarra(String codbarra);

}
