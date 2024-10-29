/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.orden.daoImp;

import pe.edu.pucp.softlib.orden.dao.ComprobanteDAO;
import pe.edu.pucp.softpub.db.DAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.edu.pucp.softlib.orden.model.Comprobante;
import pe.edu.pucp.softlib.orden.model.TipoComprobante;
/**
 *
 * @author Joshua Haro
 */
public class ComprobanteDAOImpl extends DAOImpl implements ComprobanteDAO{
    private Comprobante comprobante;
    
    public ComprobanteDAOImpl(){
        super("Comprobante");
        this.comprobante = null;
    }
    
    @Override
    public Integer insertar(Comprobante comprobante) {
        this.comprobante = comprobante;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idComprobante,fechaEmision,tipoComprobante,activo,"
                + "numDocumentoAsociado,valorTotalImpuesto";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?,?, ?, ?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.comprobante.getIdComprobante());
        this.incluirParametroDate(2, this.comprobante.getFechaEmision());
        this.incluirParametroString(3, this.comprobante.getTipoComprobante().toString());
        this.incluirParametroBoolean(4, this.comprobante.getActivo());
        this.incluirParametroString(5, this.comprobante.getNumDocumentoAsociado());
        this.incluirParametroDouble(6, this.comprobante.getValorTotalImpuesto());
    }
    
    @Override
    public Integer modificar(Comprobante comprobante) {
        this.comprobante = comprobante;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fechaEmision=?, tipoComprobante=?, activo=?, "
                + "numDocumentoAsociado=?, valorTotalImpuesto=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idComprobante=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6, this.comprobante.getIdComprobante());
        this.incluirParametroDate(1, this.comprobante.getFechaEmision());
        this.incluirParametroString(2, this.comprobante.getTipoComprobante().toString());
        this.incluirParametroBoolean(3, this.comprobante.getActivo());
        this.incluirParametroString(4, this.comprobante.getNumDocumentoAsociado());
        this.incluirParametroDouble(5, this.comprobante.getValorTotalImpuesto());
    }

    @Override
    public Integer eliminar(Comprobante comprobante) {
        this.comprobante = comprobante;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.comprobante.getIdComprobante());
    }

    @Override
    public ArrayList<Comprobante> listarTodos() {
        return (ArrayList<Comprobante>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idComprobante, fechaEmision, tipoComprobante,activo,"
                + "numDocumentoAsociado,valorTotalImpuesto";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.comprobante = new Comprobante();
        this.comprobante.setIdComprobante(resultSet.getInt("idComprobante"));
        this.comprobante.setFechaEmision(resultSet.getDate("fechaEmision"));
        this.comprobante.setTipoComprobante(TipoComprobante.
                    valueOf(resultSet.getString("tipoComprobante").toUpperCase()));
        this.comprobante.setActivo(resultSet.getBoolean("activo"));
        this.comprobante.setNumDocumentoAsociado(resultSet.getString("numDocumentoAsociado"));
        this.comprobante.setValorTotalImpuesto(resultSet.getDouble("valorTotalImpuesto"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.comprobante);
    }    

    @Override
    public Comprobante obtenerPorId(Integer idComprobante) {
        this.comprobante = new Comprobante();
        this.comprobante.setIdComprobante(idComprobante);
        super.obtenerPorId();
        return this.comprobante;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.comprobante.getIdComprobante());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.comprobante = null;
    }    
}
