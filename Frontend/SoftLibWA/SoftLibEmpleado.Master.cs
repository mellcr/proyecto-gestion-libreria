using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftLibWA
{
    public partial class SoftLibEmpleado : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Configura el nombre y rol del usuario
                litNombreUsuario.Text = Session["NombreUsuario"] != null ? Session["NombreUsuario"].ToString() : "Usuario";
                litRolUsuario.Text = Session["RolUsuario"] != null ? Session["RolUsuario"].ToString() : "Rol";
            }
        }


    }
}