
using SoftLibBO.ServicioWeb;
using SoftLibOrdenBO;
using SoftLibProducto;
using SoftLibUsuarioBO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftLibWA
{
    public partial class registro_ordenes_venta : System.Web.UI.Page
    {

        private ClienteBO clienteBO;
        private RecursoBO recurosBO;
        private LibroBO libroBO;
        private OtroRecursoBO otroRecursoBO;
        private OrdenVentaBO ordenVentaBO;
        private OrdenBO ordenBO;

        private BindingList<cliente> listarClientesTodos;
        private BindingList<recurso> listarRecursoTodos;
        private BindingList<cliente> listarClientesPorNombre;
        private BindingList<libro> listaLibrosPorNombre;
        private BindingList<otroRecurso> listaOtrosRecursosPorNombre;
        private BindingList<lineaDeOrden> lineasOrdenesVenta;

        public registro_ordenes_venta()
        {
            clienteBO = new ClienteBO();
            recurosBO = new RecursoBO();
            libroBO = new LibroBO();
            otroRecursoBO = new OtroRecursoBO();
            ordenVentaBO = new OrdenVentaBO();
            ordenBO = new OrdenBO();

            listarClientesTodos = new BindingList<cliente>();
            listarRecursoTodos = new BindingList<recurso>();
            listarClientesPorNombre = new BindingList<cliente>();
            listaLibrosPorNombre = new BindingList<libro>();
            listaOtrosRecursosPorNombre = new BindingList<otroRecurso>();
            lineasOrdenesVenta = new BindingList<lineaDeOrden>();
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
            if (Session["lineasOrdenVenta"] == null)
                lineasOrdenesVenta = new BindingList<lineaDeOrden>();
            else
                lineasOrdenesVenta = (BindingList<lineaDeOrden>)Session["lineasOrdenVenta"];

            gvProductos.DataSource = lineasOrdenesVenta;
            gvProductos.DataBind();
        }

        private void CargarProductosSeleccionados()
        {
            string tipoProductoSeleccionado = ddlTipoProducto.SelectedValue;
            string nombreABuscar = ModalProducto_txtNombreProducto.Text;

            // Filtrar productos según el tipo
            if (tipoProductoSeleccionado == "Libros")
            {
                // Cargar solo los productos que son "Libros"
                listaLibrosPorNombre = libroBO.buscarLibros(nombreABuscar);
                ModalOrdenVenta_gvProductos.DataSource = listaLibrosPorNombre;
                ModalOrdenVenta_gvProductos.DataBind();
            }
            else if (tipoProductoSeleccionado == "OtrosRecursos")
            {
                // Cargar solo los productos que son "Otros Recursos"
                listaOtrosRecursosPorNombre = otroRecursoBO.buscarOtrosRecursos(nombreABuscar);
                ModalOrdenVenta_gvProductos.DataSource = listaOtrosRecursosPorNombre;
                ModalOrdenVenta_gvProductos.DataBind();
            }
            else
            {
                // Si no se ha seleccionado ningún tipo, puedes cargar todos o limpiar la lista
                listarRecursoTodos = recurosBO.listarTodos();
                ModalOrdenVenta_gvProductos.DataSource = listarRecursoTodos;
                ModalOrdenVenta_gvProductos.DataBind();
            }
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
            int idRecursoSeleccionado = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idRecursoSeleccionado"] = idRecursoSeleccionado;
            string tipoProductoSeleccionado = ddlTipoProducto.SelectedValue;
            recurso recurso_seleccionado = recurosBO.obtenerPorId(idRecursoSeleccionado);
            txtIdRecurso.Text = recurso_seleccionado.idRecurso.ToString();
            txtNombreRecurso.Text = recurso_seleccionado.nombre;
            txtPrecioRecurso.Text = recurso_seleccionado.precio.ToString();
            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
        }

        protected void lbEliminarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            foreach (lineaDeOrden lov in this.lineasOrdenesVenta)
            {
                if (lov.recurso.idRecurso == idProducto)
                {
                    this.lineasOrdenesVenta.Remove(lov);
                    break;
                }
            }
            gvProductos.DataSource = lineasOrdenesVenta;
            gvProductos.DataBind();
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
            BindingList<lineaDeOrden> lineas = (BindingList<lineaDeOrden>)Session["lineasOrdenVenta"];
            double total = (double)Session["totalOV"];
            int idClienteSeleccionado = (int)Session["idClienteSeleccionado"];
            ordenBO.insertar(lineas, estadoDeOrden.PENDIENTE, DateTime.Now, total, 1);
            ordenVentaBO.insertar(lineas, estadoDeOrden.PENDIENTE, DateTime.Now, total, 1, DateTime.Now, 
               tipoDeVenta.PRESENCIAL, metodoPago.EFECTIVO, idClienteSeleccionado);
        }

        protected void ddlTipoProducto_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosSeleccionados();
        }

        public double calcularTotal()
        {
            double total = 0;
            foreach (lineaDeOrden lov in lineasOrdenesVenta)
                total += lov.subtotalBruto;
           return total;
        }

        protected void lbAgregarLOV_Click(object sender, EventArgs e)
        {
            int idRecursoSeleccionado = (int)Session["idRecursoSeleccionado"];
            lineaDeOrden lov = new lineaDeOrden();
            int cantidad = Int32.Parse(txtCantidadUnidades.Text);
            lov.cantidad = cantidad;
            lov.recurso = recurosBO.obtenerPorId(idRecursoSeleccionado);
            lov.subtotalBruto = lov.cantidad * lov.recurso.precio;
            lineasOrdenesVenta.Add(lov);
            Session["lineasOrdenVenta"] = lineasOrdenesVenta;

            gvProductos.DataSource = lineasOrdenesVenta;
            gvProductos.DataBind();

            double total = calcularTotal();
            Session["totalOV"] = total;

            txtTotal.Text = total.ToString();

            txtIdRecurso.Text = "";
            txtNombreRecurso.Text = "";
            txtCantidadUnidades.Text = "";
            txtPrecioRecurso.Text = "";
        }
    }
}
