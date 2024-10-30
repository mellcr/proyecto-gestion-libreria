/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.model.Cliente;

/**
 *
 * @author Joshua Haro
 */
public interface ClienteDAO {
    public Integer insertar(Cliente cliente);

    public Integer modificar(Cliente cliente);

    public Integer eliminar(Cliente cliente);

    public ArrayList<Cliente> listarTodos();

    public Cliente obtenerPorId(Integer idCliente);
    
    public Boolean existeCliente(Cliente cliente);
    
    public Boolean existeCliente(Cliente cliente, Boolean abreConexion);
    
    public ArrayList<Cliente> buscarClientes(String nombre);
}
