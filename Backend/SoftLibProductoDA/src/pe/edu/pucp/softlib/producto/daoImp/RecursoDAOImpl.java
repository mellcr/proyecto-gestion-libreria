/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class RecursoDAOImpl extends DAOImpl implements RecursoDAO{
    
    private Recurso recurso;

    public RecursoDAOImpl() {
        super("Recurso");
        this.recurso = null;
    }

    @Override
    public Integer insertar(Recurso recurso) {
        this.recurso = recurso;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(Recurso recurso, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(recurso);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre,peso,alto,ancho,precio,disponible,activo,unidadMedida,fotoRecurso";
    }
    
    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.recurso.getNombre());
        this.incluirParametroDouble(2, this.recurso.getPeso());
        this.incluirParametroDouble(3, this.recurso.getAlto());
        this.incluirParametroDouble(4, this.recurso.getAncho() );
        this.incluirParametroDouble(5, this.recurso.getPrecio());
        this.incluirParametroBoolean(6, this.recurso.getDisponible());
        this.incluirParametroBoolean(7, this.recurso.getActivo());
        this.incluirParametroString(8, this.recurso.getUnidadMedida().toString());
        this.incluirParametroFoto(9, this.recurso.getFoto());
    }

    @Override
    public Integer modificar(Recurso recurso) {
        this.recurso = recurso;
        return super.modificar();
    }

    @Override
    public Integer modificar(Recurso recurso, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(recurso);
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idRecurso = ?";
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?,peso=?,alto=?,ancho=?,precio=?,disponible=?,activo=?,"
                + "unidadMedida=?,fotoRecurso=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(10, this.recurso.getIdRecurso());
        this.incluirParametroString(1, this.recurso.getNombre());
        this.incluirParametroDouble(2, this.recurso.getPeso());
        this.incluirParametroDouble(3, this.recurso.getAlto());
        this.incluirParametroDouble(4, this.recurso.getAncho() );
        this.incluirParametroDouble(5, this.recurso.getPrecio());
        this.incluirParametroBoolean(6, this.recurso.getDisponible());      
        this.incluirParametroBoolean(7, this.recurso.getActivo());      
        this.incluirParametroString(8, this.recurso.getUnidadMedida().toString()); 
        this.incluirParametroFoto(9, this.recurso.getFoto()); 
    }

    @Override
    public Integer eliminar(Recurso recurso) {
        this.recurso = recurso;
        return super.eliminar();
    }

    @Override
    public Integer eliminar(Recurso recurso, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.eliminar(recurso);
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.recurso.getIdRecurso());
    }

    @Override
    public ArrayList<Recurso> listarTodos() {
        return (ArrayList<Recurso>) super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idRecurso,nombre,peso,alto,ancho,precio,disponible,activo,unidadMedida,fotoRecurso";
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.recurso);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.recurso = new Recurso();
        this.recurso.setIdRecurso(this.resultSet.getInt("idRecurso"));
        this.recurso.setNombre(this.resultSet.getString("nombre"));
        this.recurso.setPeso(this.resultSet.getDouble("peso"));
        this.recurso.setAlto(this.resultSet.getDouble("alto"));
        this.recurso.setAncho(this.resultSet.getDouble("ancho"));
        this.recurso.setPrecio(this.resultSet.getDouble("precio"));
        this.recurso.setDisponible(this.resultSet.getBoolean("disponible"));
        this.recurso.setActivo(this.resultSet.getBoolean("activo"));
        this.recurso.setUnidadMedida(UnidadMedida.valueOf(this.resultSet.
                getString("unidadMedida").toUpperCase()));
        // Obtener la foto del ResultSet
        byte[] fotoBytes = this.resultSet.getBytes("fotoRecurso");
        if (fotoBytes != null) {
            this.recurso.setFoto(this.convertirBytesAByteArray(fotoBytes));  // Convertir a Byte[] si es necesario
        } else {
            this.recurso.setFoto(null);  // Si no hay foto, establece nulo
        }
    }

    @Override
    public Recurso obtenerPorId(Integer idRecurso) {
        this.recurso = new Recurso();
        this.recurso.setIdRecurso(idRecurso);
        this.obtenerPorId();
        return this.recurso;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1,this.recurso.getIdRecurso());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.recurso = null;
    }

    @Override
    public Integer existeRecurso(Recurso recurso) {
        this.recurso = recurso;
        Integer idRecurso = null;
        try{
            this.abrirConexion();
            String sql = "Select idRecurso from Recurso where ";
            sql = sql.concat("nombre=?");
            sql = sql.concat("and precio=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.recurso.getNombre());
            this.incluirParametroDouble(2, this.recurso.getPrecio());
            this.ejecutarConsultaEnBD(sql);
            if(this.resultSet.next())
                idRecurso = this.resultSet.getInt("idRecurso");
        }catch(SQLException ex){
            System.err.println("Error al consultar si existe recurso - " + ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.recurso.setIdRecurso(idRecurso);
        return idRecurso;
    }   
}
