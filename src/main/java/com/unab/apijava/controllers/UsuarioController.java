package com.unab.apijava.controllers;

import com.unab.apijava.models.peticiones.UsuarioRegistrarRequestModel;
import com.unab.apijava.models.respuestas.UsuarioRestModel;
import com.unab.apijava.services.IUsuarioService;
import com.unab.apijava.shared.UsuarioCrearDto;
import com.unab.apijava.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioService iUsuarioServicio;
    
    @GetMapping
    public String obtenerUsuario(){

        return "obtenerUsuario";
        
    }


    @PostMapping 
    public UsuarioRestModel crearUsuario(@RequestBody UsuarioRegistrarRequestModel usuarioRegistroRequestModel){

        UsuarioCrearDto usuarioCrearDto= modelmapper.map(usuarioRegistroRequestModel, UsuarioCrearDto.class);

        UsuarioDto usuarioDto = iUsuarioServicio.crearUsuario(usuarioCrearDto);

        UsuarioRestModel usuarioRestModel= modelmapper.map(usuarioDto, UsuarioRestModel.class);
        
        return usuarioRestModel;

    }

}
