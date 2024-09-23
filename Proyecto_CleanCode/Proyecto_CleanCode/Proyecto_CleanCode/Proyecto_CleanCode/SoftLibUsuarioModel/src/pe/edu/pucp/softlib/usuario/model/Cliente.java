
package pe.edu.pucp.softlib.usuario.model;
import java.util.ArrayList;
import pe.edu.pucp.softlib.orden.model.OrdenVenta;

public class Cliente extends Persona{
// Atributos
    private Integer idCliente; 
    private static Integer correlativo = 1;
    private String direccion;
    private ArrayList<OrdenVenta> ordenes;
// Metodos
    // Constructor
    public Cliente(String nombre,String apellidoPaterno, String apellidoMaterno,
            String nacionalidad,String direccion, Integer idPersona, 
            TipoDocumento tipoDocumento, String numeroDocumento) {
        super(idPersona, tipoDocumento, numeroDocumento, nombre, apellidoPaterno, 
                apellidoMaterno,nacionalidad);
        this.idCliente = correlativo;
        this.idCliente = correlativo;
        this.direccion = direccion;
        this.ordenes = new ArrayList<OrdenVenta>();
        Cliente.correlativo++; 
    }
    // Getters & Setters
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
    // Declaracion
    public void generarOrdenDeVenta(CarritoDeCompras carrito){
    }
    public void actualizarDireccion(){
    }
    public void agregarOrdenVenta(){
    }
}
