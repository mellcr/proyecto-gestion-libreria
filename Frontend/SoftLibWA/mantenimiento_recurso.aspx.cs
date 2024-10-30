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
                // Cargar los datos GridView Libro
                dgvRecursoLibros.DataSource = listaDeTodosLibro;
                dgvRecursoLibros.DataBind();}
                // Cargar los datos GridView Libro
                dgvRecursoOtros.DataSource = listaDeTodosOtroRecurso; 
                dgvRecursoOtros.DataBind();
        }

        /* SOPORTE PARA LA INSERCION*/
        // Evento para el botón Insertar
        protected void btnInsertarLibros_Click(object sender, EventArgs e)
        {
            Response.Redirect("gestionar_libros.aspx");
        }
        // Evento para el botón Insertar
        protected void btnInsertarOtrosRecursos_Click(object sender, EventArgs e)
        {
            Response.Redirect("gestionar_otrosrecursos.aspx");
        }

        /*SOPORTE PARA LA MODIFICACION */
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

        // Evento para modificar otro recurso
        protected void lbModificarOtroRecurso_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idRecurso = Convert.ToInt32(btn.CommandArgument);

            // Lógica para modificar el recurso usando el idRecurso
            // Redirigir a una página de edición o abrir un modal (dependiendo de tu implementación)
            Session["idRecurso"] = idRecurso; //puntero void que guarda cualquier tipo -> para recuperar el dato se castea 
            Response.Redirect("gestionar_otrosrecursos.aspx?accion=modificar");
        }

        /* ELIMINACION DE DATOS*/
        // Evento para eliminar un libro
        protected void lbEliminarLibro_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idLibro = Convert.ToInt32(btn.CommandArgument);

            // Lógica para eliminar el libro usando el idLibro
            // Elimina de la base de datos y recarga los datos
            this.libroBO.eliminar(idLibro);
            Response.Redirect("mantenimiento_recurso.aspx"); // Recarga los datos después de eliminar
        }

        // Evento para eliminar otro recurso
        protected void lbEliminarOtroRecurso_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idRecurso = Convert.ToInt32(btn.CommandArgument);

            // Lógica para eliminar el recurso usando el idRecurso
            // Elimina de la base de datos y recarga los datos
            this.otrosRecursosBO.eliminar(idRecurso);
            Response.Redirect("mantenimiento_recurso.aspx");
        }

        /*Soporte a paginacion*/
        protected void dgvRecurso_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoLibros.PageIndex = e.NewPageIndex;
            dgvRecursoLibros.DataBind();
        }
        // Evento de paginación para Libros
        protected void dgvRecursoLibros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoLibros.PageIndex = e.NewPageIndex;
            dgvRecursoLibros.DataBind();    // Recargar los datos en el nuevo índice de página
        }

        // Evento de paginación para Otros Recursos
        protected void dgvRecursoOtros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecursoOtros.PageIndex = e.NewPageIndex;
            dgvRecursoOtros.DataBind(); // Recargar los datos en el nuevo índice de página
        }
    }
}