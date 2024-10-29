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
    public class RecursoBO : BaseBO
    {
        public BindingList<recurso> listarTodos()
        {
            recurso[] arreglo = this.WsRecurso.recurso_listarTodos();
            return new BindingList<recurso>(arreglo);
        }

    }
}
