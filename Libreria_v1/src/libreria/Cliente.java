package libreria;
/*
 * Author: mellcr
 */

public class Cliente extends Persona{
    private Integer idCliente; 
    private Integer correlativo = 1; 
    private String direccion; 

    public Cliente(String direccion, String idPersona, TipoDocumento tipoDocumento, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(idPersona, tipoDocumento, nombre, apellidoPaterno, apellidoMaterno);
        this.idCliente = correlativo;
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.correlativo++; 
    }

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
    
    
    
}
