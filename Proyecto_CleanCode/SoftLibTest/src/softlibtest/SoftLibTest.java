package softlibtest;

import pe.edu.pucp.softlib.config.DBManager;
import pe.edu.pucp.softlib.producto.daoImp.LibroMySQL;
import pe.edu.pucp.softlib.producto.model.Libro;
import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Categoria;

/*
 * Author: mellcr
 */
public class SoftLibTest {

    public static void main(String[] args) {
        //Connection con = DBManager.getInstance().getConnection();
        
        try {
            // Crear una instancia de LibroMySQL y pasarle la conexión
            LibroMySQL libroDAO = new LibroMySQL();
      
            // Crear un objeto Libro
            Libro libro = new Libro();
            libro.setNombre("El Quijote");
            libro.setPeso(1.50);
            libro.setAlto(15.00);
            libro.setAncho(15.00);
            libro.setISBN("978-3-16-148410-0");
            libro.setPrecio(49.99);
            libro.setDisponible(true);
            libro.setAutor("Miguel de Cervantes");
            libro.setEditorial("Editorial Planeta");
            libro.setSinopsis("Un hombre obsesionado con las novelas de caballería...");

            // Crear una lista de categorías para el libro
            ArrayList<Categoria> categorias = new ArrayList<>();
            Categoria ficcion = new Categoria();
            ficcion.setIdCategoria(1); // ID de la categoría "Ficción" ya existente en la base de datos
            ficcion.setNombre("Ficción");
            categorias.add(ficcion);

            Categoria clasico = new Categoria();
            clasico.setIdCategoria(2); // ID de la categoría "Clásico" ya existente en la base de datos
            clasico.setNombre("Clásico");
            categorias.add(clasico);

            libro.setCategorias(categorias); // Asignar las categorías al libro

            // Llamar al método insertar para agregar el libro a la base de datos
            int resultado = libroDAO.insertar(libro);
            if (resultado > 0) {
                System.out.println("Libro insertado correctamente.");
            } else {
                System.out.println("Hubo un problema al insertar el libro.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}