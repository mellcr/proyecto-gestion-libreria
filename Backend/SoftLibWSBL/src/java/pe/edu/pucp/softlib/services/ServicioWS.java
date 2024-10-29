/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.softlib.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.bo.AutorBO;
import pe.edu.pucp.softlib.producto.bo.LibroBO;
import pe.edu.pucp.softlib.producto.bo.OtroRecursoBO;
import pe.edu.pucp.softlib.producto.bo.RecursoBO;
import pe.edu.pucp.softlib.producto.model.Autor;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;
import pe.edu.pucp.softlib.usuario.bo.ClienteBO;
import pe.edu.pucp.softlib.usuario.model.Cliente;

/**
 *
 * @author lhia_
 */
@WebService(serviceName = "ServicioWS")
public class ServicioWS {

    private RecursoBO recursoBO;
    private ClienteBO clienteBO;
    private LibroBO libroBO;
    private AutorBO autorBO;
    private OtroRecursoBO otroRecursoBO;
    
    public ServicioWS(){
        this.recursoBO = new RecursoBO();
        this.clienteBO = new ClienteBO();
        this.libroBO = new LibroBO();
        this.autorBO = new AutorBO();
        this.otroRecursoBO = new OtroRecursoBO();
    }
    
    //SERVICIOS RECURSOS 
    
    @WebMethod(operationName = "recurso_insertar")
    public Integer recurso_insertar(String nombre, Double peso, Double alto, Double ancho, 
            Double precio, Boolean activo, Boolean disponible, 
            UnidadMedida unidadMedida, Byte[] foto){
        return this.recursoBO.insertar(nombre, peso, alto, ancho, 
            precio, activo, disponible, 
            unidadMedida, foto);
    }
    
    @WebMethod(operationName = "recurso_listarTodos")
    public ArrayList<Recurso> recurso_listarTodos(){
        return recursoBO.listarTodos();
    }
    
    
    //SERVICIOS CLIENTES 
    @WebMethod(operationName = "cliente_listarTodos")
    public ArrayList<Cliente> cliente_listarTodos(){
        return this.clienteBO.listarTodos();
    }
    
    @WebMethod(operationName = "buscarClientes")
    public ArrayList<Cliente> buscarClientes(@WebParam(name = "nombre") String nombre){
        return this.clienteBO.buscarClientes(nombre);
    }
    
    @WebMethod(operationName = "cliente_obtenerPorId")
    public Cliente cliente_obtenerPorId(@WebParam(name = "idCliente") Integer idCliente){
        return this.clienteBO.obtenerPorId(idCliente);
    }
    

    //--------------------------------------------------------------------------
    //SERVICIOS LIBROS
    @WebMethod(operationName = "libro_listarTodos")
    public ArrayList<Libro> libro_listarTodos(){
        return this.libroBO.listarTodos();
    }
    
    @WebMethod(operationName = "buscarLibros")
    public ArrayList<Libro> buscarLibros(@WebParam(name = "nombre") String nombre){
        return this.libroBO.buscarLibros(nombre);
    }
    
    //--------------------------------------------------------------------------
    //SERVICIOS AUTORES
    @WebMethod(operationName = "autor_listarTodos")
    public ArrayList<Autor> autor_listarTodos(){
        return autorBO.listarTodos();
    }

    
    //--------------------------------------------------------------------------
    //SERVICIOS OTROS RECURSOS
    @WebMethod(operationName = "buscarOtrosRecursos")
    public ArrayList<OtroRecurso> buscarOtrosRecursos(@WebParam(name = "nombre") String nombre){
        return this.otroRecursoBO.buscarOtrosRecursos(nombre);
    }  
}
