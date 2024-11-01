﻿using SoftLibBO.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftLibBO
{
    public class BaseBO
    {
        private ServicioWeb.ServicioWSClient wsCliente;
        private ServicioWeb.ServicioWSClient wsRecurso;
        private ServicioWeb.ServicioWSClient wsLibro;
        private ServicioWeb.ServicioWSClient wsOtroRecurso;
        private ServicioWeb.ServicioWSClient wsOrdenVenta;
        private ServicioWeb.ServicioWSClient wsOrden;
        private ServicioWeb.ServicioWSClient wsOrdenAbastecimiento;

        public BaseBO()
        {
            this.WsCliente = new ServicioWeb.ServicioWSClient();
            this.WsRecurso = new ServicioWeb.ServicioWSClient();
            this.WsLibro  = new ServicioWeb.ServicioWSClient();
            this.WsOtroRecurso = new ServicioWeb.ServicioWSClient();
            this.WsOrdenVenta = new ServicioWeb.ServicioWSClient();
            this.WsOrden = new ServicioWeb.ServicioWSClient();
            this.WsOrdenAbastecimiento = new ServicioWeb.ServicioWSClient();
        }

        public ServicioWSClient WsCliente { get => wsCliente; set => wsCliente = value; }
        public ServicioWSClient WsRecurso { get => wsRecurso; set => wsRecurso = value; }
        public ServicioWSClient WsLibro { get => wsLibro; set => wsLibro = value; }
        public ServicioWSClient WsOtroRecurso { get => wsOtroRecurso; set => wsOtroRecurso = value; }
        public ServicioWSClient WsOrdenVenta { get => wsOrdenVenta; set => wsOrdenVenta = value; }
        public ServicioWSClient WsOrden { get => wsOrden; set => wsOrden = value; }
        public ServicioWSClient WsOrdenAbastecimiento { get => wsOrdenAbastecimiento; set => wsOrdenAbastecimiento = value; }
    }
}
