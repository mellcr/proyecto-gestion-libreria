/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.model;

/**
 *
 * @author Joshua Haro
 */
public class TipoMovimiento {
    private Integer idTipoMovimiento;
    private String descripcion;
    private TipoAccion tipoAccion;
    
    public TipoMovimiento(){
        
    }
    
    public TipoMovimiento(Integer idTipoMovimiento,String descripcion,
            TipoAccion tipoAccion){
        this.idTipoMovimiento=idTipoMovimiento;
        this.descripcion=descripcion;
        this.tipoAccion=tipoAccion;
    }

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }
    
}
