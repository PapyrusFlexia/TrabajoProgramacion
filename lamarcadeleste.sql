-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 20-05-2019 a las 12:53:04
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lamarcadeleste`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `poder` int(10) NOT NULL,
  `valor` int(5) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id` int(1) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `poder` int(3) NOT NULL,
  `valor` int(5) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id`, `nombre`, `poder`, `valor`, `estado`, `tipo`) VALUES
(11, 'vidamenor', 4, 30, 'normal', 'pocion'),
(12, 'vidamedia', 6, 60, 'normal', 'pocion'),
(13, 'vidamayor', 8, 80, 'normal', 'pocion'),
(1, 'espada', 2, 50, 'desequipado', 'arma'),
(2, 'mandoble', 3, 75, 'desequipado', 'arma'),
(3, 'espadon', 5, 150, 'desequipado', 'arma'),
(4, 'ultraespadon', 7, 200, 'desequipado', 'arma'),
(5, 'rompealbas', 10, 300, 'desequipado', 'arma'),
(6, 'tela', 1, 50, 'desequipado', 'armadura'),
(7, 'malla', 3, 100, 'desequipado', 'armadura'),
(8, 'placas', 5, 175, 'desequipado', 'armadura'),
(9, 'vidriagon', 7, 200, 'desequipado', 'armadura'),
(10, 'divina', 10, 300, 'desequipado', 'armadura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jefes`
--

CREATE TABLE `jefes` (
  `id` int(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `vida` int(10) NOT NULL,
  `ataque` varchar(5) NOT NULL,
  `vida total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `jefes`
--

INSERT INTO `jefes` (`id`, `nombre`, `vida`, `ataque`, `vida total`) VALUES
(1, 'Frikón Ululante', -2, '1d6', 1),
(2, 'Stefan', 3, '1d12', 6),
(3, 'Compañia robotizada hindú', 3, '1d16', 7),
(4, 'Camaleónidas', 3, '1d6', 19),
(5, 'Slackman', 3, '1d12', 11),
(6, 'El Hada ITS', 3, '1d16', 19),
(7, 'Ugandan Knuckles', 3, '1d6', 10),
(8, 'Padre Oso', 3, '1d12', 6),
(9, 'Shrek', 3, '1d16', 18),
(10, 'Shaggy', 3, '1d6', 15),
(11, 'Ricardo', 3, '1d12', 5),
(12, 'DIO', 3, '1d16', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `vida` int(9) NOT NULL,
  `ataque` varchar(5) NOT NULL,
  `vida total` int(10) NOT NULL,
  `oro` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `nombre`, `vida`, `ataque`, `vida total`, `oro`) VALUES
(1, 'xcv', 5, '1d4', 8, 45);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
