/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.dao.OrdenDAO;
import pe.edu.pucp.softlib.orden.daoImp.OrdenDAOImpl;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.Orden;
import pe.edu.pucp.softlib.usuario.model.Empleado;

/**
 * 
 * @author Joshua Haro
 */
public class OrdenBO {
    private final OrdenDAO ordenDAO;
    
    public OrdenBO(){
        this.ordenDAO = new OrdenDAOImpl();
    }
    
    public Integer insertar(ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Integer idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        Orden orden = new Orden(null,lineasDeOrdenes,estadoDeOrden,fechaCreacion,
                total,empleado,true);
        return this.ordenDAO.insertar(orden);
    }
    
    public Integer modificar(Integer idOrden,ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Integer idEmpleado, Boolean activo){
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        Orden orden = new Orden(idOrden,lineasDeOrdenes,estadoDeOrden,fechaCreacion,
                total,empleado,activo);
        return this.ordenDAO.modificar(orden);
    }
    
    public Integer eliminar(Integer idOrden){
        Orden orden = new Orden();
        orden.setIdOrden(idOrden);
        return this.ordenDAO.eliminar(orden);
    }
    
    public ArrayList<Orden> listarTodos(){
        return this.ordenDAO.listarTodos();
    }
    
    public Orden obtenerPorId(Integer idOrden){
        return this.ordenDAO.obtenerPorId(idOrden);
    }
    
    public Integer existeOrden(Date fechaCreacion, Double total, Integer idEmpleado){
        Orden orden= new Orden();
        orden.setFechaCreacion(fechaCreacion);
        orden.setTotal(total);
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        return this.ordenDAO.existeOrden(orden);
    }    
}
