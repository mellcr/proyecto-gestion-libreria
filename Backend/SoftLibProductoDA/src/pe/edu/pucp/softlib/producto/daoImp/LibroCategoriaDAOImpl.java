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
import pe.edu.pucp.softlib.producto.dao.LibroCategoriaDAO;
import pe.edu.pucp.softlib.producto.model.LibroCategoria;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class LibroCategoriaDAOImpl extends DAOImpl implements LibroCategoriaDAO{

    private LibroCategoria libroCategoria;
    
    public LibroCategoriaDAOImpl() {
        super("LibroXCategoria");
        this.libroCategoria = null;
    }
    
    @Override
    public Integer insertar(LibroCategoria libroCategoria) {
        this.libroCategoria = libroCategoria;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;        
    }

    @Override
    public Integer insertar(LibroCategoria libroCategoria, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(libroCategoria);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idLibro,idCategoria";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, libroCategoria.getIdLibro());
        this.incluirParametroInt(2, libroCategoria.getIdCategoria());
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCategoria=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idLibro";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.libroCategoria.getIdCategoria());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
    
    public ArrayList<Integer> listarXCategorias(ArrayList<Integer> idsCategorias) {
        ArrayList<Integer> listaIdsLibros = new ArrayList<Integer>();
        try {
            this.abrirConexion();
            for (Integer id : idsCategorias) {
                String sql = this.generarSQLParaListarPorId();  // Se genera el SQL para listar libros por categoría
                this.colocarSQLenStatement(sql);
                this.incluirValorDeParametrosParaObtenerPorId(); // Asegúrate de pasar el id de categoría actual
                this.ejecutarConsultaEnBD(sql);
                while (this.resultSet.next()) {
                    Integer idLibro = this.resultSet.getInt("idLibro");
                    boolean existeLibro = false;  // Restablecer existeLibro en cada iteración del while
                    // Usamos .equals() para comparar correctamente objetos Integer
                    for (Integer comprobarId : listaIdsLibros) {
                        if (idLibro.equals(comprobarId)) {
                            existeLibro = true;
                            break;
                        }
                    }
                    // Si el libro no existe en la lista, lo añadimos
                    if (!existeLibro) {
                        listaIdsLibros.add(idLibro);
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return listaIdsLibros;
    }
    
    public ArrayList<Integer> categoriasXLibro(Integer idLibro){
        ArrayList<Integer> listaIdsCategorias = new ArrayList<Integer>();
        try {
            this.abrirConexion();
            String sql = "Select idCategoria from " + nombre_tabla 
                    + " where idLibro=" + idLibro;
            this.colocarSQLenStatement(sql);
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Integer idCategoria = this.resultSet.getInt("idCategoria");
                listaIdsCategorias.add(idCategoria);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return listaIdsCategorias;
    }
}
