
package pe.edu.pucp.softlib.orden.model;
import pe.edu.pucp.softlib.producto.model.Recurso;


public class LineaDeOrden {
// Atributos
    private Recurso recurso;
    private Integer cantidad;
    private Double subtotal;
// Metodos
    // Constructor
    public LineaDeOrden(Recurso recurso, Integer cantidad, Double subtotal) {
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    // Setters & Getters
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    public Recurso getRecurso() {
        return recurso;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    // Declaracion
    public String lineaDeOrden(){
        return "";
    }
    public Double generarDescuento(){
        return 0.0;
    }
    public Double calcularSubTotal(){
        return 0.0;
    }
}
