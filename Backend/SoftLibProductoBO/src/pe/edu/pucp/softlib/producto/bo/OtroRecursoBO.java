/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.OtroRecursoDAO;
import pe.edu.pucp.softlib.producto.daoImp.OtroRecursoDAOImpl;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;

/**
 *
 * @author Joshua Haro
 */
public class OtroRecursoBO {
    private final OtroRecursoDAO otroRecursoDAO;
    
    public OtroRecursoBO(){
        this.otroRecursoDAO = new OtroRecursoDAOImpl();
    }
    
    public Integer insertar(String nombre, Double peso, Double alto, Double ancho, 
            Double precio, UnidadMedida unidadMedida, Byte[] foto,
            String caracteristica) {
        OtroRecurso otroRecurso = new OtroRecurso(null, nombre, peso, alto, ancho, 
                precio,true,true,unidadMedida, foto,caracteristica);
        return this.otroRecursoDAO.insertar(otroRecurso);
    }
    
    public Integer modificar(Integer idOtroRecurso,String nombre, Double peso, 
            Double alto, Double ancho, Double precio,Boolean activo, 
            Boolean disponible,UnidadMedida unidadMedida, Byte[] foto,
            String caracteristica) {
        OtroRecurso otroRecurso = new OtroRecurso(idOtroRecurso, nombre, peso, alto, 
                ancho, precio, activo,disponible,unidadMedida,foto,caracteristica);
        return this.otroRecursoDAO.modificar(otroRecurso);
    }
    
    public Integer eliminar(Integer idOtroRecurso) {
        OtroRecurso otroRecurso = new OtroRecurso();
        otroRecurso.setIdRecurso(idOtroRecurso);
        return this.otroRecursoDAO.eliminar(otroRecurso);
    }
    
    public ArrayList<OtroRecurso> listarTodos(){
        return this.otroRecursoDAO.listarTodos();
    }
    
    public OtroRecurso obtenerPorId(Integer idOtroRecurso){
        return this.otroRecursoDAO.obtenerPorId(idOtroRecurso);
    }
    
    public Boolean existeOtroRecurso(Integer idOtroRecurso){
        OtroRecurso libro = new OtroRecurso();
        libro.setIdRecurso(idOtroRecurso);
        return this.otroRecursoDAO.existeOtroRecurso(libro);
    }    

    public ArrayList<OtroRecurso> buscarOtrosRecursos(String nombre){
        return this.otroRecursoDAO.buscarOtrosRecursos(nombre);
    }
    
    public ArrayList<OtroRecurso> mostrarDestacado(){
        return this.otroRecursoDAO.mostrarDestacado();
    }
}
