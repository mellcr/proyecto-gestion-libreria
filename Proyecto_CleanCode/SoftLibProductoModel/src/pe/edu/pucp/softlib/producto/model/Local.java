
package pe.edu.pucp.softlib.producto.model;
import java.util.ArrayList;


public class Local {
// Atributos
    protected int idLocal;
    protected String direccion;
    protected ArrayList<StockRecurso> capacidades;
    
// Metodos
    // Constructor
    public Local() {
        capacidades = new ArrayList<StockRecurso>();
    }
    public Local(int idLocal, String direccion, ArrayList<StockRecurso> capacidad) {
        this.idLocal = idLocal;
        this.direccion = direccion;
        this.capacidades = capacidad;

    }
    // Setters
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCapacidad(ArrayList<StockRecurso> capacidades) {
        this.capacidades = capacidades;
    }

    // Getters
    public int getIdLocal() {
        return idLocal;
    }
    public String getDireccion() {
        return direccion;
    }
    public ArrayList<StockRecurso> getCapacidad() {
        return capacidades;
    }

    // Definicion de Metodos
    public String lineaDeLocal(){
        return "";
    }
    public String listaDeEmpleados(){
        return "";
    }
    public String listaDeExistencias(){
        return "";
    }
}
