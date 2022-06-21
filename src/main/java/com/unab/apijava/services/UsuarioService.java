package com.unab.apijava.services;

import java.util.ArrayList;
import java.util.UUID;

import com.unab.apijava.data.entidades.UsuarioEntity;

import com.unab.apijava.data.repositorios.IUsuarioRepository;
import com.unab.apijava.shared.UsuarioCrearDto;
import com.unab.apijava.shared.UsuarioDto;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService  implements IUsuarioService  {
    @Autowired
    ModelMapper modelmapper;
    
    @Autowired
    IUsuarioRepository iUsuarioRepositorio;
    

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    @Override
    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto) {

        if(iUsuarioRepositorio.findByCorreo(usuarioCrearDto.getCorrreo()) != null){
            throw new RuntimeException("Este correo ya se encuentra registrado");
        }

        if(iUsuarioRepositorio.findByUserName(usuarioCrearDto.getUserName()) != null){
            throw new RuntimeException("Este nombre de usuario ya este en uso");
        }

        UsuarioEntity usuarioEntityDto= modelmapper.map(usuarioCrearDto, UsuarioEntity.class);
        usuarioEntityDto.setUserId(UUID.randomUUID().toString());
        usuarioEntityDto.setEncryptedPassword(bcryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));

        UsuarioEntity usuarioEntitySave=iUsuarioRepositorio.save(usuarioEntityDto);
        UsuarioDto usuarioDto= modelmapper.map(usuarioEntitySave, UsuarioDto.class);
        return usuarioDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity= iUsuarioRepositorio.findByUserName(username);

        if (usuarioEntity==null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(usuarioEntity.getUserName(), usuarioEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UsuarioDto obtenerUsuario(String userName){

        UsuarioEntity usuarioEntity= iUsuarioRepositorio.findByUserName(userName);

        if(usuarioEntity==null){
            throw new UsernameNotFoundException(userName);
        }

        UsuarioDto usuarioDtoObtenido= modelmapper.map(usuarioEntity, UsuarioDto.class);

        return usuarioDtoObtenido;
    }

}

