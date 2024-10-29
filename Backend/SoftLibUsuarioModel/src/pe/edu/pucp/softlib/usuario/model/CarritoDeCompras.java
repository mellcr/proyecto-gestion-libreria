
package pe.edu.pucp.softlib.usuario.model;
import java.util.Date;

public class CarritoDeCompras {
    private Integer idCarrito;
    private Date fechaCreacion;
    private Double subTotal;
    private Estado estado;
    
    public CarritoDeCompras(){}

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public CarritoDeCompras(Integer idCarrito, Date fechaCreacion, Double subTotal, Estado estado) {
        this.idCarrito = idCarrito;
        this.fechaCreacion = fechaCreacion;
        this.subTotal = subTotal;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
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
    
    public Double getSubTotal() {
        return subTotal;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    
}