using SoftLibBO;
using SoftLibBO.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibUsuarioBO
{
    public class ClienteBO : BaseBO
    {
        public cliente obtenerPorId(int idCliente)
        {
            return this.WsCliente.cliente_obtenerPorId(idCliente);
        }

        public BindingList<cliente> listarTodos()
        {
            cliente[] arreglo = this.WsCliente.cliente_listarTodos();
            return new BindingList<cliente>(arreglo);
        }

        public BindingList<cliente> buscarClientes(string nombre)
        {
            cliente[] arreglo = this.WsCliente.buscarClientes(nombre);
            return new BindingList<cliente>(arreglo);
        }
    }
}
