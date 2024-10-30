<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="gestionar_libros.aspx.cs" Inherits="SoftLibWA.gestionar_libros" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión - Libros
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SoftLib/gestionarRecursos.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
                <h2>
                    <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                    <asp:Label ID="lblTitulo" runat="server"></asp:Label>
                </h2>
                <div style="border-top: 1px solid #dcdcdc; margin: 10px 0; width: 100%;"></div>

            <div class="card-body mb-2">
                <div class="card border">
                    <div class="card-header bg-light">
                        <h5 class="card-title mb-0">Información General</h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-5">
                                <asp:Label ID="lblFotoGrupo" CssClass="form-label" runat="server" Text="Foto del Recurso:"></asp:Label><br />
                                <div class="text-center">
                                    <asp:Image ID="imgFotoGrupo" alt="Foto del Grupo" runat="server" CssClass="img-fluid img-thumbnail mb-2" ImageUrl="/Images/placeholder.jpg" />
                                </div>
                                <asp:FileUpload ID="fileUploadFotoGrupo" CssClass="form-control mb-2" runat="server" />
                                <asp:Button ID="btnSubirFotoGrupo" CssClass="btn btn-primary" runat="server" Text="Cargar Foto" OnClick="btnSubirFotoGrupo_Click" />                               
                            </div>

                            
                            <div class="col-md-6 row">
                                <!-- ID RECURSO + Unidad de Medida -->
                                <div class="col-md-5 mb-2 ">
                                   <asp:Label ID="lblIdRecurso" CssClass="col-form-label" runat="server" Text="ID del Recurso:"></asp:Label>
                                    <asp:TextBox ID="txtIdRecurso" CssClass="form-control" Enabled="false" runat="server"></asp:TextBox>
                                </div>
                                <div class="col-md-6">
                                    <asp:Label ID="Label1" runat="server" Text="Unidad de Medida:" CssClass="col-form-label" />
                                    <div class="form-control">
                                        <div class="form-check form-check-inline">
                                            <input id="rbUnidad" class="form-check-input" type="radio" name="unidad" runat="server" />
                                            <label id="lblUnidad" class="form-check-label" for="cphContenido_rbUnidad">UNIDAD</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input id="rbPaquete" class="form-check-input" type="radio" name="unidad" runat="server" />
                                            <label id="lblPaquete" class="form-check-label" for="cphContenido_rbPaquete">PAQUETE</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- NOmbre -->
                                <div class="col-md-13 mb-2">
                                    <asp:Label ID="lblNombre" runat="server" Text="Nombre:" CssClass="col-form-label" />
                                    <asp:TextBox ID="txtNombre" CssClass="form-control" runat="server"></asp:TextBox>
                                </div>
                                
                                <!-- Precio +  Peso-->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <asp:Label ID="lblPrecio" runat="server" Text="Precio (S/.) :" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtPrecio" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>

                                    <div class="col-md-6">
                                        <asp:Label ID="lblPeso" runat="server" Text="Peso (kg) :" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtPeso" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>
                                </div>

                                <!-- Alto +  Ancho-->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <asp:Label ID="LblAlto" runat="server" Text="Alto (cm):" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtAlto" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>

                                    <div class="col-md-6">
                                        <asp:Label ID="lblAncho" runat="server" Text="Ancho (cm):" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtAncho" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>
                                </div>

                                <!-- Editorial +  ISSBN-->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <asp:Label ID="lblEditorial" runat="server" Text="Editorial :" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtEditorial" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>

                                    <div class="col-md-6">
                                        <asp:Label ID="lblISBN" runat="server" Text="ISBN :" CssClass="col-form-label" />
                                        <asp:TextBox ID="txtISBN" CssClass="form-control" runat="server"></asp:TextBox>
                                    </div>
                                </div>
                            </div>
                            <!-- Sinopsis del Libro -->
                             <div class="row mb-3">
                                <div class="col-md-11">
                                    <asp:Label ID="lblDescripcion" runat="server" Text="Sinopsis del Libro:" CssClass="col-form-label ms-3" />
                                    <textarea id="txtDescripcion" class="form-control ms-3" rows="3" cols="20" runat="server"></textarea>
                                </div>
                             </div>

                         </div>
                    </div>
                 </div>
             </div>


            <!-- LISTADO -->
            <div class="card border mb-2">
                <!-- AUTOR -->
                <div class="card-header bg-light">
                    <h5 class="card-title mb-0">Información del Autor </h5>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="lblIDAutor" runat="server" Text="Id del Autor:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-3">
                            <asp:TextBox ID="txtIDAutor" runat="server" Enabled="false" CssClass="form-control" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblNombreAutor" runat="server" Text="Nombre del Autor:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtNombreAutor" runat="server" Enabled="false" CssClass="form-control" />
                        </div>
                        <asp:Button ID="btnBuscarAutor" CssClass="btn btn-primary col-sm-2" runat="server" Text="Buscar Autor" OnClick="btnBuscarAutor_Click" />
                    </div>
                </div>

                <!-- CATEGORIA -->
                <div class="card-header bg-light">
                    <h5 class="card-title mb-0">Información de la Categoria </h5>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="lblIDCategoria" runat="server" Text="Id de Categoria:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-3">
                            <asp:TextBox ID="txtIDCategoria" runat="server" Enabled="false" CssClass="form-control" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblNombreCategoria" runat="server" Text="Nombre de la Categoria:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtNombreCategoria" runat="server" Enabled="false" CssClass="form-control" />
                        </div>
                        <asp:Button ID="btnBuscarCategoria" CssClass="btn btn-primary col-sm-2" runat="server" Text="Buscar Categoria" OnClick="btnBuscarCategoria_Click" />
                    </div>
                </div>
            </div>
            <div>
                <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary me-2" Text="  Guardar  " OnClick="btnGuardar_Click" />
                <asp:Button ID="btnRegresar" runat="server" CssClass="float-end btn btn-secondary me-2" Text=" Regresar " OnClick="btnRegresar_Click" />
            </div>
        </div>

    <!-- Modal -->
    <asp:ScriptManager runat="server"></asp:ScriptManager>
    <!-- Seleccion Autor -->
    <div class="modal" id="form-modal-autor">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Autor</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalAutor_txtNombreAutor" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalAutor_lbBuscarAutor" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalAutor_lbBuscarAutor_Click" />
                                    </div>
                                </div>
                            </div>
                            <div class="container row">
                                <asp:GridView ID="ModalAutor_gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns ="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalAutor_gvClientes_PageIndexChanging">
                                    <Columns>
                                        <asp:BoundField HeaderText="Id" DataField="IdAutor" />
                                        <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                        <asp:TemplateField>
                                            <ItemTemplate>
                                                <asp:LinkButton ID="ModalAutor_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalAutor_lbSeleccionar_Click" CommandArgument='<%# Eval("IdAutor") %>' />
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                    </Columns>
                                </asp:GridView>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <!-- Seleccion Categoria -->
    <div class="modal" id="form-modal-categoria">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Categoría</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="TextBox2" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalCategoria_lbBuscarCategoria" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalCategoria_lbBuscarCategoria_Click"/>
                                    </div>
                                </div>
                            </div>
                            <div class="container row">
                            <asp:GridView ID="ModalCategoria_gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns ="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalCategoria_gvClientes_PageIndexChanging">
                                <Columns>
                                    <asp:BoundField HeaderText="Id" DataField="IdCategoria" />
                                    <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                    <asp:TemplateField>
                                        <ItemTemplate>
                                            <asp:LinkButton ID="ModalCategoria_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalCategoria_lbSeleccionar_Click" CommandArgument='<%# Eval("IdCategoria") %>' />
                                        </ItemTemplate>
                                    </asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
