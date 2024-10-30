<%@ Page Title="" Language="C#" MasterPageFile="~/SoftLibEmpleado.Master" AutoEventWireup="true" CodeBehind="gestionar_otrosrecursos.aspx.cs" Inherits="SoftLibWA.gestionar_otrosrecursos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión - Otros Recursos
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
                                <asp:Label ID="lblAlto" runat="server" Text="Alto (cm):" CssClass="col-form-label" />
                                <asp:TextBox ID="txtAlto" CssClass="form-control" runat="server"></asp:TextBox>
                            </div>

                            <div class="col-md-6">
                                <asp:Label ID="lblAncho" runat="server" Text="Ancho (cm):" CssClass="col-form-label" />
                                <asp:TextBox ID="txtAncho" CssClass="form-control" runat="server"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    </div>
                    <!-- Caracteristica de Otro Recurso -->
                    <div class="row mb-3">
                        <div class="col-md-11">
                            <asp:Label ID="lblCaracteristica" runat="server" Text="Caracteristicas:" CssClass="col-form-label ms-3" />
                            <textarea id="txtDescripcion" class="form-control ms-3" rows="3" cols="20" runat="server"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary me-2" Text="  Guardar  " OnClick="btnGuardar_Click" />
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-end btn btn-secondary me-2" Text=" Regresar " OnClick="btnRegresar_Click" />
        </div>
     </div>
</asp:Content>
