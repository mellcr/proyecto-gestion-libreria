/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.dao.AutorDAO;
import pe.edu.pucp.softlib.producto.model.Autor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.edu.pucp.softpub.db.DAOImpl;
/**
 *
 * @author Joshua Haro
 */
public class AutorDAOImpl extends DAOImpl implements AutorDAO {
    private Autor autor; 
    private String sql_filtro;
    
    public AutorDAOImpl(){
        super("Autor");
        this.autor = null;
    }
    
    @Override
    public Integer insertar(Autor autor) {
        this.autor = autor;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idAutor,nombre,nacionalidad,activo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.autor.getIdAutor());
        this.incluirParametroString(2, this.autor.getNombre());
        this.incluirParametroString(3, this.autor.getNacionalidad() );
        this.incluirParametroBoolean(4, this.autor.getActivo());
    }
    
    @Override
    public Integer modificar(Autor autor) {
        this.autor = autor;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?, nacionalidad=?, activo=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idAutor=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(4, this.autor.getIdAutor());
        this.incluirParametroString(1, this.autor.getNombre());
        this.incluirParametroString(2, this.autor.getNacionalidad());
        this.incluirParametroBoolean(3, this.autor.getActivo());
    }

    @Override
    public Integer eliminar(Autor autor) {
        this.autor = autor;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.autor.getIdAutor());
    }

    @Override
    public ArrayList<Autor> listarTodos() {
        return (ArrayList<Autor>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idAutor, nombre, nacionalidad, activo";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.autor = new Autor();
        this.autor.setIdAutor(resultSet.getInt("idAutor"));
        this.autor.setNombre(resultSet.getString("nombre"));
        this.autor.setNacionalidad(resultSet.getString("nacionalidad"));
        this.autor.setActivo(resultSet.getBoolean("activo"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.autor);
    }    

    @Override
    public Autor obtenerPorId(Integer idAutor) {
        this.autor = new Autor();
        this.autor.setIdAutor(idAutor);
        super.obtenerPorId();
        return this.autor;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.autor.getIdAutor());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.autor = null;
    }  
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    public ArrayList<Autor> buscarAutores(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro = cadena +"and nombre like \"%" + nombre + "%\"";
        ArrayList<Autor> autores = this.listarTodos();
        this.sql_filtro = null;
        return autores;        
    }

    
}
