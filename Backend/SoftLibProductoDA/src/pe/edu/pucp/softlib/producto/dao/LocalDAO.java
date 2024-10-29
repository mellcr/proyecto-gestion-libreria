/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import pe.edu.pucp.softlib.producto.model.Local;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author Joshua Haro
 */
public interface LocalDAO {
    public Integer insertar(Local local);

    public Integer modificar(Local local);

    public Integer eliminar(Local local);

    public ArrayList<Local> listarTodos();

    public Local obtenerPorId(Integer idLocal);     
}
