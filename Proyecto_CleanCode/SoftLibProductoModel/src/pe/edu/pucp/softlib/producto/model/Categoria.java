
package pe.edu.pucp.softlib.producto.model;

import java.util.ArrayList;

public class Categoria {
// Atributos
    private Integer idCategoria;
    private String nombre;
    private ArrayList<Libro> libros;
// Metodos
    // Constructor
    public Categoria(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }
    // Setters
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Getters
    public Integer getIdCategoria() {
        return idCategoria;
    }
    public String getNombre() {
        return nombre;
    }
    // Declaracion de metodos
    public String lineaCategoria(){
        return "";
    }
}
