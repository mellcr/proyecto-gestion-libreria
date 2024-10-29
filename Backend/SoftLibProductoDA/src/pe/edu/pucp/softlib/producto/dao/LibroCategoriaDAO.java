/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import pe.edu.pucp.softlib.producto.model.LibroCategoria;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author Joshua Haro
 */
public interface LibroCategoriaDAO {
    public Integer insertar(LibroCategoria libroCategoria);
    
    public Integer insertar(LibroCategoria libroCategoria, Boolean usarTransaccion, 
            Connection conexion);
    
    public ArrayList<Integer> listarXCategorias(ArrayList<Integer> idsCategorias);
    
    public ArrayList<Integer> categoriasXLibro(Integer idLibro);
}
