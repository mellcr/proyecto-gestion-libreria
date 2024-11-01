﻿using SoftLibBO.ServicioWeb;
using SoftLibBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.SqlServer.Server;

namespace SoftLibProducto
{
    public class LibroBO : BaseBO
    {

        public int insertar(string nombre, double peso, double alto, double ancho,
            double precio, unidadMedida unidadMedida, sbyte?[] foto,
            categoria[] categorias, autor autor, string editorial,
            string ISBN, string sinopsis,formato formato)
        {
            return this.WsLibro.libro_insertar(nombre,  peso,  alto,  ancho,
            precio,  unidadMedida, foto,
            categorias,  autor,  editorial,
            ISBN,  sinopsis,  formato);
        }

        public int modificar(int idLibro, string nombre, double peso,
                double alto, double ancho, double precio, bool activo,
                bool disponible, unidadMedida unidadMedida, sbyte?[] foto,
                categoria[] categorias, autor autor, string editorial,
                string ISBN, string sinopsis, formato formato)
        {
            return this.WsLibro.libro_modificar( idLibro,  nombre,  peso,
                 alto,  ancho,  precio,  activo,
                 disponible,  unidadMedida, foto,
                categorias,  autor,  editorial,
                 ISBN,  sinopsis,  formato);
        }

        public int eliminar(int idLibro)
        {
            return this.WsLibro.libro_eliminar(idLibro);
        }

        public BindingList<libro> listarTodos()
        {
            libro[] arreglo = this.WsLibro.libro_listarTodos();
            return new BindingList<libro>(arreglo);;
        }

        public libro obtenerPorId(int idLibro)
        {
            return this.WsLibro.libro_obtenerPorId(idLibro);
        }

        public bool existeLibro(int idLibro)
        {
            return this.WsLibro.existeLibro(idLibro);
        }

        public BindingList<libro> buscarLibros(string nombre)
        {
            libro[] arreglo = this.WsLibro.buscarLibros(nombre);
            return new BindingList<libro>(arreglo);
        }

        public BindingList<libro> mostrarDestacado()
        {
            libro[] arreglo = this.WsLibro.libro_mostrarDestacado();
            return new BindingList<libro>(arreglo);
        }

    }
}
