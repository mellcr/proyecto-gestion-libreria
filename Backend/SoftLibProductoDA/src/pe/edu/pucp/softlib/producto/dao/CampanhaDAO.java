/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softlib.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.softlib.producto.model.Campanha;

/**
 *
 * @author Joshua Haro
 */
public interface CampanhaDAO {
    public Integer insertar(Campanha campanha);

    public Integer modificar(Campanha campanha);

    public Integer eliminar(Campanha campanha);

    public ArrayList<Campanha> listarTodos();

    public Campanha obtenerPorId(Integer idCampanha);      
}
