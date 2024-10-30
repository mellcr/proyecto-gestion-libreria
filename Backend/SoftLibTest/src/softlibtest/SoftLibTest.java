package softlibtest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.bo.OrdenBO;
import pe.edu.pucp.softlib.orden.bo.OrdenVentaBO;
import pe.edu.pucp.softlib.orden.model.EstadoDeOrden;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import pe.edu.pucp.softlib.orden.model.MetodoPago;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;
import pe.edu.pucp.softlib.orden.model.TipoDeVenta;
import pe.edu.pucp.softlib.producto.bo.AutorBO;
import pe.edu.pucp.softlib.producto.bo.CampanhaBO;
import pe.edu.pucp.softlib.producto.bo.LibroBO;
import pe.edu.pucp.softlib.producto.bo.RecursoBO;
import pe.edu.pucp.softlib.producto.model.Autor;
import pe.edu.pucp.softlib.producto.model.Campanha;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.usuario.bo.ClienteBO;
import pe.edu.pucp.softlib.usuario.model.Cliente;



public class SoftLibTest {

    public static void main(String[] args) throws ParseException {
//        RecursoBO recursoBO = new RecursoBO();
//        ArrayList<Recurso> recursos = recursoBO.listarTodos();
//        
//        
//        ClienteBO clienteBO = new ClienteBO();
//        ArrayList<Cliente> clientes = clienteBO.listarTodos();
//        
//        LibroBO libroBO = new LibroBO();
//        ArrayList<Libro> libros = libroBO.listarTodos();
//     
//        
//        AutorBO autorBO = new AutorBO();
//        ArrayList<Autor> autoresPorNombre = autorBO.buscarAutores("Gab");
//        
//         
//        ArrayList<Libro> librosPorNombre = libroBO.buscarLibros("Cien");
//        
//        
//        OrdenVentaBO ordenVentaBO = new OrdenVentaBO();         
//        ArrayList<OrdenVenta> ordenesDeVenta = ordenVentaBO.listarTodos();
//        
//        CampanhaBO campañaBO = new CampanhaBO();
//        ArrayList<Campanha> campañas = campañaBO.listarTodos();
//        


        OrdenBO ordenBO = new OrdenBO();
        ArrayList<LineaDeOrden> lineas = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCreacion = dateFormat.parse("2024-09-12");
//        ordenBO.insertar(lineas, EstadoDeOrden.ENVIADO, fechaCreacion, 50.20, 1);
        OrdenVentaBO ordenVentaBO = new OrdenVentaBO();
        ordenVentaBO.insertar(lineas, EstadoDeOrden.ENVIADO, fechaCreacion, 50.20, 1, fechaCreacion, TipoDeVenta.PRESENCIAL, MetodoPago.EFECTIVO, 5);
        
    }
}