
package pe.edu.pucp.softlib.orden.model;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softlib.usuario.model.Cliente;
import pe.edu.pucp.softlib.usuario.model.Empleado;


public class OrdenVenta extends Orden{
// Atributos
    private Date fechaEntrega;  
    private TipoDeVenta tipoVenta; 
    private MetodoPago metodoPago; 
    private Cliente cliente;
// Metodos
    // Constructor
    public OrdenVenta(){
        super();
    }
    public OrdenVenta(Integer idOrden,ArrayList<LineaDeOrden> lineasDeOrdenes,
            EstadoDeOrden estadoDeOrden, Date fechaCreacion, Double total, 
            Empleado empleado,Boolean activo, Date fechaEntrega, TipoDeVenta tipoVenta,
            MetodoPago metodoPago, Cliente cliente) {
        super(idOrden,lineasDeOrdenes, estadoDeOrden,fechaCreacion,total,empleado,
                activo);
        this.fechaEntrega = fechaEntrega;
        this.tipoVenta = tipoVenta;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
    }
    // Setters & Getters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public void setTipoVenta(TipoDeVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    public TipoDeVenta getTipoVenta() {
        return tipoVenta;
    }
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
