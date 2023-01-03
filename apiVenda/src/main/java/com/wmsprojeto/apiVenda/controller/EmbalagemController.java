package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.ProdutoEmbalagemDTO;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.services.ProdutoEmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/embalagem")
@CrossOrigin("*")
public class EmbalagemController {

    @Autowired
    ProdutoEmbalagemService embalagemService;

    @GetMapping
    public ResponseEntity<List<ProdutoEmbalagem>> listarEmbalagens(){
        return ResponseEntity.status(HttpStatus.OK).body(embalagemService.findAll());
    }

    @GetMapping("/{produto}")
    public ResponseEntity<Object> buscarEmbalagem(@PathVariable("produto") String produto){
        return embalagemService.buscarEmbalagem(produto);
    }

    @PostMapping
    public ResponseEntity<Object> salvarEmbalagem(@RequestBody ProdutoEmbalagemDTO dto) throws RegraNegocio {
        return embalagemService.salvarEmbalagem(dto);
    }

    @PutMapping("/{produto}")
    public ResponseEntity<Object> atualizarEmbalagem(@RequestBody ProdutoEmbalagemDTO dto, @PathVariable("produto") String produto) throws RegraNegocio {
        return embalagemService.atualizarEmbalagem(dto, produto);
    }

    @DeleteMapping("/{produto}")
    public ResponseEntity<Object> deletarEmbalagem(@PathVariable("produto") String produto){
        return embalagemService.deletarEmbalagem(produto);
    }

}
