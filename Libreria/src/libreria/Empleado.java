package libreria;
/*
 * Author: mellcr
 */

public class Empleado extends Persona{
    private Integer idEmpleado; 
    private static Integer correlativo=1; 
    private Double sueldo; 
    private Boolean empleadoActivo; 
    private TipoRol tipoRol; 

    public Empleado(Double sueldo, TipoRol tipoRol, String idPersona, TipoDocumento tipoDocumento, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(idPersona, tipoDocumento, nombre, apellidoPaterno, apellidoMaterno);
        this.idEmpleado = correlativo; 
        this.sueldo = sueldo;
        this.tipoRol = tipoRol;
        this.empleadoActivo = true; //al momento de creacion -> activo= true
        this.correlativo++; 
    }
    
    
    
}
