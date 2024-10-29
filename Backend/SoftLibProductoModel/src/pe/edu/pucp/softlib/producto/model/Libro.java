
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;

public class Libro extends Recurso{
// Atributos
    private ArrayList<Categoria> categorias;
    private Autor autor;
    private String editorial;
    private String ISBN;
    private String sinopsis;
    private Formato formato;
            
    // Constructor categorias
    public Libro(Integer idLibro,String nombre, Double peso, Double alto, 
            Double ancho, Double precio, Boolean activo, Boolean disponible, 
            UnidadMedida unidadMedida, Byte[] foto,ArrayList<Categoria> categorias, 
            Autor autor, String editorial, String ISBN, String sinopsis,
            Formato formato) {
        super(idLibro,nombre, peso, alto, ancho, precio,activo,disponible,
                unidadMedida, foto);
        this.categorias = categorias;
        this.autor = autor;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.sinopsis = sinopsis;
        this.formato = formato; 
    }
    
    //constructor sin parametros
    public Libro() {
        super();
        this.categorias = null;
        this.autor = null;
        this.editorial = null;
        this.ISBN = null;
        this.sinopsis = null;
        this.formato = null; 
    }
    
    
    // Setters
    public void setCategoria(Categoria categoria) {
        this.categorias = new ArrayList<>();
        this.categorias.add(categoria);
    }
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    // Getters
    public Categoria getCategoria(int indice){
        return categorias.get(indice);
    }
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    public Autor getAutor() {
        return autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getSinopsis() {
        return sinopsis;
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

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
