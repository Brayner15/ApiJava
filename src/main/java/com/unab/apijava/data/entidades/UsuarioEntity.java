package com.unab.apijava.data.entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity(name = "usuarios")
@Table(indexes = {
    @Index(columnList = "userId", name = "index_userid", unique = true),
    @Index(columnList = "userName", name = "index_username", unique = true),
    @Index(columnList = "correo", name = "index_correo", unique = true),
})
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="usuarioEntity")
    private List<PartidoEntity> partidoEntityList= new ArrayList<>();
    
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
