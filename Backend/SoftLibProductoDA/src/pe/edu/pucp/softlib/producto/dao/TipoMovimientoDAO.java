/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.TipoMovimiento;

/**
 *
 * @author Joshua Haro
 */
public interface TipoMovimientoDAO {
    public Integer insertar(TipoMovimiento tipoMovimiento);

    public Integer modificar(TipoMovimiento tipoMovimiento);

    public Integer eliminar(TipoMovimiento tipoMovimiento);

    public ArrayList<TipoMovimiento> listarTodos();

    public TipoMovimiento obtenerPorId(Integer idTipoMovimiento);      
}
