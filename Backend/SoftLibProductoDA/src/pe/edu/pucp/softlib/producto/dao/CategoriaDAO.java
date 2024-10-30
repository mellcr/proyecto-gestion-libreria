/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Categoria;

/**
 *
 * @author Joshua Haro
 */
public interface CategoriaDAO {
    public Integer insertar(Categoria categoria);

    public Integer modificar(Categoria categoria);

    public Integer eliminar(Categoria categoria);

    public ArrayList<Categoria> listarTodos();

    public Categoria obtenerPorId(Integer idCategoria); 
    
    public ArrayList<Categoria> buscarCategorias(String nombre);
}
