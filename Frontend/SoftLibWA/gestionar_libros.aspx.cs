using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing.Drawing2D;
using System.IO;
using System.Linq;
using System.Net.NetworkInformation;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Microsoft.SqlServer.Server;
using SoftLibBO.ServicioWeb;
using SoftLibProducto;

namespace SoftLibWA
{
    public partial class gestionar_libros : System.Web.UI.Page
    {
        //private GrupoInvestigacionBO grupoBo;
        private LibroBO libroBO;
        private BindingList<libro> listaDepartamentos;
        private int idLibro;
        private bool esta_modificando;
        private byte[] foto;
        /**/

        public gestionar_libros()
        {
            libroBO = new LibroBO();    
        }
        protected void Page_Init(object sender, EventArgs e)
        {
            CargarFormato();

            //this.idLibro = (int)Session["IdRecurso"];
            //string accion = Request.QueryString["accion"];
            //if (accion != null && accion == "modificar")
            //    esta_modificando = true;
            //else
            //    esta_modificando = false;
            //if (esta_modificando)
            //    this.cargarDatosBDLibro();
        }

        private void CargarFormato()
        {
            // Convertir los valores del enum en una lista y asignarlos al DropDownList
            DropDownListFormato.DataSource = Enum.GetValues(typeof(formato));
            DropDownListFormato.DataBind();
            // Agregar una opción nula al inicio del DropDownList
            DropDownListFormato.Items.Insert(0, new ListItem("Seleccione un formato", ""));
        }


        // unidadMedida unidadMedida, categoria[] categorias, autor autor, 
        /*Carga los datos de libro*/
        private void cargarDatosBDLibro()
        {
            libro _libro = this.libroBO.obtenerPorId(this.idLibro);
            txtIdRecurso.Text = _libro.idRecurso.ToString();
            txtNombre.Text = _libro.nombre;
            txtPeso.Text = _libro.peso.ToString();
            txtAlto.Text = _libro.alto.ToString();
            txtAncho.Text = _libro.ancho.ToString();
            txtPrecio.Text = _libro.precio.ToString();
            txtEditorial.Text = _libro.editorial;
            txtISBN.Text = _libro.ISBN;
            txtDescripcion.InnerText = _libro.sinopsis;
            lblFormato.Text = _libro.formato.ToString();
            lblUnidadMedida.Text = _libro.unidadMedida.ToString();

            // Cargar la foto si existe
            if (_libro.foto != null && _libro.foto.Length > 0)
            {
                // Convertir sbyte?[] a byte[]
                byte[] fotoBytes = Array.ConvertAll(_libro.foto, b => (byte)(b ?? 0));

                // Convertir el byte[] a una cadena Base64
                string base64Image = Convert.ToBase64String(fotoBytes);

                // Crear el formato para mostrar en una etiqueta <img>
                imgFotoGrupo.ImageUrl = "data:image/png;base64," + base64Image;
                imgFotoGrupo.Visible = true;
            }
            else
            {
                // Si no hay foto, muestra una imagen por defecto
                imgFotoGrupo.ImageUrl = "~/Images/placeholder.jpg"; // Asegúrate de que exista este archivo
                imgFotoGrupo.Visible = true;
            }
        }

        /**/
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verificar si la variable de sesión "foto" contiene una imagen
                if (Session["foto"] != null)
                    foto = (byte[])Session["foto"];

                // Cambiar el título en función de la acción recibida
                string accion = Request.QueryString["accion"];
                if (accion == "ver" && Session["IdRecurso"] != null)
                {
                    lblTitulo.Text = "Datos del Libro";
                    this.idLibro = (int)Session["IdRecurso"];
                    cargarDatosBDLibro();
                    mostrarDatosLectura(); // Método para configurar controles en modo solo lectura
                }
                else if (accion == "modificar" && Session["IdRecurso"] != null)
                {
                    lblTitulo.Text = "Modificar Libro";
                    this.idLibro = (int)Session["IdRecurso"];
                    cargarDatosBDLibro();
                }
                else
                {
                    lblTitulo.Text = "Registrar Libro";
                }
            }
        }


        public void mostrarDatosLectura()
        {
            btnGuardar.Enabled = false;
            btnSubirFotoGrupo.Visible = false;
            fileUploadFotoGrupo.Visible = false;

            txtIdRecurso.Enabled = false;
            txtNombre.Enabled = false;
            txtPeso.Enabled = false;
            txtAlto.Enabled = false;
            txtAncho.Enabled = false;
            txtPrecio.Enabled = false;
            txtEditorial.Enabled = false;
            txtISBN.Enabled = false;
            txtDescripcion.Disabled = true; // Deshabilitar el campo Sinopsis
            lblFormato.Enabled = false;
            lblUnidadMedida.Enabled = false;

            // Deshabilitar Unidad de Medida (RadioButtons)
            rbUnidad.Disabled = true;
            rbPaquete.Disabled = true;

            DropDownListFormato.Enabled = false;
        }

        protected void btnSubirFotoGrupo_Click(object sender, EventArgs e)
        {
            //Verificar si se seleccionó un archivo
            if (fileUploadFotoGrupo.HasFile)
            {
                // Obtener la extensión del archivo
                string extension = System.IO.Path.GetExtension(fileUploadFotoGrupo.FileName);
                // Verificar si el archivo es una imagen
                if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
                {
                    // Guardar la imagen en el servidor
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadFotoGrupo.SaveAs(Server.MapPath("~/Uploads/") + filename);
                    // Mostrar la imagen en la página
                    imgFotoGrupo.ImageUrl = "~/Uploads/" + filename;
                    imgFotoGrupo.Visible = true;
                    // Guardamos la referencia en una variable de sesión llamada foto
                    FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Session["foto"] = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
                else
                {
                    // Mostrar un mensaje de error si el archivo no es una imagen
                    Response.Write("Por favor, selecciona un archivo de imagen válido.");
                }
            }
            else
            {
                // Mostrar un mensaje de error si no se seleccionó ningún archivo
                Response.Write("Por favor, selecciona un archivo de imagen.");
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_recurso.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            /*Trae las variables del TextBox*/
            int idRecurso;
            string nombre_recurso = txtNombre.Text;
            double peso_recurso = Double.Parse(txtPeso.Text);
            double alto_recurso = Double.Parse(txtAlto.Text);
            double ancho_recurso = Double.Parse(txtAncho.Text);
            double precio_recurso = Double.Parse(txtPrecio.Text);
            unidadMedida unidadmedida_recurso = ObtenerUnidadMedida();
            byte[] foto_recurso = ObtenerFoto();
            sbyte?[] foto_recurso_sbyte = Array.ConvertAll(foto_recurso, b => (sbyte?)b);
            string sinopsis_recurso = txtDescripcion.InnerText;
            string ISBN_recurso = txtISBN.Text;
            formato formato_recurso = ObtenerFormato();
            string editorial_recurso = txtEditorial.Text;
            categoria[] categorias_recurso = null;
            autor autor_recurso = null;

            // Verifica si hay un ID en txtIdRecurso.Text
            bool esModificacion = int.TryParse(txtIdRecurso.Text, out idRecurso);

            if (esModificacion)
                this.libroBO.modificar(idRecurso, nombre_recurso, peso_recurso, alto_recurso, ancho_recurso, precio_recurso,
                    true, true, unidadmedida_recurso, foto_recurso_sbyte, categorias_recurso, autor_recurso, editorial_recurso,
                    ISBN_recurso, sinopsis_recurso, formato_recurso);
            else
                this.libroBO.insertar(nombre_recurso, peso_recurso, alto_recurso, ancho_recurso, precio_recurso,
                    unidadmedida_recurso, foto_recurso_sbyte, categorias_recurso, autor_recurso, editorial_recurso,ISBN_recurso, 
                    sinopsis_recurso, formato_recurso);
            /*Una vez grabado, redigimos al mantenimiento (donde tenemos el listado) */
            Response.Redirect("mantenimiento_recurso.aspx");
        }



        private unidadMedida ObtenerUnidadMedida()
        {
            //en caso hayan mas opciones para escoger, esta logica tendra que cambiar
            if (rbUnidad.Checked)
            {
                return unidadMedida.PAQUETE;
            }
            else if (rbPaquete.Checked)
            {
                return unidadMedida.UNIDAD;
            }

            throw new Exception("No se seleccionó ningún tipo de evento."); // Manejo de error si no se selecciona nada
        }

        private formato ObtenerFormato()
        {
            // Obtenemos el valor seleccionado del DropDownList
            string formatoSeleccionado = DropDownListFormato.SelectedValue;

            // Convertimos el valor seleccionado a un valor del enum Formato
            if (Enum.TryParse(formatoSeleccionado, out formato formato))
            {
                return formato;
            }
            else
            {
                throw new Exception("Formato seleccionado no es válido."); // Error si no se puede convertir el valor
            }
        }


        private byte[] ObtenerFoto()
        {
            Byte[] bytes = null;
            if (Session["foto"] != null)
            {
                bytes = (byte[])Session["foto"];
            }
            return bytes;
        }


        protected void btnBuscarAutor_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormAutor() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void btnBuscarCategoria_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormCategoria() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void ModalAutor_lbBuscarAutor_Click(object sender, EventArgs e)
        {

        }

        protected void ModalCategoria_lbBuscarCategoria_Click(object sender, EventArgs e)
        {

        }

        protected void ModalAutor_gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }

        protected void ModalAutor_lbSeleccionar_Click(object sender, EventArgs e)
        {

        }

        protected void ModalCategoria_gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }

        protected void ModalCategoria_lbSeleccionar_Click(object sender, EventArgs e)
        {

        }
    }
}