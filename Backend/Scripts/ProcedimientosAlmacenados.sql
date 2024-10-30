
-- PROCEDIMIENTOS ALMACENADOS
-- CLIENTE
DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DELIMITER $$
CREATE PROCEDURE INSERTAR_CLIENTE(
    OUT _idCliente INT,
    IN _nombre VARCHAR(255),
    IN _apellidoPaterno VARCHAR(255),
    IN _apellidoMaterno VARCHAR(255),
    IN _nacionalidad VARCHAR(100),
    IN _numeroDocumento VARCHAR(50),
    IN _tipoDocumento ENUM('DNI', 'PASAPORTE'),
	IN _direccion VARCHAR(255)
)
BEGIN
    INSERT INTO Persona(nombre, apellidoPaterno, apellidoMaterno, nacionalidad, numeroDocumento, tipoDocumento) VALUES (_nombre, _apellidoPaterno, _apellidoMaterno, _nacionalidad, _numeroDocumento, _tipoDocumento);
    SET _idCliente = @@last_insert_id;
	INSERT INTO Cliente(idCliente,direccion) VALUES (_idCliente, _direccion);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_CLIENTES;
DELIMITER $$
CREATE PROCEDURE LISTAR_CLIENTES()
BEGIN
	SELECT p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.nacionalidad, p.numeroDocumento,
				p.tipoDocumento, c.direccion
	FROM Persona p INNER JOIN Cliente c ON p.idPersona = c.idCliente;
END$$
DELIMITER ; 

DROP PROCEDURE IF EXISTS ELIMINAR_CLIENTE;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_CLIENTE(
    IN _idCliente INT
)
BEGIN
    DELETE FROM Cliente WHERE idCliente = _idCliente;
    DELETE FROM Persona WHERE idPersona = _idCliente;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_CLIENTE;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_CLIENTE(
    IN _idCliente INT,
    IN _nombre VARCHAR(255),
    IN _apellidoPaterno VARCHAR(255),
    IN _apellidoMaterno VARCHAR(255),
    IN _nacionalidad VARCHAR(100),
    IN _numeroDocumento VARCHAR(50),
    IN _tipoDocumento ENUM('DNI', 'PASAPORTE'),
    IN _direccion VARCHAR(255)
)
BEGIN
    UPDATE Persona
    SET nombre = _nombre, apellidoPaterno = _apellidoPaterno, apellidoMaterno = _apellidoMaterno,
        nacionalidad = _nacionalidad, numeroDocumento = _numeroDocumento, tipoDocumento = _tipoDocumento
    WHERE idPersona = _idCliente;

    UPDATE Cliente
    SET direccion = _direccion
    WHERE idCliente = _idCliente;
END$$
DELIMITER ;



DROP PROCEDURE IF EXISTS LISTAR_CLIENTE_POR_ID;
DELIMITER $$  
CREATE PROCEDURE LISTAR_CLIENTE_POR_ID(
	IN _idCliente INT
)
BEGIN
		SELECT per.nombre, per.apellidoPaterno, per.apellidoMaterno, per.nacionalidad, per.numeroDocumento,
				per.tipoDocumento, cli.direccion
        FROM Persona per
        INNER JOIN Cliente cli ON per.idPersona = cli.idCliente
        WHERE per.idPersona=_idCliente;
END$$
DELIMITER ;



-- EMPLEADO

DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE INSERTAR_EMPLEADO(
    OUT _idEmpleado INT,
    IN _nombre VARCHAR(255),
    IN _apellidoPaterno VARCHAR(255),
    IN _apellidoMaterno VARCHAR(255),
    IN _nacionalidad VARCHAR(100),
    IN _numeroDocumento VARCHAR(50),
    IN _tipoDocumento ENUM('DNI', 'PASAPORTE'),
    IN _sueldo DECIMAL(10,2),
    IN _rol ENUM('ADMINISTRADOR', 'COORDINADOR', 'VENDEDOR')
)
BEGIN
    INSERT INTO Persona(nombre, apellidoPaterno, apellidoMaterno, nacionalidad, numeroDocumento, tipoDocumento)
    VALUES (_nombre, _apellidoPaterno, _apellidoMaterno, _nacionalidad, _numeroDocumento, _tipoDocumento);
    SET _idEmpleado =  @@last_insert_id;
    INSERT INTO Empleado(idEmpleado, sueldo, rol)
    VALUES (_idEmpleado, _sueldo, _rol);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_EMPLEADO(
    IN _idEmpleado INT
)
BEGIN
    DELETE FROM Persona WHERE idPersona = _idEmpleado;
    DELETE FROM Empleado WHERE idEmpleado = _idEmpleado;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_EMPLEADO(
    IN _idEmpleado INT,
    IN _nombre VARCHAR(255),
    IN _apellidoPaterno VARCHAR(255),
    IN _apellidoMaterno VARCHAR(255),
    IN _nacionalidad VARCHAR(100),
    IN _numeroDocumento VARCHAR(50),
    IN _tipoDocumento ENUM('DNI', 'PASAPORTE'),
    IN _sueldo DECIMAL(10,2),
    IN _empleadoActivo TINYINT,
    IN _rol ENUM('ADMINISTRADOR', 'COORDINADOR', 'VENDEDOR')
)
BEGIN
    UPDATE Persona
    SET nombre = _nombre, apellidoPaterno = _apellidoPaterno, apellidoMaterno = _apellidoMaterno,
        nacionalidad = _nacionalidad, numeroDocumento = _numeroDocumento, tipoDocumento = _tipoDocumento
    WHERE idPersona = _idEmpleado;

    UPDATE Empleado
    SET sueldo = _sueldo, empleadoActivo = _empleadoActivo, rol = _rol
    WHERE idEmpleado = _idEmpleado;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS;
DELIMITER $$
CREATE PROCEDURE LISTAR_EMPLEADOS()
BEGIN
    SELECT e.idEmpleado, p.nombre, p.apellidoPaterno, p.apellidoMaterno,
    p.nacionalidad, p.numeroDocumento, p.tipoDocumento, e.sueldo, e.empleadoActivo, e.rol
    FROM Persona p
    INNER JOIN Empleado e ON p.idPersona = e.idEmpleado;
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS LISTAR_EMPLEADO_POR_ID;
DELIMITER $$  
CREATE PROCEDURE LISTAR_EMPLEADO_POR_ID(
	IN _idEmpleado INT
)
BEGIN
		SELECT per.nombre, per.apellidoPaterno, per.apellidoMaterno, per.nacionalidad, per.numeroDocumento,
				per.tipoDocumento, emp.sueldo, emp.empleadoActivo, emp.rol
        FROM Persona per
        INNER JOIN Empleado emp ON per.idPersona = emp.idEmpleado
        WHERE per.idPersona=_idEmpleado;
END$$
DELIMITER ;


-- CUENTA
DROP PROCEDURE IF EXISTS INSERTAR_CUENTA;
DELIMITER $$
CREATE PROCEDURE INSERTAR_CUENTA(
    OUT _idCuenta INT,
    IN _usuario VARCHAR(255),
    IN _contraseña VARCHAR(255),
    IN _activo TINYINT,
    IN _direccion VARCHAR(255),
    IN _fidPersona INT
)
BEGIN
    INSERT INTO Cuenta(usuario, contraseña, activo, fidPersona)
    VALUES (_usuario, _contraseña, _activo, _fidPersona);
    SET _idCuenta = @@last_insert_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_CUENTA;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_CUENTA(
    IN _idCuenta INT,
    IN _usuario VARCHAR(255),
    IN _contraseña VARCHAR(255),
    IN _activo TINYINT
)
BEGIN
    UPDATE Cuenta
    SET usuario = _usuario, contraseña = _contraseña, activo = _activo
    WHERE idCuenta = _idCuenta;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_CUENTA;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_CUENTA(
    IN _idCuenta INT
)
BEGIN
    DELETE FROM Cuenta WHERE idCuenta = _idCuenta; 
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS LISTAR_CUENTAS;
DELIMITER $$
CREATE PROCEDURE LISTAR_CUENTAS()
BEGIN
    SELECT idCuenta, usuario, activo, direccion, fidPersona
    FROM Cuenta;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_CUENTA_POR_ID;
DELIMITER $$  
CREATE PROCEDURE LISTAR_CUENTA_POR_ID(
	IN _idCuenta INT
)
BEGIN
		SELECT cue.usuario, cue.contraseña, cue.activo, cue.direccion
        FROM  Cuenta cue
        WHERE cue.idCuenta=_idCuenta;
END$$
DELIMITER ;


-- CARRITO DE COMPRAS
DROP PROCEDURE IF EXISTS INSERTAR_CARRITO_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE INSERTAR_CARRITO_DE_COMPRAS(
    OUT _idCarrito INT,
    IN _fechaCreacion DATE,
    IN _subTotal DECIMAL(10,2),
    IN _estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO'),
    IN _idCliente INT
)
BEGIN
    INSERT INTO CarritoDeCompras(fechaCreacion, subTotal, estado, idCliente)
    VALUES (_fechaCreacion, _subTotal, _estado, _idCliente);
    SET _idCarrito = @@last_insert_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_CARRITO_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_CARRITO_DE_COMPRAS(
    IN _idCarrito INT,
    IN _subTotal DECIMAL(10,2),
    IN _estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO')
)
BEGIN
    UPDATE CarritoDeCompras
    SET subTotal = _subTotal, estado = _estado
    WHERE idCarrito = _idCarrito;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS MARCAR_CARRITO_INACTIVO;
DELIMITER $$
CREATE PROCEDURE MARCAR_CARRITO_INACTIVO(
    IN _idCarrito INT
)
BEGIN
    UPDATE CarritoDeCompras
    SET estado = 'ABANDONADO'
    WHERE idCarrito = _idCarrito;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_CARRITOS_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE LISTAR_CARRITOS_DE_COMPRAS()
BEGIN
    SELECT idCarrito, fechaCreacion, subTotal, estado, idCliente
    FROM CarritoDeCompras;
END$$
DELIMITER ;

-- LINEA DE CARRITO DE COMPRAS
DROP PROCEDURE IF EXISTS INSERTAR_LINEA_DE_CARRITO;
DELIMITER $$
CREATE PROCEDURE INSERTAR_LINEA_DE_CARRITO(
    OUT _idLineaCarrito INT,
    IN _cantidad INT,
    IN _precioUnitario DECIMAL(10,2),
    IN _subTotal DECIMAL(10,2),
    IN _descuento DECIMAL(10,2),
    IN _idCarrito INT,
    IN _idRecurso INT
)
BEGIN
    INSERT INTO LineaDeCarritoDeCompras(cantidad, precioUnitario, subTotal, descuento, fidCarrito, fidRecurso)
    VALUES (_cantidad, _precioUnitario, _subTotal, _descuento, _idCarrito, _idRecurso);
    SET _idLineaCarrito = @@last_insert_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_LINEA_DE_CARRITO;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_LINEA_DE_CARRITO(
    IN _idLineaCarrito INT,
    IN _cantidad INT,
    IN _precioUnitario DECIMAL(10,2),
    IN _subTotal DECIMAL(10,2),
    IN _descuento DECIMAL(10,2)
)
BEGIN
    UPDATE LineaDeCarritoDeCompras
    SET cantidad = _cantidad, precioUnitario = _precioUnitario, subTotal = _subTotal, descuento = _descuento
    WHERE idLineaCarrito = _idLineaCarrito;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_LINEA_DE_CARRITO;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_LINEA_DE_CARRITO(
    IN _idLineaCarrito INT
)
BEGIN
    DELETE FROM LineaDeCarritoDeCompras
    WHERE idLineaCarrito = _idLineaCarrito;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_LINEAS_DE_CARRITO;
DELIMITER $$
CREATE PROCEDURE LISTAR_LINEAS_DE_CARRITO(
    IN _idCarrito INT
)
BEGIN
    SELECT idLineaCarrito, cantidad, precioUnitario, subTotal, descuento, fidRecurso
    FROM LineaDeCarritoDeCompras
    WHERE fidCarrito = _idCarrito;
END$$
DELIMITER ;

-- LISTAR LINEA DE CARRITO POR ID
DROP PROCEDURE IF EXISTS LISTAR_LINEA_DE_CARRITO_POR_ID;
DELIMITER $$
CREATE PROCEDURE LISTAR_LINEA_DE_CARRITO_POR_ID(
    IN _idLineaCarrito INT
)
BEGIN
    SELECT idLineaCarrito, cantidad, precioUnitario, subTotal, descuento, fidRecurso, fidCarrito
    FROM LineaDeCarritoDeCompras
    WHERE idLineaCarrito = _idLineaCarrito;
END$$
DELIMITER ;


-- CARRITO DE COMPRAS
DROP PROCEDURE IF EXISTS INSERTAR_CARRITO_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE INSERTAR_CARRITO_DE_COMPRAS(
    OUT _idCarrito INT,
    IN _fechaCreacion DATE,
    IN _subTotal DECIMAL(10,2),
    IN _estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO'),
    IN _idCliente INT
)
BEGIN
    INSERT INTO CarritoDeCompras(fechaCreacion, subTotal, estado, idCliente)
    VALUES (_fechaCreacion, _subTotal, _estado, _idCliente);
    
    -- Obtenemos el ID generado para el carrito insertado
    SET _idCarrito = LAST_INSERT_ID();
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_CARRITO_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_CARRITO_DE_COMPRAS(
    IN _idCarrito INT,
    IN _subTotal DECIMAL(10,2),
    IN _estado ENUM('ACTIVO', 'COMPLETADO', 'ABANDONADO')
)
BEGIN
    UPDATE CarritoDeCompras
    SET subTotal = _subTotal, estado = _estado
    WHERE idCarrito = _idCarrito;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_CARRITOS_DE_COMPRAS;
DELIMITER $$
CREATE PROCEDURE LISTAR_CARRITOS_DE_COMPRAS()
BEGIN
    SELECT idCarrito, fechaCreacion, subTotal, estado, idCliente
    FROM CarritoDeCompras;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_CARRITO_POR_ID;
DELIMITER $$
CREATE PROCEDURE LISTAR_CARRITO_POR_ID(
    IN _idCarrito INT
)
BEGIN
    SELECT idCarrito, fechaCreacion, subTotal, estado, idCliente
    FROM CarritoDeCompras
    WHERE idCarrito = _idCarrito;
END$$
DELIMITER ;


-- ORDEN VENTA
DROP PROCEDURE IF EXISTS INSERTAR_ORDEN_VENTA;
DELIMITER $$
CREATE PROCEDURE INSERTAR_ORDEN_VENTA(
    OUT _idOrdenVenta INT,
    IN _estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO'),
    IN _fechaCreacion DATE,
    IN _total DECIMAL(10,2),
    IN _fidEmpleado INT,
    IN _idCliente INT,
    IN _tipoVenta ENUM('PRESENCIAL', 'VIRTUAL'),
    IN _fechaEntrega DATE,
    IN _metodoPago ENUM('EFECTIVO', 'TARJETA')
)
BEGIN
    -- Insertamos primero en la tabla Orden
    INSERT INTO Orden(estadoOrden, fechaCreacion, total, fidEmpleado)
    VALUES (_estadoOrden, _fechaCreacion, _total, _fidEmpleado);
    -- Obtenemos el ID generado para la tabla Orden
    SET _idOrdenVenta = @@last_insert_id;
    -- Insertamos en OrdenVenta usando el ID generado de Orden
    INSERT INTO OrdenVenta(idOrdenVenta, idCliente, tipoVenta, fechaEntrega, metodoPago)
    VALUES (_idOrdenVenta, _idCliente, _tipoVenta, _fechaEntrega, _metodoPago);
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS ACTUALIZAR_ORDEN_VENTA;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_ORDEN_VENTA(
    IN _idOrdenVenta INT,
    IN _estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO'),
    IN _total DECIMAL(10,2),
    IN _tipoVenta ENUM('PRESENCIAL', 'VIRTUAL'),
    IN _fechaEntrega DATE,
    IN _metodoPago ENUM('EFECTIVO', 'TARJETA')
)
BEGIN
    -- Actualizamos en la tabla Orden
    UPDATE Orden
    SET estadoOrden = _estadoOrden, total = _total
    WHERE idOrden = _idOrdenVenta;
    
    -- Actualizamos en la tabla OrdenVenta
    UPDATE OrdenVenta
    SET tipoVenta = _tipoVenta, fechaEntrega = _fechaEntrega, metodoPago = _metodoPago
    WHERE idOrdenVenta = _idOrdenVenta;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_ORDEN_VENTA;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_ORDEN_VENTA(
    IN _idOrdenVenta INT
)
BEGIN
    UPDATE Orden
    SET estadoOrden = 'CANCELADO'
    WHERE idOrden = _idOrdenVenta;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_ORDENES_VENTA;
DELIMITER $$
CREATE PROCEDURE LISTAR_ORDENES_VENTA()
BEGIN
    SELECT o.idOrden, o.estadoOrden, o.fechaCreacion, o.total, v.tipoVenta, v.fechaEntrega, v.metodoPago
    FROM Orden o
    INNER JOIN OrdenVenta v ON o.idOrden = v.idOrdenVenta;
END$$
DELIMITER ;

-- ORDEN ABASTECIMIENTO
DROP PROCEDURE IF EXISTS INSERTAR_ORDEN_ABASTECIMIENTO;
DELIMITER $$
CREATE PROCEDURE INSERTAR_ORDEN_ABASTECIMIENTO(
    OUT _idOrdenAbastecimiento INT,
    IN _estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO'),
    IN _fechaCreacion DATE,
    IN _total DECIMAL(10,2),
    IN _fidEmpleado INT,
    IN _fechaRecepcion DATE
)
BEGIN
    -- Insertamos en la tabla Orden
    INSERT INTO Orden(estadoOrden, fechaCreacion, total, fidEmpleado)
    VALUES (_estadoOrden, _fechaCreacion, _total, _fidEmpleado);
    
    -- Obtenemos el ID generado para Orden
    SET _idOrdenAbastecimiento = @@last_insert_id;
    
    -- Insertamos en OrdenAbastecimiento
    INSERT INTO OrdenAbastecimiento(idOrdenAbastecimiento, fechaRecepcion)
    VALUES (_idOrdenAbastecimiento, _fechaRecepcion);
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS ACTUALIZAR_ORDEN_ABASTECIMIENTO;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_ORDEN_ABASTECIMIENTO(
    IN _idOrdenAbastecimiento INT,
    IN _estadoOrden ENUM('PENDIENTE', 'PROCESADO', 'ENVIADO', 'ENTREGADO', 'CANCELADO', 'EN_CAMINO'),
	IN _total DECIMAL(10,2),
    IN _fechaRecepcion DATE
)
BEGIN
    -- Actualizamos en la tabla Orden
    UPDATE Orden
    SET estadoOrden = _estadoOrden, total = _total
    WHERE idOrden = _idOrdenAbastecimiento;
    
    -- Actualizamos en la tabla OrdenAbastecimiento
    UPDATE OrdenAbastecimiento
    SET fechaRecepcion = _fechaRecepcion
    WHERE idOrdenAbastecimiento = _idOrdenAbastecimiento;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_ORDEN_ABASTECIMIENTO;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_ORDEN_ABASTECIMIENTO(
    IN _idOrdenAbastecimiento INT
)
BEGIN
    UPDATE Orden
    SET estadoOrden = 'CANCELADO'
    WHERE idOrden = _idOrdenAbastecimiento;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_ORDENES_ABASTECIMIENTO;
DELIMITER $$
CREATE PROCEDURE LISTAR_ORDENES_ABASTECIMIENTO()
BEGIN
    SELECT o.idOrden, o.estadoOrden, o.fechaCreacion, o.total, a.fechaRecepcion
    FROM Orden o
    INNER JOIN OrdenAbastecimiento a ON o.idOrden = a.idOrdenAbastecimiento;
END$$
DELIMITER ;


-- LINEA DE ORDEN
DROP PROCEDURE IF EXISTS INSERTAR_LINEA_DE_ORDEN;
DELIMITER $$
CREATE PROCEDURE INSERTAR_LINEA_DE_ORDEN(
    OUT _idLineaDeOrden INT,
    IN _cantidad INT,
    IN _subtotal DECIMAL(10,2),
	IN _descuento DECIMAL(10,2),
    IN _precioUnitario DECIMAL(10,2),
	IN _subtotalBruto DECIMAL(10,2),
	IN _subtotalNeto DECIMAL(10,2),
    IN _fidOrden INT,
    IN _fidRecurso INT
)
BEGIN
    INSERT INTO LineaDeOrden(cantidad, subtotal, descuento, precioUnitario, subtotalBruto, subtotalNeto, fidOrden, fidRecurso)
    VALUES (_cantidad, _subtotal, _descuento, _precioUnitario, _subtotalBruto, _subtotalNeto, _fidOrden, _fidRecurso);
    SET _idLineaDeOrden = @@last_insert_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_LINEA_DE_ORDEN;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_LINEA_DE_ORDEN(
    IN _idLineaDeOrden INT,
    IN _cantidad INT,
    IN _precioUnitario DECIMAL(10,2),
    IN _subtotal DECIMAL(10,2),
    IN _descuento DECIMAL(10,2)
)
BEGIN
    UPDATE LineaDeOrden
    SET cantidad = _cantidad, precioUnitario = _precioUnitario, subtotal = _subtotal, descuento = _descuento
    WHERE idLineaDeOrden = _idLineaDeOrden;
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS ELIMINAR_LINEA_DE_ORDEN;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_LINEA_DE_ORDEN(
    IN _idLineaDeOrden INT
)
BEGIN
    DELETE FROM LineaDeOrden WHERE idLineaDeOrden = _idLineaDeOrden;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_LINEAS_DE_ORDEN;
DELIMITER $$
CREATE PROCEDURE LISTAR_LINEAS_DE_ORDEN(
    IN _idOrden INT
)
BEGIN
    SELECT idLineaDeOrden, cantidad, precioUnitario, subtotal, descuento, fidRecurso
    FROM LineaDeOrden
    WHERE fidOrden = _idOrden;
END$$
DELIMITER ;

-- COMPROBANTE
DROP PROCEDURE IF EXISTS INSERTAR_COMPROBANTE;
DELIMITER $$
CREATE PROCEDURE INSERTAR_COMPROBANTE(
    OUT _idComprobante INT,
    IN _fechaEmision DATE,
    IN _tipoComprobante ENUM('FACTURA', 'BOLETA'),
    IN _fidOrden INT
)
BEGIN
    INSERT INTO Comprobante(fechaEmision, tipoComprobante, fidOrden)
    VALUES (_fechaEmision, _tipoComprobante, _fidOrden);
    
    SET _idComprobante = @@last_insert_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ACTUALIZAR_COMPROBANTE;
DELIMITER $$
CREATE PROCEDURE ACTUALIZAR_COMPROBANTE(
    IN _idComprobante INT,
    IN _fechaEmision DATE,
    IN _tipoComprobante ENUM('FACTURA', 'BOLETA')
)
BEGIN
    UPDATE Comprobante
    SET fechaEmision = _fechaEmision, tipoComprobante = _tipoComprobante
    WHERE idComprobante = _idComprobante;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ELIMINAR_COMPROBANTE;
DELIMITER $$
CREATE PROCEDURE ELIMINAR_COMPROBANTE(
    IN _idComprobante INT
)
BEGIN
    DELETE FROM Comprobante WHERE idComprobante = _idComprobante;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LISTAR_COMPROBANTES;
DELIMITER $$
CREATE PROCEDURE LISTAR_COMPROBANTES()
BEGIN
    SELECT idComprobante, fechaEmision, tipoComprobante, fidOrden
    FROM Comprobante;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS insertarLibro;
DELIMITER /
CREATE PROCEDURE insertarLibro(
  OUT _idRecurso INT,
  IN _nombre VARCHAR(45),
  IN _peso DECIMAL(10,2),
  IN _alto DECIMAL(10,2),
  IN _ancho DECIMAL(10,2),
  IN _precio DECIMAL(10,2),
  IN _disponible TINYINT,
  IN _autor VARCHAR(45) ,
  IN _editorial VARCHAR(45) ,
  IN _ISBN VARCHAR(13) ,
  IN _sipnosis VARCHAR(50),
  IN _formato ENUM('BOLSILLO', 'Literal1', 'RUSTICA', 'TAPADURA', 			'APEDIDO', 'ESTUCHE', 'EBOOK', 'Literal2') 
  )
  BEGIN
	INSERT INTO Recurso(nombre,peso,alto,ancho,precio, disponible) 
    VALUES (_nombre,_peso,_alto,_ancho,_precio,_disponible);
	SET _idRecurso = @@LAST_INSERT_ID;
    INSERT INTO Libro(idLibro,autor,editorial,ISBN,sinopsis,formato) VALUES (_idRecurso,_autor,_editorial,_ISBN,_sipnosis,_formato);
  END/
  
  DROP PROCEDURE IF EXISTS actualizarLibro;
  DELIMITER /
	CREATE PROCEDURE actualizarLibro(
	  IN _idRecurso INT,
	  IN _nombre VARCHAR(45),
	  IN _peso DECIMAL(10,2),
	  IN _alto DECIMAL(10,2),
	  IN _ancho DECIMAL(10,2),
	  IN _precio DECIMAL(10,2),
	  IN _disponible TINYINT,
	  IN _autor VARCHAR(45),
	  IN _editorial VARCHAR(45),
	  IN _ISBN VARCHAR(13),
	  IN _sipnosis VARCHAR(50),
	  IN _formato ENUM('BOLSILLO', 'Literal1', 'RUSTICA', 'TAPADURA', 'APEDIDO', 'ESTUCHE', 'EBOOK', 'Literal2')
	)
	BEGIN
		-- Actualización en la tabla Recurso
		UPDATE Recurso
		SET nombre = _nombre,
			peso = _peso,
			alto = _alto,
			ancho = _ancho,
			precio = _precio,
			disponible = _disponible
		WHERE idRecurso = _idRecurso;

		-- Actualización en la tabla Libro
		UPDATE Libro
		SET autor = _autor,
			editorial = _editorial,
			ISBN = _ISBN,
			sinopsis = _sipnosis,
			formato = _formato
		WHERE idLibro = _idRecurso;
	END/
    
    DROP PROCEDURE IF EXISTS obtenerLibro;
	DELIMITER /   
    CREATE PROCEDURE obtenerLibro(
		IN _idRecurso INT
    )
    BEGIN
		SELECT res.nombre, res.peso, res.alto, res.ancho, res.precio,
				res.disponible, lib.autor, lib.editorial, lib.ISBN, lib.sinopsis,
                lib.formato
        FROM Recurso res
        INNER JOIN Libro lib ON res.idRecurso = lib.idLibro
        WHERE res.idRecurso=_idRecurso;
    END/
    
	DROP PROCEDURE IF EXISTS eliminarLibro;
	DELIMITER /   
    CREATE PROCEDURE eliminarLibro(
		IN _idRecurso INT
    )
    BEGIN
		-- Primero eliminar de la tabla Libro
		DELETE FROM Libro WHERE idLibro = _idRecurso;
		-- Luego eliminar de la tabla Recurso
		DELETE FROM Recurso WHERE idRecurso = _idRecurso;
    END/
    
	DROP PROCEDURE IF EXISTS listarLibros;
	DELIMITER /   
    CREATE PROCEDURE listarLibros(
    )
    BEGIN
		SELECT res.nombre, res.peso, res.alto, res.ancho, res.precio,
				res.disponible, lib.autor, lib.editorial, lib.ISBN, lib.sinopsis,
                lib.formato
        FROM Recurso res
        INNER JOIN Libro lib ON res.idRecurso = lib.idLibro;
    END/
DROP PROCEDURE IF EXISTS insertarOtroRecurso;
DELIMITER /
CREATE PROCEDURE insertarOtroRecurso(
  OUT _idRecurso INT,
  IN _nombre VARCHAR(45),
  IN _peso DECIMAL(10,2),
  IN _alto DECIMAL(10,2),
  IN _ancho DECIMAL(10,2),
  IN _precio DECIMAL(10,2),
  IN _disponible TINYINT,
  IN _caracteristica VARCHAR(255) 
  )
  BEGIN
	INSERT INTO Recurso(nombre,peso,alto,ancho,precio, disponible) 
    VALUES (_nombre,_peso,_alto,_ancho,_precio,_disponible);
	SET _idRecurso = @@LAST_INSERT_ID;
    INSERT INTO OtroRecurso(idOtroRecurso,caracteristica) 
    VALUES (_idRecurso,_caracteristica);
  END/
  
  DROP PROCEDURE IF EXISTS actualizarOtroRecurso;
  DELIMITER /
	CREATE PROCEDURE actualizarOtroRecurso(
	  IN _idRecurso INT,
	  IN _nombre VARCHAR(45),
	  IN _peso DECIMAL(10,2),
	  IN _alto DECIMAL(10,2),
	  IN _ancho DECIMAL(10,2),
	  IN _precio DECIMAL(10,2),
	  IN _disponible TINYINT,
	  IN _caracteristica VARCHAR(255) 
	)
	BEGIN
		-- Actualización en la tabla Recurso
		UPDATE Recurso
		SET nombre = _nombre,
			peso = _peso,
			alto = _alto,
			ancho = _ancho,
			precio = _precio,
			disponible = _disponible
		WHERE idRecurso = _idRecurso;

		-- Actualización en la tabla OtroRecurso
		UPDATE OtroRecurso
		SET caracteristica=_caracteristica
		WHERE idOtroRecurso = _idRecurso;
	END/
    
    DROP PROCEDURE IF EXISTS obtenerOtroRecurso;
	DELIMITER /   
    CREATE PROCEDURE obtenerOtroRecurso(
		IN _idRecurso INT
    )
    BEGIN
		SELECT res.nombre, res.peso, res.alto, res.ancho, res.precio,
				res.disponible, ot.caracteristica
        FROM Recurso res
        INNER JOIN OtroRecurso ot ON res.idRecurso = ot.idOtroRecurso
        WHERE res.idRecurso=_idRecurso;
    END/
    
	DROP PROCEDURE IF EXISTS eliminarOtroRecurso;
	DELIMITER /   
    CREATE PROCEDURE eliminarOtroRecurso(
		IN _idRecurso INT
    )
    BEGIN
		-- Primero eliminar de la tabla Libro
		DELETE FROM OtroRecurso WHERE idOtroRecurso = _idRecurso;
		-- Luego eliminar de la tabla Recurso
		DELETE FROM Recurso WHERE idRecurso = _idRecurso;
    END/
    
	DROP PROCEDURE IF EXISTS listarOtrosRecursos;
	DELIMITER /   
    CREATE PROCEDURE listarOtrosRecursos(
    )
    BEGIN
		SELECT res.nombre, res.peso, res.alto, res.ancho, res.precio,
				res.disponible, ot.caracteristica
        FROM Recurso res
        INNER JOIN OtroRecurso ot ON res.idRecurso = ot.idOtroRecurso;
    END/