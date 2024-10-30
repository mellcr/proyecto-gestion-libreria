/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.softlib.orden.dao.LineaDeOrdenDAO;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class LineaDeOrdenDAOImpl extends DAOImpl implements LineaDeOrdenDAO{
    
    private LineaDeOrden lineaDeOrden;

    public LineaDeOrdenDAOImpl() {
        super("LineaDeOrden");
        lineaDeOrden = null;
    }
    
    @Override
    public Integer insertar(LineaDeOrden lineaDeOrden) {
        this.lineaDeOrden = lineaDeOrden;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id; 
    }

    @Override
    public Integer insertar(LineaDeOrden lineaDeOrden, Boolean usarTransaccion, 
            Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(lineaDeOrden);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "cantidad,subtotal,descuento,precioUnitario,subtotalBruto,"
                + "subtotalNeto,fidOrden,fidRecurso";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, lineaDeOrden.getCantidad());
        this.incluirParametroDouble(2, lineaDeOrden.getSubtotal());        
        this.incluirParametroDouble(3, lineaDeOrden.getDescuento());        
        this.incluirParametroDouble(4, lineaDeOrden.getPrecioUnitario());        
        this.incluirParametroDouble(5, lineaDeOrden.getSubtotalBruto());        
        this.incluirParametroDouble(6, lineaDeOrden.getSubtotalNeto());
        this.incluirParametroInt(7, lineaDeOrden.getOrdenasociada().getIdOrden());
        this.incluirParametroInt(8, lineaDeOrden.getRecurso().getIdRecurso());
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}
