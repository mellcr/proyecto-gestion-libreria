/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.dao.CategoriaDAO;
import pe.edu.pucp.softlib.producto.model.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class CategoriaDAOImpl extends DAOImpl implements CategoriaDAO{
    private Categoria categoria; 
    private String sql_filtro;
    
    public CategoriaDAOImpl(){
        super("Categoria");
        this.categoria = null;
    }
    
    @Override
    public Integer insertar(Categoria categoria) {
        this.categoria = categoria;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idCategoria,nombre, activo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.categoria.getIdCategoria());
        this.incluirParametroString(2, this.categoria.getNombre());
        this.incluirParametroBoolean(3, this.categoria.getActivo());
    }
    
    @Override
    public Integer modificar(Categoria categoria) {
        this.categoria = categoria;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?, activo=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCategoria=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3, this.categoria.getIdCategoria());
        this.incluirParametroString(1, this.categoria.getNombre());
        this.incluirParametroBoolean(2, this.categoria.getActivo());
    }

    @Override
    public Integer eliminar(Categoria categoria) {
        this.categoria = categoria;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.categoria.getIdCategoria());
    }

    @Override
    public ArrayList<Categoria> listarTodos() {
        return (ArrayList<Categoria>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idCategoria, nombre, activo";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.categoria = new Categoria();
        this.categoria.setIdCategoria(resultSet.getInt("idCategoria"));
        this.categoria.setNombre(resultSet.getString("nombre"));
        this.categoria.setActivo(resultSet.getBoolean("activo"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.categoria);
    }    

    @Override
    public Categoria obtenerPorId(Integer idCategoria) {
        this.categoria = new Categoria();
        this.categoria.setIdCategoria(idCategoria);
        super.obtenerPorId();
        return this.categoria;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.categoria.getIdCategoria());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.categoria = null;
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    public ArrayList<Categoria> buscarCategorias(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro = cadena + " and nombre like \"%" + nombre + "%\"";
        ArrayList<Categoria> categorias = this.listarTodos();
        this.sql_filtro = null;
        return categorias;        
    }
}
