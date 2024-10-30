DROP PROCEDURE IF EXISTS insertarSede;
DELIMITER /
CREATE PROCEDURE insertarSede(
  OUT _idLocal INT,
  IN _direccion VARCHAR(45),
  IN _nombre VARCHAR(45),
  IN _aforo INT,
  IN _activo TINYINT
  )
  BEGIN
	INSERT INTO Local(direccion,activo) 
    VALUES (_direccion,_activo);
	SET _idLocal = @@LAST_INSERT_ID;
    INSERT INTO Sede(idSede,nombre,aforo) VALUES (_idLocal,_nombre,_aforo);
  END/
  
  
  DROP PROCEDURE IF EXISTS eliminarSede;
	DELIMITER /   
    CREATE PROCEDURE eliminarSede(
		IN _idLocal INT
    )
    BEGIN
		-- Primero eliminar de la tabla Sede
		DELETE FROM Sede WHERE idSede = _idLocal;
		-- Luego eliminar de la tabla Local
		DELETE FROM Local WHERE idLocal= _idLocal;
    END/
    
    DROP PROCEDURE IF EXISTS obtenerSedeId;
	DELIMITER /   
    CREATE PROCEDURE obtenerSedeId(
		IN _idLocal INT
    )
    BEGIN
		SELECT loc.direccion
        FROM Local loc
        INNER JOIN Sede sed ON loc.idLocal = sed.idSede
        WHERE loc.idLocal=_idLocal;
    END/
    

DROP PROCEDURE IF EXISTS actualizarSede;
  DELIMITER /
	CREATE PROCEDURE actualizarSede(
    IN _idLocal INT,
	IN _direccion VARCHAR(45),
	IN _nombre VARCHAR(45),
	IN _aforo INT
	)
	BEGIN
		-- Actualización en la tabla Local
		UPDATE Local
		SET direccion = _direccion
		WHERE idLocal = _idLocal;

		-- Actualización en la tabla Sede
		UPDATE Sede
		SET nombre = _nombre,
			aforo = _aforo
		WHERE idSede = _idLocal;
	END/
    
    
    DROP PROCEDURE IF EXISTS listarSedes;
	DELIMITER /   
    CREATE PROCEDURE listarSedes(
    )
    BEGIN
		SELECT loc.direccion
        FROM Local loc
        INNER JOIN Sede sed ON loc.idLocal = sed.idSede;
    END/
    

DROP PROCEDURE IF EXISTS obtenerSedeId;
DELIMITER /   
CREATE PROCEDURE obtenerSedeId(
    IN _idLocal INT
)
BEGIN
    SELECT 
        loc.idLocal, 
        loc.direccion, 
        sed.nombre, 
        sed.aforo,
        sr.idStockRecurso, 
        sr.stock, 
        sr.fidRecurso
    FROM 
        Local loc
    INNER JOIN 
        Sede sed ON loc.idLocal = sed.idSede
    LEFT JOIN 
        StockRecurso sr ON loc.idLocal = sr.fidLocal
    WHERE 
        loc.idLocal = _idLocal;
END/

    
    