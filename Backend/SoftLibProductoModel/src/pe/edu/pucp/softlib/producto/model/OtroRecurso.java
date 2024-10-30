
package pe.edu.pucp.softlib.producto.model;


public class OtroRecurso extends Recurso{
    private String descripcion;
// Metodos
    // Constructor
    public OtroRecurso(Integer idOtroRecurso,String nombre, Double peso, 
            Double alto, Double ancho, Double precio,Boolean activo, 
            Boolean disponible,UnidadMedida unidadMedida, Byte[] foto,String caracteristica) {
        super(null,nombre, peso, alto, ancho, precio,activo,disponible, unidadMedida,
                foto);
        this.descripcion = descripcion;
    }
    //constructor sin parametros
    public OtroRecurso() {
        super();
        this.descripcion = null;
    }
    
    
    // Setters
    public void setDescripcion(String caracteristica) {
        this.descripcion = caracteristica;
    }
    // Getters
    public String getDescripcion() {
        return descripcion;
    } 
    // Declaracion de metodos
//    @Override
//    public String lineaDeRecurso(){
//        return "";
//    }
    @Override
    public String lineaDeFavorito(){
        return "";
    }
}
