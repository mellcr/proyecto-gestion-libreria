    
package pe.edu.pucp.softlib.usuario.model;

import java.util.ArrayList;


public class Persona {
// Atributos
    protected Integer idPersona;
    protected String nombre; 
    protected String apellidoPaterno; 
    protected String apellidoMaterno;
    protected String nacionalidad;
    protected String numeroDocumento;
    protected TipoDocumento tipoDocumento; 
    protected ArrayList<Perfil> perfiles;
    
    public Persona(){}
    public Persona(Integer idPersona,String nombre, String apellidoPaterno, String apellidoMaterno, 
                   String nacionalidad, String numeroDocumento, 
                   TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles) {
        this.nombre = nombre;
        this.idPersona = idPersona;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nacionalidad = nacionalidad;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.perfiles=perfiles;
    }

    public ArrayList<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(ArrayList<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void toCliente(Cliente cliente) {
        if(cliente.getIdPersona()!=null)
            this.setIdPersona(cliente.getIdPersona());
        this.setNombre(cliente.getNombre());
        this.setApellidoPaterno(cliente.getApellidoPaterno());;
        this.setApellidoMaterno(cliente.getApellidoMaterno());;
        this.setNacionalidad(cliente.getNacionalidad());;
        this.setNumeroDocumento(cliente.getNumeroDocumento());;
        this.setTipoDocumento(cliente.getTipoDocumento());
        this.setPerfiles(cliente.getPerfiles());;
    }

    public void toEmpleado(Empleado empleado) {
        if(empleado.getIdPersona()!=null)
            this.setIdPersona(empleado.getIdPersona());
        this.setNombre(empleado.getNombre());
        this.setApellidoPaterno(empleado.getApellidoPaterno());;
        this.setApellidoMaterno(empleado.getApellidoMaterno());;
        this.setNacionalidad(empleado.getNacionalidad());;
        this.setNumeroDocumento(empleado.getNumeroDocumento());;
        this.setTipoDocumento(empleado.getTipoDocumento());
        this.setPerfiles(empleado.getPerfiles());;
    }
}
