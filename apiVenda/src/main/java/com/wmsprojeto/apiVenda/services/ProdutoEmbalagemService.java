package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.ProdutoEmbalagemDTO;
import com.wmsprojeto.apiVenda.model.Produto;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoEmbalagemService {

    @Autowired
    ProdutoEmbalagemRepository embalagemRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoEmbalagem> findAll() {
        return embalagemRepository.findAll();
    }

    public ResponseEntity<Object> buscarEmbalagem(String produto) {
        Optional<ProdutoEmbalagem> embalagemOptional = embalagemRepository.buscarNome(produto);
        if(embalagemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Embalagem não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(embalagemOptional.get());
    }


    @Transactional
    public ResponseEntity<Object> salvarEmbalagem(ProdutoEmbalagemDTO dto) throws RegraNegocio {
            var embalagem = new ProdutoEmbalagem();
        BeanUtils.copyProperties(dto, embalagem);
        String nomeProduto = dto.getProduto();
        Produto produto = produtoRepository.findByNome(nomeProduto)
                .orElseThrow(() -> new RegraNegocio("Produto não encontrado!"));
        embalagem.setProduto(produto);
        embalagem.setQuantidade(dto.getQuantidade());
        embalagem.setCodBarra(dto.getCodbarra());
        return ResponseEntity.status(HttpStatus.CREATED).body(embalagemRepository.save(embalagem));
    }

    @Transactional
    public ResponseEntity<Object> atualizarEmbalagem(ProdutoEmbalagemDTO dto, String nome) throws RegraNegocio {
        Optional<ProdutoEmbalagem> embalagemOptional = embalagemRepository.buscarNome(nome);
        if (embalagemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Embalagem não encontrada!");
        }
        var embalagem = new ProdutoEmbalagem();
        BeanUtils.copyProperties(dto, embalagem);
        String nomeProduto = dto.getProduto();
        Produto produto = produtoRepository.findByNome(nomeProduto)
                .orElseThrow(() -> new RegraNegocio("Produto não encontrado!"));
        embalagem.setIdembalagem(embalagemOptional.get().getIdembalagem());
        embalagem.setProduto(embalagemOptional.get().getProduto());
        embalagem.setQuantidade(dto.getQuantidade());
        embalagem.setCodBarra(dto.getCodbarra());
        return ResponseEntity.status(HttpStatus.OK).body(embalagemRepository.save(embalagem));
    }

    @Transactional
    public ResponseEntity<Object> deletarEmbalagem(String produto) {
        Optional<ProdutoEmbalagem> embalagemOptional = embalagemRepository.buscarNome(produto);
        if (embalagemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Embalagem não encontrada!");
        }
        embalagemRepository.delete(embalagemOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Embalagem deletada!");
    }
}
