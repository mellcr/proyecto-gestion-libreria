
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;

public class Sede extends Local{
// Atributos
    private String nombre;
    private Integer aforo;
// Metodos
    // Constructor
    public Sede() {
        super();
    }
    public Sede(Integer idLocal, String direccion, ArrayList<StockRecurso> capacidad,
             String nombre, 
            Integer aforo) {
        super(idLocal, direccion, capacidad);
        this.nombre = nombre;
        this.aforo = aforo;
    }
    // Setters & Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getAforo() {
        return aforo;
    }
    public void setAforo(Integer aforo) {
        this.aforo = aforo;
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
