
package pe.edu.pucp.softlib.orden.dao;

import java.sql.Connection;
import pe.edu.pucp.softlib.orden.model.LineaDeOrden;
import java.util.ArrayList;

public interface LineaDeOrdenDAO {
    public Integer insertar(LineaDeOrden lineaDeOrden);
    
    public Integer insertar(LineaDeOrden lineaDeOrden, Boolean usarTransaccion, 
            Connection conexion);
}
