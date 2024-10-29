<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="registro_ordenes_abastecimiento.aspx.cs" Inherits="SoftLibWA.registro_ordenes_abastecimiento" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Registro - Órdenes de Abastecimiento
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SoftLib/gestionarOrdenesAbastecimiento.js"></script>
    <script>
        function abrirModal() {
            var modal = new bootstrap.Modal(document.getElementById('form-modal-producto'));
            modal.show();
        }
    </script>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Registro de Orden de Abastecimiento</h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblNombreRecurso" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5">
                        <asp:TextBox ID="txtNombreRecurso" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                    <div class="col-sm-3">
                        <asp:Button ID="btnBuscarProducto" CssClass="btn btn-primary" runat="server" Text="Buscar Producto" OnClientClick="abrirModal(); return false;" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblPrecioRecurso" runat="server" Text="Precio:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5">
                        <asp:TextBox ID="txtPrecioRecurso" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblCantidadUnidades" runat="server" Text="Cantidad:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtCantidadUnidades" runat="server" CssClass="form-control" />
                    </div>
                    <div class="col-sm-3">
                        <asp:LinkButton ID="lbAgregarLOA" runat="server" CssClass="btn btn-success" Text="<i class='fa-solid fa-plus pe-2'></i> Agregar" OnClick="lbAgregarLOA_Click" />
                    </div>
                </div>

                <!-- Nuevo campo de descripción -->
                <div class="mb-3 row">
                    <asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5">
                        <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" TextMode="MultiLine" Rows="4" />
                    </div>
                </div>

                <div class="row">
                    <asp:GridView ID="gvProductos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                        <Columns>
                            <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                            <asp:BoundField HeaderText="Precio" DataField="Precio" />
                            <asp:BoundField HeaderText="Cantidad" DataField="Cantidad" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:LinkButton ID="lbEliminarProducto" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbEliminarProducto_Click" />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click" />
            </div>
        </div>

        <asp:ScriptManager runat="server"></asp:ScriptManager>

        <!-- Modal para buscar productos -->
        <div class="modal" id="form-modal-producto">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Búsqueda de Productos</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <asp:UpdatePanel runat="server">
                            <ContentTemplate>
                                <div class="container pb-3 pt-3">
                                    <div class="row align-items-center mb-3">
                                        <div class="col-auto">
                                            <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:" />
                                        </div>
                                        <div class="col-sm-3">
                                            <asp:TextBox CssClass="form-control" ID="ModalProducto_txtNombreProducto" runat="server" />
                                        </div>
                                        <div class="col-auto">
                                            <asp:DropDownList ID="ModalProducto_ddTipoRecurso" runat="server" CssClass="form-control">
                                                <asp:ListItem Text="Libro" Value="1" />
                                                <asp:ListItem Text="Otro Recurso" Value="2" />
                                            </asp:DropDownList>
                                        </div>
                                        <div class="col-auto">
                                            <asp:LinkButton ID="ModalProducto_lbBuscarProducto" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalProducto_lbBuscarProducto_Click" />
                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <asp:GridView ID="ModalOrdenAbastecimiento_gvProductos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalOrdenAbastecimiento_gvProductos_PageIndexChanging">
                                        <Columns>
                                            <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                            <asp:BoundField HeaderText="Precio" DataField="Precio" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalOrdenAbastecimiento_lbSeleccionarProducto" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalOrdenAbastecimiento_lbSeleccionarProducto_Click" CommandArgument='<%# Eval("IdRecurso") %>' />
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
    </div>
</asp:Content>
