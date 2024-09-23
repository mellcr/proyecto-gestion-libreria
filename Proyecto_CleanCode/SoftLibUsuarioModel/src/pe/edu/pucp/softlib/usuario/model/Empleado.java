
package pe.edu.pucp.softlib.usuario.model;
import java.util.ArrayList;
import pe.edu.pucp.softlib.orden.model.OrdenAbastecimiento;

public class Empleado extends Persona{
// Atributos
    private Integer idEmpleado; 
    private static Integer correlativo = 1; 
    private Double sueldo; 
    private Boolean empleadoActivo; 
    private Rol tipoRol;
    private ArrayList<OrdenAbastecimiento> ordenesAbastecimiento;
   
// Metodos
    // Constructor
    public Empleado(String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad,Double sueldo, 
            Rol tipoRol, Integer idPersona, TipoDocumento tipoDocumento,
            String numeroDocumento) {
        super(idPersona, tipoDocumento, numeroDocumento, nombre, apellidoPaterno, 
                apellidoMaterno,nacionalidad);
        this.idEmpleado = correlativo; 
        this.sueldo = sueldo;
        this.tipoRol = tipoRol;
        this.empleadoActivo = true; //al momento de creacion -> activo= true
        Empleado.correlativo++; 
    }
    // Setters & Getters
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
    public void setEmpleadoActivo(Boolean empleadoActivo) {
        this.empleadoActivo = empleadoActivo;
    }
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public Double getSueldo() {
        return sueldo;
    }
    public Boolean getEmpleadoActivo() {
        return empleadoActivo;
    }
    public void setTipoRol(Rol tipoRol) {
        this.tipoRol = tipoRol;
    }
    public Rol getTipoRol() {
        return tipoRol;
    }    
    // Declaracion
    public void actualizarRol(){
    }
    public void actualizarSueldo(){
    }
    public void generarOrdenVenta(){
    }
    public void generarOrdenAbastecimiento(){
    }
    public boolean validarLocal(Integer idLocal){
        return true;
    }
}
