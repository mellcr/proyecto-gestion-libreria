DROP PROCEDURE IF EXISTS insertarAlmacen;
DELIMITER /
CREATE PROCEDURE insertarAlmacen(
  OUT _idLocal INT,
  IN _direccion VARCHAR(45),
  IN _area DOUBLE
  )
BEGIN
	INSERT INTO Local(direccion) 
	VALUES (_direccion);
	SET _idLocal = @@LAST_INSERT_ID;
    INSERT INTO Almacen(idAlmacen,area) VALUES (_idLocal,_area);
END/
  
DROP PROCEDURE IF EXISTS actualizarAlmacen;
DELIMITER /
	CREATE PROCEDURE actualizarAlmacen(
    IN _idLocal INT,
	IN _direccion VARCHAR(45),
	IN _area DOUBLE
	)
BEGIN
	-- Actualización en la tabla Local
	UPDATE Local
	SET direccion = _direccion
	WHERE idLocal = _idLocal;

	-- Actualización en la tabla Sede
	UPDATE Almacen
	SET area = _area
	WHERE idAlmacen = _idLocal;
END/

DROP PROCEDURE IF EXISTS listarAlmacen;
DELIMITER /   
CREATE PROCEDURE listarAlmacen(
)
BEGIN
	SELECT loc.direccion
	FROM Local loc
	INNER JOIN Almacen alm ON loc.idLocal = alm.idAlmacen;
END/
    
DROP PROCEDURE IF EXISTS obtenerAlmacenId;
DELIMITER /   
CREATE PROCEDURE obtenerAlmacenId(
	IN _idLocal INT
)
BEGIN
	SELECT loc.direccion
	FROM Local loc
	INNER JOIN Almacen alm ON loc.idLocal = sed.idAlmacen
	WHERE loc.idLocal=_idLocal;
END/

DROP PROCEDURE IF EXISTS eliminarAlmacen;
DELIMITER /   
CREATE PROCEDURE eliminarAlmacen(
	IN _idLocal INT
)
BEGIN
	-- Primero eliminar de la tabla Sede
	DELETE FROM Almacen WHERE idAlmacen = _idLocal;
	-- Luego eliminar de la tabla Local
	DELETE FROM Local WHERE idLocal= _idLocal;
END/
