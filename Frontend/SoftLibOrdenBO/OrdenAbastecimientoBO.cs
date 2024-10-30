using SoftLibBO.ServicioWeb;
using SoftLibBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibOrdenBO
{
    public class OrdenAbastecimientoBO : BaseBO
    {
        public int insertar(BindingList<lineaDeOrden> lineasDeOrdenes,
            estadoDeOrden estadoDeOrden, DateTime fechaCreacion, double total,
            int idEmpleado, DateTime fechaRecepcion, string descripcion)
        {
            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrdenAbastecimiento.ordenAbastecimiento_insertar(lineas,
             estadoDeOrden, fechaCreacion, total,
             idEmpleado, fechaRecepcion, descripcion);
        }

        public int modificar(int idOrdenAbastecimiento,
               BindingList<lineaDeOrden> lineasDeOrdenes,
                estadoDeOrden estadoDeOrden, DateTime fechaCreacion, double total,
                int idEmpleado, Boolean activo, DateTime fechaRecepcion, string descripcion)
        {
            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrdenAbastecimiento.ordenAbastecimiento_modificar(idOrdenAbastecimiento,
                lineas, estadoDeOrden, fechaCreacion, total,
                 idEmpleado, activo, fechaRecepcion, descripcion);
        }

        public int eliminar(int idOrdenAbastecimiento)
        {
            return this.WsOrdenAbastecimiento.ordenAbastecimiento_eliminar(idOrdenAbastecimiento);
        }

        public BindingList<ordenAbastecimiento> listarTodos()
        {
            ordenAbastecimiento[] arreglo = this.WsOrdenAbastecimiento.ordenAbastecimiento_listarTodos();
            return new BindingList<ordenAbastecimiento>(arreglo);
        }

        public ordenAbastecimiento obtenerPorId(int idOrdenAbastecimiento)
        {
            return this.WsOrdenAbastecimiento.ordenAbastecimiento_obtenerPorId(idOrdenAbastecimiento);
        }

        public Boolean existeOrdenAbastecimiento(int idOrdenAbastecimiento)
        {
            return this.WsOrdenAbastecimiento.existeOrdenAbastecimiento(idOrdenAbastecimiento);
        }
    }
}
