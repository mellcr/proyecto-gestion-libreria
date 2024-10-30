package pe.edu.pucp.softlib.usuario.model;


public class Cuenta {
    private Integer idCuenta;
    private String usuario;
    private String contrasena;
    private Boolean activo;
    private String email;
    private Integer codigo;
    private TipoCuenta tipoCuenta;
    private Integer totalCompras;
    private Persona persona;
    private String telefono;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cuenta(){
        
    }
    
    public Cuenta(Integer idCuenta, String usuario, String contrasena, 
            Boolean activo, String email, Integer codigo, TipoCuenta tipoCuenta, 
            Integer totalCompras, String telefono, Persona persona) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.activo = activo;
        this.email = email;
        this.codigo = codigo;
        this.tipoCuenta = tipoCuenta;
        this.totalCompras = totalCompras;
        this.persona = persona;
        this.telefono = telefono;
    }
    
    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(Integer totalCompras) {
        this.totalCompras = totalCompras;
    }
    
    
}
