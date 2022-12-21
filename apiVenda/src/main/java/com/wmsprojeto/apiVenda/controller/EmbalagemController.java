package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.services.ProdutoEmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
