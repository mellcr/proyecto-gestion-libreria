<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="mantenimiento_recurso.aspx.cs" Inherits="SoftLibWA.mantenimiento_recurso" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento - Recurso
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Recurso</h2>
        
        <!-- Contenedor de pestañas -->
        <ul class="nav nav-tabs mt-3" id="recursoTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="libros-tab" data-bs-toggle="tab" data-bs-target="#libros" type="button" role="tab" aria-controls="libros" aria-selected="true">Libros</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="otros-recursos-tab" data-bs-toggle="tab" data-bs-target="#otros-recursos" type="button" role="tab" aria-controls="otros-recursos" aria-selected="false">Otros Recursos</button>
            </li>
        </ul>
        
        <!-- Contenido de la pestaña Libros -->
        <div class="tab-pane fade show active" id="libros" role="tabpanel" aria-labelledby="libros-tab">
            <div class="container mt-3">
                <asp:GridView ID="dgvRecursoLibros" runat="server" AllowPaging="true" PageSize="5" 
                    OnPageIndexChanging="dgvRecursoLibros_PageIndexChanging" AutoGenerateColumns="false" 
                    CssClass="table table-hover table-responsive table-striped">
                    <Columns>
                        <asp:BoundField HeaderText="Id del Libro" DataField="IdRecurso" />
                        <asp:BoundField HeaderText="Título" DataField="Nombre" />
                        <asp:BoundField HeaderText="Precio" DataField="Precio" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-primary me-1" 
                                    Text="Editar" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbModificarLibro_Click">
                                    <i class="fas fa-eye"></i> <!-- Ícono de ojo -->
                                </asp:LinkButton>
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-danger" 
                                    Text="Eliminar" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbEliminarLibro_Click">
                                    <i class="fas fa-trash-alt"></i> <!-- Ícono de tachito -->
                                </asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                    <EmptyDataTemplate>
                        <div class="alert alert-warning" role="alert">
                            No hay registros disponibles en este momento.
                        </div>
                    </EmptyDataTemplate>
                </asp:GridView>

                <!-- Botón Insertar para la pestaña Libros -->
                <div class="mt-3">
                    <asp:Button ID="btnInsertarLibros" CssClass="btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertarLibros_Click" />
                </div>
            </div>
        </div>



        <!-- Contenido de la pestaña Otros Recursos -->
        <div class="tab-pane fade" id="otros-recursos" role="tabpanel" aria-labelledby="otros-recursos-tab">
                <asp:GridView ID="dgvRecursoOtros" runat="server" AllowPaging="true" PageSize="5" 
                    OnPageIndexChanging="dgvRecurso_PageIndexChanging" AutoGenerateColumns="false" 
                    CssClass="table table-hover table-responsive table-striped">
                    <Columns>
                        <asp:BoundField HeaderText="Id del Recurso" DataField="IdRecurso"/>
                        <asp:BoundField HeaderText="Nombre" DataField="Nombre"/>
                        <asp:BoundField HeaderText="Precio" DataField="Precio"/>
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-primary me-1" 
                                    Text="Editar" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbModificarOtroRecurso_Click">
                                    <i class="fas fa-eye"></i> <!-- Ícono de ojo -->
                                </asp:LinkButton>
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-danger" 
                                    Text="Eliminar" CommandArgument='<%# Eval("IdRecurso") %>' OnClick="lbEliminarOtroRecurso_Click">
                                    <i class="fas fa-trash-alt"></i> <!-- Ícono de tachito -->
                                </asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                    <EmptyDataTemplate>
                        <div class="alert alert-warning text-center" role="alert">
                            No hay registros disponibles en este momento.
                        </div>
                    </EmptyDataTemplate>
                </asp:GridView>
                <!-- Botón Insertar para la pestaña Otros Recursos -->
                <div class="mt-3">
                    <asp:Button ID="btnInsertarOtrosRecursos" CssClass="btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertarOtrosRecursos_Click" />
                </div>
        </div>

    </div>
</asp:Content>

