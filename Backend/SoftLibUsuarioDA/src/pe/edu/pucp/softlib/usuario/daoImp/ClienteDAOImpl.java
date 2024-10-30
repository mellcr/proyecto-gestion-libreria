/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.daoImp;

import pe.edu.pucp.softlib.usuario.dao.ClienteDAO;
import pe.edu.pucp.softlib.usuario.dao.PersonaDAO;
import pe.edu.pucp.softlib.usuario.model.Cliente;
import pe.edu.pucp.softlib.usuario.model.Persona;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.usuario.dao.PersonaXPerfilDAO;
import pe.edu.pucp.softlib.usuario.model.Perfil;
import pe.edu.pucp.softlib.usuario.model.PersonaXPerfil;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;
import pe.edu.pucp.softpub.db.Tipo_Operacion;
/**
 *
 * @author Joshua Haro
 */
public class ClienteDAOImpl extends DAOImpl implements ClienteDAO{
    private Cliente cliente;
    private String sql_filtro;

    public ClienteDAOImpl() {
        super("Cliente");
        this.cliente = null;
    }
    
    @Override
    public Integer insertar(Cliente cliente) {
        this.cliente = cliente;
        Persona persona= new Persona();
        persona.toCliente(cliente);
        
        PersonaDAO personaDAO = new PersonaDAOImpl();
        PersonaXPerfilDAO personaXPerfilDAO = new PersonaXPerfilDAOImpl();
        Integer idPersona = personaDAO.existePersona(persona);
        Boolean existeCliente = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idPersona ==null){
                idPersona = personaDAO.insertar(persona,this.usarTransaccion,
                        this.conexion);
                this.cliente.setIdPersona(idPersona);
            }
            else{
                this.cliente.setIdPersona(idPersona);
                Boolean abreConexion=false;
                existeCliente = this.existeCliente(this.cliente,abreConexion);
            }
            if(!existeCliente){
                super.insertar();
                for(Perfil perfil : cliente.getPerfiles()){
                    PersonaXPerfil personaXPerfil = 
                            new PersonaXPerfil(cliente.getIdPersona(),
                                    perfil.getIdPerfil(), true);
                    int resultado = personaXPerfilDAO.insertar(personaXPerfil);
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
        return idPersona;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idCliente,direccion";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.cliente.getIdPersona());
        this.incluirParametroString(2, this.cliente.getDireccion());
    }
    
    @Override
    public Integer modificar(Cliente cliente) {
        Integer retorno = 0;
        this.cliente = cliente;
        Persona persona = new Persona();
        persona.toCliente(cliente);
        
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
        return "direccion=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(2,this.cliente.getIdPersona());
        this.incluirParametroString(1,this.cliente.getDireccion());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idCliente=?";
        else
            sql = "cli.idCliente=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(Cliente cliente) {
        Integer retorno = 0;
        this.cliente = cliente;
        Persona persona = new Persona();
        persona.setIdPersona(this.cliente.getIdPersona());
        
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
        this.incluirParametroInt(1, this.cliente.getIdPersona());
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        return (ArrayList<Cliente>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" cli ");
        sql = sql.concat("join Persona per on per.idPersona = cli.idCliente ");
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
                + "per.tipoDocumento,cli.direccion";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.cliente);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cliente = new Cliente();
        this.cliente.setIdPersona(this.resultSet.getInt("idPersona"));
        this.cliente.setNombre(this.resultSet.getString("nombre"));
        this.cliente.setApellidoPaterno(this.resultSet.getString("apellidoPaterno"));
        this.cliente.setApellidoMaterno(this.resultSet.getString("apellidoMaterno"));
        this.cliente.setNacionalidad(this.resultSet.getString("nacionalidad"));
        this.cliente.setNumeroDocumento(this.resultSet.getString("numeroDocumento"));
        this.cliente.setTipoDocumento(
                TipoDocumento.valueOf(this.resultSet.getString("tipoDocumento").toUpperCase()));
        this.cliente.setDireccion(this.resultSet.getString("direccion"));
    }
    
    @Override
    public Cliente obtenerPorId(Integer idCliente) {
        this.cliente = new Cliente();
        this.cliente.setIdPersona(idCliente);
        super.obtenerPorId();
        return this.cliente;
    } 

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" cli ");
        sql = sql.concat("join Persona per on per.idPersona = cli.idCliente ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.cliente.getIdPersona());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cliente = null;
    }

    @Override
    public Boolean existeCliente(Cliente cliente) {
        Boolean abreConexion =true;
        return this.existeCliente(this.cliente,abreConexion);
    }

    @Override
    public Boolean existeCliente(Cliente cliente, Boolean abreConexion) {
        this.cliente = cliente;
        Integer idCliente = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idCliente from Cliente where ";
            sql = sql.concat("idCliente=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.cliente.getIdPersona());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idCliente = this.resultSet.getInt("idCliente");
            }
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe el cliente - " + ex);
        }finally{
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }            
        }
        return idCliente !=null;
    }     
    
    public ArrayList<Cliente> buscarClientes(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro = cadena + " and nombre like \"%" + nombre + "%\"";
        ArrayList<Cliente> clientes = this.listarTodos();
        this.sql_filtro = null;
        return clientes;
    }
}
