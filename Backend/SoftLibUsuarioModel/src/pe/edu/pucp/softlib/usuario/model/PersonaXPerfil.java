/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.model;

/**
 *
 * @author Joshua Haro
 */
public class PersonaXPerfil {
    private Integer idPersona;
    private Integer idPerfil;
    private Boolean activo;
    
    public PersonaXPerfil(){
        
    }

    public PersonaXPerfil(Integer idPersona, Integer idPerfil, Boolean activo) {
        this.idPersona = idPersona;
        this.idPerfil = idPerfil;
        this.activo = activo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
