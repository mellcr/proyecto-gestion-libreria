
package pe.edu.pucp.softlib.usuario.model;
import java.util.Date;

public class CarritoDeCompras {
    private Integer idCarrito;
    private Date fechaCreacion;
    private Double subTotal;

    public CarritoDeCompras(Integer idCarrito, Date fechaCreacion, Double subTotal) {
        this.idCarrito = idCarrito;
        this.fechaCreacion = fechaCreacion;
        this.subTotal = subTotal;
    }
    
    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Double getSubTotal() {
        return subTotal;
    }
    // Declaracion
    public void cancelarCarrito(){
    }
    public void agregarLineaDeCarrito(){
    }
    public String listaDeCarrito(){
        return "";
    }
    public Double calcularSubTotal(){
        return 0.0;
    }
    public void actualizarFecha(){
    }
}
