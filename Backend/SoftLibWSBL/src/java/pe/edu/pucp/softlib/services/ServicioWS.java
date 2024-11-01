/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.softlib.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.bo.OrdenAbastecimientoBO;
import pe.edu.pucp.softlib.orden.bo.OrdenBO;
import pe.edu.pucp.softlib.orden.bo.OrdenVentaBO;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.MetodoPago;
import pe.edu.pucp.softlib.orden.model.Orden;
import pe.edu.pucp.softlib.orden.model.OrdenAbastecimiento;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;
import pe.edu.pucp.softlib.orden.model.TipoDeVenta;
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
    private OrdenBO ordenBO;
    private OrdenVentaBO ordenVentaBO;
    private OrdenAbastecimientoBO ordenAbastecimientoBO;
    
    public ServicioWS(){
        this.recursoBO = new RecursoBO();
        this.clienteBO = new ClienteBO();
        this.libroBO = new LibroBO();
        this.autorBO = new AutorBO();
        this.otroRecursoBO = new OtroRecursoBO();
        this.ordenBO = new OrdenBO();
        this.ordenVentaBO = new OrdenVentaBO();
        this.ordenAbastecimientoBO = new OrdenAbastecimientoBO();
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
    @WebMethod(operationName = "autor_listarTodos")
    public ArrayList<Autor> autor_listarTodos(){
        return autorBO.listarTodos();
    }

    
    //--------------------------------------------------------------------------
    //SERVICIOS ORDEN
    @WebMethod(operationName = "orden_insertar")
    public Integer orden_insertar(@WebParam(name = "lineasDeOrdenes") ArrayList<LineaDeOrden> lineasDeOrdenes,
                                  @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                                  @WebParam(name = "fechaCreacion") Date fechaCreacion, 
                                  @WebParam(name = "total") Double total, 
                                  @WebParam(name = "idEmpleado") Integer idEmpleado){
        return this.ordenBO.insertar(lineasDeOrdenes, estadoDeOrden,  fechaCreacion, total, idEmpleado);
    }
    @WebMethod(operationName = "orden_modificar")
    public Integer orden_modificar(@WebParam(name = "idOrden")  Integer idOrden,
                                    @WebParam(name = "lineasDeOrdenes")  ArrayList<LineaDeOrden> lineasDeOrdenes,
                                    @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                                    @WebParam(name = "fechaCreacion")  Date fechaCreacion, 
                                    @WebParam(name = "total")  Double total, 
                                    @WebParam(name = "idEmpleado")  Integer idEmpleado, 
                                    @WebParam(name = "activo")  Boolean activo){
        return this.ordenBO.modificar(idOrden,lineasDeOrdenes,estadoDeOrden,  fechaCreacion,  total, 
             idEmpleado,  activo);
    }
    
    @WebMethod(operationName = "orden_eliminar")
    public Integer orden_eliminar(@WebParam(name = "idOrden") Integer idOrden){
        return this.ordenBO.eliminar(idOrden);
    }
    
    @WebMethod(operationName = "orden_listarTodos")
    public ArrayList<Orden> orden_listarTodos(){
        return this.ordenBO.listarTodos();
    }
    
    @WebMethod(operationName = "orden_obtenerPorId")
    public Orden orden_obtenerPorId(@WebParam(name = "idOrden")  Integer idOrden){
        return this.ordenBO.obtenerPorId(idOrden);
    }
    
    @WebMethod(operationName = "existeOrden")
    public Integer existeOrden(@WebParam(name = "fechaCreacion") Date fechaCreacion, 
                                @WebParam(name = "total") Double total, 
                                @WebParam(name = "idEmpleado") Integer idEmpleado){
        return this.ordenBO.existeOrden( fechaCreacion,  total,  idEmpleado);
    }  
    
    //--------------------------------------------------------------------------
    //SERVICIOS ORDEN DE VENTA
    @WebMethod(operationName = "ordenVenta_insertar")
    public Integer ordenVenta_insertar(@WebParam(name = "lineasDeOrdenes") ArrayList<LineaDeOrden> lineasDeOrdenes,
                                        @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                                        @WebParam(name = "fechaCreacion") Date fechaCreacion, 
                                        @WebParam(name = "total") Double total, 
                                        @WebParam(name = "idEmpleado") Integer idEmpleado, 
                                        @WebParam(name = "fechaEntrega") Date fechaEntrega, 
                                        @WebParam(name = "tipoVenta") TipoDeVenta tipoVenta,
                                        @WebParam(name = "metodoPago") MetodoPago metodoPago, 
                                        @WebParam(name = "fidCliente") Integer fidCliente) {
        return this.ordenVentaBO.insertar(lineasDeOrdenes, estadoDeOrden,  fechaCreacion,  total, 
             idEmpleado,  fechaEntrega,  tipoVenta,  metodoPago,  fidCliente);
    }
    
    @WebMethod(operationName = "ordenVenta_modificar")
    public Integer ordenVenta_modificar(@WebParam(name = "idOrdenVenta") Integer idOrdenVenta,
                                        @WebParam(name = "lineasDeOrdenes") ArrayList<LineaDeOrden> lineasDeOrdenes,
                                        @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                                        @WebParam(name = "fechaCreacion") Date fechaCreacion, 
                                        @WebParam(name = "total") Double total, 
                                        @WebParam(name = "idEmpleado") Integer idEmpleado,
                                        @WebParam(name = "activo") Boolean activo, 
                                        @WebParam(name = "fechaEntrega") Date fechaEntrega, 
                                        @WebParam(name = "tipoVenta") TipoDeVenta tipoVenta,
                                        @WebParam(name = "metodoPago") MetodoPago metodoPago, 
                                        @WebParam(name = "fidCliente") Integer fidCliente) {
        return this.ordenVentaBO.modificar(idOrdenVenta,lineasDeOrdenes, estadoDeOrden, fechaCreacion, 
                total,  idEmpleado, activo, fechaEntrega,  tipoVenta, metodoPago, fidCliente);
    }
    
    @WebMethod(operationName = "ordenVenta_eliminar")
    public Integer ordenVenta_eliminar(@WebParam(name = "idOrdenVenta") Integer idOrdenVenta) {
        return this.ordenVentaBO.eliminar(idOrdenVenta);
    }
    
    @WebMethod(operationName = "ordenVenta_listarTodos")
    public ArrayList<OrdenVenta> ordenVenta_listarTodos(){
        return this.ordenVentaBO.listarTodos();
    }
    
    @WebMethod(operationName = "ordenVenta_obtenerPorId")
    public OrdenVenta ordenVenta_obtenerPorId(@WebParam(name = "idOrdenVenta") Integer idOrdenVenta){
        return this.ordenVentaBO.obtenerPorId(idOrdenVenta);
    }
    
    @WebMethod(operationName = "existeOrdenVenta")
    public Boolean existeOrdenVenta(@WebParam(name = "idOrdenVenta") Integer idOrdenVenta){
        return this.ordenVentaBO.existeOrdenVenta(idOrdenVenta);
    }  
    
    //--------------------------------------------------------------------------
    //SERVICIOS ORDEN DE ABASTECIMIENTO
    @WebMethod(operationName = "ordenAbastecimiento_insertar")
    public Integer ordenAbastecimiento_insertar(@WebParam(name = "lineasDeOrdenes") ArrayList<LineaDeOrden> lineasDeOrdenes,
                            @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                            @WebParam(name = "fechaCreacion") Date fechaCreacion,
                            @WebParam(name = "total") Double total, 
                            @WebParam(name = "idEmpleado") Integer idEmpleado,
                            @WebParam(name = "fechaRecepcion") Date fechaRecepcion, 
                            @WebParam(name = "descripcion") String descripcion) {
        return this.ordenAbastecimientoBO.insertar(lineasDeOrdenes,estadoDeOrden,  fechaCreacion,  total, 
             idEmpleado,  fechaRecepcion,  descripcion);
    }
    
    @WebMethod(operationName = "ordenAbastecimiento_modificar")
    public Integer ordenAbastecimiento_modificar(@WebParam(name = "idOrdenAbastecimiento") Integer idOrdenAbastecimiento,
                                                 @WebParam(name = "lineasDeOrdenes") ArrayList<LineaDeOrden> lineasDeOrdenes,
                                                 @WebParam(name = "estadoDeOrden") EstadoDeOrden estadoDeOrden, 
                                                 @WebParam(name = "fechaCreacion") Date fechaCreacion, 
                                                 @WebParam(name = "total") Double total, 
                                                 @WebParam(name = "idEmpleado") Integer idEmpleado,
                                                 @WebParam(name = "activo") Boolean activo, 
                                                 @WebParam(name = "fechaRecepcion") Date fechaRecepcion, 
                                                 @WebParam(name = "descripcion") String descripcion) {
        return this.ordenAbastecimientoBO.modificar( idOrdenAbastecimiento,
            lineasDeOrdenes,estadoDeOrden,  fechaCreacion,  total, idEmpleado, activo,  fechaRecepcion,  descripcion);
    }
    
    @WebMethod(operationName = "ordenAbastecimiento_eliminar")
    public Integer ordenAbastecimiento_eliminar(@WebParam(name = "idOrdenAbastecimiento") Integer idOrdenAbastecimiento) {
        return this.ordenAbastecimientoBO.eliminar(idOrdenAbastecimiento);
    }
    
    @WebMethod(operationName = "ordenAbastecimiento_listarTodos")
    public ArrayList<OrdenAbastecimiento> ordenAbastecimiento_listarTodos(){
        return this.ordenAbastecimientoBO.listarTodos();
    }
    
    @WebMethod(operationName = "ordenAbastecimiento_obtenerPorId")
    public OrdenAbastecimiento ordenAbastecimiento_obtenerPorId(@WebParam(name = "idOrdenAbastecimiento")Integer idOrdenAbastecimiento){
        return this.ordenAbastecimientoBO.obtenerPorId(idOrdenAbastecimiento);
    }
    
    @WebMethod(operationName = "existeOrdenAbastecimiento")
    public Boolean existeOrdenAbastecimiento(@WebParam(name = "idOrdenAbastecimiento") Integer idOrdenAbastecimiento){
        return this.ordenAbastecimientoBO.existeOrdenAbastecimiento(idOrdenAbastecimiento);
    }    
    
}
