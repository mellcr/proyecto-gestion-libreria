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
