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