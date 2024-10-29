/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softlib.usuario.dao.CuentaDAO;
import pe.edu.pucp.softlib.usuario.dao.PersonaDAO;
import pe.edu.pucp.softlib.usuario.model.Cuenta;
import pe.edu.pucp.softlib.usuario.model.TipoCuenta;
import pe.edu.pucp.softpub.db.DAOImpl;

/**
 *
 * @author Joshua Haro
 */
public class CuentaDAOImpl extends DAOImpl implements CuentaDAO{
    private Cuenta cuenta; 
    
    public CuentaDAOImpl(){
        super("Cuenta");
        this.cuenta = null;
    }
    
    @Override
    public Integer insertar(Cuenta cuenta) {
        this.cuenta = cuenta;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idCuenta,usuario,contrasenha,activo,email,telefono,codigo,"
                + "tipoCuenta,totalCompras,fidPersona";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?,?, ?, ?,?, ?, ?,?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.cuenta.getIdCuenta());
        this.incluirParametroString(2, this.cuenta.getUsuario());
        this.incluirParametroString(3, this.cuenta.getContrasena());
        this.incluirParametroBoolean(4, this.cuenta.getActivo());
        this.incluirParametroString(5, this.cuenta.getEmail());
        this.incluirParametroString(6, this.cuenta.getTelefono());
        this.incluirParametroInt(7, this.cuenta.getCodigo());
        this.incluirParametroString(8, this.cuenta.getTipoCuenta().toString());
        this.incluirParametroInt(9, this.cuenta.getTotalCompras());
        this.incluirParametroInt(10, this.cuenta.getPersona().getIdPersona());
    }
    
    @Override
    public Integer modificar(Cuenta cuenta) {
        this.cuenta = cuenta;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "usuario=?, contrasenha=?, activo=?, email=?, telefono=?, "
                + "codigo=?, tipoCuenta=?, totalCompras=?, fidPersona=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCuenta=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(10, this.cuenta.getIdCuenta());
        this.incluirParametroString(1, this.cuenta.getUsuario());
        this.incluirParametroString(2, this.cuenta.getContrasena());
        this.incluirParametroBoolean(3, this.cuenta.getActivo());
        this.incluirParametroString(4, this.cuenta.getEmail());
        this.incluirParametroString(5, this.cuenta.getTelefono());
        this.incluirParametroInt(6, this.cuenta.getCodigo());
        this.incluirParametroString(7, this.cuenta.getTipoCuenta().toString());
        this.incluirParametroInt(8, this.cuenta.getTotalCompras());
        this.incluirParametroInt(9, this.cuenta.getPersona().getIdPersona());
    }

    @Override
    public Integer eliminar(Cuenta cuenta) {
        this.cuenta = cuenta;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.cuenta.getIdCuenta());
    }

    @Override
    public ArrayList<Cuenta> listarTodos() {
        return (ArrayList<Cuenta>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idCuenta,usuario,contrasenha,activo,email,telefono,codigo,"
                + "tipoCuenta,totalCompras,fidPersona";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cuenta = new Cuenta();
        this.cuenta.setIdCuenta(resultSet.getInt("idCuenta"));
        this.cuenta.setUsuario(resultSet.getString("usuario"));
        this.cuenta.setContrasena(resultSet.getString("contrasenha"));
        this.cuenta.setActivo(resultSet.getBoolean("activo"));
        this.cuenta.setEmail(resultSet.getString("email"));
        this.cuenta.setTelefono(resultSet.getString("telefono"));
        this.cuenta.setCodigo(resultSet.getInt("codigo"));
        this.cuenta.setTipoCuenta(
                TipoCuenta.valueOf(resultSet.getString("tipoCuenta").toUpperCase()));
        this.cuenta.setTotalCompras(resultSet.getInt("totalCompras"));
        PersonaDAO personaDAO = new PersonaDAOImpl();
        int idPersona = resultSet.getInt("fidPersona");
        this.cuenta.setPersona(personaDAO.obtenerPorId(idPersona));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.cuenta);
    }    

    @Override
    public Cuenta obtenerPorId(Integer idCuenta) {
        this.cuenta = new Cuenta();
        this.cuenta.setIdCuenta(idCuenta);
        super.obtenerPorId();
        return this.cuenta;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.cuenta.getIdCuenta());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cuenta = null;
    }     
}
