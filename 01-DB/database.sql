-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2023 a las 19:41:54
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0
CREATE DATABASE parking;
USE parking;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parking`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalculateTicketTotalWithCustomExitTimeAndExitDate` (IN `ticket_id` INT, IN `custom_exit_time` DATETIME)   BEGIN
  DECLARE entry_time DATETIME;
  DECLARE veh_category ENUM('camioneta', 'camion', 'carro', 'moto');
  DECLARE vehicle_rate DECIMAL(10, 2);
  DECLARE total_cost DECIMAL(10, 2);
  
  -- Obtener la hora de entrada del ticket
  SELECT entry_date INTO entry_time FROM ticket WHERE id = ticket_id;
  
  -- Obtener la categoría del vehículo del ticket
  SELECT v.category INTO veh_category
  FROM ticket AS t
  INNER JOIN vehicle AS v ON t.plate = v.plate
  WHERE t.id = ticket_id;
  
  -- Obtener la tarifa por hora para la categoría de vehículo desde la tabla 'parking'
  IF veh_category = 'camioneta' THEN
    SELECT camioneta INTO vehicle_rate FROM parking
    WHERE id = (SELECT parking_id FROM parking_seller WHERE id_parking_seller = 
        (SELECT parking_id FROM ticket WHERE id = ticket_id));
  ELSEIF veh_category = 'camion' THEN
    SELECT camion INTO vehicle_rate FROM parking
    WHERE id = (SELECT parking_id FROM parking_seller WHERE id_parking_seller = 
        (SELECT parking_id FROM ticket WHERE id = ticket_id));
  ELSEIF veh_category = 'carro' THEN
    SELECT carro INTO vehicle_rate FROM parking
    WHERE id = (SELECT parking_id FROM parking_seller WHERE id_parking_seller = 
        (SELECT parking_id FROM ticket WHERE id = ticket_id));
  ELSE
    SELECT moto INTO vehicle_rate FROM parking
    WHERE id = (SELECT parking_id FROM parking_seller WHERE id_parking_seller = 
        (SELECT parking_id FROM ticket WHERE id = ticket_id));
  END IF;
  
  -- Calcular el costo total en función de la diferencia entre la hora de entrada y la hora de salida personalizada
  SET total_cost = CEIL(TIMESTAMPDIFF(SECOND, entry_time, custom_exit_time) / 3600) * vehicle_rate;
  
  -- Actualizar la hora de salida y el campo 'total' en la tabla 'ticket'
  UPDATE ticket SET exit_date = custom_exit_time, total = total_cost WHERE id = ticket_id;
  
END$$

DELIMITER ;
-----------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE InsertRandomParkings(rowsToInsert INT)
BEGIN
    DECLARE counter INT DEFAULT 0;
    DECLARE parkingName VARCHAR(45);
    DECLARE nameExists INT;

    WHILE counter < rowsToInsert DO
        -- Genera un nombre aleatorio "parking_i"
        SET parkingName = CONCAT('parking_', FLOOR(RAND() * 1000000));

        -- Verifica si el nombre ya existe en la tabla
        SELECT COUNT(*) INTO nameExists FROM parking WHERE name = parkingName;

        IF nameExists = 0 THEN
            INSERT INTO parking (name, address, camioneta, camion, carro, moto, status)
            SELECT
                parkingName,
                SUBSTRING(UUID(), 1, 12),
                FLOOR(RAND() * 4000),   -- Valor para camioneta
                FLOOR(RAND() * 10000),   -- Valor para camion
                FLOOR(RAND() * 3000),   -- Valor para carro
                FLOOR(RAND() * 1000),   -- Valor para moto
                IF(RAND() > 0.5, 'activo', 'inactivo');

            SET counter = counter + 1;
        END IF;
    END WHILE;
END $$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parking`
--

CREATE TABLE `parking` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `camioneta` int(11) DEFAULT NULL,
  `camion` int(11) DEFAULT NULL,
  `carro` int(11) DEFAULT NULL,
  `moto` int(11) DEFAULT NULL,
  `status` enum('activo','inactivo') NOT NULL DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `parking`
--

INSERT INTO `parking` (`id`, `name`, `address`, `camioneta`, `camion`, `carro`, `moto`, `status`) VALUES
(1, 'de la esquina', 'aqui', 100, 200, 30, 100, 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parking_seller`
--

CREATE TABLE `parking_seller` (
  `id_parking_seller` int(11) NOT NULL,
  `parking_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `parking_seller`
--

INSERT INTO `parking_seller` (`id_parking_seller`, `parking_id`, `user_id`) VALUES
(1, 1, 888),
(2, 1, 777);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `parking_id` int(11) NOT NULL,
  `plate` varchar(6) NOT NULL,
  `entry_date` datetime NOT NULL DEFAULT current_timestamp(),
  `exit_date` datetime DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `status` enum('activo','inactivo') NOT NULL DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `parking_id`, `plate`, `entry_date`, `exit_date`, `total`, `status`) VALUES
(1, 1, '12345', '2023-10-12 13:46:51', '2023-12-11 16:30:00', 288600, 'activo'),
(2, 2, '12345', '2023-10-12 13:46:51', '2023-12-11 16:30:00', 288600, 'inactivo'),
(3, 2, '12345', '2023-10-15 10:25:11', '2023-12-11 16:30:00', 275000, 'activo'),
(1236, 1, '12345', '2023-10-15 11:07:15', '2023-12-11 16:30:00', 274800, 'inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(250) NOT NULL,
  `rol` enum('admin','seller') NOT NULL DEFAULT 'seller',
  `status` enum('activo','inactivo') NOT NULL DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `rol`, `status`) VALUES
(777, 'jeffry-gym', 'jefryne88@gmail.com', '$2y$10$.LoHrb62oXUyoTUp8HXj/eGZA7GG0kk5tFQi08kFA0/l5l20LMNai', 'seller', 'activo'),
(888, 'carlos nunez', 'superadmin@gmail.com', '$2y$10$tAwPjiTO8EkL9Ri0sW70o.b.MvW/v1XiyqOFoyq/aHWkT7xKpQtSK', 'admin', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle`
--

CREATE TABLE `vehicle` (
  `plate` varchar(6) NOT NULL,
  `name_owner` varchar(45) NOT NULL,
  `category` enum('camioneta','camion','carro','moto') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehicle`
--

INSERT INTO `vehicle` (`plate`, `name_owner`, `category`) VALUES
('12345', 'JEFFRY', 'camion');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `parking`
--
ALTER TABLE `parking`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `parking_seller`
--
ALTER TABLE `parking_seller`
  ADD PRIMARY KEY (`id_parking_seller`),
  ADD KEY `parking_id` (`parking_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parking_id` (`parking_id`),
  ADD KEY `plate` (`plate`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`plate`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `parking`
--
ALTER TABLE `parking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `parking_seller`
--
ALTER TABLE `parking_seller`
  MODIFY `id_parking_seller` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1237;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `parking_seller`
--
ALTER TABLE `parking_seller`
  ADD CONSTRAINT `parking_seller_ibfk_1` FOREIGN KEY (`parking_id`) REFERENCES `parking` (`id`),
  ADD CONSTRAINT `parking_seller_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`parking_id`) REFERENCES `parking_seller` (`id_parking_seller`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`plate`) REFERENCES `vehicle` (`plate`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CALL InsertRandomParkings(9);
