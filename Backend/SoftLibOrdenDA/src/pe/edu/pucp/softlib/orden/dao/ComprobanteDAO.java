
package pe.edu.pucp.softlib.orden.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.orden.model.Comprobante;

public interface ComprobanteDAO {
    public Integer insertar(Comprobante comprobante);

    public Integer modificar(Comprobante comprobante);

    public Integer eliminar(Comprobante comprobante);

    public ArrayList<Comprobante> listarTodos();

    public Comprobante obtenerPorId(Integer idComprobante); 
}
