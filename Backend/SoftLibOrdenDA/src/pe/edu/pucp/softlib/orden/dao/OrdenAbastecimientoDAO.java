package pe.edu.pucp.softlib.orden.dao;

import pe.edu.pucp.softlib.orden.model.OrdenAbastecimiento;
import java.util.ArrayList;

public interface OrdenAbastecimientoDAO {
    public Integer insertar(OrdenAbastecimiento ordenAbastecimiento);

    public Integer modificar(OrdenAbastecimiento ordenAbastecimiento);

    public Integer eliminar(OrdenAbastecimiento ordenAbastecimiento);

    public ArrayList<OrdenAbastecimiento> listarTodos();

    public OrdenAbastecimiento obtenerPorId(Integer idOrdenAbastecimiento);
    
    public Boolean existeOrdenAbastecimiento(OrdenAbastecimiento ordenAbastecimiento);
    
    public Boolean existeOrdenAbastecimiento(OrdenAbastecimiento ordenAbastecimiento, 
            Boolean abreConexion);
}
