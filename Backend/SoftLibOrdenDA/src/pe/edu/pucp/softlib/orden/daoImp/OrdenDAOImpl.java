/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.daoImp;

import pe.edu.pucp.softlib.orden.dao.OrdenDAO;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.Orden;
import pe.edu.pucp.softlib.usuario.bo.EmpleadoBO;
/**
 *
 * @author Joshua Haro
 */
public class OrdenDAOImpl extends DAOImpl implements OrdenDAO{
    
    private Orden orden;

    public OrdenDAOImpl() {
        super("Orden");
        this.orden = null;
    }

    @Override
    public Integer insertar(Orden orden) {
        this.orden = orden;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(Orden orden, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(orden);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "estadoOrden,fechaCreacion,total,fidEmpleado";
    }
    
    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.orden.getEstadoOrden().toString());
        this.incluirParametroDate(2, this.orden.getFechaCreacion());
        this.incluirParametroDouble(3, this.orden.getTotal());
        this.incluirParametroInt(4, this.orden.getEmpleado().getIdPersona());
    }

    @Override
    public Integer modificar(Orden orden) {
        this.orden = orden;
        return super.modificar();
    }

    @Override
    public Integer modificar(Orden orden, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(orden);
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idOrden = ?";
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "estadoOrden=?,fechaCreacion=?,total=?,fidEmpleado=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6, this.orden.getIdOrden());
        this.incluirParametroString(1, this.orden.getEstadoOrden().toString());
        this.incluirParametroDate(2, this.orden.getFechaCreacion());
        this.incluirParametroDouble(3, this.orden.getTotal());
        this.incluirParametroInt(4, this.orden.getEmpleado().getIdPersona());           
    }

    @Override
    public Integer eliminar(Orden orden) {
        this.orden = orden;
        return super.eliminar();
    }

    @Override
    public Integer eliminar(Orden orden, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.eliminar(orden);
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.orden.getIdOrden());
    }

    @Override
    public ArrayList<Orden> listarTodos() {
        return (ArrayList<Orden>) super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idOrden,estadoOrden,fechaCreacion,total,fidEmpleado";
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.orden);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.orden = new Orden();
        this.orden.setIdOrden(this.resultSet.getInt("idOrden"));
        this.orden.setEstadoOrden(EstadoDeOrden.
                valueOf(this.resultSet.getString("estadoOrden").toUpperCase()));
        this.orden.setFechaCreacion(this.resultSet.getDate("fechaCreacion"));
        this.orden.setTotal(this.resultSet.getDouble("total"));
        EmpleadoBO empleadoBO = new EmpleadoBO();
        int idEmpleado = this.resultSet.getInt("fidEmpleado");
        this.orden.setEmpleado(empleadoBO.obtenerPorId(idEmpleado));
    }

    @Override
    public Orden obtenerPorId(Integer idOrden) {
        this.orden = new Orden();
        this.orden.setIdOrden(idOrden);
        this.obtenerPorId();
        return this.orden;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1,this.orden.getIdOrden());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.orden = null;
    }

    @Override
    public Integer existeOrden(Orden orden) {
        this.orden = orden;
        Integer idOrden = null;
        try{
            this.abrirConexion();
            String sql = "Select idOrden from Orden where ";
            sql = sql.concat("fechaCreacion=?");
            sql = sql.concat("and total=? ");
            sql = sql.concat("and fidEmpleado=? ");
            this.incluirParametroDate(1, this.orden.getFechaCreacion());
            this.incluirParametroDouble(2, this.orden.getTotal());
            this.incluirParametroInt(3, this.orden.getEmpleado().getIdPersona());
            this.ejecutarConsultaEnBD(sql);
            if(this.resultSet.next())
                idOrden = this.resultSet.getInt("idOrden");
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe orden - " + ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.orden.setIdOrden(idOrden);
        return idOrden;
    }    
}
