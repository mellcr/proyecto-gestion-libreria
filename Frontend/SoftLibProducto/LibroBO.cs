using SoftLibBO.ServicioWeb;
using SoftLibBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibProducto
{
    public class LibroBO : BaseBO
    {
        public BindingList<libro> buscarLibros(string nombre)
        {
            libro[] arreglo = this.WsLibro.buscarLibros(nombre);
            return new BindingList<libro>(arreglo);
        }

        public BindingList<libro> listarTodos()
        {
            libro[] arreglo = this.WsLibro.libro_listarTodos();
            return new BindingList<libro>(arreglo);
        }
    }
}
