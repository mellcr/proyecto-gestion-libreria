package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.model.Recurso;

public abstract class RecursoMySQL implements RecursoDAO{

    private PreparedStatement pst;
    private Connection con;
    private String sql;
        
    @Override
    public int insertar(Recurso recurso) {
        try {
            // SQL para insertar atributos comunes de Recurso
            sql = "INSERT INTO Recurso (nombre, peso, alto, ancho, precio,"
                    + " disponible) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, recurso.getNombre());
            pst.setDouble(2, recurso.getPeso());
            pst.setDouble(3, recurso.getAlto());
            pst.setDouble(4, recurso.getAncho());
            pst.setDouble(5, recurso.getPrecio());
            pst.setBoolean(6, recurso.getDisponible());

            int filasAfectadas = pst.executeUpdate();
            
            // Inserción de los atributos específicos de las subclases
            insertarAtributosEspecificos(recurso);
            
            return filasAfectadas;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

        // Método abstracto para que las subclases implementen sus atributos específicos
        protected abstract void insertarAtributosEspecificos(Recurso recurso) throws SQLException;
    }
    
    
}
