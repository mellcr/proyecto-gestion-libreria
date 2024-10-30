/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.daoImp;

import pe.edu.pucp.softlib.usuario.dao.EmpleadoDAO;
import pe.edu.pucp.softlib.usuario.dao.PersonaDAO;
import pe.edu.pucp.softlib.usuario.model.Empleado;
import pe.edu.pucp.softlib.usuario.model.Persona;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;
import pe.edu.pucp.softpub.db.Tipo_Operacion;
/**
 *
 * @author Joshua Haro
 */
public class EmpleadoDAOImpl extends DAOImpl implements EmpleadoDAO{
    private Empleado empleado;
    private String sql_filtro;

    public EmpleadoDAOImpl() {
        super("Empleado");
        this.empleado = null;
    }
    
    @Override
    public Integer insertar(Empleado empleado) {
        this.empleado = empleado;
        Persona persona= new Persona();
        persona.toEmpleado(empleado);
        
        PersonaDAO personaDAO = new PersonaDAOImpl();
        Integer idPersona = personaDAO.existePersona(persona);
        Boolean existeEmpleado = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idPersona ==null){
                idPersona = personaDAO.insertar(persona,this.usarTransaccion,
                        this.conexion);
                this.empleado.setIdPersona(idPersona);
            }
            else{
                this.empleado.setIdPersona(idPersona);
                Boolean abreConexion=false;
                existeEmpleado = this.existeEmpleado(this.empleado,abreConexion);
            }
            if(!existeEmpleado){
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
        return idPersona;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idEmpleado,sueldo,empleadoActivo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.empleado.getIdPersona());
        this.incluirParametroDouble(2, this.empleado.getSueldo());
        this.incluirParametroBoolean(3, this.empleado.getEmpleadoActivo());
    }
    
    @Override
    public Integer modificar(Empleado empleado) {
        Integer retorno = 0;
        this.empleado = empleado;
        Persona persona = new Persona();
        persona.toEmpleado(empleado);
        
        PersonaDAO personaDAO  =new PersonaDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            personaDAO.modificar(persona,this.usarTransaccion,this.conexion);
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
        return "sueldo=?,empleadoActivo=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3,this.empleado.getIdPersona());
        this.incluirParametroDouble(1, this.empleado.getSueldo());
        this.incluirParametroBoolean(2, this.empleado.getEmpleadoActivo());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idEmpleado=?";
        else
            sql = "emp.idEmpleado=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(Empleado empleado) {
        Integer retorno = 0;
        this.empleado = empleado;
        Persona persona = new Persona();
        persona.setIdPersona(this.empleado.getIdPersona());
        
        PersonaDAO personaDAO = new PersonaDAOImpl();
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            retorno = super.eliminar();
            personaDAO.eliminar(persona, this.usarTransaccion, this.conexion);
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
        this.incluirParametroInt(1, this.empleado.getIdPersona());
    }

    @Override
    public ArrayList<Empleado> listarTodos() {
        return (ArrayList<Empleado>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" emp ");
        sql = sql.concat("join Persona per on per.idPersona = emp.idEmpleado ");
        sql = sql.concat(this.obtenerPredicadoParaListado());
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "per.idPersona, per.nombre, per.apellidoPaterno, "
                + "per.apellidoMaterno, per.nacionalidad,per.numeroDocumento, "
                + "per.tipoDocumento,emp.sueldo,emp.empleadoActivo";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.empleado);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.empleado = new Empleado();
        this.empleado.setIdPersona(this.resultSet.getInt("idPersona"));
        this.empleado.setNombre(this.resultSet.getString("nombre"));
        this.empleado.setApellidoPaterno(this.resultSet.getString("apellidoPaterno"));
        this.empleado.setApellidoMaterno(this.resultSet.getString("apellidoMaterno"));
        this.empleado.setNacionalidad(this.resultSet.getString("nacionalidad"));
        this.empleado.setNumeroDocumento(this.resultSet.getString("numeroDocumento"));
        this.empleado.setTipoDocumento(
                TipoDocumento.valueOf(this.resultSet.getString("tipoDocumento").toUpperCase()));
        this.empleado.setSueldo(this.resultSet.getDouble("sueldo"));
        this.empleado.setEmpleadoActivo(this.resultSet.getBoolean("empleadoActivo"));
    }
    
    @Override
    public Empleado obtenerPorId(Integer idEmpleado) {
        this.empleado = new Empleado();
        this.empleado.setIdPersona(idEmpleado);
        super.obtenerPorId();
        return this.empleado;
    } 

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" emp ");
        sql = sql.concat("join Persona per on per.idPersona = emp.idEmpleado ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.empleado.getIdPersona());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.empleado = null;
    }

    @Override
    public Boolean existeEmpleado(Empleado empleado) {
        Boolean abreConexion =true;
        return this.existeEmpleado(this.empleado,abreConexion);
    }

    @Override
    public Boolean existeEmpleado(Empleado empleado, Boolean abreConexion) {
        this.empleado = empleado;
        Integer idEmpleado = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idEmpleado from Empleado where ";
            sql = sql.concat("idEmpleado=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.empleado.getIdPersona());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idEmpleado = this.resultSet.getInt("idEmpleado");
            }
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe el empleado - " + ex);
        }finally{
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }            
        }
        return idEmpleado !=null;
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    public ArrayList<Empleado> buscarEmpleados(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro = cadena +" and nombre like \"%" + nombre + "%\"";
        ArrayList<Empleado> empleados = this.listarTodos();
        this.sql_filtro = null;
        return empleados;
    }
}
