/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.dao;

import java.sql.Connection;
import pe.edu.pucp.softlib.usuario.model.PersonaXPerfil;

/**
 *
 * @author Joshua Haro
 */
public interface PersonaXPerfilDAO {
    public Integer insertar(PersonaXPerfil personaXPerfil);
    
    public Integer insertar(PersonaXPerfil personaXPerfil, Boolean usarTransaccion, 
            Connection conexion);    
}
