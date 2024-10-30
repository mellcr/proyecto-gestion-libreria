
package pe.edu.pucp.softlib.producto.model;
import java.util.Date;
import java.util.ArrayList;

public class Campanha {
    private Integer idCampanha;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private EstadoCampanha estado;
    private Double porcentajeDescuento;
    private Boolean activo; 
    private Byte[] banner;
    
    public Campanha(){
        
    }
    public Campanha(Integer idCampanha, Date fechaInicio, Date fechaFinal, 
            String descripcion, EstadoCampanha estado, 
            Double porcentajeDescuento, Boolean activo, Byte[] banner) {
        this.idCampanha = idCampanha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFinal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.porcentajeDescuento = porcentajeDescuento;
        this.activo = activo; 
        this.banner = banner;
    }

    public Byte[] getBanner() {
        return banner;
    }

    public void setBanner(Byte[] banner) {
        this.banner = banner;
    }

    public void setIdCampanha(Integer idCampaña) {
        this.idCampanha = idCampaña;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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


    public Integer getIdCampanha() {
        return idCampanha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
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

    public Boolean getActivo() {
        return activo;
    }
    
    ////////////////////////////////
    public void setActivo(Boolean activo) {
        this.activo = activo;
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
    // Declaracion de metodos
    public String lineaDeCampaña(){
        return "";
    }
}
