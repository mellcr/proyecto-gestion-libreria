package pe.edu.pucp.softlib.producto.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import pe.edu.pucp.softlib.producto.dao.RecursoDAO;
import pe.edu.pucp.softlib.producto.model.Recurso;
import pe.edu.pucp.softlib.config.DBManager;

public abstract class RecursoMySQL implements RecursoDAO{

    protected PreparedStatement pst;
    protected Connection con;
    protected String sql;
    
    @Override
    public int insertar(Recurso recurso) {
        
        
        try {
            //
            Connection con = DBManager.getInstance().getConnection();
        
            // Inserción genérica para la tabla Recurso
            sql = "INSERT INTO Recurso (nombre, peso, alto, ancho, precio, disponible) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, recurso.getNombre());
            pst.setDouble(2, recurso.getPeso());
            pst.setDouble(3, recurso.getAlto());
            pst.setDouble(4, recurso.getAncho());
            pst.setDouble(5, recurso.getPrecio());
            pst.setBoolean(6, recurso.getDisponible());

            int filasAfectadas = pst.executeUpdate();

            // Obtener el ID generado
            ResultSet rs = pst.getGeneratedKeys();
            int idRecurso = 0;
            if (rs.next()) {
                idRecurso = rs.getInt(1); // Guardar el ID del recurso insertado
            }

            // Llamar al método abstracto para insertar atributos específicos
            insertarAtributosEspecificos(recurso, idRecurso);

            return filasAfectadas;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    // Método abstracto para que las subclases implementen sus atributos específicos
    protected abstract void insertarAtributosEspecificos(Recurso recurso, int idRecurso) throws SQLException;


}
    
