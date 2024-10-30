/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.dao.OrdenAbastecimientoDAO;
import pe.edu.pucp.softlib.orden.daoImp.OrdenAbastecimientoDAOImpl;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.OrdenAbastecimiento;
import pe.edu.pucp.softlib.usuario.model.Empleado;

/**
 *
 * @author Joshua Haro
 */
public class OrdenAbastecimientoBO {
    private final OrdenAbastecimientoDAO ordenAbastecimientoDAO;
    
    public OrdenAbastecimientoBO(){
        this.ordenAbastecimientoDAO = new OrdenAbastecimientoDAOImpl();
    }
    
    public Integer insertar(ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Integer idEmpleado, Date fechaRecepcion, String descripcion) {
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        OrdenAbastecimiento ordenAbastecimiento = 
                new OrdenAbastecimiento(null, lineasDeOrdenes, 
                estadoDeOrden, fechaCreacion, total, empleado,true,
                fechaRecepcion,descripcion);
        return this.ordenAbastecimientoDAO.insertar(ordenAbastecimiento);
    }
    
    public Integer modificar(Integer idOrdenAbastecimiento,
            ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Integer idEmpleado,Boolean activo, Date fechaRecepcion, String descripcion) {
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        OrdenAbastecimiento ordenAbastecimiento = 
                new OrdenAbastecimiento(idOrdenAbastecimiento, lineasDeOrdenes, 
                estadoDeOrden, fechaCreacion, total, empleado, activo,
                fechaRecepcion,descripcion);
        return this.ordenAbastecimientoDAO.modificar(ordenAbastecimiento);
    }
    
    public Integer eliminar(Integer idOrdenAbastecimiento) {
        OrdenAbastecimiento ordenAbastecimiento = new OrdenAbastecimiento();
        ordenAbastecimiento.setIdOrden(idOrdenAbastecimiento);
        return this.ordenAbastecimientoDAO.eliminar(ordenAbastecimiento);
    }
    
    public ArrayList<OrdenAbastecimiento> listarTodos(){
        return this.ordenAbastecimientoDAO.listarTodos();
    }
    
    public OrdenAbastecimiento obtenerPorId(Integer idOrdenAbastecimiento){
        return this.ordenAbastecimientoDAO.obtenerPorId(idOrdenAbastecimiento);
    }
    
    public Boolean existeOrdenAbastecimiento(Integer idOrdenAbastecimiento){
        OrdenAbastecimiento ordenAbastecimiento = new OrdenAbastecimiento();
        ordenAbastecimiento.setIdOrden(idOrdenAbastecimiento);
        return this.ordenAbastecimientoDAO.existeOrdenAbastecimiento
                    (ordenAbastecimiento);
    }    
}
