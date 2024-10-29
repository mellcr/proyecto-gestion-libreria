package pe.edu.pucp.softlib.producto.bo;


import pe.edu.pucp.softlib.producto.dao.LocalDAO;
import pe.edu.pucp.softlib.producto.daoImp.LocalDAOImpl;
import pe.edu.pucp.softlib.producto.model.Local;


/**
 *
 * @author lhia_
 */
public class LocalBO {
    private final LocalDAO localDAO;

    public LocalBO() {
        this.localDAO = new LocalDAOImpl();
    }

   
    
}
