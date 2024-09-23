
package pe.edu.pucp.softlib.orden.model;
import java.util.ArrayList;
import java.util.Date; 

public class Orden {
// Atributos
    protected Integer idOrden; 
    protected ArrayList<LineaDeOrden> lineasDeOrden; 
    protected EstadoDeOrden estadoOrden; 
    protected Date fechaCreacion;
    protected Double total;
// Metodos
    // Constructor
    public Orden(ArrayList<LineaDeOrden> lineaOrden, EstadoDeOrden estado) {
        //this.idOrden = correlativo; 
        this.lineasDeOrden = lineaOrden;
        this.estadoOrden = estado;
        this.fechaCreacion = new Date();
    }
    // Getters & Setters
    public Integer getIdOrden() {
        return idOrden;
    }
    public ArrayList<LineaDeOrden> getLineasOrden() {
        return lineasDeOrden;
    }
    public LineaDeOrden getLineaOrden(int indice){
        return lineasDeOrden.get(indice);
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public Double getTotal() {
        return total;
    }
    public EstadoDeOrden getEstadoOrden() {
        return estadoOrden;
    }
    public void setEstadoOrden(EstadoDeOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    public void setLineaOrden(LineaDeOrden linea){
        this.lineasDeOrden.add(linea);
    }    
    // Declaracion
    public String lineaDeOrden(){
        return "";
    }
    public void cancelarOrden(){
    }
    public void actualizarEstado(){
    }
    public void aceptarOrden(){
    }
    public Double calcularTotal(){
        return 0.0;
    }
}
