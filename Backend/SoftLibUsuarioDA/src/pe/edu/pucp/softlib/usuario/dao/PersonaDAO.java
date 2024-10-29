/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.dao;

import pe.edu.pucp.softlib.usuario.model.Persona;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author Joshua Haro
 */
public interface PersonaDAO {
    public Integer insertar(Persona persona);
    
    public Integer insertar(Persona persona, Boolean usarTransaccion, 
            Connection conexion);

    public Integer modificar(Persona persona);
    
    public Integer modificar(Persona persona, Boolean usarTransaccion, 
            Connection conexion);

    public Integer eliminar(Persona persona);
    
    public Integer eliminar(Persona persona, Boolean usarTransaccion, 
            Connection conexion);

    public ArrayList<Persona> listarTodos();

    public Persona obtenerPorId(Integer idPersona);

    public Integer existePersona(Persona persona);     
}
