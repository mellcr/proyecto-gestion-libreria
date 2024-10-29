<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="mantenimiento_recurso.aspx.cs" Inherits="SoftLibWA.mantenimiento_recurso" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento - Producto
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Recurso</h2>
        <div class="container row">
            <asp:GridView ID="dgvRecurso" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="dgvRecurso_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id de la Sección" DataField="IdSeccion"/>
                    <asp:BoundField HeaderText="Nombre de la Sección" DataField="Nombre_Seccion"/>
                    <asp:BoundField HeaderText="Departamento" DataField="Departamento"/>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>"  CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbModificar_Click" />
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbEliminar_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="container row">
            <div class="text-end">
                <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertar_Click" />
            </div>
        </div>
    </div>
</asp:Content>
