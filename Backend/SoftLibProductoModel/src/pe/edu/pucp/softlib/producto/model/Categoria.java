
package pe.edu.pucp.softlib.producto.model;

import java.util.ArrayList;

public class Categoria {
// Atributos
    private Integer idCategoria;
    private String nombre;
    private ArrayList<Libro> libros;
    private Boolean activo; 
// Metodos
    // Constructor
    public Categoria(Integer idCategoria,String nombre, Boolean activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre; 
        this.activo = activo;
    }
    
    public Categoria(){
        nombre = null;
        idCategoria = null;
        libros = new ArrayList<Libro>();
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
   
}
