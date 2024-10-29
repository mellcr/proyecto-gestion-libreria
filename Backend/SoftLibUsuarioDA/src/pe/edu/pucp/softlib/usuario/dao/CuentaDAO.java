/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.model.Cuenta;

/**
 *
 * @author Joshua Haro
 */
public interface CuentaDAO {
    public Integer insertar(Cuenta cuenta);

    public Integer modificar(Cuenta cuenta);

    public Integer eliminar(Cuenta cuenta);

    public ArrayList<Cuenta> listarTodos();

    public Cuenta obtenerPorId(Integer idCuenta);      
}
