using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftLibWA
{
    public partial class gestionar_ordenes_abastecimiento : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                
            }
        }


        protected void ddlLocales_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Implementa la lógica para manejar el cambio de selección en ddlLocales si es necesario
            // Por ejemplo, podrías filtrar el GridView basado en el local seleccionado.
        }

        protected void BtnLimpiar_Click(object sender, EventArgs e)
        {
            // Restablecer el ddlLocales a la opción predeterminada
            // Aquí puedes añadir más lógica para limpiar otros filtros si es necesario
        }

        protected void BtnIdOrden_Click(object sender, EventArgs e)
        {

        }

        protected void BtnModificar_Click(object sender, EventArgs e)
        {

        }

        protected void BtnEliminar_Click(object sender, EventArgs e)
        {

        }

        protected void GridAbastecimiento_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }
    }
}