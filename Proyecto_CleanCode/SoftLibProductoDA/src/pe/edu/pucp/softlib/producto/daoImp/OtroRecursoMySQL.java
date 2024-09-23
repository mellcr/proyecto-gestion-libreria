package pe.edu.pucp.softlib.producto.daoImp;

import pe.edu.pucp.softlib.producto.model.OtroRecurso;
import pe.edu.pucp.softlib.producto.model.Recurso;
import java.sql.SQLException;

/*
 * 
 */
public class OtroRecursoMySQL extends RecursoMySQL {
    
    @Override
    protected void insertarAtributosEspecificos(Recurso recurso, int idRecurso) throws SQLException {
        if (recurso instanceof OtroRecurso) {
            OtroRecurso otroRecurso = (OtroRecurso) recurso;

            // Insertar los atributos específicos del otro recurso
            sql = "INSERT INTO OtroRecurso (idRecurso, caracteristica) VALUES (?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idRecurso);
            pst.setString(2, otroRecurso.getDescripcion());
            pst.executeUpdate();
        }
    }
    
    
}


