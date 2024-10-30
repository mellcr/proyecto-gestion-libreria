/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.MovimientoInventario;

/**
 *
 * @author Joshua Haro
 */
public interface MovimientoInventarioDAO {
    public Integer insertar(MovimientoInventario movimientoInventario);

    public Integer modificar(MovimientoInventario movimientoInventario);

    public Integer eliminar(MovimientoInventario movimientoInventario);

    public ArrayList<MovimientoInventario> listarTodos();

    public MovimientoInventario obtenerPorId(Integer idMovimientoInventario);     
}
