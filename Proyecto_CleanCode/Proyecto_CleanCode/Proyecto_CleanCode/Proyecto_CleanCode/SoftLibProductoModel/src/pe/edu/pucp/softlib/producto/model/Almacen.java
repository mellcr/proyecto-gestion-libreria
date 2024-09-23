
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;

public class Almacen extends Local{
// Atributos
    private Double area;
// Metodos
    // Constructor
    public Almacen() {
        super();
    }
    public Almacen(Integer idLocal, String direccion, ArrayList<StockRecurso> capacidad
            , Double area) {
        super(idLocal, direccion, capacidad);
        this.area = area;
    }
    // Setters & Getters
    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    // Definicion de Metodos
    @Override
    public String lineaDeLocal(){
        return "";
    }
    @Override
    public String listaDeEmpleados(){
        return "";
    }
    @Override
    public String listaDeExistencias(){
        return "";
    }
}
