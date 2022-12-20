package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
    @Query("SELECT p FROM ProdutoEmbalagem p WHERE p.codbarra =:codbarra")
    Optional<ProdutoEmbalagem> findByCodbarra(String codbarra);

    @Query("SELECT p FROM ProdutoEmbalagem p WHERE p.produto.idproduto =:idproduto")
    Optional<ProdutoEmbalagem> findByIdProduto(Long idproduto);
}
