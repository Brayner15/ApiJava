package com.unab.apijava.services;

import com.unab.apijava.shared.UsuarioCrearDto;
import com.unab.apijava.shared.UsuarioDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService{

    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto);
    public UsuarioDto obtenerUsuario(String userName);
    
}
