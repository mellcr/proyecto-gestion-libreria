/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.model.Empleado;

/**
 *
 * @author Joshua Haro
 */
public interface EmpleadoDAO {
    public Integer insertar(Empleado empleado);

    public Integer modificar(Empleado empleado);

    public Integer eliminar(Empleado empleado);

    public ArrayList<Empleado> listarTodos();

    public Empleado obtenerPorId(Integer idEmpleado);
    
    public Boolean existeEmpleado(Empleado empleado);
    
    public Boolean existeEmpleado(Empleado empleado, Boolean abreConexion);
         
    public ArrayList<Empleado> buscarEmpleados(String nombre);
}
