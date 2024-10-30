
package pe.edu.pucp.softlib.orden.model;
import pe.edu.pucp.softlib.producto.model.Recurso;


public class LineaDeOrden {
// Atributo
    private Integer idLineaDeOrden;
    private Orden ordenasociada;
    private Recurso recurso;
    private Integer cantidad;
    private Double subtotal;
    private Double descuento;
    private Double precioUnitario;
    private Double subtotalBruto;
    private Double subtotalNeto;
// Metodos
    // Constructor
    public LineaDeOrden(){};
    public LineaDeOrden(Recurso recurso, Integer cantidad, Double subtotal) {
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public LineaDeOrden(Recurso recurso, Integer cantidad, Double subtotal, 
            Double descuento, Double precioUnitario, Double subtotalBruto, 
            Double subtotalNeto, Orden ordenasociada) {
        this.recurso = recurso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.precioUnitario = precioUnitario;
        this.subtotalBruto = subtotalBruto;
        this.subtotalNeto = subtotalNeto;
        this.ordenasociada = ordenasociada;
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

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setSubtotalBruto(Double subtotalBruto) {
        this.subtotalBruto = subtotalBruto;
    }

    public Double getSubtotalBruto() {
        return subtotalBruto;
    }

    public void setSubtotalNeto(Double subtotalNeto) {
        this.subtotalNeto = subtotalNeto;
    }

    public Double getSubtotalNeto() {
        return subtotalNeto;
    }

    public void setOrdenasociada(Orden ordenasociada) {
        this.ordenasociada = ordenasociada;
    }

    public Orden getOrdenasociada() {
        return ordenasociada;
    }

    public Integer getIdLineaDeOrden() {
        return idLineaDeOrden;
    }

    public void setIdLineaDeOrden(Integer idLineaDeOrden) {
        this.idLineaDeOrden = idLineaDeOrden;
    }
    
    
    
    
}
