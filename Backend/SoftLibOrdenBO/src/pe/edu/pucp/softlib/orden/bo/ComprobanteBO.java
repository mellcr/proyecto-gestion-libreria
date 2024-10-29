package pe.edu.pucp.softlib.orden.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.orden.dao.ComprobanteDAO;
import pe.edu.pucp.softlib.orden.daoImp.ComprobanteDAOImpl;
import pe.edu.pucp.softlib.orden.model.Comprobante;
import pe.edu.pucp.softlib.orden.model.TipoComprobante;

/**
 *
 * @author Joshua Haro
 */
public class ComprobanteBO {

    private final ComprobanteDAO comprobanteDAO;

    public ComprobanteBO() {
        this.comprobanteDAO = new ComprobanteDAOImpl();
    }

    public Integer insertar(TipoComprobante tipoComprobante, 
            Date fechaEmision, Boolean activo, String numDocumentoAsociado, 
            Double valorTotalImpuesto) {
        Comprobante comprobante = new Comprobante(null,tipoComprobante,fechaEmision,
                            activo,numDocumentoAsociado,valorTotalImpuesto);
        return comprobanteDAO.insertar(comprobante);
    }
    
    public Integer modificar(Integer idComprobante, TipoComprobante tipoComprobante, 
            Date fechaEmision, Boolean activo, String numDocumentoAsociado, 
            Double valorTotalImpuesto) {
        Comprobante comprobante = new Comprobante(idComprobante, tipoComprobante,
                fechaEmision,activo,numDocumentoAsociado,valorTotalImpuesto);
        return comprobanteDAO.modificar(comprobante);                
    }
    
    public Integer eliminar(Integer idComprobante){
        Comprobante comprobante = new Comprobante();
        comprobante.setIdComprobante(idComprobante);
        return comprobanteDAO.eliminar(comprobante);
    }
    
    public ArrayList<Comprobante> listarTodos(){
        return comprobanteDAO.listarTodos();
    }
    
    public Comprobante obtenerPorId(Integer idComprobante){
        return comprobanteDAO.obtenerPorId(idComprobante);
    }
}
