package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.model.Libro;
import pe.edu.pucp.softlib.producto.model.Recurso;
import java.sql.SQLException;

/*
 *
 */

public class LibroMySQL extends RecursoMySQL{
    
    @Override
    protected void insertarAtributosEspecificos(Recurso recurso) throws SQLException {
        if (recurso instanceof Libro) {
            Libro libro = (Libro) recurso;
            // SQL para insertar atributos específicos de Libro
            sql = "INSERT INTO Libro (autor, editorial, categoria, sinopsis) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, libro.getAutor());
            pst.setString(2, libro.getEditorial());
            pst.setString(3, libro.());
            pst.setString(4, libro.getSinopsis());
            pst.executeUpdate();
        }
    }

    
}
