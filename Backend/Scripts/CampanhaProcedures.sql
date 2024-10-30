DROP PROCEDURE IF EXISTS insertarCampanha;
DELIMITER /
CREATE PROCEDURE insertarCampanha(
  OUT _idCampanha INT,
  IN _fechainicio DATE,
  IN _fechafin DATE,
  IN _descripcion VARCHAR(255),
  IN _estado ENUM('PENDIENTE', 'ACTIVA', 'INACTIVA'),
  IN _porcentajedescuento DECIMAL(10,2)
  )
  BEGIN
	INSERT INTO Campanha(fechaInicio,fechaFin,descripcion,estado, porcentajeDescuento) 
    VALUES (_fechainicio,_fechafin,_descripcion,_estado,_porcentajedescuento);
	SET _idCampanha = @@LAST_INSERT_ID;
  END/
  
  
	DROP PROCEDURE IF EXISTS eliminarCampanha;
	DELIMITER /   
    CREATE PROCEDURE eliminarCampanha(
		IN _idCampanha INT
    )
    BEGIN
		-- Eliminar de la tabla Campanha
		DELETE FROM Campanha WHERE idCampanha = _idCampanha;
    END/  
    
    DROP PROCEDURE IF EXISTS obtenerPorId;
	DELIMITER /   
    CREATE PROCEDURE obtenerPorId(
		IN _idCampanha INT
    )
    BEGIN
		SELECT *
        FROM Campanha
        WHERE idCampanha=_idCampanha;
    END/
    
	DROP PROCEDURE IF EXISTS listarCampanhas;
	DELIMITER /   
    CREATE PROCEDURE listarCampanhas(
    )
    BEGIN
		SELECT *
        FROM Campanha;
    END/
    
    DROP PROCEDURE IF EXISTS actualizarCampanha;
	DELIMITER /
	CREATE PROCEDURE actualizarCampanha(
	  IN _idCampanha INT,
	  IN _fechainicio DATE,
	  IN _fechafin DATE,
	  IN _descripcion VARCHAR(255),
	  IN _estado ENUM('PENDIENTE', 'ACTIVA', 'INACTIVA'),
	  IN _porcentajedescuento DECIMAL(10,2)
	)
	BEGIN
		-- Actualización en la tabla Campanha
		UPDATE Campanha
		SET idCampanha = _idCampanha,
			fechainicio = _fechainicio,
			fechafin = _fechafin,
			descripcion = _descripcion,
			estado = _estado,
            porcentajedescuento=_porcentajedescuento
		WHERE idCampanha = _idCampanha;
	END/