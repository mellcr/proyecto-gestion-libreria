/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.daoImp.RecursoDAOImpl;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;

/**
 *
 * @author Joshua Haro
 */
public class RecursoBO {
    private final RecursoDAO recursoDAO;
    
    public RecursoBO(){
        this.recursoDAO = new RecursoDAOImpl();
    }
    
    public Integer insertar(String nombre, Double peso, Double alto, Double ancho, 
            Double precio, Boolean activo, Boolean disponible, 
            UnidadMedida unidadMedida, Byte[] foto){
        Recurso recurso = new Recurso(null,nombre,peso,alto,ancho,precio,
                activo,disponible,unidadMedida, foto);
        return this.recursoDAO.insertar(recurso);
    }
    
    public Integer modificar(Integer idRecurso,String nombre, Double peso, 
            Double alto, Double ancho, Double precio, Boolean activo, 
            Boolean disponible, UnidadMedida unidadMedida, Byte[] foto){
        Recurso recurso = new Recurso(idRecurso,nombre,peso,alto,ancho,precio,
                activo,disponible, unidadMedida, foto);
        return this.recursoDAO.modificar(recurso);
    }
    
    public Integer eliminar(Integer idRecurso){
        Recurso recurso = new Recurso();
        recurso.setIdRecurso(idRecurso);
        return this.recursoDAO.eliminar(recurso);
    }
    
    public ArrayList<Recurso> listarTodos(){
        return this.recursoDAO.listarTodos();
    }
    
    public Recurso obtenerPorId(Integer idRecurso){
        return this.recursoDAO.obtenerPorId(idRecurso);
    }
    
    public Integer existeRecurso(String nombre, Double precio){
        Recurso recurso= new Recurso();
        recurso.setNombre(nombre);
        recurso.setPrecio(precio);
        return this.recursoDAO.existeRecurso(recurso);
    }
}
