
package pe.edu.pucp.softlib.usuario.model;

import java.util.ArrayList;

public class Empleado extends Persona{
// Atributos
    private Double sueldo; 
    private Boolean empleadoActivo; 
    
    public Empleado(){}

    public Empleado(Integer idPersona, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad, String numeroDocumento,
            TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,Double sueldo, 
            Boolean empleadoActivo) {
        super(idPersona,nombre, apellidoPaterno, apellidoMaterno, nacionalidad, 
                numeroDocumento, tipoDocumento,perfiles);
        this.sueldo = sueldo;
        this.empleadoActivo = empleadoActivo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Boolean getEmpleadoActivo() {
        return empleadoActivo;
    }

    public void setEmpleadoActivo(Boolean empleadoActivo) {
        this.empleadoActivo = empleadoActivo;
    }
}
