
package pe.edu.pucp.softlib.producto.model;


public class Recurso {
    // Atributos
    protected Integer idRecurso;
    protected String nombre;
    protected Double peso;
    protected Double alto;
    protected Double ancho;
    protected Double precio;
    protected Boolean disponible;   // atributo para mostrarlo en web (muestre los Recursos disponibles) 
    protected Boolean activo; 
    protected UnidadMedida unidadMedida;
    protected Byte[] foto;

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    // Constructor
    public Recurso(Integer idRecurso,String nombre, Double peso, Double alto, Double ancho, 
            Double precio, Boolean activo, Boolean disponible, UnidadMedida unidadMedida, Byte [] foto) {
        this.idRecurso = idRecurso;
        this.nombre = nombre;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.precio = precio;
        this.activo = activo;
        this.disponible = disponible;
        this.unidadMedida = unidadMedida;
        this.foto = foto;
    }
    public Recurso() {
        this.nombre = null;
        this.peso = null;
        this.alto = null;
        this.ancho = null;
        this.precio = null;
        this.activo = true;
        this.disponible = true;
        this.unidadMedida = null;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public void setAlto(Double alto) {
        this.alto = alto;
    }
    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    // Getters
    public Integer getIdRecurso() {
        return idRecurso;
    }
    public String getNombre() {
        return nombre;
    }
    public Double getPeso() {
        return peso;
    }
    public Double getAlto() {
        return alto;
    }
    public Double getAncho() {
        return ancho;
    }
    public Double getPrecio() {
        return precio;
    }
    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
    // Declaracion de metodos
    public Integer calcularStockTotal(){
        return 0;
    }
    public String lineaDeFavorito(){
        return "";
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    public void toLibro(Libro libro){
        if(libro.getIdRecurso()!=null)
            this.setIdRecurso(libro.getIdRecurso());
        this.setNombre(libro.getNombre());
        this.setPeso(libro.getPeso());
        this.setAlto(libro.getAlto());
        this.setAncho(libro.getAncho());
        this.setPrecio(libro.getPrecio());
        this.setDisponible(libro.getDisponible());
        this.setActivo(libro.getActivo());        
        this.setUnidadMedida(libro.getUnidadMedida());        
    }
    
    public void toOtroRecurso(OtroRecurso otroRecurso){
        if(otroRecurso.getIdRecurso()!=null)
            this.setIdRecurso(otroRecurso.getIdRecurso());
        this.setNombre(otroRecurso.getNombre());
        this.setPeso(otroRecurso.getPeso());
        this.setAlto(otroRecurso.getAlto());
        this.setAncho(otroRecurso.getAncho());
        this.setPrecio(otroRecurso.getPrecio());
        this.setDisponible(otroRecurso.getDisponible());
        this.setActivo(otroRecurso.getActivo());
        this.setUnidadMedida(otroRecurso.getUnidadMedida());          
    }
}
