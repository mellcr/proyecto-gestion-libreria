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
        public int insertar(string nombre, string apellidoPaterno,
                    string apellidoMaterno, string nacionalidad, string numeroDocumento,
                    tipoDocumento tipoDocumento, BindingList<perfil> perfiles, string direccion)
        {
            perfil[] _perfiles = perfiles.ToArray();
            return this.WsCliente.cliente_insertar(nombre, apellidoPaterno,
                   apellidoMaterno, nacionalidad, numeroDocumento,
                     tipoDocumento, _perfiles, direccion);
        }

        public int modificar(int idPersona, string nombre, string apellidoPaterno,
                string apellidoMaterno, string nacionalidad, string numeroDocumento,
                tipoDocumento tipoDocumento, perfil[] perfiles, string direccion)
        {
            perfil[] _perfiles = perfiles.ToArray();
            return this.WsCliente.cliente_modificar(idPersona, nombre, apellidoPaterno,
                 apellidoMaterno, nacionalidad, numeroDocumento,
                 tipoDocumento, perfiles, direccion);
        }

        public int eliminar(int idCliente)
        {
            return this.WsCliente.cliente_eliminar(idCliente);
        }

        public bool existeCliente(int idCliente)
        {
            return this.WsCliente.existeCliente(idCliente);
        }
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
