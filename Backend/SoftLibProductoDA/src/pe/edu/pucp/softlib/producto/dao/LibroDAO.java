/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Categoria;
import pe.edu.pucp.softlib.producto.model.Libro;

/**
 *
 * @author Joshua Haro
 */
public interface LibroDAO {
    public Integer insertar(Libro libro);

    public Integer modificar(Libro libro);

    public Integer eliminar(Libro libro);

    public ArrayList<Libro> listarTodos();

    public Libro obtenerPorId(Integer idRecurso);
    
    public Boolean existeLibro(Libro libro);
    
    public Boolean existeLibro(Libro libro, Boolean abreConexion);
    
    public ArrayList<Libro> listarXCategoria(ArrayList<Integer> idsCategorias);
    
    public ArrayList<Categoria> categoriasXLibro(Integer idLibro);
    
    public ArrayList<Libro> buscarLibros(String nombre);
    
    public ArrayList<Libro> mostrarDestacado();
}
