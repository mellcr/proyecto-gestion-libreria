/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.producto.dao.OtroRecursoDAO;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.db.Tipo_Operacion;

/**
 *
 * @author Joshua Haro
 */
public class OtroRecursoDAOImpl extends DAOImpl implements OtroRecursoDAO{
    private OtroRecurso otroRecurso;
    private String sql_filtro;
    
    public OtroRecursoDAOImpl() {
        super("OtroRecurso");
    }
    @Override
    public Integer insertar(OtroRecurso otroRecurso) {
        this.otroRecurso = otroRecurso;
        Recurso recurso = new Recurso();
        recurso.toOtroRecurso(otroRecurso);
        
        RecursoDAO recursoDAO = new RecursoDAOImpl();
        Integer idRecurso = recursoDAO.existeRecurso(recurso);
        Boolean existeOtroRecurso = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idRecurso ==null){
                idRecurso = recursoDAO.insertar(recurso,this.usarTransaccion,
                        this.conexion);
                this.otroRecurso.setIdRecurso(idRecurso);
            }
            else{
                this.otroRecurso.setIdRecurso(idRecurso);
                Boolean abreConexion=false;
                existeOtroRecurso = this.existeOtroRecurso(this.otroRecurso,
                        abreConexion);
            }
            if(!existeOtroRecurso){
                super.insertar();
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
        return idRecurso;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idOtroRecurso,caracteristica";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.otroRecurso.getIdRecurso());
        this.incluirParametroString(2, this.otroRecurso.getDescripcion());
    }
    
    @Override
    public Integer modificar(OtroRecurso otroRecurso) {
        Integer retorno = 0;
        this.otroRecurso = otroRecurso;
        Recurso recurso = new Recurso();
        recurso.toOtroRecurso(otroRecurso);
        
        RecursoDAO recursoDAO  =new RecursoDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            recursoDAO.modificar(recurso,this.usarTransaccion,this.conexion);
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
        return "caracteristica=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(2,this.otroRecurso.getIdRecurso());
        this.incluirParametroString(1,this.otroRecurso.getDescripcion());
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idOtroRecurso=?";
        else
            sql = "otr.idOtroRecurso=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(OtroRecurso otroRecurso) {
        Integer retorno = 0;
        this.otroRecurso = otroRecurso;
        Recurso recurso = new Recurso();
        recurso.setIdRecurso(this.otroRecurso.getIdRecurso());
        
        RecursoDAO recursoDAO = new RecursoDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            retorno = super.eliminar();
            recursoDAO.eliminar(recurso, this.usarTransaccion, this.conexion);
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
        this.incluirParametroInt(1, this.otroRecurso.getIdRecurso());
    }
    
    @Override
    public ArrayList<OtroRecurso> listarTodos() {
        return (ArrayList<OtroRecurso>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" otr ");
        sql = sql.concat("join Recurso rec on rec.idRecurso = otr.idOtroRecurso ");
        sql = sql.concat(this.obtenerPredicadoParaListado());
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "rec.idRecurso, rec.nombre, rec.peso, rec.alto, rec.ancho,"
                + "rec.precio, rec.disponible, rec.activo,rec.unidadMedida, "
                + "otr.caracteristica";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.otroRecurso);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.otroRecurso = new OtroRecurso();
        this.otroRecurso.setIdRecurso(this.resultSet.getInt("idRecurso"));
        this.otroRecurso.setNombre(this.resultSet.getString("nombre"));
        this.otroRecurso.setPeso(this.resultSet.getDouble("peso"));
        this.otroRecurso.setAlto(this.resultSet.getDouble("alto"));
        this.otroRecurso.setAncho(this.resultSet.getDouble("ancho"));
        this.otroRecurso.setPrecio(this.resultSet.getDouble("precio"));
        this.otroRecurso.setDisponible(this.resultSet.getBoolean("disponible"));
        this.otroRecurso.setActivo(this.resultSet.getBoolean("activo"));
        this.otroRecurso.setUnidadMedida(UnidadMedida.valueOf
                    (this.resultSet.getString("unidadMedida").toUpperCase()));
        this.otroRecurso.setDescripcion(this.resultSet.getString("caracteristica"));
    }    

    @Override
    public OtroRecurso obtenerPorId(Integer idRecurso) {
        this.otroRecurso = new OtroRecurso();
        this.otroRecurso.setIdRecurso(idRecurso);
        super.obtenerPorId();
        return this.otroRecurso;
    } 
    
    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" otr ");
        sql = sql.concat("join Recurso rec on rec.idRecurso = otr.idOtroRecurso ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.otroRecurso.getIdRecurso());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.otroRecurso = null;
    }

    @Override
    public Boolean existeOtroRecurso(OtroRecurso otroRecurso) {
        Boolean abreConexion =true;
        return this.existeOtroRecurso(this.otroRecurso,abreConexion);
    }

    @Override
    public Boolean existeOtroRecurso(OtroRecurso otroRecurso, Boolean abreConexion) {
        this.otroRecurso = otroRecurso;
        Integer idOtroRecurso = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idOtroRecurso from OtroRecurso where ";
            sql = sql.concat("idOtroRecurso=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.otroRecurso.getIdRecurso());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idOtroRecurso = this.resultSet.getInt("idOtroRecurso");
            }
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe OtroRecurso - " + ex);
        }finally{
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }            
        }
        return idOtroRecurso !=null;
    }
    
        @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    public ArrayList<OtroRecurso> buscarOtrosRecursos(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro = cadena + " and nombre like \"%" + nombre + "%\"";
        ArrayList<OtroRecurso> otroRecursos = this.listarTodos();
        this.sql_filtro = null;
        return otroRecursos;
    }
    
    public ArrayList<OtroRecurso> mostrarDestacado(){
        String cadena = super.obtenerPredicadoParaListado();
        this.sql_filtro =cadena +" and destacado=1";
        ArrayList<OtroRecurso> otroRecursos = this.listarTodos();
        this.sql_filtro = null;
        return otroRecursos;        
    }
}
