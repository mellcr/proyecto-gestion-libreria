
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
    protected Integer idLineaDeOrden;
    protected ArrayList<Campaña> campañas;

    
// Metodos
    // Constructor
    public Recurso(String nombre, Double peso, Double alto, Double ancho, Double precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.precio = precio;

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
    // Declaracion de metodos
    public Integer calcularStockTotal(){
        return 0;
    }
    public String lineaDeRecurso(){
        return "";
    }
    public String lineaDeFavorito(){
        return "";
    }
}
