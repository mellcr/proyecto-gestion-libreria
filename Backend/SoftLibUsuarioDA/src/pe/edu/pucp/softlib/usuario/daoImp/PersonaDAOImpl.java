/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.usuario.dao.PersonaDAO;
import pe.edu.pucp.softlib.usuario.model.Persona;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class PersonaDAOImpl extends DAOImpl implements PersonaDAO{
    private Persona persona;
    
    public PersonaDAOImpl() {
        super("Persona");
        this.persona = null;
    }

    @Override
    public Integer insertar(Persona persona) {
        this.persona = persona;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(Persona persona, Boolean usarTransaccion, 
            Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(persona);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre,apellidoPaterno,apellidoMaterno,nacionalidad,"
                + "numeroDocumento,tipoDocumento";
    }
    
    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.persona.getNombre());
        this.incluirParametroString(2, this.persona.getApellidoPaterno());
        this.incluirParametroString(3, this.persona.getApellidoMaterno());
        this.incluirParametroString(4, this.persona.getNacionalidad());
        this.incluirParametroString(5, this.persona.getNumeroDocumento());
        this.incluirParametroString(6, this.persona.getTipoDocumento().toString());
    }

    @Override
    public Integer modificar(Persona persona) {
        this.persona = persona;
        return super.modificar();
    }

    @Override
    public Integer modificar(Persona persona, Boolean usarTransaccion, 
            Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(persona);
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPersona = ?";
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?,apellidoPaterno=?,apellidoMaterno=?,nacionalidad=?,"
                + "numeroDocumento=?,tipoDocumento=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(7, this.persona.getIdPersona());
        this.incluirParametroString(1, this.persona.getNombre());
        this.incluirParametroString(2, this.persona.getApellidoPaterno());
        this.incluirParametroString(3, this.persona.getApellidoMaterno());
        this.incluirParametroString(4, this.persona.getNacionalidad());
        this.incluirParametroString(5, this.persona.getNumeroDocumento());
        this.incluirParametroString(6, this.persona.getTipoDocumento().toString());
    }

    @Override
    public Integer eliminar(Persona persona) {
        this.persona = persona;
        return super.eliminar();
    }

    @Override
    public Integer eliminar(Persona persona, Boolean usarTransaccion, 
            Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.eliminar(persona);
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.persona.getIdPersona());
    }

    @Override
    public ArrayList<Persona> listarTodos() {
        return (ArrayList<Persona>) super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idPersona,nombre,apellidoPaterno,apellidoMaterno,nacionalidad,"
                + "numeroDocumento,tipoDocumento";
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.persona);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.persona = new Persona();
        this.persona.setIdPersona(this.resultSet.getInt("idPersona"));
        this.persona.setNombre(this.resultSet.getString("nombre"));
        this.persona.setApellidoPaterno(this.resultSet.getString("apellidoPaterno"));
        this.persona.setApellidoMaterno(this.resultSet.getString("apellidoMaterno"));
        this.persona.setNacionalidad(this.resultSet.getString("nacionalidad"));
        this.persona.setNumeroDocumento(this.resultSet.getString("numeroDocumento"));
        this.persona.setTipoDocumento(
                TipoDocumento.valueOf(this.resultSet.getString("tipoDocumento").
                        toUpperCase()));
    }

    @Override
    public Persona obtenerPorId(Integer idPersona) {
        this.persona = new Persona();
        this.persona.setIdPersona(idPersona);
        this.obtenerPorId();
        return this.persona;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1,this.persona.getIdPersona());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.persona = null;
    }

    @Override
    public Integer existePersona(Persona persona) {
        this.persona = persona;
        Integer idPersona = null;
        try{
            this.abrirConexion();
            String sql = "Select idPersona from Persona where ";
            sql = sql.concat("nombre=?");
            sql = sql.concat("and apellidoPaterno=? ");
            sql = sql.concat("and apellidoMaterno=? ");
            sql = sql.concat("and nacionalidad=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.persona.getNombre());
            this.incluirParametroString(2, this.persona.getApellidoPaterno());
            this.incluirParametroString(3, this.persona.getApellidoMaterno());
            this.incluirParametroString(4, this.persona.getNacionalidad());
            this.ejecutarConsultaEnBD(sql);
            if(this.resultSet.next())
                idPersona = this.resultSet.getInt("idPersona");
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe persona - " + ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.persona.setIdPersona(idPersona);
        return idPersona;
    }        
}
