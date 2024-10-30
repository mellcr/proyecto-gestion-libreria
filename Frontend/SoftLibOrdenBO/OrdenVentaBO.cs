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
    public class OrdenVentaBO : BaseBO
    {
        public int insertar(BindingList<lineaDeOrden> lineasDeOrdenes,
            estadoDeOrden estadoDeOrden, DateTime fechaCreacion, double total,
            int idEmpleado, DateTime fechaEntrega, tipoDeVenta tipoVenta,
            metodoPago metodoPago, int fidCliente)
        {

            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrdenVenta.ordenVenta_insertar(lineas,
            estadoDeOrden, fechaCreacion, total, idEmpleado, fechaEntrega, tipoVenta,
             metodoPago, fidCliente);
        }

        public int modificar(int idOrdenVenta,
        BindingList<lineaDeOrden> lineasDeOrdenes, estadoDeOrden estadoDeOrden,
                DateTime fechaCreacion, double total, int idEmpleado, bool activo,
        DateTime fechaEntrega, tipoDeVenta tipoVenta, metodoPago metodoPago,
                int fidCliente)
        {
            lineaDeOrden[] lineas = lineasDeOrdenes.ToArray();
            return this.WsOrdenVenta.ordenVenta_modificar(idOrdenVenta,
         lineas, estadoDeOrden,
                 fechaCreacion, total, idEmpleado, activo, fechaEntrega, tipoVenta, metodoPago,
                 fidCliente);
        }

        public int eliminar(int idOrdenVenta)
        {
            return this.WsOrdenVenta.ordenVenta_eliminar(idOrdenVenta);
        }

        public BindingList<ordenVenta> listarTodos()
        {
            ordenVenta[] arreglo = this.WsOrdenVenta.ordenVenta_listarTodos();
            return new BindingList<ordenVenta>(arreglo);
        }

        public ordenVenta obtenerPorId(int idOrdenVenta)
        {
            return this.WsOrdenVenta.ordenVenta_obtenerPorId(idOrdenVenta);
        }

        public Boolean existeOrdenVenta(int idOrdenVenta)
        {
            return this.WsOrdenVenta.existeOrdenVenta(idOrdenVenta);
        }
    }
}
