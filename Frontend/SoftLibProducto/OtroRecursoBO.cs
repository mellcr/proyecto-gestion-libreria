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
        public int insertar(string nombre, double peso, double alto, double ancho,
            double precio, unidadMedida unidadMedida, sbyte?[] foto,
            string caracteristica)
        {
            return this.WsOtroRecurso.otrosRecursos_insertar(nombre,  peso,  alto,  ancho,
             precio,  unidadMedida, foto,
             caracteristica);
        }

        public int modificar(int idOtroRecurso, string nombre, double peso,
                double alto, double ancho, double precio, bool activo,
                bool disponible, unidadMedida unidadMedida, sbyte?[] foto,
                string caracteristica)
        {
            return this.WsOtroRecurso.otrosRecursos_modificar(idOtroRecurso,  nombre,  peso,
                 alto,  ancho,  precio,  activo, disponible,  unidadMedida, foto, caracteristica);
        }

        public int eliminar(int idOtroRecurso)
        {
            return this.WsOtroRecurso.otrosRecursos_eliminar(idOtroRecurso);
        }

        public BindingList<otroRecurso> listarTodos()
        {
            otroRecurso[] arreglo = this.WsOtroRecurso.otrosRecursos_listarTodos();
            return new BindingList<otroRecurso>(arreglo);
        }

        public otroRecurso obtenerPorId(int idOtroRecurso)
        {
            return this.WsOtroRecurso.otrosRecursos_obtenerPorId(idOtroRecurso);
        }

        public bool existeOtroRecurso(int idOtroRecurso)
        {
            return this.WsOtroRecurso.existeOtroRecurso(idOtroRecurso);
        }

        public BindingList<otroRecurso> mostrarDestacado()
        {
            otroRecurso[] arreglo = this.WsOtroRecurso.otrosRecursos_mostrarDestacado();
            return new BindingList<otroRecurso>(arreglo);
        }

            public BindingList<otroRecurso> buscarOtrosRecursos(string nombre)
        {
            otroRecurso[] arreglo = this.WsOtroRecurso.buscarOtrosRecursos(nombre);
            return new BindingList<otroRecurso>(arreglo);
        }
    }
}
