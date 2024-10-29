/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.orden.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.orden.model.Orden;
import java.sql.Connection;

/**
 *
 * @author Joshua Haro
 */
public interface OrdenDAO {
    public Integer insertar(Orden orden);
    
    public Integer insertar(Orden orden, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Orden orden);
    
    public Integer modificar(Orden orden, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Orden orden);
    
    public Integer eliminar(Orden orden, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Orden> listarTodos();

    public Orden obtenerPorId(Integer idOrden);

    public Integer existeOrden(Orden idOrden);    
}
