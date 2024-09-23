package libreria;
/*
 * Author: mellcr
 */

public abstract class Persona {
    protected String idPersona; 
    protected TipoDocumento tipoDocumento; 
    protected String nombre; 
    protected String apellidoPaterno; 
    protected String apellidoMaterno;
    //protected Cuenta cuenta; 

    public Persona(String idPersona, TipoDocumento tipoDocumento, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idPersona = idPersona;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
    
}
