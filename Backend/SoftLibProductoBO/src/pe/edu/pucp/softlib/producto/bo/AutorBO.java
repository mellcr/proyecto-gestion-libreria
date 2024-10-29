/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.AutorDAO;
import pe.edu.pucp.softlib.producto.daoImp.AutorDAOImpl;
import pe.edu.pucp.softlib.producto.model.Autor;

/**
 *
 * @author Joshua Haro
 */
public class AutorBO {

    private final AutorDAO autorDAO;

    public AutorBO() {
        this.autorDAO = new AutorDAOImpl();
    }

    public Integer insertar(String nombre, String nacionalidad) {
        Autor autor = new Autor(null,nombre,nacionalidad,true);
        return autorDAO.insertar(autor );
    }
    
    public Integer modificar(Integer idAutor, String nombre,String nacionalidad,
                    Boolean activo) {
        Autor autor  = new Autor(idAutor, nombre, nacionalidad,activo);
        return autorDAO.modificar(autor);                
    }
    
    public Integer eliminar(Integer idAutor){
        Autor autor = new Autor();
        autor.setIdAutor(idAutor);
        return autorDAO.eliminar(autor);
    }
    
    public ArrayList<Autor> listarTodos(){
        return autorDAO.listarTodos();
    }
    
    public Autor obtenerPorId(Integer idAutor){
        return autorDAO.obtenerPorId(idAutor);
    }        
    
    public ArrayList<Autor> buscarAutores(String nombre){
        return autorDAO.buscarAutores(nombre);
    }
    
    
    
}
