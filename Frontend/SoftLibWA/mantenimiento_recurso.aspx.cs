using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftLibBO.ServicioWeb;
using SoftLibProducto;

namespace SoftLibWA
{
    public partial class mantenimiento_recurso : System.Web.UI.Page
    {
        private LibroBO libroBO;
        private OtroRecursoBO otrosRecursosBO;
        private BindingList<libro> listaDeTodosLibro;
        private BindingList<otroRecurso> listaDeTodosOtroRecurso;

        public mantenimiento_recurso()
        {
            this.libroBO = new LibroBO();
            this.otrosRecursosBO = new OtroRecursoBO();
            this.listaDeTodosLibro = this.libroBO.listarTodos();
            this.listaDeTodosOtroRecurso = this.otrosRecursosBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar los datos en ambos GridViews
                CargarDatosLibros();
                CargarDatosOtrosRecursos();
            }
        }

        // Cargar datos en el GridView de Libros
        private void CargarDatosLibros()
        {
            // Aquí deberías conectar con tu base de datos y obtener los datos de Libros
            // Ejemplo (usa tu propia lógica y fuentes de datos):
            dgvRecursoLibros.DataSource = ObtenerDatosLibros(); // Método que retorna una lista de libros
            dgvRecursoLibros.DataBind();
        }

        // Métodos de ejemplo para obtener y eliminar datos (ajusta según tu lógica)
        private object ObtenerDatosLibros()
        {
            // Conectar con la base de datos y retornar la lista de libros
            return null; // Reemplaza con la lógica real
        }

        // Cargar datos en el GridView de Otros Recursos
        private void CargarDatosOtrosRecursos()
        {
            // Aquí deberías conectar con tu base de datos y obtener los datos de Otros Recursos
            // Ejemplo (usa tu propia lógica y fuentes de datos):
            dgvRecursoOtros.DataSource = ObtenerDatosOtrosRecursos(); // Método que retorna una lista de otros recursos
            dgvRecursoOtros.DataBind();
        }

        // Evento de paginación para Libros
        protected void dgvRecursoLibros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoLibros.PageIndex = e.NewPageIndex;
            CargarDatosLibros(); // Recargar los datos en el nuevo índice de página
        }

        // Evento de paginación para Otros Recursos
        protected void dgvRecursoOtros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoOtros.PageIndex = e.NewPageIndex;
            CargarDatosOtrosRecursos(); // Recargar los datos en el nuevo índice de página
        }

        // Evento para modificar un libro
        protected void lbModificarLibro_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idLibro = Convert.ToInt32(btn.CommandArgument);

            // Lógica para modificar el libro usando el idLibro
            // Redirigir a una página de edición o abrir un modal (dependiendo de tu implementación)
            Session["idLibro"] = idLibro; //puntero void que guarda cualquier tipo -> para recuperar el dato se castea 
            Response.Redirect("gestionar_libros.aspx?accion=modificar");
        }

        // Evento para eliminar un libro
        protected void lbEliminarLibro_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idLibro = Convert.ToInt32(btn.CommandArgument);

            // Lógica para eliminar el libro usando el idLibro
            // Elimina de la base de datos y recarga los datos
            EliminarLibro(idLibro);
            CargarDatosLibros(); // Recarga los datos después de eliminar
        }

        // Evento para modificar otro recurso
        protected void lbModificarOtroRecurso_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idRecurso = Convert.ToInt32(btn.CommandArgument);

            // Lógica para modificar el recurso usando el idRecurso
            // Redirigir a una página de edición o abrir un modal (dependiendo de tu implementación)
        }

        // Evento para eliminar otro recurso
        protected void lbEliminarOtroRecurso_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idRecurso = Convert.ToInt32(btn.CommandArgument);

            // Lógica para eliminar el recurso usando el idRecurso
            // Elimina de la base de datos y recarga los datos
            EliminarRecurso(idRecurso);
            CargarDatosOtrosRecursos(); // Recarga los datos después de eliminar
        }

        // Evento para el botón Insertar
        protected void btnInsertarLibros_Click(object sender, EventArgs e)
        {
            // Lógica para insertar un nuevo recurso
            // Esto puede redirigir a un formulario de inserción o mostrar un modal
            Response.Redirect("gestionar_libros.aspx");
        }
        // Evento para el botón Insertar
        protected void btnInsertarOtrosRecursos_Click(object sender, EventArgs e)
        {
            // Lógica para insertar un nuevo recurso
            // Esto puede redirigir a un formulario de inserción o mostrar un modal
            Response.Redirect("gestionar_otrosrecursos.aspx");
        }

        

        private object ObtenerDatosOtrosRecursos()
        {
            // Conectar con la base de datos y retornar la lista de otros recursos
            return null; // Reemplaza con la lógica real
        }

        private void EliminarLibro(int idLibro)
        {
            // Lógica para eliminar el libro de la base de datos
        }

        private void EliminarRecurso(int idRecurso)
        {
            // Lógica para eliminar el recurso de la base de datos
        }

        /*Soporte a paginacion*/
        protected void dgvRecurso_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoLibros.PageIndex = e.NewPageIndex;
            dgvRecursoLibros.DataBind();
        }
    }
}