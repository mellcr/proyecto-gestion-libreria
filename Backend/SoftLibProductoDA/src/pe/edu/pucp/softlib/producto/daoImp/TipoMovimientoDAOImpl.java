/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.producto.dao.TipoMovimientoDAO;
import pe.edu.pucp.softlib.producto.model.TipoAccion;
import pe.edu.pucp.softlib.producto.model.TipoMovimiento;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class TipoMovimientoDAOImpl extends DAOImpl implements TipoMovimientoDAO{

    private TipoMovimiento tipoMovimiento;
    
    public TipoMovimientoDAOImpl() {
        super("TipoMovimiento");
        tipoMovimiento = null;
    }
    
    @Override
    public Integer insertar(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idTipoMovimiento,descripcion,tipoAccion";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.tipoMovimiento.getIdTipoMovimiento());
        this.incluirParametroString(2, this.tipoMovimiento.getDescripcion());
        this.incluirParametroString(3, this.tipoMovimiento.getTipoAccion().toString());
    }
    
    @Override
    public Integer modificar(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "descripcion=?,tipoAccion=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idTipoMovimiento=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3, this.tipoMovimiento.getIdTipoMovimiento());
        this.incluirParametroString(1, this.tipoMovimiento.getDescripcion());
        this.incluirParametroString(2, this.tipoMovimiento.getTipoAccion().toString());
    }
    
    @Override
    public Integer eliminar(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.tipoMovimiento.getIdTipoMovimiento());
    }
    
    @Override
    public ArrayList<TipoMovimiento> listarTodos() {
        return (ArrayList<TipoMovimiento>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idTipoMovimiento,descripcion,tipoAccion";
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tipoMovimiento = new TipoMovimiento();
        this.tipoMovimiento.setIdTipoMovimiento(resultSet.getInt("idTipoMovimiento"));
        this.tipoMovimiento.setDescripcion(resultSet.getString("descripcion"));
        this.tipoMovimiento.setTipoAccion(
                TipoAccion.valueOf(resultSet.getString("tipoAccion").toUpperCase()));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.tipoMovimiento);
    }
    
    @Override
    public TipoMovimiento obtenerPorId(Integer idTipoMovimiento) {
        this.tipoMovimiento = new TipoMovimiento();
        this.tipoMovimiento.setIdTipoMovimiento(idTipoMovimiento);
        super.obtenerPorId();
        return this.tipoMovimiento;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.tipoMovimiento.getIdTipoMovimiento());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tipoMovimiento = null;
    }  
}
