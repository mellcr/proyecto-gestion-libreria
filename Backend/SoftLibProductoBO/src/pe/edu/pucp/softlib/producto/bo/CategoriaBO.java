/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.CategoriaDAO;
import pe.edu.pucp.softlib.producto.daoImp.CategoriaDAOImpl;
import pe.edu.pucp.softlib.producto.model.Categoria;

/**
 *
 * @author Joshua Haro
 */
public class CategoriaBO {

    private final CategoriaDAO categoriaDAO;

    public CategoriaBO() {
        this.categoriaDAO = new CategoriaDAOImpl();
    }

    public Integer insertar(String nombre) {
        Categoria categoria = new Categoria(null,nombre,true);
        return categoriaDAO.insertar(categoria);
    }
    
    public Integer modificar(Integer idCategoria, String nombre, Boolean activo) {
        Categoria categoria = new Categoria(idCategoria, nombre, activo);
        return categoriaDAO.modificar(categoria);                
    }
    
    public Integer eliminar(Integer idCategoria){
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        return categoriaDAO.eliminar(categoria);
    }
    
    public ArrayList<Categoria> listarTodos(){
        return categoriaDAO.listarTodos();
    }
    
    public Categoria obtenerPorId(Integer idCategoria){
        return categoriaDAO.obtenerPorId(idCategoria);
    } 
    
    public ArrayList<Categoria> buscarCategorias(String nombre){
        return categoriaDAO.buscarCategorias(nombre);
    }
}
