

DROP TABLE IF EXISTS LineaDeOrden;
DROP TABLE IF EXISTS Comprobante;
DROP TABLE IF EXISTS OrdenAbastecimiento;
DROP TABLE IF EXISTS OrdenVenta;
DROP TABLE IF EXISTS Orden;
DROP TABLE IF EXISTS LineaDeCarritoDeCompras;
DROP TABLE IF EXISTS CarritoDeCompras;
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS StockRecurso;
DROP TABLE IF EXISTS Sede;
DROP TABLE IF EXISTS Local;
DROP TABLE IF EXISTS CampañaRecurso;
DROP TABLE IF EXISTS Campaña;
DROP TABLE IF EXISTS LibroCategoria;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS OtroRecurso;
DROP TABLE IF EXISTS Recurso;

CREATE TABLE Persona (
    idPersona INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidoPaterno VARCHAR(255),
    apellidoMaterno VARCHAR(255),
    nacionalidad VARCHAR(100),
    numeroDocumento VARCHAR(50),
    tipoDocumento ENUM('DNI', 'PASAPORTE') NOT NULL,
    PRIMARY KEY (idPersona)
) ENGINE=InnoDB;

CREATE TABLE Cliente (
    idCliente INT NOT NULL AUTO_INCREMENT,
    idPersona INT,
    direccion VARCHAR(255),
    PRIMARY KEY (idCliente),
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Empleado (
    idEmpleado INT NOT NULL AUTO_INCREMENT,
    idPersona INT,
    sueldo DECIMAL(10,2) NOT NULL,
    empleadoActivo BOOLEAN NOT NULL,
	rol ENUM('ADMINISTRADOR, COORDINADOR, VENDEDOR'),
    PRIMARY KEY (idEmpleado),
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE Recurso (
    idRecurso INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    peso DECIMAL(10,2),
    alto DECIMAL(10,2),
    ancho DECIMAL(10,2),
    precio DECIMAL(10,2) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (idRecurso)
) ENGINE=InnoDB;


CREATE TABLE Libro (
    idLibro INT NOT NULL AUTO_INCREMENT,
    idRecurso INT NOT NULL,
	categorias VARCHAR(255),
    autor VARCHAR(255),
    editorial VARCHAR(255),
    ISBN VARCHAR(50),
    sinopsis VARCHAR(1000),
	formato ENUM('BOLSILLO', 'RUSTICA', 'TAPADURA', 'ESTUCHE', 'EBOOK') NOT NULL,
    PRIMARY KEY (idLibro),
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE OtroRecurso (
    idOtroRecurso INT NOT NULL AUTO_INCREMENT,
    idRecurso INT NOT NULL,  -- Relación con la tabla Recurso
    caracteristica VARCHAR(255),
    PRIMARY KEY (idOtroRecurso),
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Categoria (
    idCategoria INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    PRIMARY KEY (idCategoria)
) ENGINE=InnoDB;

CREATE TABLE LibroCategoria (
    idLibro INT NOT NULL,   -- Clave foránea que referencia a la tabla Libro
    idCategoria INT NOT NULL,   -- Clave foránea que referencia a la tabla Categoria
    PRIMARY KEY (idLibro, idCategoria),  -- Clave primaria compuesta por ambas claves foráneas
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro) ON DELETE CASCADE,   -- Relación con Libro
    FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria) ON DELETE CASCADE  -- Relación con Categoria
) ENGINE=InnoDB;

CREATE TABLE Campanha (
    idCampanha INT NOT NULL AUTO_INCREMENT,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    descripcion VARCHAR(255),
    estado ENUM('PENDIENTE', 'ACTIVA', 'INACTIVA') NOT NULL,
    porcentajeDescuento DECIMAL(10,2),
    PRIMARY KEY (idCampanha)
) ENGINE=InnoDB;

CREATE TABLE CampanhaRecurso (
    idCampanha INT NOT NULL,   -- Clave foránea que referencia a la tabla Campanha
    idRecurso INT NOT NULL,    -- Clave foránea que referencia a la tabla Recurso
    PRIMARY KEY (idCampanha, idRecurso),  -- Clave primaria compuesta por ambas claves foráneas
    FOREIGN KEY (idCampanha) REFERENCES Campanha(idCampanha) ON DELETE CASCADE,   -- Relación con Campanha
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE       -- Relación con Recurso
) ENGINE=InnoDB;

CREATE TABLE Local (
    idLocal INT NOT NULL AUTO_INCREMENT,
    direccion VARCHAR(255),
    PRIMARY KEY (idLocal)
) ENGINE=InnoDB;

CREATE TABLE Sede (
    idSede INT NOT NULL AUTO_INCREMENT,
    idLocal INT NOT NULL,
    PRIMARY KEY (idSede),
    FOREIGN KEY (idLocal) REFERENCES Local(idLocal) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE StockRecurso (
    idStockRecurso INT NOT NULL AUTO_INCREMENT,
    stock INT NOT NULL,
    idRecurso INT NOT NULL,
	idLocal INT NOT NULL,
    PRIMARY KEY (idStockRecurso),
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE,
	FOREIGN KEY (idLocal) REFERENCES Local(idLocal) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE CarritoDeCompras (
    idCarrito INT NOT NULL AUTO_INCREMENT,
    fechaCreacion DATE NOT NULL,
    subTotal DECIMAL(10,2) NOT NULL,
    estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO') NOT NULL,
    idCliente INT,
    PRIMARY KEY (idCarrito),
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE LineaDeCarritoDeCompras (
    idLineaCarrito INT NOT NULL AUTO_INCREMENT,
    cantidad INT NOT NULL,
	precioUnitario DECIMAL(10,2) NOT NULL,
    subTotal DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL,
    idCarrito INT,
    idRecurso INT,
    PRIMARY KEY (idLineaCarrito),
    FOREIGN KEY (idCarrito) REFERENCES CarritoDeCompras(idCarrito) ON DELETE CASCADE,
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE Orden (
    idOrden INT NOT NULL AUTO_INCREMENT,
    estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO') NOT NULL,
    fechaCreacion DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    idEmpleado INT NOT NULL,  -- Clave foránea a Empleado, indicando quién gestiona la orden
    PRIMARY KEY (idOrden),
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado) ON DELETE CASCADE  -- Relación con Empleado
) ENGINE=InnoDB;


CREATE TABLE OrdenVenta (
    idOrdenVenta INT NOT NULL AUTO_INCREMENT,
    idOrden INT NOT NULL,  -- Clave foránea que referencia a Orden
    idCliente INT NOT NULL,  -- Clave foránea que referencia a Cliente
    tipoVenta ENUM('PRESENCIAL', 'VIRTUAL') NOT NULL,
    fechaEntrega DATE NOT NULL,
    metodoPago ENUM('EFECTIVO', 'TARJETA') NOT NULL,
    PRIMARY KEY (idOrdenVenta),
    FOREIGN KEY (idOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE,  -- Relación con Orden
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE OrdenAbastecimiento (
    idOrdenAbastecimiento INT NOT NULL AUTO_INCREMENT,
    idOrden INT NOT NULL,  -- Clave foránea que referencia a Orden
    fechaRecepcion DATE NOT NULL,
    PRIMARY KEY (idOrdenAbastecimiento),
    FOREIGN KEY (idOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE  -- Relación con Orden
) ENGINE=InnoDB;

CREATE TABLE LineaDeOrden (
    idLineaDeOrden INT NOT NULL AUTO_INCREMENT,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) DEFAULT 0,
    precioUnitario DECIMAL(10,2) NOT NULL,
    subtotalBruto DECIMAL(10,2) NOT NULL,
    subtotalNeto DECIMAL(10,2) NOT NULL,
    idOrden INT NOT NULL,  -- Relación con la tabla Orden
    idRecurso INT NOT NULL,  -- Relación con la tabla Recurso (producto)
    PRIMARY KEY (idLineaDeOrden),
    FOREIGN KEY (idOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE,  -- Relación con Orden
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE  -- Relación con Recurso (producto)
) ENGINE=InnoDB;

CREATE TABLE Comprobante (
    idComprobante INT NOT NULL AUTO_INCREMENT,
    fechaEmision DATE NOT NULL,
    tipoComprobante ENUM('FACTURA', 'BOLETA') NOT NULL,
    idOrden INT NOT NULL,  -- Relación con la tabla Orden
    PRIMARY KEY (idComprobante),
    FOREIGN KEY (idOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE  -- Relación con Orden
) ENGINE=InnoDB;

