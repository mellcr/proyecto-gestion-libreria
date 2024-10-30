using SoftLibBO;
using SoftLibBO.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibOrdenBO
{
    public class OrdenBO : BaseBO
    {
        public int insertar(BindingList<lineaDeOrden> lineasDeOrdenes,
           estadoDeOrden estadoDeOrden, DateTime fechaCreacion, double total,
           int idEmpleado)
        {
            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrden.orden_insertar(lineas, estadoDeOrden, fechaCreacion, total,
             idEmpleado);
        }

        public int modificar(int idOrden, BindingList<lineaDeOrden> lineasDeOrdenes,
                estadoDeOrden estadoDeOrden, DateTime fechaCreacion, double total,
                int idEmpleado, bool activo)
        {
            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrden.orden_modificar(idOrden, lineas,
                 estadoDeOrden, fechaCreacion, total,
                 idEmpleado, activo);
        }

        public int eliminar(int idOrden)
        {
            return this.WsOrden.orden_eliminar(idOrden);
        }

        public BindingList<orden> listarTodos()
        {
            orden[] arreglo = this.WsOrden.orden_listarTodos();
            return new BindingList<orden>(arreglo);
        }

        public orden obtenerPorId(int idOrden)
        {
            return this.WsOrden.orden_obtenerPorId(idOrden);
        }

        public int existeOrden(DateTime fechaCreacion, double total, int idEmpleado)
        {
            return this.WsOrden.existeOrden(fechaCreacion, total, idEmpleado);
        }
    }
}
