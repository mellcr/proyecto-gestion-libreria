/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Autor;

/**
 *
 * @author Joshua Haro
 */
public interface AutorDAO {
    public Integer insertar(Autor autor);

    public Integer modificar(Autor autor);

    public Integer eliminar(Autor autor);

    public ArrayList<Autor> listarTodos();

    public Autor obtenerPorId(Integer idAutor);    
    
    public ArrayList<Autor> buscarAutores(String nombre);
}
