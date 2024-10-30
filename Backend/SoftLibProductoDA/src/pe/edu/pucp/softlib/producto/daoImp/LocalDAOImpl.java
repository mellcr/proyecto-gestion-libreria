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
import pe.edu.pucp.softlib.producto.dao.LocalDAO;
import pe.edu.pucp.softlib.producto.model.Local;
import pe.edu.pucp.softlib.producto.model.TipoLocal;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class LocalDAOImpl extends DAOImpl implements LocalDAO{
    private Local local;
    
    public LocalDAOImpl() {
        super("Local");
        this.local = null;
    }
    
    @Override
    public Integer insertar(Local local) {
        this.local = local;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idLocal,direccion,activo,nombre,tipoLocal,aforo,area";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.local.getIdLocal());
        this.incluirParametroString(2, this.local.getDireccion());
        this.incluirParametroBoolean(3, this.local.getActivo());
        this.incluirParametroString(4, this.local.getNombre());
        this.incluirParametroString(5, this.local.getTipoLocal().toString());
        this.incluirParametroInt(6, this.local.getAforo());
        this.incluirParametroDouble(7, this.local.getArea());
    }
    
    @Override
    public Integer modificar(Local local) {
        this.local = local;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "direccion=?, activo=?, nombre=?,tipoLocal=?,aforo=?,area=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idLocal=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(8, this.local.getIdLocal());
        this.incluirParametroString(1, this.local.getDireccion());
        this.incluirParametroBoolean(2, this.local.getActivo());
        this.incluirParametroString(4, this.local.getNombre());
        this.incluirParametroString(5, this.local.getTipoLocal().toString());
        this.incluirParametroInt(6, this.local.getAforo());
        this.incluirParametroDouble(7, this.local.getArea());
    }

    @Override
    public Integer eliminar(Local local) {
        this.local = local;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.local.getIdLocal());
    }

    @Override
    public ArrayList<Local> listarTodos() {
        return (ArrayList<Local>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idLocal, direccion, activo, nombre, tipoLocal, aforo, area";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.local = new Local();
        this.local.setIdLocal(resultSet.getInt("idLocal"));
        this.local.setDireccion(resultSet.getString("direccion"));
        this.local.setActivo(resultSet.getBoolean("activo"));
        this.local.setNombre(resultSet.getString("nombre"));
        this.local.setTipoLocal(TipoLocal.valueOf
                    (resultSet.getString("tipoLocal").toUpperCase()));
        this.local.setAforo(resultSet.getInt("aforo"));
        this.local.setArea(resultSet.getDouble("area"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.local);
    }    

    @Override
    public Local obtenerPorId(Integer idLocal) {
        this.local = new Local();
        this.local.setIdLocal(idLocal);
        super.obtenerPorId();
        return this.local;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.local.getIdLocal());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.local = null;
    }        
}
