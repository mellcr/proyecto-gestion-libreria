/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.model;

/**
 *
 * @author Joshua Haro
 */
public class LibroCategoria {
    private Integer idLibroCategoria;
    private Integer idLibro;
    private Integer idCategoria;

    public LibroCategoria(){
        
    }

    public LibroCategoria(Integer idLibroCategoria, Integer idLibro, 
            Integer idCategoria) {
        this.idLibroCategoria = idLibroCategoria;
        this.idLibro = idLibro;
        this.idCategoria = idCategoria;
    }

    public Integer getIdLibroCategoria() {
        return idLibroCategoria;
    }

    public void setIdLibroCategoria(Integer idLibroCategoria) {
        this.idLibroCategoria = idLibroCategoria;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}
