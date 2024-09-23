package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.Recurso;
import java.sql.SQLException;
import pe.edu.pucp.softlib.producto.model.Categoria;
import java.sql.ResultSet; 
import java.sql.Statement; 

/*
 *
 */

public class LibroMySQL extends RecursoMySQL{
     
    @Override
    protected void insertarAtributosEspecificos(Recurso recurso, int idRecurso) throws SQLException {
        if (recurso instanceof Libro) {
            Libro libro = (Libro) recurso;
            
            // Insertar los atributos específicos del libro
            sql = "INSERT INTO Libro (idRecurso, autor,isbn,sinopsis,formato) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idRecurso);
            pst.setString(2, libro.getAutor());
            pst.setString(3, libro.getISBN());
            pst.setString(4, libro.getSinopsis());              
            pst.setString(5, libro.getFormato().toString());
            pst.executeUpdate();

            // Insertar las categorías en la tabla intermedia
            for (Categoria categoria : libro.getCategorias()) {
                sql = "INSERT INTO Libro_Categoria (idLibro, idCategoria) VALUES (?, ?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, idRecurso); // Usar idRecurso como idLibro
                pst.setInt(2, categoria.getIdCategoria());
                pst.executeUpdate();
            }
        }
    }

    
}
