﻿using SoftLibBO.ServicioWeb;
using SoftLibOrdenBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftLibWA
{
    public partial class gestionar_ordenes_venta : System.Web.UI.Page
    {
        private OrdenVentaBO ordenVentaBO;

        BindingList<ordenVenta> listaOrdenesVenta;

        public gestionar_ordenes_venta()
        {
            this.ordenVentaBO = new OrdenVentaBO();
            this.listaOrdenesVenta = new BindingList<ordenVenta>();
            this.listaOrdenesVenta = this.ordenVentaBO.listarTodos();

        }



        protected void Page_Load(object sender, EventArgs e)
        {
            GridVentas.DataSource = listaOrdenesVenta;
            GridVentas.DataBind();

        }


        protected void TxtBuscarCliente_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TxtBuscarProducto_TextChanged(object sender, EventArgs e)
        {

        }

        protected void FechaInicio_TextChanged(object sender, EventArgs e)
        {

        }

        protected void FechaFin_TextChanged(object sender, EventArgs e)
        {

        }

        protected void GridVentas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }

        protected void GridVentas_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void BtnVer_Click(object sender, EventArgs e)
        {

        }

        protected void BtnEliminar_Click(object sender, EventArgs e)
        {

        }

        protected void BtnLimpiar_Click(object sender, EventArgs e)
        {

        }

        protected void BtnVerDetalle_Click(object sender, EventArgs e)
        {

        }

        protected void BtnModificar_Click(object sender, EventArgs e)
        {

        }

        protected void BtnEliminar_Click1(object sender, EventArgs e)
        {

        }

        protected void BtnIdOrden_Click(object sender, EventArgs e)
        {
            /*LinkButton btn = (LinkButton)sender;
            string idOrdenVenta = btn.CommandArgument;

            // Redirigir a la página de detalle de la orden de venta
            Response.Redirect($"DetalleOrdenVenta.aspx?idOrdenVenta={idOrdenVenta}")¨*/
        }


    }
}


