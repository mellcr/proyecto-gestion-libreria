package softlibproductotest;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.producto.bo.AutorBO;
//import pe.edu.pucp.softlib.producto.bo.AlmacenBO;
import pe.edu.pucp.softlib.producto.bo.CampanhaBO;
import pe.edu.pucp.softlib.producto.bo.CategoriaBO;
import pe.edu.pucp.softlib.producto.bo.LibroBO;
import pe.edu.pucp.softlib.producto.bo.OtroRecursoBO;
import pe.edu.pucp.softlib.producto.model.Autor;
import pe.edu.pucp.softlib.producto.model.Campanha;
import pe.edu.pucp.softlib.producto.model.Categoria;
import pe.edu.pucp.softlib.producto.model.EstadoCampanha;
import pe.edu.pucp.softlib.producto.model.Formato;
import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.UnidadMedida;

/*
 * Author: mellcr
 */
public class SoftLibProductoTest {

    public static void main(String[] args) {
        CampanhaBOTest();
    }
    
    private static void CampanhaBOTest(){
        int resultado;
        AutorBO autorBO = new AutorBO();
        /*resultado = autorBO.insertar("Dante Alighieri", "Italiana");
        if(resultado!=0)
            System.out.println("Se inserto correctamente");
        else
            System.out.println("No se logro insertar el autor");*/
        resultado = autorBO.eliminar(1);
        if(resultado!=0)
            System.out.println("Se elimino correctamente");
        else
            System.out.println("No se logro eliminar el autor");
        ArrayList<Autor> listarAutores = autorBO.listarTodos();
        for(Autor autor : listarAutores)
            System.out.println(autor.getNombre());
        /*Probando Libros*/
//        LibroBO libroBO= new LibroBO();
//        Categoria categoria=new Categoria(1,"Fantasia",true);
//        ArrayList<Categoria> categorias =new ArrayList<Categoria>();
//        categorias.add(categoria);
//        Autor autor = new Autor("J.K. Rowling", "Gringa");
//        /*-----------------------Insertar Libro-----------------------*/
//        {
//        resultado = libroBO.insertar("Harry Potter",5.4,2.4,2.4,54.5,
//                UnidadMedida.UNIDAD,categorias, autor, "Alfaguara", "165165", 
//                "Libro de Magia", Formato.BOLSILLO);
//        if(resultado!=0)
//            System.out.println("Libro ingresado correctamente");
//        else
//            System.out.println("No se pudo ingresar el libro");
//        
//        }
        
        /*-----------------------Modificar Libro-----------------------*/
        {
//        resultado=libroBO.modificar(9,"Harry Potter 2",5.4,2.4,2.4,54.5,true,true,
//                categoria, "J.K. Rowling", "Alfaguara", "165165", 
//                "Libro de Magia", Formato.ESTUCHE);
//        if(resultado!=0)
//            System.out.println("Libro modificado correctamente");
//        else
//            System.out.println("No se pudo modificar el libro");
        }
        
        /*-----------------------Obtener Libro-----------------------*/
        {
//        Libro nuevoLibro = libroBO.obtenerPorId(9);
//        if(nuevoLibro != null)
//            System.out.println(nuevoLibro.getNombre());
//            else
//                System.out.println("No se pudo encontrar el libro");              
        }
        
        /*-----------------------Eliminar Libro-----------------------*/
        {
//        resultado=libroBO.eliminar(11);
//        if(resultado!=0)
//            System.out.println("Libro eliminado correctamente");
//        else
//            System.out.println("No se pudo eliminar el libro");
        }
        
        /*-----------------------Listar Libro-----------------------*/
        {
//        ArrayList <Libro> listaLibros = libroBO.listarTodosLibros();
//        for(Libro libroLista : listaLibros){
//            System.out.println(libroLista.getNombre());
//        }
        }
        
        
        
        /*Probando otros recursos */
        OtroRecursoBO otroRecursoBO = new OtroRecursoBO();
        
        /*-----------------------Insertar OtroRecurso-----------------------*/
        {
//        int iD = otroRecursoBO.insertar("rompecabeszas", 54.5, 5.4, 6.4,4.5, 
//                "Rompecabezas de la Torre Eiffel");
//        if(resultado != 0 )
//            System.out.println("Otro recurso insertado correctamente");
//        else
//            System.out.println("Otro recurso no se inserto correctamente");
//       
        }
        
        /*-----------------------Modificar OtroRecurso-----------------------*/
        {
//            resultado = otroRecursoBO.modificar(8,"Rompecabezas", 54.5, 5.4, 
//                    6.4,4.5,true,true, "Rompecabezas de la Torre Eiffel");
//            if(resultado != 0 )
//                System.out.println("Otro recurso modificado correctamente");
//            else
//                System.out.println("Otro recurso no se modifico correctamente");
        }
        
        /*-----------------------Obtener OtroRecurso-----------------------*/
        {
//            OtroRecurso nuevoRecurso=otroRecursoBO.obtenerPorId(8);
//            if(nuevoRecurso != null)
//                System.out.println(nuevoRecurso.getNombre());
//            else
//                System.out.println("No se pudo encontrar el otro recurso");            
        }
        
        /*-----------------------Eliminar OtroRecurso-----------------------*/
        {
//        resultado=otroRecursoBO.eliminar(8);
//        if(resultado!=0)
//            System.out.println("OtroRecurso eliminado correctamente");
//        else
//            System.out.println("No se pudo eliminar el OtroRecurso");
        }
        
        /*-----------------------Listar OtroRecurso-----------------------*/
        {
//            ArrayList <OtroRecurso> listaOtroRecurso = 
//                    otroRecursoBO.listarTodosOtrosRecursos();
//            for(OtroRecurso otroRecurso : listaOtroRecurso){
//                System.out.println(otroRecurso.getNombre());
//            }
        }
        
        /*Probando Campanha*/
        CampanhaBO campañaBO = new CampanhaBO();
        java.sql.Date fechaInicio = java.sql.Date.valueOf("2024-01-01");
        java.sql.Date fechaFinal = java.sql.Date.valueOf("2024-02-31");
        /*-----------------------Insertar Campanha-----------------------*/
        {
//            resultado = campañaBO.insertar(fechaInicio, fechaFinal, 
//                    "Descuento del 20% en libros ficcion",EstadoCampanha.ACTIVA,
//                    0.20);  
//            if(resultado != 0 )
//                System.out.println("Campanha insertado correctamente");
//            else
//                System.out.println("Campanha no se inserto correctamente");
        }
        
        /*-----------------------Modificar Campanha-----------------------*/
        {
//            resultado = campañaBO.modificar(1,fechaInicio, fechaFinal, 
//                    "Descuento del 50% en libros de aventura",
//                    EstadoCampanha.ACTIVA, 0.50);
//            if(resultado != 0 )
//                System.out.println("Campanha modificado correctamente");
//            else
//                System.out.println("Campanha no se modifico correctamente");            
        }
        
        /*-----------------------Obtener Campanha-----------------------*/
        {
//            Campanha campanha=campañaBO.obtenerPorId(1);
//            if(campanha != null)
//                System.out.println(campanha.getDescripcion());
//            else
//                System.out.println("No se pudo encontrar la campanha");
        }   
        
        /*-----------------------Eliminar Campanha-----------------------*/
        {
//            resultado = campañaBO.eliminar(1);  
//            if(resultado != 0 )
//                System.out.println("Campanha eliminada correctamente");
//            else
//                System.out.println("Campanha no se elimino correctamente");            
        }
        
        /*-----------------------Listar Campanha-----------------------*/
        {
//            ArrayList <Campanha> listarCampanhas = campañaBO.listarTodos();
//            for(Campanha campanha : listarCampanhas){
//                System.out.println(campanha.getDescripcion());
//            }            
        }
        
        /*Probando Categoria*/
        //CategoriaBO categoriaBO = new CategoriaBO();
        /*-----------------------Insertar Categoria-----------------------*/
        {
//            resultado = categoriaBO.insertar("Ciencia Ficcion");  
//            if(resultado != 0 )
//                System.out.println("Categoria insertado correctamente");
//            else
//                System.out.println("Categoria no se inserto correctamente");
        }
        
        /*-----------------------Modificar Categoria-----------------------*/
        {
//            resultado = categoriaBO.modificar(1,"Comedia");
//            if(resultado != 0 )
//                System.out.println("Categoria modificado correctamente");
//            else
//                System.out.println("Categoria no se modifico correctamente");            
        }
        
        /*-----------------------Obtener Categoria-----------------------*/
        {
//            Categoria catego=categoriaBO.obtenerPorId(2);
//            if(catego != null)
//                System.out.println(catego.getNombre());
//            else
//                System.out.println("No se pudo encontrar la categoria");
        }   
        
        /*-----------------------Eliminar Categoria-----------------------*/
        {
//            resultado = categoriaBO.eliminar(2);  
//            if(resultado != 0 )
//                System.out.println("Categoria eliminada correctamente");
//            else
//                System.out.println("Categoria no se elimino correctamente");            
        }
        
        /*-----------------------Listar Categoria-----------------------*/
        {
//            ArrayList <Categoria> listarCategorias = categoriaBO.listarTodos();
//            for(Categoria cate : listarCategorias){
//                System.out.println(cate.getNombre());
//            }            
        }      
        
        //SedeBO sedeBO = new SedeBO();
        /*-----------------------Insertar Sede-----------------------*/
        {
//            resultado = sedeBO.insertar("Pueblo Libre", "Crisol Pueblo Libre", 
//                    500);  
//            if(resultado != 0 )
//                System.out.println("Sede insertada correctamente");
//            else
//                System.out.println("Sede no se inserto correctamente");
        }
        
        /*-----------------------Modificar Sede-----------------------*/
        {
//            resultado = sedeBO.modificar(1,"Pueblo Libre", false,
//                    "Crisol Pueblo Libre",1000);
//            if(resultado != 0 )
//                System.out.println("Sede modificado correctamente");
//            else
//                System.out.println("Sede no se modifico correctamente");            
        }
        
        /*-----------------------Obtener Sede-----------------------*/
        {
//            Sede sede=sedeBO.obtenerPorId(1);
//            if(sede != null)
//                System.out.println(sede.getNombre());
//            else
//                System.out.println("No se pudo encontrar la sede");
        }   
        
        /*-----------------------Eliminar Sede-----------------------*/
        {
//            resultado = sedeBO.eliminar(1);  
//            if(resultado != 0 )
//                System.out.println("Sede eliminada correctamente");
//            else
//                System.out.println("Sede no se elimino correctamente");            
        }
        
        /*-----------------------Listar Sede-----------------------*/
        {
//            ArrayList <Sede> listarSedes = sedeBO.listarTodosSedes();
//            for(Sede sede : listarSedes){
//                System.out.println(sede.getNombre());
//            }            
        }      
        
        //AlmacenBO almacenBO = new AlmacenBO();
         /*-----------------------Insertar Sede-----------------------*/
        {
//            resultado = almacenBO.insertar("San Borja", 542.5);  
//            if(resultado != 0 )
//                System.out.println("Almacen insertada correctamente");
//            else
//                System.out.println("Almacen no se inserto correctamente");
        }
        
        /*-----------------------Modificar Sede-----------------------*/
        {
//            resultado = almacenBO.modificar(2,"Santa Anita", true,
//                    100.5);
//            if(resultado != 0 )
//                System.out.println("Almacen modificado correctamente");
//            else
//                System.out.println("Almacen no se modifico correctamente");            
        }
        
        /*-----------------------Obtener Sede-----------------------*/
        {
//            Almacen almacen=almacenBO.obtenerPorId(2);
//            if(almacen != null)
//                System.out.println(almacen.getDireccion());
//            else
//                System.out.println("No se pudo encontrar el almacen");
        }   
        
        /*-----------------------Eliminar Sede-----------------------*/
        {
//            resultado = almacenBO.eliminar(2);  
//            if(resultado != 0 )
//                System.out.println("Almacen eliminado correctamente");
//            else
//                System.out.println("Almacen no se elimino correctamente");            
        }
        
        /*-----------------------Listar Sede-----------------------*/
        {
//            ArrayList <Almacen> listarAlmacenes = almacenBO.listarTodosAlmacenes();
//            for(Almacen almacen : listarAlmacenes){
//                System.out.println(almacen.getDireccion());
//            }            
        }      
               
    }
}