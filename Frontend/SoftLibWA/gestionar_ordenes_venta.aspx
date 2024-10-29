<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="gestionar_ordenes_venta.aspx.cs" Inherits="SoftLibWA.gestionar_ordenes_venta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión - Órdenes de Venta
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
  <div class="container">
        <div class="row">
            <h1>Listado de Órdenes de Venta</h1>
        </div>

        <!-- Filtros -->
        <div class="search-container mb-3">
            <div class="search-row d-flex justify-content-between">
                <!-- Filtro por Cliente -->
                <div class="search-item col-sm-5">
                    <label class="col-form-label">Buscar por Cliente</label>
                    <asp:TextBox ID="TxtBuscarCliente" runat="server" AutoPostBack="true" CssClass="form-control" placeholder="Nombre del Cliente" OnTextChanged="TxtBuscarCliente_TextChanged"></asp:TextBox>
                </div>
                <!-- Filtro por Producto -->
                <div class="search-item col-sm-5">
                    <label class="col-form-label">Buscar por Producto</label>
                    <asp:TextBox ID="TxtBuscarProducto" runat="server" AutoPostBack="true" CssClass="form-control" placeholder="Nombre del Producto" OnTextChanged="TxtBuscarProducto_TextChanged"></asp:TextBox>
                </div>
            </div>

            <div class="search-row mt-2 text-end">
                <!-- Botón Limpiar Filtros -->
                <asp:LinkButton ID="BtnLimpiar" runat="server" OnClick="BtnLimpiar_Click" CssClass="btn btn-danger">
                    <i class="fas fa-times-circle"></i> Limpiar Filtros
                </asp:LinkButton>
            </div>
        </div>

        <!-- Rectángulo para listado de órdenes -->
        <div class="order-list-box mt-3">
            <div class="container row">
                <asp:GridView ID="GridVentas" runat="server" AutoGenerateColumns="false"
                    AllowPaging="true" PageSize="5" OnPageIndexChanging="GridVentas_PageIndexChanging"
                    CssClass="table table-hover table-responsive table-striped">
                    <Columns>
                        <asp:TemplateField HeaderText="Id">
                            <ItemTemplate>
                                <asp:LinkButton ID="BtnIdOrden" runat="server" 
                                    Text='<%# Eval("idOrdenVenta") %>' 
                                    CssClass="btn btn-link" 
                                    CommandArgument='<%# Eval("idOrdenVenta") %>' 
                                    OnClick="BtnIdOrden_Click" />
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField DataField="fechaCreacion" HeaderText="Fecha" DataFormatString="{0:dd/MM/yyyy}" />
                        <asp:BoundField DataField="cliente" HeaderText="Cliente" />
                        <asp:BoundField DataField="producto" HeaderText="Producto" />
                        <asp:BoundField DataField="total" HeaderText="Total" DataFormatString="{0:C}" HtmlEncode="false" />
                        <asp:TemplateField HeaderText="Acciones">
                            <ItemTemplate>
                                <asp:LinkButton ID="BtnModificar" runat="server" Text="Modificar" CssClass="btn btn-warning" CommandArgument='<%# Eval("idOrdenVenta") %>' OnClick="BtnModificar_Click" />
                                <asp:LinkButton ID="BtnEliminar" runat="server" Text="Eliminar" CssClass="btn btn-danger" CommandArgument='<%# Eval("idOrdenVenta") %>' OnClick="BtnEliminar_Click" OnClientClick="return confirm('¿Está seguro de eliminar este registro?');" />
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </div>
        </div>
</asp:Content>
