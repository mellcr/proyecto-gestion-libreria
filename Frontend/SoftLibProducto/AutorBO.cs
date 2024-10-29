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
    public class AutorBO :BaseBO
    {
        public int insertar(string nombre, string nacionalidad)
        {
            return this.WsAutor.autor_insertar(nombre, nacionalidad);
        }
        
        public int modificar(int idAutor, string nombre, string nacionalidad,
                        bool activo)
        {
            return this.WsAutor.autor_modificar(idAutor, nombre, nacionalidad, activo);
        }

        public int eliminar(int idAutor)
        {
            return this.WsAutor.autor_eliminar(idAutor);
        }

        public BindingList<autor> listarTodos()
        {
            autor[] arreglo = this.WsAutor.autor_listarTodos();
            return new BindingList<autor>(arreglo);
        }

        public autor obtenerPorId(int idAutor)
        {
            return this.WsAutor.autor_obtenerPorId(idAutor);
        }

        public BindingList<autor> buscarAutores(string nombre)
        {
            autor[] arreglo = this.WsAutor.buscarAutores(nombre);
            return new BindingList<autor>(arreglo);
        }

    }
}
