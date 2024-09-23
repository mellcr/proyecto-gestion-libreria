
package pe.edu.pucp.softlib.producto.model;
import java.util.Date;
import java.util.ArrayList;

public class Campaña {
    private int idCampaña;
    private Date FechaInicio;
    private Date fechaFinal;
    private String descripcion;
    private EstadoCampanha estado;
    private Double porcentajeDescuento;
    private ArrayList<Recurso> productosPromocion;

    

    public Campaña(int idCampaña, Date FechaInicio, Date fechaFinal, 
            String descripcion, EstadoCampanha estado, Double porcentajeDescuento, 
            ArrayList<Recurso> productosPromocion) {
        this.idCampaña = idCampaña;
        this.FechaInicio = FechaInicio;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.porcentajeDescuento = porcentajeDescuento;
        this.productosPromocion = productosPromocion;
    }

    public void setIdCampanha(int idCampaña) {
        this.idCampaña = idCampaña;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(EstadoCampanha estado) {
        this.estado = estado;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setProductosPromocion(ArrayList<Recurso> productosPromocion) {
        this.productosPromocion = productosPromocion;
    }


    public int getIdCampanha() {
        return idCampaña;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoCampanha getEstado() {
        return estado;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public ArrayList<Recurso> getProductosPromocion() {
        return productosPromocion;
    }
    // Declaracion de metodos
    public String lineaDeCampaña(){
        return "";
    }
    public Double calcularPrecioDescuento(){
        return 0.0;
    }
    public boolean validarCampanha(){
        return true;
    }
    public boolean validarProducto(Integer idProducto){
        return true;
    }
}
