
package pe.edu.pucp.softlib.orden.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.usuario.model.Empleado;

public class OrdenAbastecimiento extends Orden{
// Atributos
    private Date fechaRecepcion;
    private String descripcion;
// Metodos
    // Constructor
    public OrdenAbastecimiento(){
        super();
    }
    
    public OrdenAbastecimiento(Integer idOrden,ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Empleado empleado,Boolean activo, Date fechaRecepcion, String descripcion) {
        super(idOrden,lineasDeOrdenes, estadoDeOrden,fechaCreacion,total,empleado,
                activo);
        this.fechaRecepcion = fechaRecepcion;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // Setters & Getters
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }
}
