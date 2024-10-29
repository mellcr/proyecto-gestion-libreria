
package pe.edu.pucp.softlib.usuario.model;

import java.util.ArrayList;

public class Cliente extends Persona{
    private String direccion;
    
    public Cliente(){
    }
    public Cliente(Integer idPersona,String nombre, String apellidoPaterno, String apellidoMaterno, 
                   String nacionalidad, String numeroDocumento, 
                   TipoDocumento tipoDocumento, ArrayList<Perfil> perfiles,
                   String direccion) {
        super(idPersona,nombre, apellidoPaterno, apellidoMaterno, nacionalidad, 
                numeroDocumento, tipoDocumento,perfiles);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
