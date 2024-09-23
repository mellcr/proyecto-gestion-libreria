package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.Recurso;
import java.sql.SQLException;

/*
 * 
 */
public class OtroRecursoMySQL extends RecursoMySQL {
    
    @Override
    protected void insertarAtributosEspecificos(Recurso recurso) throws SQLException {
        if (recurso instanceof OtroRecurso) {
            OtroRecurso otroRecurso = (OtroRecurso) recurso;
            // SQL para insertar atributos específicos de OtrosRecursos
            sql = "INSERT INTO OtrosRecursos (caracteristica) VALUES (?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, otroRecurso.getDescripcion());
            pst.executeUpdate();
        }
    }
    
    
}


