package libreria;

import java.util.ArrayList;
import java.util.Date;

/*
 * Author: mellcr
 */

public class OrdenAbastecimiento extends Orden{
    private static Integer correlativo = 1; 
    private Date fechaRecepcion;
    private Local localDestino; 
    private Empleado empleado; 

    public OrdenAbastecimiento(Date fechaRecepcion, Local localDestino, Empleado empleado, ArrayList<LineaOrden> lineaOrden, EstadoOrden estado) {
        super(lineaOrden, estado);
        this.idOrden = correlativo; 
        this.fechaRecepcion = fechaRecepcion;
        this.localDestino = localDestino;
        this.empleado = empleado;
        this.correlativo++; 
    }
    
    
    
}
