/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.dao.PersonaDAO;
import pe.edu.pucp.softlib.usuario.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softlib.usuario.model.Perfil;
import pe.edu.pucp.softlib.usuario.model.Persona;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;

/**
 *
 * @author Joshua Haro
 */
public class PersonaBO {
    private final PersonaDAO personaDAO;
    
    public PersonaBO(){
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public Integer insertar(String nombre, String apellidoPaterno, String apellidoMaterno, 
                   String nacionalidad, String numeroDocumento, 
                   TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles){
        Persona persona = new Persona(null,nombre,apellidoPaterno,apellidoMaterno,
                nacionalidad,numeroDocumento,tipoDocumento,perfiles);
        return this.personaDAO.insertar(persona);
    }
    
    public Integer modificar(Integer idPersona,String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento, 
                   TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles){
        Persona persona = new Persona(idPersona,nombre,apellidoPaterno,apellidoMaterno,
                nacionalidad,numeroDocumento,tipoDocumento,perfiles);
        return this.personaDAO.modificar(persona);
    }
    
    public Integer eliminar(Integer idPersona){
        Persona persona = new Persona();
        persona.setIdPersona(idPersona);
        return this.personaDAO.eliminar(persona);
    }
    
    public ArrayList<Persona> listarTodos(){
        return this.personaDAO.listarTodos();
    }
    
    public Persona obtenerPorId(Integer idPersona){
        return this.personaDAO.obtenerPorId(idPersona);
    }
    
    public Integer existePersona(String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad){
        Persona persona= new Persona();
        persona.setNombre(nombre);
        persona.setApellidoPaterno(apellidoPaterno);
        persona.setApellidoMaterno(apellidoMaterno);
        persona.setNacionalidad(nacionalidad);
        return this.personaDAO.existePersona(persona);
    }    
}
