
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;


public class Local {
// Atributos
    protected int idLocal;
    protected String direccion;
    protected String nombre;
    protected ArrayList<MovimientoInventario> movimientos;
    protected Boolean activo;
    protected TipoLocal tipoLocal;
    protected Integer aforo;
    protected Double area;
    protected ArrayList<StockRecurso> capacidades;

    public Local(String direccion, String nombre, Boolean activo, TipoLocal tipoLocal, Integer aforo, Double area) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.activo = activo;
        this.tipoLocal = tipoLocal;
        this.aforo = aforo;
        this.area = area;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<MovimientoInventario> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<MovimientoInventario> movimientos) {
        this.movimientos = movimientos;
    }

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public ArrayList<StockRecurso> getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(ArrayList<StockRecurso> capacidades) {
        this.capacidades = capacidades;
    }
    
// Metodos
    // Constructor
    public Local() {
        this.capacidades = new ArrayList<StockRecurso>();
        this.activo = true;
    }
    
    public Local(int idLocal,String nombre, String direccion) {
        this.idLocal = idLocal;
        this.direccion = direccion;
        this.nombre = nombre;
        this.capacidades = new ArrayList<StockRecurso>();
        this.activo = true;

    }
    
    public Local(String direccion) {
        this.idLocal = 0;
        this.direccion = direccion;
        this.capacidades = new ArrayList<StockRecurso>();
        this.activo = true;
    }
    
    // Setters
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCapacidad(ArrayList<StockRecurso> capacidades) {
        this.capacidades = capacidades;
    }

    // Getters
    public int getIdLocal() {
        return idLocal;
    }
    public String getDireccion() {
        return direccion;
    }
    public ArrayList<StockRecurso> getCapacidad() {
        return capacidades;
    }

    // Definicion de Metodos
    public String lineaDeLocal(){
        return "";
    }
    public String listaDeEmpleados(){
        return "";
    }
    public String listaDeExistencias(){
        return "";
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
