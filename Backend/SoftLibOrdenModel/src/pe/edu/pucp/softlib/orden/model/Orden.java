
package pe.edu.pucp.softlib.orden.model;
import java.util.ArrayList;
import java.util.Date; 
import pe.edu.pucp.softlib.usuario.model.Empleado;

public class Orden {
// Atributos
    protected Integer idOrden; 
    protected ArrayList<LineaDeOrden> lineasDeOrden; 
    protected EstadoDeOrden estadoOrden; // no activo -> cancelado 
    protected Date fechaCreacion;
    protected Double total;
    protected Empleado empleado;
    protected Boolean activo;

    public Orden(Integer idOrden,ArrayList<LineaDeOrden> lineasDeOrden, 
            EstadoDeOrden estadoOrden, Date fechaCreacion, Double total, 
            Empleado empleado, Boolean activo) {
        this.idOrden = idOrden;
        this.lineasDeOrden = lineasDeOrden;
        this.estadoOrden = estadoOrden;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
        this.empleado = empleado;
        this.activo = activo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public Orden(){};
    // Getters & Setters
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }
    public Integer getIdOrden() {
        return idOrden;
    }
    public ArrayList<LineaDeOrden> getLineasOrden() {
        return lineasDeOrden;
    }
    public LineaDeOrden getLineaOrden(int indice){
        return lineasDeOrden.get(indice);
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public Double getTotal() {
        return total;
    }
    public EstadoDeOrden getEstadoOrden() {
        return estadoOrden;
    }
    public void setEstadoOrden(EstadoDeOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    public void setLineaOrden(LineaDeOrden linea){
        this.lineasDeOrden.add(linea);
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public void setLineasDeOrden(ArrayList<LineaDeOrden> lineasDeOrden) {
        this.lineasDeOrden = lineasDeOrden;
    }
    
    public void toOrdenVenta(OrdenVenta ordenVenta){
        if(ordenVenta.getIdOrden()!=null)
            this.setIdOrden(ordenVenta.getIdOrden());
        this.setFechaCreacion(ordenVenta.getFechaCreacion());
        this.setEstadoOrden(ordenVenta.getEstadoOrden());
        this.setTotal(ordenVenta.getTotal());
        this.setEmpleado(ordenVenta.getEmpleado());
        this.setActivo(ordenVenta.getActivo());                
        this.setLineasDeOrden(ordenVenta.getLineasOrden());                
    }

    public void toOrdenAbastecimiento(OrdenAbastecimiento ordenAbastecimiento) {
        if(ordenAbastecimiento.getIdOrden()!=null)
            this.setIdOrden(ordenAbastecimiento.getIdOrden());
        this.setFechaCreacion(ordenAbastecimiento.getFechaCreacion());
        this.setEstadoOrden(ordenAbastecimiento.getEstadoOrden());
        this.setTotal(ordenAbastecimiento.getTotal());
        this.setEmpleado(ordenAbastecimiento.getEmpleado());
        this.setActivo(ordenAbastecimiento.getActivo());                
        this.setLineasDeOrden(ordenAbastecimiento.getLineasOrden()); 
    }
}
