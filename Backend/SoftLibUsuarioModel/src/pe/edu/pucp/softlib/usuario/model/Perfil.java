/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.model;

import java.util.ArrayList;

/**
 *
 * @author Joshua Haro
 */
public class Perfil {
    private Integer idPerfil;
    private String nombre;
    private ArrayList<Rol> roles;

    public Perfil(Integer idPerfil, String nombre, ArrayList<Rol> roles) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.roles = roles;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }
    
    
}
