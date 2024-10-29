/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.LibroDAO;
import pe.edu.pucp.softlib.producto.daoImp.LibroDAOImpl;
import pe.edu.pucp.softlib.producto.model.Autor;
import pe.edu.pucp.softlib.producto.model.Categoria;
import pe.edu.pucp.softlib.producto.model.Formato;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;

/**
 *
 * @author Joshua Haro
 */
public class LibroBO {
    private final LibroDAO libroDAO;
    
    public LibroBO(){
        this.libroDAO = new LibroDAOImpl();
    }
    
    public Integer insertar(String nombre, Double peso, Double alto, Double ancho, 
            Double precio, UnidadMedida unidadMedida, Byte[] foto,
            ArrayList<Categoria> categorias,Autor autor, String editorial, 
            String ISBN, String sinopsis, 
            Formato formato) {
        Libro libro = new Libro(null, nombre, peso, alto, ancho, precio,true,true,
                unidadMedida, foto,categorias,autor,editorial,ISBN,sinopsis,formato);
        return this.libroDAO.insertar(libro);
    }
    
    public Integer modificar(Integer idLibro,String nombre, Double peso, 
            Double alto, Double ancho, Double precio, Boolean activo, 
            Boolean disponible,UnidadMedida unidadMedida, Byte[] foto, 
            ArrayList<Categoria> categorias,Autor autor, String editorial, 
            String ISBN, String sinopsis, Formato formato) {
        Libro libro = new Libro(idLibro, nombre, peso, alto, ancho, precio, activo,
                disponible,unidadMedida,foto,categorias, autor, editorial, ISBN, 
                sinopsis, formato);
        return this.libroDAO.modificar(libro);
    }
    
    public Integer eliminar(Integer idLibro) {
        Libro libro = new Libro();
        libro.setIdRecurso(idLibro);
        return this.libroDAO.eliminar(libro);
    }
    
    public ArrayList<Libro> listarTodos(){
        return this.libroDAO.listarTodos();
    }
    
    public Libro obtenerPorId(Integer idLibro){
        return this.libroDAO.obtenerPorId(idLibro);
    }
    
    public Boolean existeLibro(Integer idLibro){
        Libro libro = new Libro();
        libro.setIdRecurso(idLibro);
        return this.libroDAO.existeLibro(libro);
    } 
    
    public ArrayList<Libro> buscarLibros(String nombre){
        return this.libroDAO.buscarLibros(nombre);
    }
    
    public ArrayList<Libro> mostrarDestacado(){
        return this.libroDAO.mostrarDestacado();
    }
}
