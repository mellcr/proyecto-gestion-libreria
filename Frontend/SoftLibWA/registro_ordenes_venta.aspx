<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="registro_ordenes_venta.aspx.cs" Inherits="SoftLibWA.registro_ordenes_venta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Registro - Órdenes de Venta
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SoftLib/gestionarOrdenesVenta.js"></script>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Registro de Orden de Venta</h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblIdCliente" runat="server" Text="Id del Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtIdCliente" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                    <asp:Button ID="btnBuscarCliente" CssClass="btn btn-primary col-sm-2" runat="server" Text="Buscar Cliente" OnClick="btnBuscarCliente_Click" />
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblNombreCliente" runat="server" Text="Nombre del Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5">
                        <asp:TextBox ID="txtNombreCliente" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
            </div>
        </div>

        <div class="card mt-3">
            <div class="card-header bg-light">
                <h5 class="card-title mb-0">Detalle de la Orden de Venta</h5>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblIdRecurso" runat="server" Text="Id del Producto:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtIdRecurso" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                    <asp:Button ID="btnBuscarProducto" CssClass="btn btn-primary col-sm-2" runat="server" Text="Buscar Producto" OnClick="btnBuscarProducto_Click" />
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblNombreRecurso" runat="server" Text="Título:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5">
                        <asp:TextBox ID="txtNombreRecurso" runat="server" Enabled="false" CssClass="form-control" />
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
                        <asp:LinkButton ID="lbAgregarLOV" runat="server" CssClass="btn btn-success" Text="<i class='fa-solid fa-plus pe-2'></i> Agregar" OnClick="lbAgregarLOV_Click"/>
                    </div>
                </div>
                <div class="row">
                    <asp:GridView ID="gvProductos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                        <Columns>
                            <asp:BoundField HeaderText="Id Producto" DataField="Recurso.IdRecurso" />
                            <asp:BoundField HeaderText="Nombre" DataField="Recurso.Nombre" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:LinkButton ID="lbEliminarProducto" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("Recurso.idRecurso") %>' OnClick="lbEliminarProducto_Click" />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
                <div class="row align-items-center justify-content-end">
                    <asp:Label ID="lblTotal" runat="server" Text="TOTAL:" CssClass="col-form-label col-sm-2 text-end"></asp:Label>
                    <div class="col-sm-2">
                        <asp:TextBox ID="txtTotal" runat="server" Enabled="false" CssClass="form-control col-sm-2"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click" />
            </div>
        </div>

        <asp:ScriptManager runat="server"></asp:ScriptManager>

        <!-- Modal para buscar cliente -->
        <div class="modal" id="form-modal-cliente">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Búsqueda de Clientes</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <asp:UpdatePanel runat="server">
                            <ContentTemplate>
                                <div class="container row pb-3 pt-3">
                                    <div class="row align-items-center">
                                        <div class="col-auto">
                                            <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:" />
                                        </div>
                                        <div class="col-sm-3">
                                            <asp:TextBox CssClass="form-control" ID="ModalCliente_txtNombreCliente" runat="server" />
                                        </div>
                                        <div class="col-sm-2">
                                            <asp:LinkButton ID="ModalCliente_lbBuscarCliente" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalCliente_lbBuscarCliente_Click" />
                                        </div>
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="ModalOrdenVenta_gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalOrdenVenta_gvClientes_PageIndexChanging">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="IdPersona" />
                                            <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalOrdenVenta_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalOrdenVenta_lbSeleccionar_Click" CommandArgument='<%# Eval("idPersona") %>' />
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
                                            <asp:Label CssClass="form-label" runat="server" Text="Tipo de Producto:"></asp:Label>
                                        </div>
                                        <div class="col-sm-6">
                                            <asp:DropDownList ID="ddlTipoProducto" runat="server" CssClass="form-select form-select-sm" AutoPostBack="true" OnSelectedIndexChanged="ddlTipoProducto_SelectedIndexChanged">
                                                <asp:ListItem Text="Selecciona un tipo" Value="" />
                                                <asp:ListItem Text="Libros" Value="Libros" />
                                                <asp:ListItem Text="Otros Recursos" Value="OtrosRecursos" />
                                            </asp:DropDownList>
                                        </div>
                                    </div>
                                    <div class="row align-items-center mb-4">
                                        <div class="col-auto">
                                            <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
                                        </div>
                                        <div class="col-sm-4">
                                            <asp:TextBox CssClass="form-control" ID="ModalProducto_txtNombreProducto" runat="server"></asp:TextBox>
                                        </div>
                                        <div class="col-auto">
                                            <asp:LinkButton ID="ModalProducto_lbBuscarProducto" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalProducto_lbBuscarProducto_Click" />
                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <asp:GridView ID="ModalOrdenVenta_gvProductos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalOrdenVenta_gvProductos_PageIndexChanging">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="IdRecurso" />
                                            <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                            <asp:BoundField HeaderText="Precio" DataField="Precio" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalOrdenVenta_lbSeleccionarProducto" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalOrdenVenta_lbSeleccionarProducto_Click" CommandArgument='<%# Eval("idRecurso") %>' />
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
