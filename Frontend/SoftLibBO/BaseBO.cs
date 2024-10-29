using SoftLibBO.ServicioWeb;
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
        private ServicioWeb.ServicioWSClient wsAutor;

        public BaseBO()
        {
            this.WsCliente = new ServicioWeb.ServicioWSClient();
            this.WsRecurso = new ServicioWeb.ServicioWSClient();
            this.WsLibro  = new ServicioWeb.ServicioWSClient();
            this.WsOtroRecurso = new ServicioWeb.ServicioWSClient();
            this.WsAutor = new ServicioWeb.ServicioWSClient();
        }

        public ServicioWSClient WsCliente { get => wsCliente; set => wsCliente = value; }
        public ServicioWSClient WsRecurso { get => wsRecurso; set => wsRecurso = value; }
        public ServicioWSClient WsLibro { get => wsLibro; set => wsLibro = value; }
        public ServicioWSClient WsOtroRecurso { get => wsOtroRecurso; set => wsOtroRecurso = value; }
        public ServicioWSClient WsAutor { get => wsAutor; set => wsAutor = value; }
    }
}
