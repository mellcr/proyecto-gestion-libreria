
using SoftLibBO.ServicioWeb;
using SoftLibProducto;
using SoftLibUsuarioBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web.UI;
using System.Web.UI.WebControls;
//using SoftLibWA.SoapServiceReference; // Referencia al servicio SOAP

namespace SoftLibWA
{
    public partial class registro_ordenes_venta : System.Web.UI.Page
    {
        /* private ClienteWSClient clienteBO;
         private RecursoWSClient recursoBO;
         private OrdenVentaWSClient OrdenVentaBO;
         private BindingList<cliente> clientes;

         private BindingList<recurso> recursos;
         private ServicioWSClient recursoBO;

         private ServicioWSClient clienteBO;
         private BindingList<cliente> clientes;*/

        private ClienteBO clienteBO;
        private RecursoBO recurosBO;

        private BindingList<cliente> listarClientesTodos;
        private BindingList<recurso> listarRecursoTodos;
        private BindingList<cliente> listarClientesPorNombre;

        public registro_ordenes_venta()
        {
            clienteBO = new ClienteBO();
            recurosBO  = new RecursoBO();

            listarClientesTodos = new BindingList<cliente>();
            listarRecursoTodos = new BindingList<recurso>();
            listarClientesPorNombre = new BindingList<cliente>();
        }

        protected void Page_Init(object sender, EventArgs e)
        {  
            ModalOrdenVenta_gvClientes.DataSource = clienteBO.listarTodos();
            ModalOrdenVenta_gvClientes.DataBind();

            ModalOrdenVenta_gvProductos.DataSource = recurosBO.listarTodos();
            ModalOrdenVenta_gvProductos.DataBind();
        }
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        private void CargarProductosSeleccionados()
        {

        }

        protected void btnBuscarCliente_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormCliente() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void ModalCliente_lbBuscarCliente_Click(object sender, EventArgs e)
        {
            string nombre = ModalCliente_txtNombreCliente.Text;
            listarClientesPorNombre = clienteBO.buscarClientes(nombre);  
            ModalOrdenVenta_gvClientes.DataSource = listarClientesPorNombre;
            ModalOrdenVenta_gvClientes.DataBind();
        }

        protected void ModalOrdenVenta_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int idClienteSeleccionado = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idClienteSeleccionado"] = idClienteSeleccionado;
            cliente cliente_seleccionado = clienteBO.obtenerPorId(idClienteSeleccionado);
            txtIdCliente.Text = cliente_seleccionado.idPersona.ToString();
            txtNombreCliente.Text = cliente_seleccionado.nombre;
            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
        }

        protected void ModalProducto_lbBuscarProducto_Click(object sender, EventArgs e)
        {
        }

        protected void ModalOrdenVenta_lbSeleccionarProducto_Click(object sender, EventArgs e)
        {
            
        }

        protected void lbEliminarProducto_Click(object sender, EventArgs e)
        {
        }

        protected void ModalOrdenVenta_gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            ModalOrdenVenta_gvClientes.PageIndex = e.NewPageIndex;
            ModalCliente_lbBuscarCliente_Click(sender, e); // Volver a buscar para mantener resultados
        }

        protected void ModalOrdenVenta_gvProductos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            ModalOrdenVenta_gvProductos.PageIndex = e.NewPageIndex;
            ModalProducto_lbBuscarProducto_Click(sender, e); // Volver a buscar para mantener resultados
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Index.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
          
        }

        protected void ddlTipoProducto_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
