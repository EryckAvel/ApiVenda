package com.wmsprojeto.apiVenda.controller;


import com.wmsprojeto.apiVenda.dto.ProdutoEmbalagemDTO;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.services.ProdutoEmbalagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    ProdutoEmbalagemService produtoEmbalagemService;

    @GetMapping("/{codbarra}")
    public ResponseEntity<Object> busacarCodBarras(@PathVariable String codbarra){
        Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemService.findByCodBarra(codbarra);
        if(!produtoEmbalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoEmbalagemOptional.get().getProduto());
    }

    @PutMapping("/{codbarra}/qtd")
    public ResponseEntity<Object> buscarCodeSalvarqtd(@PathVariable("codbarra") String codbarra, @RequestBody ProdutoEmbalagemDTO dto){
        Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemService.findByCodBarra(codbarra);
        if(!produtoEmbalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        var embalagem = new ProdutoEmbalagem();
        BeanUtils.copyProperties(dto, embalagem);
        embalagem.setCodBarra(produtoEmbalagemOptional.get().getCodBarra());
        embalagem.setIdembalagem(produtoEmbalagemOptional.get().getIdembalagem());
        embalagem.setProduto(produtoEmbalagemOptional.get().getProduto()    );
        embalagem.setEmbalagem(produtoEmbalagemOptional.get().getEmbalagem());
        embalagem.setSituacao(produtoEmbalagemOptional.get().getSituacao());
        return ResponseEntity.status(HttpStatus.OK).body(produtoEmbalagemService.save(embalagem));

    }


}
