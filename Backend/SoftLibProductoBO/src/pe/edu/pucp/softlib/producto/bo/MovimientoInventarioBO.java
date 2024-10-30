/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.producto.dao.MovimientoInventarioDAO;
import pe.edu.pucp.softlib.producto.daoImp.MovimientoInventarioDAOImpl;
import pe.edu.pucp.softlib.producto.model.Local;
import pe.edu.pucp.softlib.producto.model.MovimientoInventario;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.TipoMovimiento;

/**
 *
 * @author Joshua Haro
 */
public class MovimientoInventarioBO {
    private final MovimientoInventarioDAO movimientoInventarioDAO;
    
    public MovimientoInventarioBO(){
        movimientoInventarioDAO= new MovimientoInventarioDAOImpl();
    }
    
    public Integer insertar(Date fechaMovimiento, 
            Integer cantidad, String detalles,Local local,Integer idRecurso,
            TipoMovimiento tipoMovimiento){
        MovimientoInventario movimientoInventario=
                new MovimientoInventario(null,fechaMovimiento,cantidad,detalles,
                local,idRecurso,tipoMovimiento,true);
        int resultado= movimientoInventarioDAO.insertar(movimientoInventario);
        return resultado;
    }
    
    public Integer modificar(Integer idMovimiento,Date fechaMovimiento, 
            Integer cantidad, String detalles,Local local,Integer idRecurso,
            TipoMovimiento tipoMovimiento, Boolean activo) {
        MovimientoInventario movimientoInventario=
                new MovimientoInventario(idMovimiento,fechaMovimiento,cantidad,
                        detalles,local,idRecurso,tipoMovimiento,activo);
        return movimientoInventarioDAO.modificar(movimientoInventario);                
    }
    
    public Integer eliminar(Integer idMovimiento){
        MovimientoInventario movimientoInventario = new MovimientoInventario();
        movimientoInventario.setIdMovimiento(idMovimiento);
        return movimientoInventarioDAO.eliminar(movimientoInventario);
    }
    
    public ArrayList<MovimientoInventario> listarTodos(){
        return movimientoInventarioDAO.listarTodos();
    }
    
    public MovimientoInventario obtenerPorId(Integer idMovimiento){
        return movimientoInventarioDAO.obtenerPorId(idMovimiento);
    }  
}
