package libreria;
import java.util.ArrayList;
import java.util.Date;

/*
 * Author: mellcr
 */

public class OrdenVenta extends Orden{
    private static Integer correlativo = 1; 
    private Date fechaEntrega; 
    private Cliente cliente; 
    private TipoVenta tipoVenta; 
    private MetodoPago metodoPago; 

    public OrdenVenta(Date fechaEntrega, Cliente cliente, TipoVenta tipoVenta, MetodoPago metodoPago, ArrayList<LineaOrden> lineaOrden, EstadoOrden estado) {
        super(lineaOrden, estado);
        this.idOrden = correlativo; 
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.metodoPago = metodoPago;
        this.correlativo++;
    }
    
    
    
    
    
    
}
