/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.OtroRecurso;

/**
 *
 * @author Joshua Haro
 */
public interface OtroRecursoDAO {
    public Integer insertar(OtroRecurso otroRecurso);

    public Integer modificar(OtroRecurso otroRecurso);

    public Integer eliminar(OtroRecurso otroRecurso);

    public ArrayList<OtroRecurso> listarTodos();

    public OtroRecurso obtenerPorId(Integer idOtroRecurso);
    
    public Boolean existeOtroRecurso(OtroRecurso otroRecurso);
    
    public Boolean existeOtroRecurso(OtroRecurso otroRecurso, Boolean abreConexion);

    public ArrayList<OtroRecurso> buscarOtrosRecursos(String nombre); 
    
    public ArrayList<OtroRecurso> mostrarDestacado();
}
