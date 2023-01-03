package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.dto.UsuarioDTO;
import com.wmsprojeto.apiVenda.model.Usuario;
import com.wmsprojeto.apiVenda.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Não possivel encontrar o usuario:" + username));
        return usuario;
    }

    public ResponseEntity<Usuario> salvarUsuario(UsuarioDTO dto) {
        var usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        usuario.setDatacadastro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }


    public ResponseEntity<Object> buscarUsuario(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarEmail(email);
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuari não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
    }


    public ResponseEntity<Object> atualizarUsuario(UsuarioDTO dto, String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarEmail(email);
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuari não encontrado!");
        }
        var usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        usuario.setIdusuario(usuarioOptional.get().getIdusuario());
        usuario.setEmail(usuarioOptional.get().getEmail());
        usuario.setDatacadastro(usuarioOptional.get().getDataCadastro());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    public ResponseEntity<Object> deletarUsuario(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarEmail(email);
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuari não encontrado!");
        }
        usuarioRepository.delete(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado!");
    }
}
