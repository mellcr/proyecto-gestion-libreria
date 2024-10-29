    
package pe.edu.pucp.softlib.orden.model;
import java.util.Date;

public class Comprobante {
    private Integer idComprobante;
    private TipoComprobante tipoComprobante;
    private Date fechaEmision;
    private Boolean activo; //activo o cancelado 
    private String numDocumentoAsociado;
    private Double valorTotalImpuesto;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNumDocumentoAsociado() {
        return numDocumentoAsociado;
    }

    public void setNumDocumentoAsociado(String numDocumentoAsociado) {
        this.numDocumentoAsociado = numDocumentoAsociado;
    }

    public Double getValorTotalImpuesto() {
        return valorTotalImpuesto;
    }

    public void setValorTotalImpuesto(Double valorTotalImpuesto) {
        this.valorTotalImpuesto = valorTotalImpuesto;
    }

    public Comprobante(){
        
    }

    public Comprobante(Integer idComprobante, TipoComprobante tipoComprobante, 
            Date fechaEmision, Boolean activo, String numDocumentoAsociado, 
            Double valorTotalImpuesto) {
        this.idComprobante = idComprobante;
        this.tipoComprobante = tipoComprobante;
        this.fechaEmision = fechaEmision;
        this.activo = activo;
        this.numDocumentoAsociado = numDocumentoAsociado;
        this.valorTotalImpuesto = valorTotalImpuesto;
    }
    

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }    
    // Declaracion
    public String lineaDeComprobante(){
        return "";
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }
    
    
    
}
