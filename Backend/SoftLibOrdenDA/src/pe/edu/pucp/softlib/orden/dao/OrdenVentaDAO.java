
package pe.edu.pucp.softlib.orden.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;

public interface OrdenVentaDAO {
    public Integer insertar(OrdenVenta ordenVenta);

    public Integer modificar(OrdenVenta ordenVenta);

    public Integer eliminar(OrdenVenta ordenVenta);

    public ArrayList<OrdenVenta> listarTodos();

    public OrdenVenta obtenerPorId(Integer idOrdenVenta);
    
    public Boolean existeOrdenVenta(OrdenVenta ordenVenta);
    
    public Boolean existeOrdenVenta(OrdenVenta ordenVenta, Boolean abreConexion);
}
