package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
    Optional<ProdutoEmbalagem> findByCodbarra(String codbarra);

    @Query("SELECT p FROM ProdutoEmbalagem p WHERE p.produto.idproduto = 1")
    Optional<ProdutoEmbalagem> findByIdProduto(Long idProduto);
}
