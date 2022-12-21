package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.dto.UsuarioDTO;
import com.wmsprojeto.apiVenda.model.Usuario;
import com.wmsprojeto.apiVenda.services.UsuarioDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioDetailsService usuarioDetailsService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDetailsService.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDTO dto){
        var usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        usuario.setDatacadastro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDetailsService.save(usuario));
    }

}
