
package pe.edu.pucp.softlib.usuario.model;


public class Cuenta {
// Atributos
    protected Integer idCuenta;
    protected static Integer correlativo = 1;
    protected String usuario;
    protected String contrasena;
    protected Boolean activo;
    protected String email;
    protected String telefono;
    protected Persona persona;
// Metodos
    // Constructor
    public Cuenta(Persona persona, Integer idCuenta, String usuario, String contrasena,
            Boolean activo, String email, String telefono) {
        this.persona = persona;
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.activo = activo;
        this.email = email;
        this.telefono = telefono;
        Cuenta.correlativo++;
    }
    // Setters & Getters
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Persona getPersona() {
        return persona;
    }
    public Integer getIdCuenta() {
        return idCuenta;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }    
    // Declaracion
    public boolean validarAcceso(){
        return false;
    }
    public void actualizarDatos(){
    }
}
