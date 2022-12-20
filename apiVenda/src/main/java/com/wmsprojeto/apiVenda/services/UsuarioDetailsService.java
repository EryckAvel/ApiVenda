package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.Usuario;
import com.wmsprojeto.apiVenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        Usuario usuario=usuarioRepository.findByUsername(username);
        return usuario;
         */
        return null;
    }
}
