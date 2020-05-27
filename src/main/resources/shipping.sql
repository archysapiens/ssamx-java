-- Script que inserta registrops para la tabla shipping.
-- Fecha: 19-may-2020

-- Limpia tabla.

TRUNCATE TABLE   `spring`.`shipping` ;

--Prepara los parametros de incremento e insercion

SET @MAX_QUESTIONS=0;
FLUSH PRIVILEGES;

SET @row := 0;

// Inserta los registros

INSERT INTO shipping
SELECT @row := @row + 1 AS id,
  b.`anio`,
  CURDATE() AS assign_date,
	b.`id` id_period,
	c.id id_files,
	a.`id` id_state,
       b.`qna`,
     NULL AS shipping_tag,
  NULL AS staging_d,
  NULL AS staging_t,
  'A' AS stat,
   NULL AS update_date
FROM  `spring`.`states` a , `spring`.`periods` b,  `spring`.`files` c 
WHERE c.id=5 ;

COMMIT;



SELECT 
  `id`,
  `anio`,
  `assign_date`,
  `id_files`,
  `id_period`,
  `id_state`,
  `qna`,
  `shipping_tag`,
  `staging_d`,
  `staging_t`,
  `stat`,
  `update_date` 
FROM
  `spring`.`shipping` 
	LIMIT 0, 2000 ;

