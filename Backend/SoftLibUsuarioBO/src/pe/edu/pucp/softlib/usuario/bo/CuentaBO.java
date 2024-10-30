/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.dao.CuentaDAO;
import pe.edu.pucp.softlib.usuario.daoImp.CuentaDAOImpl;
import pe.edu.pucp.softlib.usuario.model.Cuenta;
import pe.edu.pucp.softlib.usuario.model.Persona;
import pe.edu.pucp.softlib.usuario.model.TipoCuenta;

/**
 *
 * @author Joshua Haro
 */
public class CuentaBO {

    private final CuentaDAO cuentaDAO;

    public CuentaBO() {
        this.cuentaDAO = new CuentaDAOImpl();
    }

    public Integer insertar(String usuario, String contrasena, 
            Boolean activo, String email, Integer codigo, TipoCuenta tipoCuenta, 
            Integer totalCompras, String telefono, Persona persona) {
        Cuenta cuenta = new Cuenta(null,usuario,contrasena,activo,email,codigo,
                    tipoCuenta,totalCompras,telefono,persona);
        return cuentaDAO.insertar(cuenta);
    }
    
    public Integer modificar(Integer idCuenta, String usuario, String contrasena, 
            Boolean activo, String email, Integer codigo, TipoCuenta tipoCuenta, 
            Integer totalCompras, String telefono, Persona persona) {
        Cuenta cuenta = new Cuenta(idCuenta,usuario,contrasena,activo,email,codigo,
                    tipoCuenta,totalCompras,telefono,persona);
        return cuentaDAO.modificar(cuenta);                
    }
    
    public Integer eliminar(Integer idCuenta){
        Cuenta cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);
        return cuentaDAO.eliminar(cuenta);
    }
    
    public ArrayList<Cuenta> listarTodos(){
        return cuentaDAO.listarTodos();
    }
    
    public Cuenta obtenerPorId(Integer idCuenta){
        return cuentaDAO.obtenerPorId(idCuenta);
    }    
}
