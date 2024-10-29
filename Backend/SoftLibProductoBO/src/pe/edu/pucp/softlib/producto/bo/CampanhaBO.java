/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.producto.dao.CampanhaDAO;
import pe.edu.pucp.softlib.producto.daoImp.CampanhaDAOImpl;
import pe.edu.pucp.softlib.producto.model.Campanha;
import pe.edu.pucp.softlib.producto.model.EstadoCampanha;

/**
 *
 * @author Joshua Haro
 */
public class CampanhaBO {

    private final CampanhaDAO campanhaDAO;

    public CampanhaBO() {
        this.campanhaDAO = new CampanhaDAOImpl();
    }

    public Integer insertar(Date fechaInicio, Date fechaFinal, 
            String descripcion, EstadoCampanha estado, Double porcentajeDescuento,
            Byte[] banner) {
        Campanha campanha = new Campanha(null,fechaInicio,fechaFinal,descripcion,
                        estado,porcentajeDescuento,true,banner);
        return campanhaDAO.insertar(campanha);
    }
    
    public Integer modificar(Integer idCampanha, Date fechaInicio, Date fechaFinal, 
            String descripcion, EstadoCampanha estado, 
            Double porcentajeDescuento, Boolean activo, Byte[] banner) {
        Campanha campanha = new Campanha(idCampanha,fechaInicio,fechaFinal,
                descripcion,estado,porcentajeDescuento,activo,banner);
        return campanhaDAO.modificar(campanha);                
    }
    
    public Integer eliminar(Integer idCampanha){
        Campanha campanha = new Campanha();
        campanha.setIdCampanha(idCampanha);
        return campanhaDAO.eliminar(campanha);
    }
    
    public ArrayList<Campanha> listarTodos(){
        return campanhaDAO.listarTodos();
    }
    
    public Campanha obtenerPorId(Integer idCampanha){
        return campanhaDAO.obtenerPorId(idCampanha);
    }    
}
