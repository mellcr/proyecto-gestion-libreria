/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.dao.CampanhaDAO;
import pe.edu.pucp.softlib.producto.model.Campanha;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.edu.pucp.softlib.producto.model.EstadoCampanha;
import pe.edu.pucp.softpub.db.DAOImpl;
/**
 *
 * @author Joshua Haro
 */
public class CampanhaDAOImpl extends DAOImpl implements CampanhaDAO{
    private Campanha campanha; 
    
    public CampanhaDAOImpl(){
        super("Campanha");
        this.campanha = null;
    }
    
    @Override
    public Integer insertar(Campanha campanha) {
        this.campanha = campanha;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idCampanha,fechaInicio, fechaFin,descripcion,estado,"
                + "porcentajeDescuento,activo,banner";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.campanha.getIdCampanha());
        this.incluirParametroDate(2, this.campanha.getFechaInicio());
        this.incluirParametroDate(3, this.campanha.getFechaFin());
        this.incluirParametroString(4, this.campanha.getDescripcion());
        this.incluirParametroString(5, this.campanha.getEstado().toString());
        this.incluirParametroDouble(6, this.campanha.getPorcentajeDescuento());
        this.incluirParametroBoolean(7, this.campanha.getActivo());
        this.incluirParametroFoto(8, this.campanha.getBanner());
    }
    
    @Override
    public Integer modificar(Campanha campanha) {
        this.campanha = campanha;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "descripcion=?, estado=?, porcentajeDescuento=?,activo=?,foto=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCampanha=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(5, this.campanha.getIdCampanha());
        this.incluirParametroString(1, this.campanha.getDescripcion());
        this.incluirParametroString(2, this.campanha.getEstado().toString());
        this.incluirParametroDouble(3, this.campanha.getPorcentajeDescuento());
        this.incluirParametroBoolean(4, this.campanha.getActivo());
        this.incluirParametroFoto(5, this.campanha.getBanner());
    }

    @Override
    public Integer eliminar(Campanha campanha) {
        this.campanha = campanha;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.campanha.getIdCampanha());
    }

    @Override
    public ArrayList<Campanha> listarTodos() {
        return (ArrayList<Campanha>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idCampanha, fechaInicio, fechaFin,descripcion,estado,"
                + "porcentajeDescuento,activo,foto";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.campanha = new Campanha();
        this.campanha.setIdCampanha(resultSet.getInt("idCampanha"));
        this.campanha.setFechaInicio(resultSet.getDate("fechaInicio"));
        this.campanha.setFechaFin(resultSet.getDate("fechaFin"));
        this.campanha.setDescripcion(resultSet.getString("descripcion"));
        this.campanha.setEstado(EstadoCampanha.
                valueOf(resultSet.getString("estado").toUpperCase()));  
        this.campanha.setPorcentajeDescuento(resultSet.getDouble("porcentajeDescuento"));
        this.campanha.setActivo(resultSet.getBoolean("activo"));
        byte[] fotoBytes = this.resultSet.getBytes("foto");
        if (fotoBytes != null) {
            this.campanha.setBanner(this.convertirBytesAByteArray(fotoBytes));  // Convertir a Byte[] si es necesario
        } else {
            this.campanha.setBanner(null);  // Si no hay foto, establece nulo
        }
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.campanha);
    }    

    @Override
    public Campanha obtenerPorId(Integer idCategoria) {
        this.campanha = new Campanha();
        this.campanha.setIdCampanha(idCategoria);
        super.obtenerPorId();
        return this.campanha;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.campanha.getIdCampanha());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.campanha = null;
    }    
}
