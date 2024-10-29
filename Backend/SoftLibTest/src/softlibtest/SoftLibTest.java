package softlibtest;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.bo.AutorBO;
import pe.edu.pucp.softlib.producto.bo.LibroBO;
import pe.edu.pucp.softlib.producto.bo.RecursoBO;
import pe.edu.pucp.softlib.producto.model.Autor;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.usuario.bo.ClienteBO;
import pe.edu.pucp.softlib.usuario.model.Cliente;



public class SoftLibTest {

    public static void main(String[] args) {
        RecursoBO recursoBO = new RecursoBO();
        ArrayList<Recurso> recursos = recursoBO.listarTodos();
        
        
        ClienteBO clienteBO = new ClienteBO();
        ArrayList<Cliente> clientes = clienteBO.listarTodos();
        
        LibroBO libroBO = new LibroBO();
        ArrayList<Libro> libros = libroBO.listarTodos();
     
        
        AutorBO autorBO = new AutorBO();
        ArrayList<Autor> autoresPorNombre = autorBO.buscarAutores("Gab");
        
         
        ArrayList<Libro> librosPorNombre = libroBO.buscarLibros("Cien");
        
//        ArrayList<Cliente> clientesPorNombre = clienteBO.buscarClientes("Ma"); 
        
    }
}