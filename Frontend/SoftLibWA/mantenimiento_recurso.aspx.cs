using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftLibWA
{
    public partial class mantenimiento_recurso : System.Web.UI.Page
    {
        //private SeccionBo seccionBo;
        private BindingList<Object> listaDeTodos;

        public mantenimiento_recurso()
        {
            //this.seccionBo = new SeccionBo();
            //this.listaDeTodos = this.seccionBo.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            //dgvSeccion.DataSource = listaDeTodos;
            //dgvSeccion.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            //response.Redirect("gestionar_seccion.aspx");
        }

        /*MODIFICAR Y ELIMINAR -> pasan un id que debe ser capturado por el sender*/
        protected void lbModificar_Click(object sender, EventArgs e)
        {
            //string idSeccion = ((LinkButton)sender).CommandArgument;
            //Session["idSeccion"] = idSeccion;
            // Se modifica al objeto en otra pagina 
            //sResponse.Redirect("gestionar_seccion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            //string idSeccion = ((LinkButton)sender).CommandArgument;
            //this.seccionBo.eliminar(idSeccion);                     // el bo lo elimina
            ///Response.Redirect("mantenimiento_seccion.aspx");        //refresca automaticamente para mostrar los cambios
        }

        /*Soporte a paginacion*/
        protected void dgvRecurso_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvRecurso.PageIndex = e.NewPageIndex;
            dgvRecurso.DataBind();
        }
    }
}