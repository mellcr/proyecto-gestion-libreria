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
    public abstract int insertar(Recurso recurso);

    
    
    
    
}
