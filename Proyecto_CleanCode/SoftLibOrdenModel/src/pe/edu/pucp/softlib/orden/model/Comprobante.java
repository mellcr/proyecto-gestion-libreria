
package pe.edu.pucp.softlib.orden.model;
import java.util.Date;

public class Comprobante {
    private Integer idComprobante;
    private Orden ordenasociada;
    private Date fechaEmision;

    public Comprobante(Integer idComprobante, Orden ordenasociada, Date fechaEmision) {
        this.idComprobante = idComprobante;
        this.ordenasociada = ordenasociada;
        this.fechaEmision = fechaEmision;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setOrdenasociada(Orden ordenasociada) {
        this.ordenasociada = ordenasociada;
    }

    public Orden getOrdenasociada() {
        return ordenasociada;
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
    
}
