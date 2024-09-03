package libreria;

import java.util.ArrayList;
import java.util.Date; 

/*
 * Author: mellcr
 */

public abstract class Orden {
    protected Integer idOrden; 
    //protected static Integer correlativo = 1; 
    protected ArrayList<LineaOrden> lineaOrden; 
    protected EstadoOrden estado; 
    protected Date fechaEmision;
    protected Double total;

    public Orden(ArrayList<LineaOrden> lineaOrden, EstadoOrden estado) {
        //this.idOrden = correlativo; 
        this.lineaOrden = lineaOrden;
        this.estado = estado;
        this.fechaEmision = new Date();
        //this.correlativo++;
        
        //metodo para calcular TOTAL 
    }
    
    
    
    
    
}
