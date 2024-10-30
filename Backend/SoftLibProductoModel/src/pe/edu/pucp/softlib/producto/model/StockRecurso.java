
package pe.edu.pucp.softlib.producto.model;

public class StockRecurso {
// Atributos
    private int idStockRecurso;
    private Recurso recurso;
    private Local local;
    private Integer stock;
    private Boolean disponibleEnLocal; //stock >0  
    
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
    
    public Boolean getDisponible() {
        return disponibleEnLocal;
    }

    public void setDisponible(Boolean disponible) {
        this.disponibleEnLocal = disponible;
    }

    public int getIdStockRecurso() {
        return idStockRecurso;
    }

    public void setIdStockRecurso(int idStockRecurso) {
        this.idStockRecurso = idStockRecurso;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Boolean getDisponibleEnLocal() {
        return disponibleEnLocal;
    }

    public void setDisponibleEnLocal(Boolean disponibleEnLocal) {
        this.disponibleEnLocal = disponibleEnLocal;
    }
    
}
