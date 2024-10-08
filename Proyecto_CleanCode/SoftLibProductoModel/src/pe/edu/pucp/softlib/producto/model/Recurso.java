
package pe.edu.pucp.softlib.producto.model;

import java.util.ArrayList;

public class Recurso {
// Atributos
    protected Integer idRecurso;
    protected String nombre;
    protected Double peso;
    protected Double alto;
    protected Double ancho;
    protected Double precio;
    private Boolean disponible;

    // Constructor
    public Recurso(String nombre, Double peso, Double alto, Double ancho, Double precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.precio = precio;

    }
    public Recurso() {
        this.nombre = null;
        this.peso = null;
        this.alto = null;
        this.ancho = null;
        this.precio = null;
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
}
