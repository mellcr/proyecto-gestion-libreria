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

        public int insertar(string nombre, double peso, double alto, double ancho,
            double precio, bool activo, bool disponible,
            unidadMedida unidadMedida, sbyte?[] foto)
        {
            
            return this.WsRecurso.recurso_insertar( nombre,  peso,  alto,  ancho,precio,  activo,  disponible,unidadMedida, foto);
        }

        public int modificar(int idRecurso, string nombre, double peso,
                double alto, double ancho, double precio, bool activo,
                bool disponible, unidadMedida unidadMedida, sbyte?[] foto)
        {
            return this.WsRecurso.recurso_modificar(idRecurso, nombre, peso, alto, ancho, precio, activo, disponible, unidadMedida, foto);
        }

        public int eliminar(int idRecurso)
        {
            return this.WsRecurso.recurso_eliminar(idRecurso);
        } 

        public recurso obtenerPorId(int idRecurso)
        {
            return this.WsRecurso.recurso_obtenerPorId(idRecurso);
        }

        public int existeRecurso(string nombre, double precio)
        {
            return this.WsRecurso.existeRecurso(nombre, precio);
        }

        public BindingList<recurso> listarTodos()
        {
            recurso[] arreglo = this.WsRecurso.recurso_listarTodos();
            return new BindingList<recurso>(arreglo);
        }

    }
}
