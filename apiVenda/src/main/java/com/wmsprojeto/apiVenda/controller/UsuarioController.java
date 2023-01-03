package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.dto.UsuarioDTO;
import com.wmsprojeto.apiVenda.model.Usuario;
import com.wmsprojeto.apiVenda.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioDetailsService usuarioDetailsService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return usuarioDetailsService.listarUsuarios();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable("email") String email){
        return usuarioDetailsService.buscarUsuario(email);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDTO dto){
        return usuarioDetailsService.salvarUsuario(dto);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> atualizarUsuario(@RequestBody UsuarioDTO dto, @PathVariable("email") String email){
        return usuarioDetailsService.atualizarUsuario(dto, email);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable("email") String email){
        return usuarioDetailsService.deletarUsuario(email);
    }

}
