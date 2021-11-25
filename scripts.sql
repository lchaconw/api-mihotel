Scripts SQL

CREATE TABLE `test`.`persona` ( `id_persona` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(50) NOT NULL , `apellido` VARCHAR(50) NOT NULL , `email` VARCHAR(50) NOT NULL , `telefono` INT NOT NULL , PRIMARY KEY (`id_persona`)) ENGINE = InnoDB;
INSERT INTO `persona` (`id_persona`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, 'Alberto', 'Perez', 'albert@mail.com', '54089489'), (NULL, 'Sarah', 'Castillo', 'sarah@mail.com', '89748546')


CREATE TABLE `test`.`agendamiento` ( `id_agendamiento` INT NOT NULL AUTO_INCREMENT , `id_cliente` INT NOT NULL , `acompanantes` INT NOT NULL , `fecha_ingreso` DATE NOT NULL , `dias_reserva` INT NOT NULL , `plan_todo_Incluido` INT NOT NULL, PRIMARY KEY (`id_agendamiento`)) ENGINE = InnoDB;
INSERT INTO `agendamiento` (`id_agendamiento`, `id_cliente`, `acompanantes`, `fecha_ingreso`, `dias_reserva`, `plan_todo_Incluido`) VALUES (NULL, '1', '4', '2021-11-16', '4', '0'), (NULL, '2', '6', '2021-11-24', '6', '1')


CREATE TABLE `test`.`servicio` ( `id_servicio` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(50) NOT NULL , `CANTIDAD` INT NOT NULL , `id_agendamiento` INT NOT NULL , `precio` INT NOT NULL , PRIMARY KEY (`id_servicio`)) ENGINE = InnoDB;
INSERT INTO `servicio` (`id_servicio`, `nombre`, `precio`, `id_agendamiento`, `cantidad`) VALUES (NULL, 'SPA', '10000', '1', '4'), (NULL, 'RESTAURANTE', '30000', '1', '10'), (NULL, 'GYM', '15000', '1', '4'), (NULL, 'SPA', '10000', '2', '3'), (NULL, 'RESTAURANTE', '30000', '2', '15'), (NULL, 'GYM', '15000', '2', '7')


CREATE TABLE `test`.`acompanantes` ( `id_acompanante` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(50) NOT NULL , `id_agendamiento` INT NOT NULL , PRIMARY KEY (`id_acompanante`)) ENGINE = InnoDB;
INSERT INTO `acompanantes` (`id_acompanante`, `nombre`, `id_agendamiento`) VALUES (NULL, 'Edisson', '1'), (NULL, 'Alberto', '1'), (NULL, 'Cristian', '1'), (NULL, 'Sarah', '1'),
	(NULL, 'Pepe', '2'), (NULL, 'Sofia', '2'), (NULL, 'Silvia', '2'), (NULL, 'Jorge', '2'), (NULL, 'Luis', '2'), (NULL, 'Tomas', '2')