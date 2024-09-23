
package pe.edu.pucp.softlib.orden.model;
import java.util.ArrayList;
import java.util.Date;


public class OrdenVenta extends Orden{
// Atributos
    private static Integer correlativo = 1; 
    private Integer idCorrelativo;
    private Date fechaEntrega;  
    private TipoDeVenta tipoVenta; 
    private MetodoPago metodoPago; 
// Metodos
    // Constructor
    public OrdenVenta(Date fechaEntrega, TipoDeVenta tipoVenta, 
            MetodoPago metodoPago, ArrayList<LineaDeOrden> lineaOrden, EstadoDeOrden estado) {
        super(lineaOrden, estado);
        this.idOrden = correlativo; 
        this.fechaEntrega = fechaEntrega;
        this.tipoVenta = tipoVenta;
        this.metodoPago = metodoPago;
        OrdenVenta.correlativo++;
    }
    // Setters & Getters
    public Integer getIdCorrelativo() {
        return idCorrelativo;
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
    // Declaracion
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
    public void informarCliente(){
    }
    public void aceptarPago(){
    }
}
