/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Recurso;
import java.sql.Connection;

/**
 *
 * @author Joshua Haro
 */
public interface RecursoDAO {
    public Integer insertar(Recurso recurso);
    
    public Integer insertar(Recurso recurso, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Recurso recurso);
    
    public Integer modificar(Recurso recurso, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Recurso recurso);
    
    public Integer eliminar(Recurso recurso, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Recurso> listarTodos();

    public Recurso obtenerPorId(Integer idRecurso);

    public Integer existeRecurso(Recurso recurso);    
}
