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
    
    @WebMethod(operationName = "recurso_listarTodos")
    public ArrayList<Recurso> recurso_listarTodos(){
        return recursoBO.listarTodos();
    }
    
    @WebMethod(operationName = "cliente_listarTodos")
    public ArrayList<Cliente> cliente_listarTodos(){
        return this.clienteBO.listarTodos();
    }
    
//    
//    @WebMethod(operationName = "listarCliente")
//    public ArrayList<Cliente> listarCliente() {
//        ArrayList<Cliente> clientes = null;
//        try{
//           clienteBO = new ClienteBO();
//            clientes = clienteBO.listarTodos();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return clientes;
//    }
    @WebMethod(operationName = "libro_listarTodos")
    public ArrayList<Libro> libro_listarTodos(){
        return this.libroBO.listarTodos();
    }
    
//    @WebMethod(operationName = "listarLibros")
//    public ArrayList<Libro> listarLibros() {
//        ArrayList<Libro> libros = null;
//        try{
//           libroBO = new LibroBO();
//           libros = libroBO.listarTodos();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return libros;
//    }
    
    @WebMethod(operationName = "autor_listarTodos")
    public ArrayList<Autor> autor_listarTodos(){
        return autorBO.listarTodos();
    }
    
//    @WebMethod(operationName = "listarAutores")
//    public ArrayList<Autor> listarAutores(@WebParam(name = "nombre") String nombre) {
//        ArrayList<Autor> autores = null;
//        try{
//           autorBO= new AutorBO();
//           autores = autorBO.buscarAutores(nombre);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return autores;
//    }
    
    @WebMethod(operationName = "buscarLibros")
    public ArrayList<Libro> buscarLibros(@WebParam(name = "nombre") String nombre){
        return this.libroBO.buscarLibros(nombre);
    }
    
//    @WebMethod(operationName = "listarLibrosPorNombre")
//    public ArrayList<Libro> listarLibrosPorNombre(@WebParam(name = "nombre") String nombre) {
//        ArrayList<Libro> libros = null;
//        try{
//           libroBO = new LibroBO();
//           libros = libroBO.buscarLibros(nombre);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return libros;
//    }
    
    @WebMethod(operationName = "buscarClientes")
    public ArrayList<Cliente> buscarClientes(@WebParam(name = "nombre") String nombre){
        return this.clienteBO.buscarClientes(nombre);
    }
    
//    
//    @WebMethod(operationName = "listarClientesPorNombre")
//    public ArrayList<Cliente> listarClientesPorNombre(@WebParam(name = "nombre") String nombre) {
//        ArrayList<Cliente> clientes = null;
//        try{
//           clienteBO= new ClienteBO();
//           clientes = clienteBO.buscarClientes(nombre);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return clientes;
//    }
    
    @WebMethod(operationName = "buscarOtrosRecursos")
    public ArrayList<OtroRecurso> buscarOtrosRecursos(@WebParam(name = "nombre") String nombre){
        return this.otroRecursoBO.buscarOtrosRecursos(nombre);
    }
    
//    @WebMethod(operationName = "listarOtrosRecursosPorNombre")
//    public ArrayList<OtroRecurso> listarOtrosRecursos(@WebParam(name = "nombre") String nombre) {
//        ArrayList<OtroRecurso> otrosRecursos = null;
//        try{
//           otroRecursoBO = new OtroRecursoBO();
//           otrosRecursos = otroRecursoBO.buscarOtrosRecursos(nombre);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return otrosRecursos;
//    }
    
    @WebMethod(operationName = "cliente_obtenerPorId")
    public Cliente cliente_obtenerPorId(@WebParam(name = "idCliente") Integer idCliente){
        return this.clienteBO.obtenerPorId(idCliente);
    }
    
    
//    @WebMethod(operationName = "obtenerPorIdCliente")
//    public Cliente obtenerPorIdCliente(@WebParam(name = "idCliente") int idCliente) {
//        Cliente cliente = null;
//        try{
//           clienteBO = new ClienteBO();
//           cliente = clienteBO.obtenerPorId(idCliente);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return cliente;
//    }
    
}
