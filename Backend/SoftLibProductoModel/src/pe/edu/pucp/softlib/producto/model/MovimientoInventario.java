/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softlib.producto.model;

import java.util.Date;

/**
 *
 * @author Joshua Haro
 */
public class MovimientoInventario {
    private Integer idMovimiento;
    private Date fechaMovimiento;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private String detalles;
    private Local local;
    private Integer idRecurso;
    private Boolean activo;
    
    public MovimientoInventario(){
        
    }

    public MovimientoInventario(Integer idMovimiento, Date fechaMovimiento, 
            Integer cantidad, String detalles,Local local,Integer idRecurso, 
            TipoMovimiento tipoMovimiento,Boolean activo) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidad = cantidad;
        this.detalles = detalles;
        this.local = local;
        this.tipoMovimiento = tipoMovimiento;
        this.idRecurso = idRecurso;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
    

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
