/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.producto.dao.LocalDAO;
import pe.edu.pucp.softlib.producto.dao.MovimientoInventarioDAO;
import pe.edu.pucp.softlib.producto.dao.TipoMovimientoDAO;
import pe.edu.pucp.softlib.producto.model.MovimientoInventario;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class MovimientoInventarioDAOImpl extends DAOImpl 
        implements MovimientoInventarioDAO{

    private MovimientoInventario movimientoInventario;
    
    public MovimientoInventarioDAOImpl() {
        super("MovimientoInventario");
        movimientoInventario = null;
    }
    
    @Override
    public Integer insertar(MovimientoInventario movimientoInventario) {
        this.movimientoInventario = movimientoInventario;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idMovimiento,fecha,cantidad,detalle,fidTipoMov,fidLocal,"
                + "fidRecurso,activo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.movimientoInventario.getIdMovimiento());
        this.incluirParametroDate(2, this.movimientoInventario.getFechaMovimiento());
        this.incluirParametroInt(3, this.movimientoInventario.getCantidad());
        this.incluirParametroString(4, this.movimientoInventario.getDetalles());
        this.incluirParametroInt(5, 
                this.movimientoInventario.getTipoMovimiento().getIdTipoMovimiento());
        this.incluirParametroInt(6, 
                this.movimientoInventario.getLocal().getIdLocal());
        this.incluirParametroInt(7, 
                this.movimientoInventario.getIdRecurso());
        this.incluirParametroBoolean(8, this.movimientoInventario.getActivo());
    }
    
    @Override
    public Integer modificar(MovimientoInventario movimientoInventario) {
        this.movimientoInventario = movimientoInventario;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fechaMovimiento=?,cantidad=?,detalle=?,fidTipoMov=?,fidLocal=?,"
                + "fidRecurso=?,activo=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idMovimiento=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(8, this.movimientoInventario.getIdMovimiento());
        this.incluirParametroDate(1, this.movimientoInventario.getFechaMovimiento());
        this.incluirParametroInt(2, this.movimientoInventario.getCantidad());
        this.incluirParametroString(3, this.movimientoInventario.getDetalles());
        this.incluirParametroInt(4, 
                this.movimientoInventario.getTipoMovimiento().getIdTipoMovimiento());
        this.incluirParametroInt(5, 
                this.movimientoInventario.getLocal().getIdLocal());
        this.incluirParametroInt(6, 
                this.movimientoInventario.getIdRecurso());
        this.incluirParametroBoolean(7, this.movimientoInventario.getActivo());
    }
    
    @Override
    public Integer eliminar(MovimientoInventario movimientoInventario) {
        this.movimientoInventario = movimientoInventario;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.movimientoInventario.getIdMovimiento());
    }
    
    @Override
    public ArrayList<MovimientoInventario> listarTodos() {
        return (ArrayList<MovimientoInventario>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idMovimiento,fecha,cantidad,detalle,fidTipoMov,fidLocal,"
                + "fidRecurso,activo";
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.movimientoInventario = new MovimientoInventario();
        this.movimientoInventario.setIdMovimiento(resultSet.getInt("idMovimiento"));
        this.movimientoInventario.setFechaMovimiento(resultSet.getDate("fecha"));
        this.movimientoInventario.setCantidad(resultSet.getInt("cantidad"));
        this.movimientoInventario.setDetalles(resultSet.getString("detalle"));
        int idLocal = resultSet.getInt("fidLocal");
        LocalDAO localDAO = new LocalDAOImpl();
        this.movimientoInventario.setLocal(localDAO.obtenerPorId(idLocal));
        int idTipoMovimiento = resultSet.getInt("fidTipoMov");
        TipoMovimientoDAO tipoMovimientoDAO = new TipoMovimientoDAOImpl();
        this.movimientoInventario.setTipoMovimiento(
                tipoMovimientoDAO.obtenerPorId(idTipoMovimiento));
        this.movimientoInventario.setIdRecurso(resultSet.getInt("fidRecurso"));
        this.movimientoInventario.setLocal(localDAO.obtenerPorId(idLocal));
        this.movimientoInventario.setActivo(resultSet.getBoolean("activo"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.movimientoInventario);
    }
    
    @Override
    public MovimientoInventario obtenerPorId(Integer idMovimientoInventario) {
        this.movimientoInventario = new MovimientoInventario();
        this.movimientoInventario.setIdMovimiento(idMovimientoInventario);
        super.obtenerPorId();
        return this.movimientoInventario;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.movimientoInventario.getIdMovimiento());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.movimientoInventario = null;
    }   
}
