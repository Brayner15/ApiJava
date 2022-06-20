package com.unab.apijava.shared;

import java.io.Serializable;

public class UsuarioCrearDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String corrreo;
    private String userName;
    private String password;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorrreo() {
        return this.corrreo;
    }

    public void setCorrreo(String corrreo) {
        this.corrreo = corrreo;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
