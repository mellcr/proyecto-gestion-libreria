/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.daoImp;

import pe.edu.pucp.softlib.orden.dao.OrdenAbastecimientoDAO;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.orden.dao.LineaDeOrdenDAO;
import pe.edu.pucp.softlib.orden.dao.OrdenDAO;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.Orden;
import pe.edu.pucp.softlib.orden.model.OrdenAbastecimiento;
import pe.edu.pucp.softlib.usuario.bo.EmpleadoBO;
import pe.edu.pucp.softpub.db.Tipo_Operacion;
/**
 *
 * @author Joshua Haro
 */
public class OrdenAbastecimientoDAOImpl extends DAOImpl 
        implements OrdenAbastecimientoDAO{
    private OrdenAbastecimiento ordenAbastecimiento;

    public OrdenAbastecimientoDAOImpl() {
        super("OrdenAbastecimiento");
        this.ordenAbastecimiento = null;
    }
    
    @Override
    public Integer insertar(OrdenAbastecimiento ordenAbastecimiento) {
        this.ordenAbastecimiento = ordenAbastecimiento;
        Orden orden = new Orden();
        orden.toOrdenAbastecimiento(ordenAbastecimiento);
        
        OrdenDAO ordenDAO = new OrdenDAOImpl();
        LineaDeOrdenDAO lineaDeOrdenDAO =new LineaDeOrdenDAOImpl();
        Integer idOrden = ordenDAO.existeOrden(orden);
        Boolean existeOrdenAbastecimiento = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idOrden ==null){
                idOrden = ordenDAO.insertar(orden,this.usarTransaccion,
                        this.conexion);
                this.ordenAbastecimiento.setIdOrden(idOrden);
            }
            else{
                this.ordenAbastecimiento.setIdOrden(idOrden);
                Boolean abreConexion=false;
                existeOrdenAbastecimiento = 
                        this.existeOrdenAbastecimiento(this.ordenAbastecimiento,abreConexion);
            }
            if(!existeOrdenAbastecimiento){
                super.insertar();
                for(LineaDeOrden lineaDeOrden : ordenAbastecimiento.getLineasOrden()){
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
        return "idOrdenAbastecimiento,fechaRecepcion,descripcion";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.ordenAbastecimiento.getIdOrden());
        this.incluirParametroDate(2, this.ordenAbastecimiento.getFechaRecepcion());
        this.incluirParametroString(3, this.ordenAbastecimiento.getDescripcion());
    }
    
    @Override
    public Integer modificar(OrdenAbastecimiento ordenAbastecimiento) {
        Integer retorno = 0;
        this.ordenAbastecimiento = ordenAbastecimiento;
        Orden orden = new Orden();
        orden.toOrdenAbastecimiento(ordenAbastecimiento);
        
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
        return "fechaRecepcion=?,descripcion=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3,this.ordenAbastecimiento.getIdOrden());
        this.incluirParametroDate(1,this.ordenAbastecimiento.getFechaRecepcion());
        this.incluirParametroString(2,this.ordenAbastecimiento.getDescripcion());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idOrdenAbastecimiento=?";
        else
            sql = "aba.idOrdenAbastecimiento=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(OrdenAbastecimiento ordenAbastecimiento) {
        Integer retorno = 0;
        this.ordenAbastecimiento = ordenAbastecimiento;
        Orden orden = new Orden();
        orden.setIdOrden(this.ordenAbastecimiento.getIdOrden());
        
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
        this.incluirParametroInt(1, this.ordenAbastecimiento.getIdOrden());
    }

    @Override
    public ArrayList<OrdenAbastecimiento> listarTodos() {
        return (ArrayList<OrdenAbastecimiento>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" aba ");
        sql = sql.concat("join Orden ord on ord.idOrden = aba.idOrdenAbastecimiento ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ord.idOrden, ord.estadoOrden, ord.fechaCreacion, "
                + "ord.total, ord.fidEmpleado,ord.activo, aba.fechaRecepcion, "
                + "aba.descripcion";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.ordenAbastecimiento);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.ordenAbastecimiento = new OrdenAbastecimiento();
        this.ordenAbastecimiento.setIdOrden(this.resultSet.getInt("idOrden"));
        this.ordenAbastecimiento.setEstadoOrden(EstadoDeOrden.valueOf(
                this.resultSet.getString("estadoOrden").toUpperCase()));
        this.ordenAbastecimiento.setFechaCreacion(this.resultSet.getDate("fechaCreacion"));
        this.ordenAbastecimiento.setTotal(this.resultSet.getDouble("total"));
        EmpleadoBO empleadoBO = new EmpleadoBO();
        int idEmpleado = this.resultSet.getInt("fidEmpleado");
        this.ordenAbastecimiento.setEmpleado(empleadoBO.obtenerPorId(idEmpleado));
        this.ordenAbastecimiento.setActivo(this.resultSet.getBoolean("activo"));
        this.ordenAbastecimiento.setFechaRecepcion
                            (this.resultSet.getDate("fechaRecepcion"));
        this.ordenAbastecimiento.setDescripcion(this.resultSet.getString("descripcion"));
    }
    
    @Override
    public OrdenAbastecimiento obtenerPorId(Integer idOrdenAbastecimiento) {
        this.ordenAbastecimiento = new OrdenAbastecimiento();
        this.ordenAbastecimiento.setIdOrden(idOrdenAbastecimiento);
        super.obtenerPorId();
        return this.ordenAbastecimiento;
    } 

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" aba ");
        sql = sql.concat("join Orden ord on ord.idOrden = aba.idOrdenAbastecimiento ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.ordenAbastecimiento.getIdOrden());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.ordenAbastecimiento = null;
    }

    @Override
    public Boolean existeOrdenAbastecimiento(OrdenAbastecimiento ordenAbastecimiento) {
        Boolean abreConexion =true;
        return this.existeOrdenAbastecimiento(this.ordenAbastecimiento,abreConexion);
    }

    @Override
    public Boolean existeOrdenAbastecimiento(OrdenAbastecimiento ordenAbastecimiento,
            Boolean abreConexion) {
        this.ordenAbastecimiento = ordenAbastecimiento;
        Integer idOrdenVenta = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idOrdenAbastecimiento from OrdenAbastecimiento where ";
            sql = sql.concat("idOrdenAbastecimiento=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.ordenAbastecimiento.getIdOrden());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idOrdenVenta = this.resultSet.getInt("idOrdenAbastecimiento");
            }
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe el ordenAbastecimiento - " + ex);
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
