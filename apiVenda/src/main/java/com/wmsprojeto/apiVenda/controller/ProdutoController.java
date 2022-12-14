package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.dto.ProdutoDTO;
import com.wmsprojeto.apiVenda.model.Produto;
import com.wmsprojeto.apiVenda.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listaProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable("id") Long id){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDTO dto){
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable("id") Long id,@RequestBody ProdutoDTO dto){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        produto.setIdproduto(produtoOptional.get().getIdproduto());
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable("id") Long id){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        produtoService.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente deletado!");
    }

}
