
package pe.edu.pucp.softlib.usuario.model;


public class Persona {
// Atributos
    protected Integer idPersona;
    protected TipoDocumento tipoDocumento; 
    protected String numeroDocumento;
    protected String nombre; 
    protected String apellidoPaterno; 
    protected String apellidoMaterno;
    protected String nacionalidad;
    //protected Cuenta cuenta; 
// Metodos
    // Constructor
    public Persona(Integer idPersona, TipoDocumento tipoDocumento, String numeroDocumento, 
            String nombre, String apellidoPaterno, String apellidoMaterno, String nacionalidad) {
        this.idPersona = idPersona;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nacionalidad = nacionalidad;
    }
    // Setters & Getters
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
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
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    // Declaracion
    public Persona registrarPersona(String idPersona, TipoDocumento tipoDocumento, 
            String numeroDocumento, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String nacionalidad) {
        return null;
    }
    public Persona buscarPersonaPorID(String idPersona){
        return null;
    }  
    public Persona modificarPersona(String idPersona, String nuevoIdPersona, 
            TipoDocumento tipoDocumento, String numeroDocumento, String nuevoNombre, 
            String nuevoApellidoPaterno, String nuevoApellidoMaterno, String nacionalidad) {
        return null;
    }
    public boolean eliminarPersona(String idPersona) {
        return false;
    }
    public boolean esEmpleado(Persona persona) {
        return false;
    }
    public boolean esCliente(Persona persona) {
        return false;
    }
    public boolean validarPermisoAdministrador(Empleado empleado) {
        return false;
    }
    public boolean validarCredenciales(Cuenta cuenta){
        return false;
    }
    public String lineaDePersona(){
        return "";
    }
}
