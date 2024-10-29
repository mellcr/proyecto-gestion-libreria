/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.dao.EmpleadoDAO;
import pe.edu.pucp.softlib.usuario.daoImp.EmpleadoDAOImpl;
import pe.edu.pucp.softlib.usuario.model.Empleado;
import pe.edu.pucp.softlib.usuario.model.Perfil;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;

/**
 *
 * @author Joshua Haro
 */
public class EmpleadoBO {
    private final EmpleadoDAO empleadoDAO;
    
    public EmpleadoBO(){
        this.empleadoDAO = new EmpleadoDAOImpl();
    }
    
    public Integer insertar(String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento,
            TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,Double sueldo, 
            Boolean empleadoActivo) {
        Empleado empleado = new Empleado(null, nombre, apellidoPaterno, apellidoMaterno, 
                nacionalidad, numeroDocumento,tipoDocumento,perfiles,sueldo,empleadoActivo);
        return this.empleadoDAO.insertar(empleado);
    }
    
    public Integer modificar(Integer idEmpleado,String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento, 
            TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,Double sueldo, 
            Boolean empleadoActivo) {
        Empleado empleado = new Empleado(idEmpleado, nombre, apellidoPaterno, apellidoMaterno, 
                nacionalidad, numeroDocumento,tipoDocumento,perfiles,sueldo,empleadoActivo);
        return this.empleadoDAO.modificar(empleado);
    }
    
    public Integer eliminar(Integer idEmpleado) {
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        return this.empleadoDAO.eliminar(empleado);
    }
    
    public ArrayList<Empleado> listarTodos(){
        return this.empleadoDAO.listarTodos();
    }
    
    public Empleado obtenerPorId(Integer idEmpleado){
        return this.empleadoDAO.obtenerPorId(idEmpleado);
    }
    
    public Boolean existeEmpleado(Integer idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdPersona(idEmpleado);
        return this.empleadoDAO.existeEmpleado(empleado);
    }
    
        public ArrayList<Empleado> buscarClientes(String nombre){
        return this.empleadoDAO.buscarEmpleados(nombre);
    }
}
