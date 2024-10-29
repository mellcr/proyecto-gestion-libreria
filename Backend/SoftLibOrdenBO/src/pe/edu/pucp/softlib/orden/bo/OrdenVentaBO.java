/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.dao.OrdenVentaDAO;
import pe.edu.pucp.softlib.orden.daoImp.OrdenVentaDAOImpl;
import pe.edu.pucp.softlib.orden.model.Comprobante;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.MetodoPago;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;
import pe.edu.pucp.softlib.orden.model.TipoDeVenta;
import pe.edu.pucp.softlib.usuario.model.Cliente;
import pe.edu.pucp.softlib.usuario.model.Empleado;

/**
 *
 * @author Joshua Haro
 */
public class OrdenVentaBO {
    private final OrdenVentaDAO ordenVentaDAO;
    
    public OrdenVentaBO(){
        this.ordenVentaDAO = new OrdenVentaDAOImpl();
    }
    
    public Integer insertar(ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Integer idEmpleado, Date fechaEntrega, TipoDeVenta tipoVenta,
            MetodoPago metodoPago, Integer fidCliente, Integer fidComprobante) {
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        Cliente cliente = new Cliente();
        cliente.setIdPersona(fidCliente);
        Comprobante comprobante = new Comprobante();
        comprobante.setIdComprobante(fidComprobante);
        OrdenVenta ordenVenta = new OrdenVenta(null, lineasDeOrdenes, 
                estadoDeOrden, fechaCreacion, total, empleado,true,
                fechaEntrega,tipoVenta,metodoPago, cliente,comprobante);
        return this.ordenVentaDAO.insertar(ordenVenta);
    }
    
    public Integer modificar(Integer idOrdenVenta,
            ArrayList<LineaDeOrden> lineasDeOrdenes,EstadoDeOrden estadoDeOrden, 
            Date fechaCreacion, Double total, Integer idEmpleado,Boolean activo, 
            Date fechaEntrega, TipoDeVenta tipoVenta,MetodoPago metodoPago, 
            Integer fidCliente, Integer fidComprobante) {
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        Cliente cliente = new Cliente();
        cliente.setIdPersona(fidCliente);
        Comprobante comprobante = new Comprobante();
        comprobante.setIdComprobante(fidComprobante);
        OrdenVenta ordenVenta = new OrdenVenta(idOrdenVenta, lineasDeOrdenes, 
                estadoDeOrden, fechaCreacion, total, empleado, activo,
                fechaEntrega,tipoVenta,metodoPago,cliente, comprobante);
        return this.ordenVentaDAO.modificar(ordenVenta);
    }
    
    public Integer eliminar(Integer idOrdenVenta) {
        OrdenVenta ordenVenta = new OrdenVenta();
        ordenVenta.setIdOrden(idOrdenVenta);
        return this.ordenVentaDAO.eliminar(ordenVenta);
    }
    
    public ArrayList<OrdenVenta> listarTodos(){
        return this.ordenVentaDAO.listarTodos();
    }
    
    public OrdenVenta obtenerPorId(Integer idOrdenVenta){
        return this.ordenVentaDAO.obtenerPorId(idOrdenVenta);
    }
    
    public Boolean existeOrdenVenta(Integer idOrdenVenta){
        OrdenVenta ordenVenta = new OrdenVenta();
        ordenVenta.setIdOrden(idOrdenVenta);
        return this.ordenVentaDAO.existeOrdenVenta(ordenVenta);
    }     
}
