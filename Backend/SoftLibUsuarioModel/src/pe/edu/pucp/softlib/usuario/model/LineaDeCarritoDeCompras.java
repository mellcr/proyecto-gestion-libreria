
package pe.edu.pucp.softlib.usuario.model;

import pe.edu.pucp.softlib.producto.model.Recurso;


public class LineaDeCarritoDeCompras {
private Integer idLineaDeCarrito;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subTotal;
    private Double descuento;
    private Recurso recurso;
    
    public LineaDeCarritoDeCompras(){}
    public LineaDeCarritoDeCompras(Integer idLineaDeCarrito, Integer cantidad, 
            Double precioUnitario, Double subTotal) {
        this.idLineaDeCarrito = idLineaDeCarrito;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setIdLineaDeCarrito(Integer idLineaDeCarrito) {
        this.idLineaDeCarrito = idLineaDeCarrito;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIdLineaDeCarrito() {
        return idLineaDeCarrito;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Double getSubTotal(){
        return subTotal; 
    }
}
