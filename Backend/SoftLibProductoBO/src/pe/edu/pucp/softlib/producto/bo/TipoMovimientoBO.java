/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.dao.TipoMovimientoDAO;
import pe.edu.pucp.softlib.producto.daoImp.TipoMovimientoDAOImpl;
import pe.edu.pucp.softlib.producto.model.TipoAccion;
import pe.edu.pucp.softlib.producto.model.TipoMovimiento;

/**
 *
 * @author Joshua Haro
 */
public class TipoMovimientoBO {

    private final TipoMovimientoDAO tipoMovimientoDAO;

    public TipoMovimientoBO() {
        this.tipoMovimientoDAO = new TipoMovimientoDAOImpl();
    }

    public Integer insertar(String descripcion, TipoAccion tipoAccion) {
        TipoMovimiento tipoMovimiento = new TipoMovimiento(null,descripcion,
                            tipoAccion);
        return tipoMovimientoDAO.insertar(tipoMovimiento);
    }
    
    public Integer modificar(Integer idTipoMovimiento,String descripcion, 
            TipoAccion tipoAccion) {
        TipoMovimiento tipoMovimiento = new TipoMovimiento(idTipoMovimiento,
                descripcion,tipoAccion);
        return tipoMovimientoDAO.modificar(tipoMovimiento);                
    }
    
    public Integer eliminar(Integer idTipoMovimiento){
        TipoMovimiento tipoMovimiento = new TipoMovimiento();
        tipoMovimiento.setIdTipoMovimiento(idTipoMovimiento);
        return tipoMovimientoDAO.eliminar(tipoMovimiento);
    }
    
    public ArrayList<TipoMovimiento> listarTodos(){
        return tipoMovimientoDAO.listarTodos();
    }
    
    public TipoMovimiento obtenerPorId(Integer idTipoMovimiento){
        return tipoMovimientoDAO.obtenerPorId(idTipoMovimiento);
    }    
}
