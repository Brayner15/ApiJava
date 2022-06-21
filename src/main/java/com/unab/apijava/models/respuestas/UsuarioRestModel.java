package com.unab.apijava.models.respuestas;

import java.util.List;

public class UsuarioRestModel {
    
    private String userId;
    private String nombre;
    private String correo;
    private String userName;
    private List<PartidosRestModel> partidosRestModel;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
