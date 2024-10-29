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
import pe.edu.pucp.softlib.producto.model.Categoria;
import pe.edu.pucp.softlib.producto.model.Formato;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;
import pe.edu.pucp.softlib.usuario.bo.ClienteBO;
import pe.edu.pucp.softlib.usuario.model.Cliente;
import pe.edu.pucp.softlib.usuario.model.Perfil;
import pe.edu.pucp.softlib.usuario.model.TipoDocumento;

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
    public Integer recurso_insertar(@WebParam(name = "nombre")String nombre, 
                                      @WebParam(name = "peso") Double peso, 
                                      @WebParam(name = "alto") Double alto,
                                      @WebParam(name = "ancho") Double ancho, 
                                      @WebParam(name = "precio") Double precio, 
                                      @WebParam(name = "activo") Boolean activo, 
                                      @WebParam(name = "disponible") Boolean disponible, 
                                      @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                      @WebParam(name = "foto") Byte[] foto){
        return this.recursoBO.insertar(nombre, peso, alto, ancho, precio, activo, disponible, unidadMedida, foto);
    }
    
    
    @WebMethod(operationName = "recurso_modificar")
     public Integer recurso_modificar(@WebParam(name = "idRecurso")Integer idRecurso,
                                      @WebParam(name = "nombre")String nombre, 
                                      @WebParam(name = "peso") Double peso, 
                                      @WebParam(name = "alto") Double alto,
                                      @WebParam(name = "ancho") Double ancho, 
                                      @WebParam(name = "precio") Double precio, 
                                      @WebParam(name = "activo") Boolean activo, 
                                      @WebParam(name = "disponible") Boolean disponible, 
                                      @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                      @WebParam(name = "foto") Byte[] foto){
        return this.recursoBO.modificar(idRecurso, nombre,  peso, 
             alto,  ancho,  precio,  activo, 
             disponible,  unidadMedida,  foto);
    }
    
    @WebMethod(operationName = "recurso_eliminar")
    public Integer recurso_eliminar(@WebParam(name = "idRecurso") Integer idRecurso){
        return this.recursoBO.eliminar(idRecurso);
    }
    
    @WebMethod(operationName = "recurso_obtenerPorId")
    public Recurso recurso_obtenerPorId(@WebParam(name = "idRecurso") Integer idRecurso){
        return this.recursoBO.obtenerPorId(idRecurso);
    }
    
 
    @WebMethod(operationName = "recurso_listarTodos")
    public ArrayList<Recurso> recurso_listarTodos(){
        return recursoBO.listarTodos();
    }
    
    @WebMethod(operationName = "existeRecurso")
    public Integer existeRecurso(@WebParam(name = "nombre")  String nombre, 
                                 @WebParam(name = "precio") Double precio){
        return this.recursoBO.existeRecurso(nombre, precio);
    }
    
    
    
    //--------------------------------------------------------------------------
    //SERVICIOS LIBROS
    @WebMethod(operationName = "libro_insertar")
     public Integer libro_insertar(@WebParam(name = "nombre") String nombre, 
                                    @WebParam(name = "peso") Double peso, 
                                    @WebParam(name = "alto") Double alto, 
                                    @WebParam(name = "ancho") Double ancho, 
                                    @WebParam(name = "precio") Double precio, 
                                    @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                    @WebParam(name = "foto") Byte[] foto,
                                    @WebParam(name = "categorias") ArrayList<Categoria> categorias,
                                    @WebParam(name = "autor") Autor autor, 
                                    @WebParam(name = "editorial") String editorial, 
                                    @WebParam(name = "ISBN") String ISBN, 
                                    @WebParam(name = "sinopsis") String sinopsis, 
                                    @WebParam(name = "formato") Formato formato) {
        return this.libroBO.insertar( nombre,  peso,  alto,  ancho, precio,  unidadMedida,  foto,
                            categorias, autor,  editorial, ISBN,  sinopsis, formato);
    }
     
    @WebMethod(operationName = "libro_modificar")
    public Integer libro_modificar(@WebParam(name = "idLibro") Integer idLibro,
                                    @WebParam(name = "nombre") String nombre, 
                                    @WebParam(name = "peso") Double peso, 
                                    @WebParam(name = "alto") Double alto, 
                                    @WebParam(name = "ancho") Double ancho, 
                                    @WebParam(name = "precio") Double precio, 
                                    @WebParam(name = "activo") Boolean activo, 
                                    @WebParam(name = "disponible") Boolean disponible,
                                    @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                    @WebParam(name = "foto") Byte[] foto, 
                                    @WebParam(name = "categorias") ArrayList<Categoria> categorias,
                                    @WebParam(name = "autor") Autor autor, 
                                    @WebParam(name = "editorial") String editorial, 
                                    @WebParam(name = "ISBN") String ISBN, 
                                    @WebParam(name = "sinopsis") String sinopsis, 
                                    @WebParam(name = "formato") Formato formato) {
        return this.libroBO.modificar( idLibro, nombre,  peso, 
             alto,  ancho,  precio,  activo, 
             disponible, unidadMedida, foto, 
            categorias, autor,  editorial, 
             ISBN,  sinopsis,  formato);
    }
    
    @WebMethod(operationName = "libro_eliminar")
    public Integer libro_eliminar( @WebParam(name = "idLibro") Integer idLibro) {
        return this.libroBO.eliminar(idLibro);
    }
    
    @WebMethod(operationName = "libro_obtenerPorId")
    public Libro libro_obtenerPorId(@WebParam(name = "idLibro") Integer idLibro){
        return this.libroBO.obtenerPorId(idLibro);
    }
    
    @WebMethod(operationName = "existeLibro")
    public Boolean existeLibro(@WebParam(name = "idLibro") Integer idLibro){
        return this.libroBO.existeLibro(idLibro);
    } 
    
    @WebMethod(operationName = "libro_mostrarDestacado")
    public ArrayList<Libro> libro_mostrarDestacado(){
        return this.libroBO.mostrarDestacado();
    }
    
    @WebMethod(operationName = "libro_listarTodos")
    public ArrayList<Libro> libro_listarTodos(){
        return this.libroBO.listarTodos();
    }
    
    @WebMethod(operationName = "buscarLibros")
    public ArrayList<Libro> buscarLibros(@WebParam(name = "nombre") String nombre){
        return this.libroBO.buscarLibros(nombre);
    }
    
    
    //--------------------------------------------------------------------------
    //SERVICIOS OTROS RECURSOS
    
    @WebMethod(operationName = "otrosRecursos_insertar")
    public Integer otrosRecursos_insertar(@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "peso") Double peso, 
                                          @WebParam(name = "alto") Double alto, 
                                          @WebParam(name = "ancho") Double ancho, 
                                          @WebParam(name = "precio") Double precio, 
                                          @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                          @WebParam(name = "foto") Byte[] foto,
                                          @WebParam(name = "caracteristica") String caracteristica) {
        return this.otroRecursoBO.insertar(nombre, peso, alto, ancho, precio, unidadMedida, foto, caracteristica);
    }
    
    @WebMethod(operationName = "otrosRecursos_modificar")
    public Integer otrosRecursos_modificar(@WebParam(name = "idOtroRecurso") Integer idOtroRecurso,
                                            @WebParam(name = "nombre") String nombre, 
                                            @WebParam(name = "peso") Double peso, 
                                            @WebParam(name = "alto") Double alto, 
                                            @WebParam(name = "ancho") Double ancho, 
                                            @WebParam(name = "precio") Double precio,
                                            @WebParam(name = "activo") Boolean activo, 
                                            @WebParam(name = "disponible") Boolean disponible,
                                            @WebParam(name = "unidadMedida") UnidadMedida unidadMedida, 
                                            @WebParam(name = "foto") Byte[] foto,
                                            @WebParam(name = "caracteristica") String caracteristica) {
        return this.otroRecursoBO.modificar(idOtroRecurso, nombre,  peso, alto,  ancho,  precio, activo, 
             disponible, unidadMedida,  foto, caracteristica);
    }
    
    @WebMethod(operationName = "otrosRecursos_eliminar")
    public Integer otrosRecursos_eliminar(@WebParam(name = "idOtroRecurso") Integer idOtroRecurso) {
        return this.otroRecursoBO.eliminar(idOtroRecurso);
    }
    
    @WebMethod(operationName = "otrosRecursos_listarTodos")
    public ArrayList<OtroRecurso> otrosRecursos_listarTodos(){
        return this.otroRecursoBO.listarTodos();
    }
    
    @WebMethod(operationName = "otrosRecursos_obtenerPorId")
    public OtroRecurso otrosRecursos_obtenerPorId(@WebParam(name = "idOtroRecurso") Integer idOtroRecurso){
        return this.otroRecursoBO.obtenerPorId(idOtroRecurso);
    }
    
    @WebMethod(operationName = "existeOtroRecurso")
    public Boolean existeOtroRecurso(@WebParam(name = "idOtroRecurso") Integer idOtroRecurso){
        return this.otroRecursoBO.existeOtroRecurso(idOtroRecurso);
    }    
    
    @WebMethod(operationName = "otrosRecursos_mostrarDestacado")
    public ArrayList<OtroRecurso> otrosRecursos_mostrarDestacado(){
        return this.otroRecursoBO.mostrarDestacado();
    }
    
    @WebMethod(operationName = "buscarOtrosRecursos")
    public ArrayList<OtroRecurso> buscarOtrosRecursos(@WebParam(name = "nombre") String nombre){
        return this.otroRecursoBO.buscarOtrosRecursos(nombre);
    }  
    
    //SERVICIOS CLIENTES 
    
    @WebMethod(operationName = "cliente_insertar")
    public Integer cliente_insertar(@WebParam(name = "nombre") String nombre, 
                                    @WebParam(name = "apellidoPaterno") String apellidoPaterno, 
                                    @WebParam(name = "apellidoMaterno") String apellidoMaterno, 
                                    @WebParam(name = "nacionalidad") String nacionalidad, 
                                    @WebParam(name = "numeroDocumento") String numeroDocumento, 
                                    @WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento, 
                                    @WebParam(name = "perfiles") ArrayList<Perfil> perfiles,
                                    @WebParam(name = "direccion") String direccion) {
        return this.clienteBO.insertar(nombre, apellidoPaterno, 
            apellidoMaterno, nacionalidad, numeroDocumento, 
            tipoDocumento, perfiles, direccion);
    }
    
    @WebMethod(operationName = "cliente_modificar")
    public Integer cliente_modificar(@WebParam(name = "idPersona") Integer idPersona,
                                     @WebParam(name = "nombre") String nombre, 
                                     @WebParam(name = "apellidoPaterno") String apellidoPaterno, 
                                     @WebParam(name = "apellidoMaterno") String apellidoMaterno, 
                                     @WebParam(name = "nacionalidad") String nacionalidad, 
                                     @WebParam(name = "numeroDocumento") String numeroDocumento, 
                                     @WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento, 
                                     @WebParam(name = "perfiles") ArrayList<Perfil> perfiles,
                                     @WebParam(name = "direccion") String direccion) {
        return this.clienteBO.modificar(idPersona, nombre, apellidoPaterno, apellidoMaterno, nacionalidad, numeroDocumento, 
            tipoDocumento,perfiles, direccion);
    }
    
    @WebMethod(operationName = "cliente_eliminar")
    public Integer cliente_eliminar(@WebParam(name = "idCliente") Integer idCliente) {
        return this.clienteBO.eliminar(idCliente);
    }
    
    @WebMethod(operationName = "existeCliente")
    public Boolean existeCliente(@WebParam(name = "idCliente") Integer idCliente){
        return this.clienteBO.existeCliente(idCliente);
    }
      
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
    //SERVICIOS AUTORES
    
    @WebMethod(operationName = "autor_insertar")
    public Integer autor_insertar(@WebParam(name = "nombre") String nombre, 
                                  @WebParam(name = "nacionalidad") String nacionalidad) {
        return autorBO.insertar(nombre, nacionalidad);
    }
    
    @WebMethod(operationName = "autor_modificar")
    public Integer autor_modificar(@WebParam(name = "idAutor") Integer idAutor, 
                                   @WebParam(name = "nombre") String nombre,
                                   @WebParam(name = "nacionalidad") String nacionalidad,
                                   @WebParam(name = "activo") Boolean activo) {
        return autorBO.modificar(idAutor, nombre, nacionalidad, activo);                
    }
    
    @WebMethod(operationName = "autor_eliminar")
    public Integer autor_eliminar(@WebParam(name = "activo") Integer idAutor){
        return autorBO.eliminar(idAutor);
    }
    
    @WebMethod(operationName = "autor_listarTodos")
    public ArrayList<Autor> autor_listarTodos(){
        return autorBO.listarTodos();
    }
    
    @WebMethod(operationName = "autor_obtenerPorId")
    public Autor autor_obtenerPorId(@WebParam(name = "idAutor") Integer idAutor){
        return autorBO.obtenerPorId(idAutor);
    }        
    
    @WebMethod(operationName = "buscarAutores")
    public ArrayList<Autor> buscarAutores(String nombre){
        return autorBO.buscarAutores(nombre);
    }

    
    
}
