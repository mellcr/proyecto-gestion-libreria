using SoftLibBO;
using SoftLibBO.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibProducto
{
    public class OtroRecursoBO : BaseBO
    {
        public BindingList<otroRecurso> buscarOtrosRecursos(string nombre)
        {
            otroRecurso[] arreglo = this.WsOtroRecurso.buscarOtrosRecursos(nombre);
            return new BindingList<otroRecurso>(arreglo);
        }
    }
}
