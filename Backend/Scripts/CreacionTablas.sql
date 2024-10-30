DROP TABLE IF EXISTS LineaDeOrden;
DROP TABLE IF EXISTS Comprobante;
DROP TABLE IF EXISTS OrdenAbastecimiento;
DROP TABLE IF EXISTS OrdenVenta;
DROP TABLE IF EXISTS Orden;
DROP TABLE IF EXISTS LineaDeCarritoDeCompras;
DROP TABLE IF EXISTS CarritoDeCompras;
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS StockRecurso;
DROP TABLE IF EXISTS Sede;
DROP TABLE IF EXISTS Almacen;
DROP TABLE IF EXISTS Local;
DROP TABLE IF EXISTS CampanhaRecurso;
DROP TABLE IF EXISTS Campanha;
DROP TABLE IF EXISTS LibroCategoria;
DROP TABLE IF EXISTS LibroAutor;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS Autor;
DROP TABLE IF EXISTS OtroRecurso;
DROP TABLE IF EXISTS Recurso;
DROP TABLE IF EXISTS OrdenAbastecimiento;
DROP TABLE IF EXISTS OrdenVenta;
DROP TABLE IF EXISTS Orden;
DROP TABLE IF EXISTS Empleado;

CREATE TABLE Persona (
    idPersona INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidoPaterno VARCHAR(255),
    apellidoMaterno VARCHAR(255),
    nacionalidad VARCHAR(100),
    numeroDocumento VARCHAR(50),
    tipoDocumento ENUM('DNI', 'PASAPORTE'),
    PRIMARY KEY (idPersona)
) ENGINE=InnoDB;

CREATE TABLE Cliente (
    idCliente INT,
    direccion VARCHAR(255),
    PRIMARY KEY (idCliente),
    FOREIGN KEY (idCliente) REFERENCES Persona(idPersona) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Empleado (
    idEmpleado INT,
    sueldo DECIMAL(10,2),
    empleadoActivo TINYINT,
	rol ENUM('ADMINISTRADOR', 'COORDINADOR', 'VENDEDOR'),
    PRIMARY KEY (idEmpleado),
    FOREIGN KEY (idEmpleado) REFERENCES Persona(idPersona) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Cuenta (
    idCuenta INT AUTO_INCREMENT,
	usuario VARCHAR(255),
	contraseña VARCHAR(255),
	activo TINYINT, 
    direccion VARCHAR(255),
	fidPersona INT,
    PRIMARY KEY (idCuenta),
    FOREIGN KEY (fidPersona) REFERENCES Persona(idPersona) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Recurso (
    idRecurso INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    peso DECIMAL(10,2),
    alto DECIMAL(10,2),
    ancho DECIMAL(10,2),
    precio DECIMAL(10,2),
    disponible TINYINT,
    PRIMARY KEY (idRecurso)
) ENGINE=InnoDB;


CREATE TABLE Libro (
    idLibro INT,
	categorias VARCHAR(255),
    autor VARCHAR(255),
    editorial VARCHAR(255),
    ISBN VARCHAR(50),
    sinopsis VARCHAR(1000),
	formato ENUM('BOLSILLO', 'RUSTICA', 'TAPADURA', 'ESTUCHE', 'EBOOK'),
    PRIMARY KEY (idLibro),
    FOREIGN KEY (idLibro) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Autor (
    idAutor INT AUTO_INCREMENT,
	nombre VARCHAR(255),
    nacionalidad VARCHAR(255),
    PRIMARY KEY (idAutor)
) ENGINE=InnoDB;

CREATE TABLE OtroRecurso (
    idOtroRecurso INT,
    caracteristica VARCHAR(255),
    PRIMARY KEY (idOtroRecurso),
    FOREIGN KEY (idOtroRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Categoria (
    idCategoria INT AUTO_INCREMENT,
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

CREATE TABLE LibroAutor (
    idLibro INT NOT NULL,   -- Clave foránea que referencia a la tabla Libro
    idAutor INT NOT NULL,   -- Clave foránea que referencia a la tabla Autor
    PRIMARY KEY (idLibro, idAutor),  -- Clave primaria compuesta por ambas claves foráneas
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro) ON DELETE CASCADE,   -- Relación con Libro
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor) ON DELETE CASCADE  -- Relación con Categoria
) ENGINE=InnoDB;

CREATE TABLE Campanha (
    idCampanha INT AUTO_INCREMENT,
    fechaInicio DATE,
    fechaFin DATE,
    descripcion VARCHAR(255),
    estado ENUM('PENDIENTE', 'ACTIVA', 'INACTIVA'),
    porcentajeDescuento DECIMAL(10,2),
    PRIMARY KEY (idCampanha)
) ENGINE=InnoDB;

CREATE TABLE CampanhaRecurso (
    idCampanha INT NOT NULL,   -- Clave foránea que referencia a la tabla Campaña
    idRecurso INT NOT NULL,   -- Clave foránea que referencia a la tabla Recurso
    PRIMARY KEY (idCampanha, idRecurso),  -- Clave primaria compuesta por ambas claves foráneas
    FOREIGN KEY (idCampanha) REFERENCES Campanha(idCampanha) ON DELETE CASCADE,   -- Relación con Campaña
    FOREIGN KEY (idRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE    -- Relación con Recurso
) ENGINE=InnoDB;

CREATE TABLE Local (
    idLocal INT AUTO_INCREMENT,
    direccion VARCHAR(255),
    PRIMARY KEY (idLocal)
) ENGINE=InnoDB;

CREATE TABLE Sede (
    idSede INT,
    PRIMARY KEY (idSede),
    FOREIGN KEY (idSede) REFERENCES Local(idLocal) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE Almacen (
    idAlmacen INT,
    PRIMARY KEY (idAlmacen),
    FOREIGN KEY (idAlmacen) REFERENCES Local(idLocal) ON DELETE CASCADE
) ENGINE=InnoDB;



CREATE TABLE StockRecurso (
    idStockRecurso INT AUTO_INCREMENT,
    stock INT,
    fidRecurso INT,
	fidLocal INT,
    PRIMARY KEY (idStockRecurso),
    FOREIGN KEY (fidRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE,
	FOREIGN KEY (fidLocal) REFERENCES Local(idLocal) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE CarritoDeCompras (
    idCarrito INT AUTO_INCREMENT,
    fechaCreacion DATE,
    subTotal DECIMAL(10,2),
    estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO'),
    idCliente INT,
    PRIMARY KEY (idCarrito),
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE,
	UNIQUE (idCliente)
) ENGINE=InnoDB;

CREATE TABLE LineaDeCarritoDeCompras (
    idLineaCarrito INT AUTO_INCREMENT,
    cantidad INT,
	precioUnitario DECIMAL(10,2),
    subTotal DECIMAL(10,2),
    descuento DECIMAL(10,2),
    fidCarrito INT,
    fidRecurso INT,
    PRIMARY KEY (idLineaCarrito),
    FOREIGN KEY (fidCarrito) REFERENCES CarritoDeCompras(idCarrito) ON DELETE CASCADE,
    FOREIGN KEY (fidRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE Orden (
    idOrden INT AUTO_INCREMENT,
    estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO') NOT NULL,
    fechaCreacion DATE,
    total DECIMAL(10,2),
    fidEmpleado INT,  -- Clave foránea a Empleado, indicando quién gestiona la orden
    PRIMARY KEY (idOrden),
    FOREIGN KEY (fidEmpleado) REFERENCES Empleado(idEmpleado) ON DELETE CASCADE  -- Relación con Empleado
) ENGINE=InnoDB;


CREATE TABLE OrdenVenta (
    idOrdenVenta INT AUTO_INCREMENT,
	idCliente INT,  -- Clave foránea que referencia a Cliente
    tipoVenta ENUM('PRESENCIAL', 'VIRTUAL'),
    fechaEntrega DATE,
    metodoPago ENUM('EFECTIVO', 'TARJETA'),
    PRIMARY KEY (idOrdenVenta),
    FOREIGN KEY (idOrdenVenta) REFERENCES Orden(idOrden) ON DELETE CASCADE,  -- Relación con Orden
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE OrdenAbastecimiento (
    idOrdenAbastecimiento INT,
    fechaRecepcion DATE,
    PRIMARY KEY (idOrdenAbastecimiento),
    FOREIGN KEY (idOrdenAbastecimiento) REFERENCES Orden(idOrden) ON DELETE CASCADE  -- Relación con Orden
) ENGINE=InnoDB;

CREATE TABLE LineaDeOrden (
    idLineaDeOrden INT AUTO_INCREMENT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    descuento DECIMAL(10,2),
    precioUnitario DECIMAL(10,2),
    subtotalBruto DECIMAL(10,2),
    subtotalNeto DECIMAL(10,2),
    fidOrden INT NOT NULL,  -- Relación con la tabla Orden
    fidRecurso INT NOT NULL,  -- Relación con la tabla Recurso (producto)
    PRIMARY KEY (idLineaDeOrden),
    FOREIGN KEY (fidOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE,  -- Relación con Orden
    FOREIGN KEY (fidRecurso) REFERENCES Recurso(idRecurso) ON DELETE CASCADE,  -- Relación con Recurso (producto)
	UNIQUE(fidRecurso)
) ENGINE=InnoDB;

CREATE TABLE Comprobante (
    idComprobante INT AUTO_INCREMENT,
    fechaEmision DATE,
    tipoComprobante ENUM('FACTURA', 'BOLETA'),
    fidOrden INT NOT NULL,  -- Relación con la tabla Orden
    PRIMARY KEY (idComprobante),
    FOREIGN KEY (fidOrden) REFERENCES Orden(idOrden) ON DELETE CASCADE,  -- Relación con Orden
	UNIQUE (fidOrden)
) ENGINE=InnoDB;



