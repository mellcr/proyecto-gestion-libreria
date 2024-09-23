
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;

public class Libro extends Recurso{
// Atributos
    private ArrayList<Categoria> categorias;
    private String autor;
    private String editorial;
    private String ISBN;
    private String sinopsis;
    private Formato formato;
            
// Metodos
    // Constructor 1 categoria
    public Libro(String nombre, Double peso, Double alto, 
            Double ancho, Double precio, Categoria categoria, String autor, 
            String editorial, String ISBN, String sinopsis, Formato formato) {
        super(nombre, peso, alto, ancho, precio);
        this.categorias = new ArrayList<>();
        this.categorias.add(categoria);
        this.autor = autor;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.sinopsis = sinopsis;
        this.formato = formato; 
    }
    
    // Constructor categorias
    public Libro(String nombre, Double peso, Double alto, 
            Double ancho, Double precio, ArrayList<Categoria> categorias, 
            String autor, String editorial, String ISBN, String sinopsis,
            Formato formato) {
        super(nombre, peso, alto, ancho, precio);
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
    public void setAutor(String autor) {
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
    public String getAutor() {
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
