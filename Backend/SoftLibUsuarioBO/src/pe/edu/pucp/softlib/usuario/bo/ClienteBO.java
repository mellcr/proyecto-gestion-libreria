/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.softlib.usuario.dao.ClienteDAO;
import pe.edu.pucp.softlib.usuario.daoImp.ClienteDAOImpl;
import pe.edu.pucp.softlib.usuario.model.Cliente;
import pe.edu.pucp.softlib.usuario.model.Perfil;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;

/**
 *
 * @author Joshua Haro
 */
public class ClienteBO {
    private final ClienteDAO clienteDAO;
    
    public ClienteBO(){
        this.clienteDAO = new ClienteDAOImpl();
    }
    
    public Integer insertar(String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento, 
            TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,String direccion) {
        Cliente cliente = new Cliente(null, nombre, apellidoPaterno, apellidoMaterno, 
                nacionalidad, numeroDocumento,tipoDocumento,perfiles,direccion);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer modificar(Integer idPersona,String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento, 
            TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,String direccion) {
        Cliente cliente = new Cliente(idPersona, nombre, apellidoPaterno, apellidoMaterno, 
                nacionalidad, numeroDocumento,tipoDocumento,perfiles,direccion);
        return this.clienteDAO.modificar(cliente);
    }
    
    public Integer eliminar(Integer idCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdPersona(idCliente);
        return this.clienteDAO.eliminar(cliente);
    }
    
    public ArrayList<Cliente> listarTodos(){
        return this.clienteDAO.listarTodos();
    }
    
    public Cliente obtenerPorId(Integer idCliente){
        return this.clienteDAO.obtenerPorId(idCliente);
    }
    
    public Boolean existeCliente(Integer idCliente){
        Cliente cliente = new Cliente();
        cliente.setIdPersona(idCliente);
        return this.clienteDAO.existeCliente(cliente);
    }
    
    public ArrayList<Cliente> buscarClientes(String nombre){
        return this.clienteDAO.buscarClientes(nombre);
    }
}
