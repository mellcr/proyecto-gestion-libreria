/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.daoImp;

import pe.edu.pucp.softlib.orden.dao.OrdenVentaDAO;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.orden.dao.ComprobanteDAO;
import pe.edu.pucp.softlib.orden.dao.LineaDeOrdenDAO;
import pe.edu.pucp.softlib.orden.dao.OrdenDAO;
import pe.edu.pucp.softlib.orden.model.Comprobante;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.MetodoPago;
import pe.edu.pucp.softlib.orden.model.Orden;
import pe.edu.pucp.softlib.orden.model.TipoDeVenta;
import pe.edu.pucp.softlib.usuario.bo.ClienteBO;
import pe.edu.pucp.softlib.usuario.bo.EmpleadoBO;
import pe.edu.pucp.softpub.db.Tipo_Operacion;
/**
 *
 * @author Joshua Haro
 */
public class OrdenVentaDAOImpl extends DAOImpl implements OrdenVentaDAO{
    private OrdenVenta ordenVenta;

    public OrdenVentaDAOImpl() {
        super("OrdenVenta");
        this.ordenVenta = null;
    }
    
    @Override
    public Integer insertar(OrdenVenta ordenVenta) {
        this.ordenVenta = ordenVenta;
        Orden orden = new Orden();
        orden.toOrdenVenta(ordenVenta);
        
        OrdenDAO ordenDAO = new OrdenDAOImpl();
        LineaDeOrdenDAO lineaDeOrdenDAO =new LineaDeOrdenDAOImpl();
        Integer idOrden = ordenDAO.existeOrden(orden);
        Boolean existeOrdenVenta = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idOrden ==null){
                idOrden = ordenDAO.insertar(orden,this.usarTransaccion,
                        this.conexion);
                this.ordenVenta.setIdOrden(idOrden);
            }
            else{
                this.ordenVenta.setIdOrden(idOrden);
                Boolean abreConexion=false;
                existeOrdenVenta = this.existeOrdenVenta(this.ordenVenta,abreConexion);
            }
            if(!existeOrdenVenta){
                super.insertar();
                for(LineaDeOrden lineaDeOrden : ordenVenta.getLineasOrden()){
                    int idLineaOrden = lineaDeOrdenDAO.insertar(
                            lineaDeOrden, this.usarTransaccion, this.conexion);
                }
            }
            this.comitarTransaccion();
        }catch(SQLException ex){
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        }finally{
            try{
                this.cerrarConexion();
            }
            catch(SQLException ex){
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idOrden;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idOrdenVenta,tipoVenta,fechaEntrega,metodoPago,fidCliente";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.ordenVenta.getIdOrden());
        this.incluirParametroString(2, this.ordenVenta.getTipoVenta().toString());
        this.incluirParametroDate(3, this.ordenVenta.getFechaEntrega());
        this.incluirParametroString(4, this.ordenVenta.getMetodoPago().toString());
        this.incluirParametroInt(5, this.ordenVenta.getCliente().getIdPersona());
    }
    
    @Override
    public Integer modificar(OrdenVenta ordenVenta) {
        Integer retorno = 0;
        this.ordenVenta = ordenVenta;
        Orden orden = new Orden();
        orden.toOrdenVenta(ordenVenta);
        
        OrdenDAO ordenDAO  =new OrdenDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            ordenDAO.modificar(orden,this.usarTransaccion,this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        }catch(SQLException ex){
            System.err.println("Error al intentar modificar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }            
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }            
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "tipoVenta=?,fechaEntrega=?,metodoPago=?,fidCliente=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6,this.ordenVenta.getIdOrden());
        this.incluirParametroString(1,this.ordenVenta.getTipoVenta().toString());
        this.incluirParametroDate(2,this.ordenVenta.getFechaEntrega());
        this.incluirParametroString(3,this.ordenVenta.getMetodoPago().toString());
        this.incluirParametroInt(4,this.ordenVenta.getCliente().getIdPersona());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idOrdenVenta=?";
        else
            sql = "ven.idOrdenVenta=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(OrdenVenta ordenVenta) {
        Integer retorno = 0;
        this.ordenVenta = ordenVenta;
        Orden orden = new Orden();
        orden.setIdOrden(this.ordenVenta.getIdOrden());
        
        OrdenDAO ordenDAO = new OrdenDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            retorno = super.eliminar();
            ordenDAO.eliminar(orden, this.usarTransaccion, this.conexion);
            this.comitarTransaccion();
        }catch(SQLException ex){
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }            
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion =true;
        return retorno;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.ordenVenta.getIdOrden());
    }

    @Override
    public ArrayList<OrdenVenta> listarTodos() {
        return (ArrayList<OrdenVenta>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" ven ");
        sql = sql.concat("join Orden ord on ord.idOrden = ven.idOrdenVenta ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ord.idOrden, ord.estadoOrden, ord.fechaCreacion, "
                + "ord.total, ord.fidEmpleado,ord.activo, ven.tipoVenta, "
                + "ven.fechaEntrega,ven.metodoPago,ven.fidCliente";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.ordenVenta);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.ordenVenta = new OrdenVenta();
        this.ordenVenta.setIdOrden(this.resultSet.getInt("idOrden"));
        this.ordenVenta.setEstadoOrden(EstadoDeOrden.valueOf(
                this.resultSet.getString("estadoOrden").toUpperCase()));
        this.ordenVenta.setFechaCreacion(this.resultSet.getDate("fechaCreacion"));
        this.ordenVenta.setTotal(this.resultSet.getDouble("total"));
        EmpleadoBO empleadoBO = new EmpleadoBO();
        int idEmpleado = this.resultSet.getInt("fidEmpleado");
        this.ordenVenta.setEmpleado(empleadoBO.obtenerPorId(idEmpleado));
        this.ordenVenta.setActivo(this.resultSet.getBoolean("activo"));
        this.ordenVenta.setTipoVenta(TipoDeVenta.valueOf(
                this.resultSet.getString("tipoVenta").toUpperCase()));
        this.ordenVenta.setFechaEntrega(this.resultSet.getDate("fechaEntrega"));
        this.ordenVenta.setMetodoPago(MetodoPago.valueOf(
                this.resultSet.getString("metodoPago").toUpperCase()));
        ClienteBO clienteBO = new ClienteBO();
        int idCliente = this.resultSet.getInt("fidCliente");
        this.ordenVenta.setCliente(clienteBO.obtenerPorId(idCliente));
    }
    
    @Override
    public OrdenVenta obtenerPorId(Integer idOrdenVenta) {
        this.ordenVenta = new OrdenVenta();
        this.ordenVenta.setIdOrden(idOrdenVenta);
        super.obtenerPorId();
        return this.ordenVenta;
    } 

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" ven ");
        sql = sql.concat("join Orden ord on ord.idOrden = ven.idOrdenVenta ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.ordenVenta.getIdOrden());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.ordenVenta = null;
    }

    @Override
    public Boolean existeOrdenVenta(OrdenVenta ordenVenta) {
        Boolean abreConexion =true;
        return this.existeOrdenVenta(this.ordenVenta,abreConexion);
    }

    @Override
    public Boolean existeOrdenVenta(OrdenVenta ordenVenta, Boolean abreConexion) {
        this.ordenVenta = ordenVenta;
        Integer idOrdenVenta = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idOrdenVenta from OrdenVenta where ";
            sql = sql.concat("idOrdenVenta=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.ordenVenta.getIdOrden());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idOrdenVenta = this.resultSet.getInt("idOrdenVenta");
            }
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe el libro - " + ex);
        }finally{
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }            
        }
        return idOrdenVenta !=null;
    }    
}
