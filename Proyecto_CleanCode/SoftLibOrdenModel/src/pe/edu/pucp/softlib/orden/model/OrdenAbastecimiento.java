
package pe.edu.pucp.softlib.orden.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.producto.model.Local;

public class OrdenAbastecimiento extends Orden{
// Atributos
    private Integer idOrden;
    private static Integer correlativo = 1; 
    private Integer idCorrelativo;
    private Date fechaRecepcion;
    private Local localDestino; 
//    private Empleado empleado; 
// Metodos
    // Constructor
     public OrdenAbastecimiento(Date fechaRecepcion, Local localDestino, 
      ArrayList<LineaDeOrden> lineaOrden, EstadoDeOrden estado) {
        super(lineaOrden, estado);
        this.idOrden = correlativo; 
        this.fechaRecepcion = fechaRecepcion;
        this.localDestino = localDestino;
        OrdenAbastecimiento.correlativo++; 
    }
    // Setters & Getters
    public Integer getIdCorrelativo() {
        return idCorrelativo;
    }
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setLocalDestino(Local localDestino) {
        this.localDestino = localDestino;
    }
    public Local getLocalDestino() {
        return localDestino;
    }
    // Declaracion
    @Override
    public String lineaDeOrden(){
        return "";
    }
    @Override
    public void cancelarOrden(){
    }
    @Override
    public void actualizarEstado(){
    }
    @Override
    public void aceptarOrden(){
    }
    public void informarLocal(){
    }
    public void informarEmpleado(){
    }
}
