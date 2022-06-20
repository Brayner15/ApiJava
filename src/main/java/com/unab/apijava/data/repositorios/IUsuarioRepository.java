package com.unab.apijava.data.repositorios;

import com.unab.apijava.data.entidades.UsuarioEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByCorreo(String correo);
    public UsuarioEntity findByUserName(String userName);
    
}
