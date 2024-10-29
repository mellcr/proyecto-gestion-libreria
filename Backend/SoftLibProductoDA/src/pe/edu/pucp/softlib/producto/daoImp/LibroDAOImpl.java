/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.producto.dao.AutorDAO;
import pe.edu.pucp.softlib.producto.dao.CategoriaDAO;
import pe.edu.pucp.softlib.producto.dao.LibroCategoriaDAO;
import pe.edu.pucp.softlib.producto.dao.LibroDAO;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.model.Categoria;
import pe.edu.pucp.softlib.producto.model.Formato;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.LibroCategoria;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.db.Tipo_Operacion;

/**
 *
 * @author Joshua Haro
 */
public class LibroDAOImpl extends DAOImpl implements LibroDAO{
    private Libro libro;
    private String sql_filtro;

    public LibroDAOImpl() {
        super("Libro");
        this.libro = null;
    }
    
    @Override
    public Integer insertar(Libro libro) {
        this.libro = libro;
        Recurso recurso = new Recurso();
        recurso.toLibro(libro);
        
        RecursoDAO recursoDAO = new RecursoDAOImpl();
        LibroCategoriaDAO libroCategoriaDAO = new LibroCategoriaDAOImpl();
        Integer idRecurso = recursoDAO.existeRecurso(recurso);
        Boolean existeLibro = false;
        this.usarTransaccion = false;
        try{
            this.iniciarTransaccion();
            if(idRecurso ==null){
                idRecurso = recursoDAO.insertar(recurso,this.usarTransaccion,
                        this.conexion);
                this.libro.setIdRecurso(idRecurso);
            }
            else{
                this.libro.setIdRecurso(idRecurso);
                Boolean abreConexion=false;
                existeLibro = this.existeLibro(this.libro,abreConexion);
            }
            if(!existeLibro){
                super.insertar();
                for(Categoria categoria : libro.getCategorias()){
                    LibroCategoria libroCategoria= 
                            new LibroCategoria(null, libro.getIdRecurso(),
                                    categoria.getIdCategoria());
                    int idLibroCategoria = libroCategoriaDAO.insertar(
                            libroCategoria, this.usarTransaccion, this.conexion);
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
        return idRecurso;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idLibro,fidAutor,editorial,ISBN,sinopsis,formato";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1,this.libro.getIdRecurso());
        this.incluirParametroString(2, this.libro.getAutor().getNombre());
        this.incluirParametroString(3, this.libro.getEditorial());
        this.incluirParametroString(4, this.libro.getISBN());
        this.incluirParametroString(5, this.libro.getSinopsis());
        this.incluirParametroString(6, this.libro.getFormato().toString());
    }
    
    @Override
    public Integer modificar(Libro libro) {
        Integer retorno = 0;
        this.libro = libro;
        Recurso recurso = new Recurso();
        recurso.toLibro(libro);
        
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
        return "autor=?,editorial=?,ISBN=?,sinopsis=?,formato=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6,this.libro.getIdRecurso());
       
        this.incluirParametroString(1,this.libro.getEditorial());
        this.incluirParametroString(2,this.libro.getISBN());
        this.incluirParametroString(3,this.libro.getSinopsis());
        this.incluirParametroString(4,this.libro.getFormato().toString());
        this.incluirParametroString(1,(this.libro.getAutor().getIdAutor()).toString());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion == Tipo_Operacion.MODIFICAR || 
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR)
            sql = "idLibro=?";
        else
            sql = "lib.idLibro=?";
        return sql;
    }
    
    @Override
    public Integer eliminar(Libro libro) {
        Integer retorno = 0;
        this.libro = libro;
        Recurso recurso = new Recurso();
        recurso.setIdRecurso(this.libro.getIdRecurso());
        
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
        this.incluirParametroInt(1, this.libro.getIdRecurso());
    }

    @Override
    public ArrayList<Libro> listarTodos() {
        return (ArrayList<Libro>) super.listarTodos(null);
    }
    
    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" lib ");
        sql = sql.concat("join Recurso rec on rec.idRecurso = lib.idLibro ");
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
                + "lib.fidAutor,lib.editorial,lib.ISBN, lib.sinopsis, lib.formato";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.libro);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.libro = new Libro();
        this.libro.setIdRecurso(this.resultSet.getInt("idRecurso"));
        this.libro.setNombre(this.resultSet.getString("nombre"));
        this.libro.setPeso(this.resultSet.getDouble("peso"));
        this.libro.setAlto(this.resultSet.getDouble("alto"));
        this.libro.setAncho(this.resultSet.getDouble("ancho"));
        this.libro.setPrecio(this.resultSet.getDouble("precio"));
        this.libro.setDisponible(this.resultSet.getBoolean("disponible"));
        this.libro.setActivo(this.resultSet.getBoolean("activo"));
        this.libro.setUnidadMedida(UnidadMedida.valueOf
                    (this.resultSet.getString("unidadMedida").toUpperCase()));
        int idAutor =  this.resultSet.getInt("fidAutor");
        AutorDAO autorDAO = new AutorDAOImpl();
        this.libro.setAutor(autorDAO.obtenerPorId(idAutor));
        this.libro.setEditorial(this.resultSet.getString("editorial"));
        this.libro.setISBN(this.resultSet.getString("ISBN"));
        this.libro.setSinopsis(this.resultSet.getString("sinopsis"));
        this.libro.setFormato(Formato.valueOf
                            (this.resultSet.getString("formato").toUpperCase()));
    }
    
    @Override
    public Libro obtenerPorId(Integer idRecurso) {
        this.libro = new Libro();
        this.libro.setIdRecurso(idRecurso);
        super.obtenerPorId();
        return this.libro;
    } 

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" lib ");
        sql = sql.concat("join Recurso rec on rec.idRecurso = lib.idLibro ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.libro.getIdRecurso());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.libro = null;
    }

    @Override
    public Boolean existeLibro(Libro libro) {
        Boolean abreConexion =true;
        return this.existeLibro(this.libro,abreConexion);
    }

    @Override
    public Boolean existeLibro(Libro libro, Boolean abreConexion) {
        this.libro = libro;
        Integer idLibro = null;
        try{
            if(abreConexion)
                this.abrirConexion();
            String sql = "select idLibro from Libro where ";
            sql = sql.concat("idLibro=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.libro.getIdRecurso());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idLibro = this.resultSet.getInt("idLibro");
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
        return idLibro !=null;
    }
    
    public ArrayList<Libro> listarXCategoria(ArrayList<Integer> idsCategorias){
        ArrayList<Libro> libros = null;
        LibroCategoriaDAO libroCategoriaDAO = new LibroCategoriaDAOImpl();
        ArrayList<Integer> idsLibros = libroCategoriaDAO.
                listarXCategorias(idsCategorias);
        for(Integer idLibro : idsLibros){
            Libro libro = this.obtenerPorId(idLibro);
            libros.add(libro);
        }
        return libros;
    }
    
    public ArrayList<Categoria> categoriasXLibro(Integer idLibro){
        ArrayList<Categoria> categorias = null;
        LibroCategoriaDAO libroCategoriaDAO = new LibroCategoriaDAOImpl();
        CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
        ArrayList<Integer> idsCategorias = libroCategoriaDAO.categoriasXLibro(idLibro);
        for(Integer idCategoria : idsCategorias){
            Categoria categoria = categoriaDAO.obtenerPorId(idCategoria);
            categorias.add(categoria);
        }
        return categorias;
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sql_filtro != null)
            return this.sql_filtro;
        return super.obtenerPredicadoParaListado();
    }
    
    public ArrayList<Libro> buscarLibros(String nombre){
        String cadena = super.obtenerPredicadoParaListado();
        if (nombre != null && nombre != "")
            this.sql_filtro =cadena +" and nombre like \"%" + nombre + "%\"";
        ArrayList<Libro> libros = this.listarTodos();
        this.sql_filtro = null;
        return libros;
    }
    
    public ArrayList<Libro> mostrarDestacado(){
        String cadena = super.obtenerPredicadoParaListado();
        this.sql_filtro =cadena +" and destacado=1";
        ArrayList<Libro> libros = this.listarTodos();
        this.sql_filtro = null;
        return libros;        
    }
}
