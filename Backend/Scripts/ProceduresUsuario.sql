--Prodecimientos Almacenados del paquete Usuario

DROP IF EXISTS INSERTAR_ADMINISTRADOR
DELIMITER $$
CREATE PROCEDURE INSERTAR_ADMINISTRADOR(
    OUT _id_administrador INT,
    IN _nombre VARCHAR(255),
    IN _apellido_paterno VARCHAR(255),
	IN _apellido_materno VARCHAR(255),
	IN _nacionalidad VARCHAR(100),
	IN _numero_documento VARCHAR(100),
    IN _tipo_documento ENUM('DNI', 'CE', 'RUC'),
	IN _sueldo DECIMAL(10,2)
)
BEGIN
    INSERT INTO persona(nombre, apellidoPaterno, apellidoMaterno, nacionalidad, numeroDocumento, tipoDocumento) 
    VALUES (_nombre, _apellido_paterno, _apellido_materno, _nacionalidad, _numero_documento, _tipo_documento);
    SET _id_administrador = @@last_insert_id();
    INSERT INTO empleado(idEmpleado, sueldo, empleadoActivo) 
    VALUES (_id_administrador, _sueldo, 1);
    INSERT INTO administrador(idAdministrador) VALUES(_id_administrador);
END$$

DROP IF EXISTS MODIFICAR_ADMINISTRADOR
DELIMITER $$
CREATE PROCEDURE MODIFICAR_ADMINISTRADOR(
    IN _id_administrador INT,
    IN _nombre VARCHAR(255),
    IN _apellido_paterno VARCHAR(255),
	IN _apellido_materno VARCHAR(255),
	IN _nacionalidad VARCHAR(100),
	IN _numero_documento VARCHAR(100),
    IN _tipo_documento ENUM('DNI', 'CE', 'RUC'),
	IN _sueldo DECIMAL(10,2)
)
BEGIN
    -- Actualizar la información en la tabla persona
    UPDATE persona 
    SET nombre = _nombre, 
        apellidoPaterno = _apellido_paterno, 
        apellidoMaterno = _apellido_materno, 
        nacionalidad = _nacionalidad, 
        numeroDocumento = _numero_documento
		tipoDocumento = _tipo_documento
    WHERE idPersona = _id_administrador;

    -- Actualizar la información en la tabla empleado
    UPDATE empleado 
    SET sueldo = _sueldo
    WHERE idEmpleado = _id_administrador;
END$$


DROP IF EXISTS LISTAR_ADMINISTRADOR_X_ID
DELIMITER $$
CREATE PROCEDURE LISTAR_ADMINISTRADOR_X_ID(
    IN _id_administrador INT
)
BEGIN
    SELECT 
        a.idAdministrador,  
        p.nombre, 
        p.apellidoPaterno, 
		p.apellidoMaterno,
        p.nacionalidad, 
        p.numeroDocumento, 
		p.tipoDocumento,
        e.sueldo
    FROM persona p
    INNER JOIN empleado e ON p.idPersona = e.idEmpleado
    INNER JOIN administrador a ON e.id_empleado = a.idAdministrador
    WHERE a.idAdministrador = _id_administrador;
END$$

DROP IF EXISTS LISTAR_ADMINISTRADORES_TODOS
DELIMITER $$
CREATE PROCEDURE LISTAR_ADMINISTRADORES_TODOS()
BEGIN
    SELECT 
        a.idAdministrador,  
        p.nombre, 
        p.apellidoPaterno, 
        p.apellidoMaterno,
        p.nacionalidad, 
        p.numeroDocumento, 
        p.tipoDocumento,
        e.sueldo
    FROM persona p
    INNER JOIN empleado e ON p.idPersona = e.idEmpleado
    INNER JOIN administrador a ON e.idEmpleado = a.idAdministrador
    WHERE e.empleadoActivo = TRUE;
END$$

DROP IF EXISTS ELIMINAR_ADMINISTRADOR
DELIMITER $$
CREATE PROCEDURE ELIMINAR_ADMINISTRADOR(
    IN _id_administrador INT
)
BEGIN
    UPDATE empleado 
    SET empleadoActivo = FALSE 
    WHERE idEmpleado = _id_administrador;
END$$

DROP IF EXISTS INSERTAR_COORDINADOR
DELIMITER $$
CREATE PROCEDURE INSERTAR_COORDINADOR(
    OUT _id_coordinador INT,
    IN _nombre VARCHAR(255),
    IN _apellido_paterno VARCHAR(255),
	IN _apellido_materno VARCHAR(255),
	IN _nacionalidad VARCHAR(100),
	IN _numero_documento VARCHAR(100),
    IN _tipo_documento ENUM('DNI', 'CE', 'RUC'),
	IN _sueldo DECIMAL(10,2)
)
BEGIN
    INSERT INTO persona(nombre, apellidoPaterno, apellidoMaterno, nacionalidad, numeroDocumento, tipoDocumento) 
    VALUES (_nombre, _apellido_paterno, _apellido_materno, _nacionalidad, _numero_documento, _tipo_documento);
    SET _id_coordinador = @@last_insert_id();
    INSERT INTO empleado(idEmpleado, sueldo, empleadoActivo) 
    VALUES (_id_coordinador, _sueldo, 1);
    INSERT INTO coordinador(idCoordinador) VALUES(_id_coordinador);
END$$

DROP IF EXISTS MODIFICAR_COORDINADOR
DELIMITER $$
CREATE PROCEDURE MODIFICAR_COORDINADOR(
    IN _id_coordinador INT,
    IN _nombre VARCHAR(255),
    IN _apellido_paterno VARCHAR(255),
	IN _apellido_materno VARCHAR(255),
	IN _nacionalidad VARCHAR(100),
	IN _numero_documento VARCHAR(100),
    IN _tipo_documento ENUM('DNI', 'CE', 'RUC'),
	IN _sueldo DECIMAL(10,2)
)
BEGIN
    -- Actualizar la información en la tabla persona
    UPDATE persona 
    SET nombre = _nombre, 
        apellidoPaterno = _apellido_paterno, 
        apellidoMaterno = _apellido_materno, 
        nacionalidad = _nacionalidad, 
        numeroDocumento = _numero_documento
		tipoDocumento = _tipo_documento
    WHERE idPersona = _id_coordinador;

    -- Actualizar la información en la tabla empleado
    UPDATE empleado 
    SET sueldo = _sueldo
    WHERE idEmpleado = _id_coordinador;
END$$

DROP IF EXISTS LISTAR_COORDINADOR_X_ID
DELIMITER $$
CREATE PROCEDURE LISTAR_COORDINADOR_X_ID(
    IN _id_coordinador INT
)
BEGIN
    SELECT 
        a.idCoordinador,  
        p.nombre, 
        p.apellidoPaterno, 
		p.apellidoMaterno,
        p.nacionalidad, 
        p.numeroDocumento, 
		p.tipoDocumento,
        e.sueldo
    FROM persona p
    INNER JOIN empleado e ON p.idPersona = e.idEmpleado
    INNER JOIN coordinador a ON e.idEmpleado = a.idCoordinador
    WHERE a.idCoordinador = _id_coordinador;
END$$


DROP IF EXISTS LISTAR_COORDINADORES_TODOS
DELIMITER $$
CREATE PROCEDURE LISTAR_COORDINADORES_TODOS()
BEGIN
    SELECT 
        a.idCoordinador,  
        p.nombre, 
        p.apellidoPaterno, 
        p.apellidoMaterno,
        p.nacionalidad, 
        p.numeroDocumento, 
        p.tipoDocumento,
        e.sueldo
    FROM persona p
    INNER JOIN empleado e ON p.idPersona = e.idEmpleado
    INNER JOIN coordinador a ON e.idEmpleado = a.idCoordinador
    WHERE e.empleadoActivo = TRUE;
END$$