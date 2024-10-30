package pe.edu.pucp.softlib.producto.model;

public class Autor {
// Atributos
    private Integer idAutor;
    private String nombre;
    private String nacionalidad;
    private Boolean activo;
// Metodos
    // Constructor
    public Autor(){
    }
    public Autor(Integer idAutor, String nombreString, String nacionalidad, 
            Boolean activo) {
        this.idAutor = idAutor;
        this.nombre = nombreString;
        this.nacionalidad = nacionalidad;
        this.activo = activo;
    }
    // Getters & Setters
    public Integer getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombreString) {
        this.nombre = nombreString;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
