
package pe.edu.pucp.softlib.producto.model;

public class StockRecurso {
// Atributos
    private int idStockRecurso;
    private Recurso recurso;
    private Integer stock;
    
// Metodos
    // Constructor
    public StockRecurso(Recurso recurso, Integer stock) {
        this.recurso = recurso;
        this.stock = stock;
    }
    // Setters
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    // Getters
    public Recurso getRecurso() {
        return recurso;
    }
    public Integer getStock() {
        return stock;
    }
    // Declaracion de metodos
    public String lineaDeStock(){
        return "";
    }
}
