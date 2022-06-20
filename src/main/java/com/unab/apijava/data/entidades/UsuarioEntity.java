package com.unab.apijava.data.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "usuarios")
public class UsuarioEntity  implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final String UsuarioCrearDto = null;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, length = 10)
    private String userName;

    @Column(nullable = false)
    private String encryptedPassword;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return null;
    }

    public String getEncryptedPassword() {
        return null;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    

    public String getUserId() {
        return this.userId;
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
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    
}
