-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-09-2016 a las 13:27:03
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdmeraso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alicuota`
--

CREATE TABLE IF NOT EXISTS `alicuota` (
  `codigoAlicuota` int(11) NOT NULL,
  `valor` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `porcentaje` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `alicuota`
--

INSERT INTO `alicuota` (`codigoAlicuota`, `valor`, `porcentaje`) VALUES
(1, '0', '0.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE IF NOT EXISTS `caja` (
  `fecha` date NOT NULL,
  `turno` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `totalEstudio` decimal(10,2) NOT NULL,
  `codigoSolicitud` int(11) NOT NULL,
  `nombrePaciente` varchar(70) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaestudio`
--

CREATE TABLE IF NOT EXISTS `categoriaestudio` (
  `codigoCategoria` int(11) NOT NULL,
  `nombreCategoria` varchar(60) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `categoriaestudio`
--

INSERT INTO `categoriaestudio` (`codigoCategoria`, `nombreCategoria`) VALUES
(1, 'ESTUDIOS ESPECIALES PEDIATRICOS'),
(2, 'RESPIRATORIO Y CARDIOVASCULAR'),
(3, 'CRANEO Y CARA'),
(4, 'ESQUELETO Y COLUMNA'),
(5, 'MIEMBROS SUPERIORES'),
(6, 'MIEMBROS INFERIORES'),
(7, 'ABDOMEN DIGESTIVO'),
(8, 'GENOTOURINARIO Y EMBARAZO'),
(9, 'ECOSONOGRAMAS'),
(10, 'EQUIPOS Y CONTRASTES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallesolicitud`
--

CREATE TABLE IF NOT EXISTS `detallesolicitud` (
`numeroDetalle` int(11) NOT NULL,
  `numero_solicitud` int(11) NOT NULL,
  `numeroEstudio` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudio`
--

CREATE TABLE IF NOT EXISTS `estudio` (
  `codigoEstudio` int(11) NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `codigoCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estudio`
--

INSERT INTO `estudio` (`codigoEstudio`, `nombre`, `precio`, `codigoCategoria`) VALUES
(1, 'TORAX PA', '208.00', 2),
(2, 'HON. MED. Y TEC. TORAX PA', '4792.00', 2),
(3, 'TORAX PA Y LATERAL', '247.00', 2),
(4, 'HON. MED. Y TEC. TORAX PA Y LATERAL', '5753.00', 2),
(5, 'TORAX PA LAT. Y OSEO', '325.00', 2),
(6, 'HON. MED. Y TEC. TORAX PA LAT. O.', '1475.00', 2),
(7, 'TORAX OSEO', '486.00', 2),
(8, 'HON. MED. Y TEC. TORAX OSEO', '6314.00', 2),
(9, 'ESTERNON PA Y LAT.', '247.00', 2),
(10, 'HON. MED. Y TEC. ESTERNO PA Y LAT.', '4953.00', 2),
(11, 'CRANEO 2P', '247.00', 3),
(12, 'HON. MED. Y TEC. CRANEO 2P', '5753.00', 3),
(13, 'CRANEO 3P', '286.00', 3),
(14, 'HON. MED. Y TEC. CRANEO 3P', '6214.00', 3),
(15, 'CRANEO 4P', '326.00', 3),
(16, 'HON. MED. Y TEC. CRANEO 4P', '7174.00', 3),
(17, 'CRANEO PARA SILLA TURCA', '325.00', 3),
(18, 'HON. MED. Y TEC. CRANEO SILLA TURCA.', '7175.00', 3),
(19, 'SENOS PARANASALES', '325.00', 3),
(20, 'HON. MED. Y TEC. SENOS PARANASALES', '7175.00', 3),
(21, 'RINOFARINGES O ADENOIDES', '247.00', 3),
(22, 'HON. MED. Y TEC. RINOFARINGES O ADENOIDES', '7253.00', 3),
(23, 'HUESOS PROPIOS NASALES', '286.00', 3),
(24, 'HON. MED. Y TEC. HUESOS P. NASALES', '6714.00', 3),
(25, 'COLUMNA CERV. AP L', '247.00', 4),
(26, 'HON. MED. Y TEC. COL. CERV. AP Y L', '7253.00', 4),
(27, 'COL. CERV. AP LAT Y OBLICUO', '325.00', 4),
(28, 'HON. MED. Y TEC. COL CERV AP L Y O', '8175.00', 4),
(29, 'COL. CERVICAL AP Y LAT. OBL. DIN', '403.00', 4),
(30, 'HON. MED. Y TEC. COL. CERV. AP LAT. O. DIN.', '7097.00', 4),
(31, 'COL. DOR. AP  Y LAT', '325.00', 4),
(32, 'HON. MED. Y TEC. COL. DOR. AP Y LAT', '0.00', 4),
(33, 'COL. DOR. LUM. AP Y LAT', '403.00', 4),
(34, 'HON. MED. Y TEC. COL. DOR. AP Y LAT', '9597.00', 4),
(35, 'COL.. DOR. LUM. AP LAT Y OBL.', '403.00', 4),
(36, 'HON. MED. Y TEC. COL. DOR. LUM AP LAT Y OB.', '9597.00', 4),
(37, 'COL. DOR. LUM ESCOLIOSIS 1', '247.00', 4),
(38, 'HON. MED. Y TEC. COL. DOR. LUM. ESCOLIOSIS 1', '7253.00', 4),
(39, 'COL. DOR. LUM ESCOLIOSIS 2', '243.00', 4),
(40, 'HON. MED. Y TEC.  ESCOLIOSIS 2', '8257.00', 4),
(41, 'COL LUM. SACRA AP Y LAT', '325.00', 4),
(42, 'HON. MED. Y TEC.  COL LUM. SACRA AP Y LAT', '7175.00', 4),
(43, 'COL LUM SACRA AP LAT Y OBLICUA', '325.00', 4),
(44, 'HON. MED. Y TEC. COL. LUM. SACRA AP LAT Y OB.', '8175.00', 4),
(45, 'COL LUM SACRA AP Y LAT OB. DIN', '403.00', 4),
(46, 'HON. MED. Y TEC. COL. LUM. SAC. AP Y L O DIN', '9097.00', 4),
(47, 'COL. LUM. SACRA EN BENGI', '403.00', 4),
(48, 'HON. MED. Y TEC.  COL LUM. SACRA EN BENGI', '7597.00', 4),
(49, 'SACRO COXIS AP Y LAT', '325.00', 4),
(50, 'HON. MED. Y TEC.  SACRO COSIS AP Y LAT', '7175.00', 4),
(51, 'PELVIS O CADERA AP', '208.00', 4),
(52, 'HON. MED. Y TEC.  PELVIS O CADERA AP', '5292.00', 4),
(53, 'CADERA AP Y OBLICUO', '208.00', 4),
(54, 'HON. MED. Y TEC.  CADERA AP Y OBLICUO', '6253.00', 4),
(55, 'CADERA AP- RANA Y LUX', '247.00', 4),
(56, 'HON. MED. Y TEC. CAD. AP- RANA Y LUX', '6253.00', 4),
(57, 'ART SACRO ILIACAS', '325.00', 4),
(58, 'HON. MED. Y TEC.  ART SACRO ILIACAS', '2475.00', 4),
(59, 'ART COXOFEMORAL UNILATERAL', '247.00', 4),
(60, 'HON. MED. Y TEC. ART COXOFEMORAL UNIL', '1553.00', 4),
(61, 'ART COXOFEMORAL BILATERAL', '325.00', 4),
(62, 'HON. MED. Y TEC.  ART COXOFEMORAL BIL', '2275.00', 4),
(63, 'CLAVICULA 2P', '247.00', 5),
(64, 'HON. MED. Y TEC. CLAVICULA 2P', '5753.00', 5),
(65, 'AMBAS CLAVICULAS 2P', '325.00', 5),
(66, 'HON. MED. Y TEC. AMBAS CLAVICULAS 2P', '7675.00', 5),
(67, 'HOMBRO 3P', '403.00', 5),
(68, 'HON. MED. Y TEC.  HOMBRO 3P', '7097.00', 5),
(69, 'AMBOS HOMBROS 3P C/U', '0.00', 5),
(70, 'HON. MED. Y TEC.  AMBOS HOMBROS 3P C/U', '9500.00', 5),
(71, 'HOMBRO 1P', '208.00', 5),
(72, 'HON. MED. Y TEC. HOMBRO 1P', '208.00', 5),
(73, 'HON. MED. Y TEC. HOMBRO 1P', '4792.00', 5),
(74, 'HOMBRO 2P', '0.00', 5),
(75, 'HON. MED. Y TEC. HOMBRO 2P', '6000.00', 5),
(76, 'HOMBRO 5P', '325.00', 5),
(77, 'HON. MED. Y TEC. HOMBRO 5P', '9675.00', 5),
(78, 'ESCAPULA 2P', '247.00', 5),
(79, 'HON. MED. Y TEC. ESCAPULA 2P', '7553.00', 5),
(80, 'AMBAS ESCAPULAS 2P C/U', '325.00', 5),
(81, 'HON. MED. Y TEC. AMBAS ESCAPULAS 2P C/U', '8675.00', 5),
(82, 'HUMERO 2P', '247.00', 5),
(83, 'AMBOS HUMEROS 2P', '325.00', 5),
(84, 'HON. MED. Y TEC. AMBOS HUMEROS 2P C/U', '7675.00', 5),
(85, 'HON. MED. Y TEC. HUMERO 2P', '6253.00', 5),
(86, 'CODO 2P', '247.00', 5),
(87, 'HON. MED. Y TEC. CODO 2P', '5253.00', 5),
(88, 'AMBOS CODOS 2P', '247.00', 5),
(89, 'HON. MED. Y TEC. AMBOS CODOS 2P', '7675.00', 5),
(90, 'ANTEBRAZO 2P', '247.00', 5),
(91, 'HON. MED. Y TEC. ANTEBRAZO 2P', '5753.00', 5),
(92, 'AMBOS ANTEBRAZOS 2P C/U', '325.00', 5),
(93, 'HON. MED. Y TEC. AMBOS ANTEBRAZOS 2P C/U', '7675.00', 5),
(94, 'MUÑECA 2P', '247.00', 5),
(95, 'HON. MED. Y TEC. MUÑECA 2P', '5753.00', 5),
(96, 'AMBAS MUÑECAS 2P C/U', '325.00', 5),
(97, 'HON. MED. Y TEC. AMBAS MUÑECAS 2P C/U', '7675.00', 5),
(98, 'MANO 2P', '247.00', 5),
(99, 'HON. MED. Y TEC. MANO 2P', '5753.00', 5),
(100, 'AMBAS MANOS 2P', '325.00', 5),
(101, 'HON. MED. Y TEC. AMBAS MANOS 2P ', '7675.00', 5),
(102, 'AMBAS MANOS AP', '208.00', 5),
(103, 'HON. MED. Y TEC. AMBAS MANOS AP', '5792.00', 5),
(104, 'MANO EDAD OSEA', '208.00', 5),
(105, 'HON. MED. Y TEC. MANO EDAD OSEA', '5292.00', 5),
(106, 'DEDO 2P', '247.00', 5),
(107, 'HON. MED. Y TEC. DEDO 2P', '5653.00', 5),
(108, 'AMPLIACION DE MANO 1P', '208.00', 5),
(109, 'HON. MED. Y TEC.  AMPLIACION DE MANO 1P', '5792.00', 5),
(110, 'FEMUR 2P', '247.00', 6),
(111, 'HON. MED. Y TEC. FEMUR 2P', '6253.00', 6),
(112, 'AMBOS FEMURES 2P C/U', '325.00', 6),
(113, 'HON. MED. Y TEC. AMBOS FEMURES 2P C/U ', '8175.00', 6),
(114, 'RODILLA AP Y LATERAL', '247.00', 6),
(115, 'HON. MED. Y TEC. RODILLA AP Y LATERAL', '6253.00', 6),
(116, 'AMBAS RODILLAS 2P C/U', '8175.00', 6),
(117, 'ROTULA 1P', '208.00', 6),
(118, 'HON. MED. Y TEC. ROTULA 1P', '5792.00', 6),
(119, 'ROTULA 2P', '247.00', 6),
(120, 'HON. MED. Y TEC.  ROTULA 2P', '6253.00', 6),
(121, 'ROTULA 3P', '247.00', 6),
(122, 'HON. MED. Y TEC. ROTULA 3P', '6753.00', 6),
(123, 'AMBAS ROTULAS 3P C/U', '325.00', 6),
(124, 'HON. MED. Y TEC. AMBAS ROTULAS 3P C/U', '8175.00', 6),
(125, 'PIERNA', '247.00', 6),
(126, 'HON. MED. Y TEC. PIERNA 2P', '6253.00', 6),
(127, 'AMBAS PIERNAS 2P C/U', '325.00', 6),
(128, 'HON. MED. Y TEC. AMBAS PIERNAS 2P C/U', '8175.00', 6),
(129, 'TOBILLO 2P', '247.00', 6),
(130, 'HON. MED. Y TEC. TOBILLO 2P', '5753.00', 6),
(131, 'AMBOS TOBILLOS 2P C/U', '7675.00', 6),
(132, 'TOBILLO 3P', '247.00', 6),
(133, 'HON. MED. Y TEC. TOBILLO 3P', '6753.00', 6),
(134, 'CALCANEO 2P', '247.00', 6),
(135, 'HON. MED. Y TEC. CALCANEO 2P', '5753.00', 6),
(136, 'AMBOS CALCANEOS ', '325.00', 6),
(137, 'HON. MED. Y TEC. AMBOS CALCANEOS', '7675.00', 6),
(138, 'PIE 2P', '247.00', 6),
(139, 'HON. MED. Y TEC. PIE 2P', '5753.00', 6),
(140, 'AMBOS PIES 2P C/U', '325.00', 6),
(141, 'HON. MED. Y TEC. AMBOS PIES 2P C/U', '7675.00', 6),
(142, 'MEDICION DE MIEMBROS INFERIORES', '325.00', 6),
(143, 'HON. MED. Y TEC. MEDICION DE MIEMBROS INFERIORES', '8675.00', 6),
(144, 'PANORAM. MIEMBROS INFERIORES INFANTES', '325.00', 6),
(145, 'HON. MED. Y TEC. PAN. MIEMBROS INFERIORES INFANTES', '7675.00', 6),
(146, 'AMBOS PIES 2P C/U CON APOYO', '0.00', 6),
(147, 'HON. MED. Y TEC. AMBOS PIES 2P C/U CON APOYO', '8500.00', 6),
(148, 'ABDOMEN SIMPLRE', '208.00', 7),
(149, 'HON. MED. Y TEC. ABDOMEN SIMPLE', '4792.00', 7),
(150, 'ABDOMEN SIMPLE DE PIE Y ACOSTADO', '325.00', 7),
(151, 'HON. MED. Y TEC. ABDOMEN. SIMP. DE PIE Y ACOSTADO', '6175.00', 7),
(152, 'ESOFAGO ESTOMAGO Y DUODENO ADULTO', '19900.00', 7),
(153, 'TRANSITO INTESTINAL ADULTO', '19900.00', 7),
(154, 'COLON POR ENEMA', '21100.00', 7),
(155, 'COLON POR ENEMA POR COLOSTOMIA', '23700.00', 7),
(156, 'ESOFAGOGRAMA', '15900.00', 7),
(157, 'FISTULOGRAFIA', '15900.00', 7),
(158, 'URETROCISTOGRAFIA RETROGRADA', '19700.00', 7),
(159, 'PELVIMETRI CON EDAD OSEA FETAL', '475.00', 8),
(160, 'HON. MED. Y TEC. PELVIMETRIA CON EDAD OSEA FETAL', '7525.00', 8),
(161, 'HISTEROSALPINGOGRAFIA 5P', '19700.00', 8),
(162, 'UROGRAFIA CON TOMOGRAFIA INCLUIDA 6P', '19900.00', 8),
(163, 'CISTOGRAFIA 4P', '19900.00', 8),
(164, 'URETROCISTOGRAFIA', '19700.00', 8),
(165, 'ESOFAGO PEDIATRICO 4P', '20900.00', 1),
(166, 'ESOFAGO ESTOMAGO Y DUODENO PED.', '20900.00', 1),
(167, 'TRANSITO INTESTINAL PEDIATRICO', '20600.00', 1),
(168, 'COLON POR ENEMA PEDIATRICO', '20600.00', 1),
(169, 'UROGRAFIA DE ELIMINACION PEDIATRICA', '20900.00', 1),
(170, 'URETROCISTOGRAFIA PEDIATRICA', '20900.00', 1),
(171, 'CISTROGRAFIA PEDIATRICA', '20700.00', 1),
(172, 'TRANSITO + E.E.D', '20900.00', 1),
(173, 'BARIO ORAL', '1100.00', 10),
(174, 'EQUIPO DE COLON POR ENEMA', '1400.00', 10),
(175, 'CONSTRASTE HIDROSOLUBLE', '1300.00', 10),
(176, 'ULTRASONIDO GINECOLOGICO', '7500.00', 9),
(177, 'ULTRASONIDO ABDOMINAL', '7500.00', 9),
(178, 'ULTRASONIDO OBSTETRICO', '7500.00', 9),
(179, 'ULTRASONIDO  RENAL', '7500.00', 9),
(180, 'ULTRASONIDO MAMARIO', '7500.00', 9),
(181, 'ULTRASONIDO TIROIDEO', '7500.00', 9),
(182, 'ULTRASONIDO  PAROTIDEO', '7500.00', 9),
(183, 'ULTRASONIDO TESTICULAR', '7500.00', 9),
(184, 'ULTRASONIDO PROSTATICO', '7500.00', 9),
(185, 'ULTRASONIDO PELVICO', '7500.00', 9),
(186, 'ULTRASONIDO PARTES BLANDAS', '7500.00', 9),
(187, 'ULTRASONIDO TRANSVAGINAL', '7500.00', 9),
(188, 'ULTRASONIDO TRANSRECTAL', '7500.00', 9),
(189, 'ULTRASONIDO FONTANELARES', '7500.00', 9),
(190, 'ULTRASONIDO TORAXICO', '7500.00', 9),
(191, 'ULTRASONIDO  ABDOMINAL', '7500.00', 9),
(192, 'ULTRASONIDO  PELVICO', '7500.00', 9),
(193, 'ULTRASONIDO  CEREBRAL', '7500.00', 9),
(194, 'ULTRASONIDO ABDOM/ENFASIS RENAL', '7500.00', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudioinstitucion`
--

CREATE TABLE IF NOT EXISTS `estudioinstitucion` (
  `numeroEstudio` int(11) NOT NULL,
  `codigoEstudios` int(11) NOT NULL,
  `codigoOrganizacion` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `precios` decimal(10,2) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estudioinstitucion`
--

INSERT INTO `estudioinstitucion` (`numeroEstudio`, `codigoEstudios`, `codigoOrganizacion`, `nombre`, `precios`, `categoria`) VALUES
(1, 1, 1, 'TORAX PA', '208.00', 2),
(2, 2, 1, 'HON. MED. Y TEC. TORAX PA', '4792.00', 2),
(3, 3, 1, 'TORAX PA Y LATERAL', '247.00', 2),
(4, 4, 1, 'HON. MED. Y TEC. TORAX PA Y LATERAL', '5753.00', 2),
(5, 5, 1, 'TORAX PA LAT. Y OSEO', '325.00', 2),
(6, 6, 1, 'HON. MED. Y TEC. TORAX PA LAT. O.', '1475.00', 2),
(7, 7, 1, 'TORAX OSEO', '486.00', 2),
(8, 8, 1, 'HON. MED. Y TEC. TORAX OSEO', '6314.00', 2),
(9, 9, 1, 'ESTERNON PA Y LAT.', '247.00', 2),
(10, 10, 1, 'HON. MED. Y TEC. ESTERNON PA Y LAT.', '4953.00', 2),
(11, 11, 1, 'CRANEO 2P', '247.00', 3),
(12, 12, 1, 'HON. MED. Y TEC. CRANEO 2P', '5753.00', 3),
(13, 13, 1, 'CRANEO 3P', '286.00', 3),
(14, 14, 1, 'HON. MED. Y TEC. CRANEO 3P', '6214.00', 3),
(15, 15, 1, 'CRANEO 4P', '326.00', 3),
(16, 16, 1, 'HON. MED. Y TEC. CRANEO 4P', '7174.00', 3),
(17, 17, 1, 'CRANEO PARA SILLA TURCA', '325.00', 3),
(18, 18, 1, 'HON. MED. Y TEC. CRANEO SILLA TURCA.', '7175.00', 3),
(19, 19, 1, 'SENOS PARANASALES', '325.00', 3),
(20, 20, 1, 'HON. MED. Y TEC. SENOS PARANASALES', '7175.00', 3),
(21, 21, 1, 'RINOFARINGES O ADENOIDES', '247.00', 3),
(22, 22, 1, 'HON. MED. Y TEC. RINOFARINGES O ADENOIDES', '7253.00', 3),
(23, 23, 1, 'HUESOS PROPIOS NASALES', '286.00', 3),
(24, 24, 1, 'HON. MED. Y TEC. HUESOS P. NASALES', '6714.00', 3),
(25, 25, 1, 'COLUMNA CERV. AP L', '247.00', 4),
(26, 26, 1, 'HON. MED. Y TEC. COL. CERV. AP Y L', '7253.00', 4),
(27, 27, 1, 'COL. CERV. AP LAT Y OBLICUO', '325.00', 4),
(28, 28, 1, 'HON. MED. Y TEC. COL CERV AP L Y O', '8175.00', 4),
(29, 29, 1, 'COL. CERVICAL AP Y LAT. OBL. DIN', '403.00', 4),
(30, 30, 1, 'HON. MED. Y TEC. COL. CERV. AP LAT. O. DIN.', '7097.00', 4),
(31, 31, 1, 'COL. DOR. AP  Y LAT', '325.00', 4),
(32, 32, 1, 'HON. MED. Y TEC. COL. DOR. AP Y LAT', '0.00', 4),
(33, 33, 1, 'COL. DOR. LUM. AP Y LAT', '403.00', 4),
(34, 34, 1, 'HON. MED. Y TEC. COL. DOR. AP Y LAT', '9597.00', 4),
(35, 35, 1, 'COL.. DOR. LUM. AP LAT Y OBL.', '403.00', 4),
(36, 36, 1, 'HON. MED. Y TEC. COL. DOR. LUM AP LAT Y OB.', '9597.00', 4),
(37, 37, 1, 'COL. DOR. LUM ESCOLIOSIS 1', '247.00', 4),
(38, 38, 1, 'HON. MED. Y TEC. COL. DOR. LUM. ESCOLIOSIS 1', '7253.00', 4),
(39, 39, 1, 'COL. DOR. LUM ESCOLIOSIS 2', '243.00', 4),
(40, 40, 1, 'HON. MED. Y TEC.  ESCOLIOSIS 2', '8257.00', 4),
(41, 41, 1, 'COL LUM. SACRA AP Y LAT', '325.00', 4),
(42, 42, 1, 'HON. MED. Y TEC.  COL LUM. SACRA AP Y LAT', '7175.00', 4),
(43, 43, 1, 'COL LUM SACRA AP LAT Y OBLICUA', '325.00', 4),
(44, 44, 1, 'HON. MED. Y TEC. COL. LUM. SACRA AP LAT Y OB.', '8175.00', 4),
(45, 45, 1, 'COL LUM SACRA AP Y LAT OB. DIN', '403.00', 4),
(46, 46, 1, 'HON. MED. Y TEC.  COL. LUM. SACRA AP Y LAT OB DIN', '9097.00', 4),
(47, 46, 1, 'HON. MED. Y TEC. COL. LUM. SAC. AP Y L O DIN', '9097.00', 4),
(48, 47, 1, 'COL. LUM. SACRA EN BENGI', '403.00', 4),
(49, 48, 1, 'HON. MED. Y TEC.  COL LUM. SACRA EN BENGI', '7597.00', 4),
(50, 49, 1, 'SACRO COXIS AP Y LAT', '325.00', 4),
(51, 50, 1, 'HON. MED. Y TEC.  SACRO COSIS AP Y LAT', '7175.00', 4),
(52, 51, 1, 'PELVIS O CADERA AP', '208.00', 4),
(53, 52, 1, 'HON. MED. Y TEC.  PELVIS O CADERA AP', '5292.00', 4),
(54, 53, 1, 'CADERA AP Y OBLICUO', '208.00', 4),
(55, 54, 1, 'HON. MED. Y TEC.  CADERA AP Y OBLICUO', '6253.00', 4),
(56, 55, 1, 'CADERA AP- RANA Y LUX', '247.00', 4),
(57, 56, 1, 'HON. MED. Y TEC. CAD. AP- RANA Y LUX', '6253.00', 4),
(58, 57, 1, 'ART SACRO ILIACAS', '325.00', 4),
(59, 58, 1, 'HON. MED. Y TEC.  ART SACRO ILIACAS', '2475.00', 4),
(60, 59, 1, 'ART COXOFEMORAL UNILATERAL', '247.00', 4),
(61, 60, 1, 'HON. MED. Y TEC. ART COXOFEMORAL UNIL', '1553.00', 4),
(62, 61, 1, 'ART COXOFEMORAL BILATERAL', '325.00', 4),
(63, 62, 1, 'HON. MED. Y TEC.  ART COXOFEMORAL BIL', '2275.00', 4),
(64, 63, 1, 'CLAVICULA 2P', '247.00', 5),
(65, 64, 1, 'HON. MED. Y TEC. CLAVICULA 2P', '5753.00', 5),
(66, 65, 1, 'AMBAS CLAVICULAS 2P', '325.00', 5),
(67, 66, 1, 'HON. MED. Y TEC. AMBAS CLAVICULAS 2P', '7675.00', 5),
(68, 67, 1, 'HOMBRO 3P', '403.00', 5),
(69, 68, 1, 'HON. MED. Y TEC.  HOMBRO 3P', '7097.00', 5),
(70, 69, 1, 'AMBOS HOMBROS 3P C/U', '0.00', 5),
(71, 70, 1, 'HON. MED. Y TEC.  AMBOS HOMBROS 3P C/U', '9500.00', 5),
(72, 71, 1, 'HOMBRO 1P', '208.00', 5),
(73, 72, 1, 'HON. MED. Y TEC. HOMBRO 1P', '208.00', 5),
(74, 73, 1, 'HON. MED. Y TEC. HOMBRO 1P', '4792.00', 5),
(75, 74, 1, 'HOMBRO 2P', '0.00', 5),
(76, 75, 1, 'HON. MED. Y TEC. HOMBRO 2P', '6000.00', 5),
(77, 76, 1, 'HOMBRO 5P', '325.00', 5),
(78, 77, 1, 'HON. MED. Y TEC. HOMBRO 5P', '9675.00', 5),
(79, 78, 1, 'ESCAPULA 2P', '247.00', 5),
(80, 79, 1, 'HON. MED. Y TEC. ESCAPULA 2P', '7553.00', 5),
(81, 80, 1, 'AMBAS ESCAPULAS 2P C/U', '325.00', 5),
(82, 81, 1, 'HON. MED. Y TEC. AMBAS ESCAPULAS 2P C/U', '8675.00', 5),
(83, 82, 1, 'HUMERO 2P', '247.00', 5),
(84, 83, 1, 'AMBOS HUMEROS 2P', '325.00', 5),
(85, 84, 1, 'HON. MED. Y TEC. AMBOS HUMEROS 2P C/U', '7675.00', 5),
(86, 85, 1, 'HON. MED. Y TEC. HUMERO 2P', '6253.00', 5),
(87, 86, 1, 'CODO 2P', '247.00', 5),
(88, 87, 1, 'HON. MED. Y TEC. CODO 2P', '5253.00', 5),
(89, 88, 1, 'AMBOS CODOS 2P', '247.00', 5),
(90, 89, 1, 'HON. MED. Y TEC. AMBOS CODOS 2P', '7675.00', 5),
(91, 90, 1, 'ANTEBRAZO 2P', '247.00', 5),
(92, 91, 1, 'HON. MED. Y TEC. ANTEBRAZO 2P', '5753.00', 5),
(93, 92, 1, 'AMBOS ANTEBRAZOS 2P C/U', '325.00', 5),
(94, 93, 1, 'HON. MED. Y TEC. AMBOS ANTEBRAZOS 2P C/U', '7675.00', 5),
(95, 94, 1, 'MUÑECA 2P', '247.00', 5),
(96, 95, 1, 'HON. MED. Y TEC. MUÑECA 2P', '5753.00', 5),
(97, 96, 1, 'AMBAS MUÑECAS 2P C/U', '325.00', 5),
(98, 97, 1, 'HON. MED. Y TEC. AMBAS MUÑECAS 2P C/U', '7675.00', 5),
(99, 98, 1, 'MANO 2P', '247.00', 5),
(100, 99, 1, 'HON. MED. Y TEC. MANO 2P', '5753.00', 5),
(101, 100, 1, 'AMBAS MANOS 2P', '325.00', 5),
(102, 101, 1, 'HON. MED. Y TEC. AMBAS MANOS 2P ', '7675.00', 5),
(103, 102, 1, 'AMBAS MANOS AP', '208.00', 5),
(104, 103, 1, 'HON. MED. Y TEC. AMBAS MANOS AP', '5792.00', 5),
(105, 104, 1, 'MANO EDAD OSEA', '208.00', 5),
(106, 105, 1, 'HON. MED. Y TEC. MANO EDAD OSEA', '5292.00', 5),
(107, 106, 1, 'DEDO 2P', '247.00', 5),
(108, 107, 1, 'HON. MED. Y TEC. DEDO 2P', '5653.00', 5),
(109, 108, 1, 'AMPLIACION DE MANO 1P', '208.00', 5),
(110, 109, 1, 'HON. MED. Y TEC.  AMPLIACION DE MANO 1P', '5792.00', 5),
(111, 110, 1, 'FEMUR 2P', '247.00', 6),
(112, 111, 1, 'HON. MED. Y TEC. FEMUR 2P', '6253.00', 6),
(113, 112, 1, 'AMBOS FEMURES 2P C/U', '325.00', 6),
(114, 113, 1, 'HON. MED. Y TEC. AMBOS FEMURES 2P C/U ', '8175.00', 6),
(115, 114, 1, 'RODILLA AP Y LATERAL', '247.00', 6),
(116, 115, 1, 'HON. MED. Y TEC. RODILLA AP Y LATERAL', '6253.00', 6),
(117, 116, 1, 'AMBAS RODILLAS 2P C/U', '8175.00', 6),
(118, 117, 1, 'ROTULA 1P', '208.00', 6),
(119, 118, 1, 'HON. MED. Y TEC. ROTULA 1P', '5792.00', 6),
(120, 119, 1, 'ROTULA 2P', '247.00', 6),
(121, 120, 1, 'HON. MED. Y TEC.  ROTULA 2P', '6253.00', 6),
(122, 121, 1, 'ROTULA 3P', '247.00', 6),
(123, 122, 1, 'HON. MED. Y TEC. ROTULA 3P', '6753.00', 6),
(124, 123, 1, 'AMBAS ROTULAS 3P C/U', '325.00', 6),
(125, 124, 1, 'HON. MED. Y TEC. AMBAS ROTULAS 3P C/U', '8175.00', 6),
(126, 125, 1, 'PIERNA', '247.00', 6),
(127, 126, 1, 'HON. MED. Y TEC. PIERNA 2P', '6253.00', 6),
(128, 127, 1, 'AMBAS PIERNAS 2P C/U', '325.00', 6),
(129, 128, 1, 'HON. MED. Y TEC. AMBAS PIERNAS 2P C/U', '8175.00', 6),
(130, 129, 1, 'TOBILLO 2P', '247.00', 6),
(131, 130, 1, 'HON. MED. Y TEC. TOBILLO 2P', '5753.00', 6),
(132, 131, 1, 'AMBOS TOBILLOS 2P C/U', '7675.00', 6),
(133, 132, 1, 'TOBILLO 3P', '247.00', 6),
(134, 133, 1, 'HON. MED. Y TEC. TOBILLO 3P', '6753.00', 6),
(135, 134, 1, 'CALCANEO 2P', '247.00', 6),
(136, 135, 1, 'HON. MED. Y TEC. CALCANEO 2P', '5753.00', 6),
(137, 136, 1, 'AMBOS CALCANEOS ', '325.00', 6),
(138, 137, 1, 'HON. MED. Y TEC. AMBOS CALCANEOS', '7675.00', 6),
(139, 138, 1, 'PIE 2P', '247.00', 6),
(140, 139, 1, 'HON. MED. Y TEC. PIE 2P', '5753.00', 6),
(141, 140, 1, 'AMBOS PIES 2P C/U', '325.00', 6),
(142, 141, 1, 'HON. MED. Y TEC. AMBOS PIES 2P C/U', '7675.00', 6),
(143, 142, 1, 'MEDICION DE MIEMBROS INFERIORES', '325.00', 6),
(144, 143, 1, 'HON. MED. Y TEC. MEDICION DE MIEMBROS INFERIORES', '8675.00', 6),
(145, 144, 1, 'PANORAM. MIEMBROS INFERIORES INFANTES', '325.00', 6),
(146, 145, 1, 'HON. MED. Y TEC. PAN. MIEMBROS INFERIORES INFANTES', '7675.00', 6),
(147, 146, 1, 'AMBOS PIES 2P C/U CON APOYO', '0.00', 6),
(148, 147, 1, 'HON. MED. Y TEC. AMBOS PIES 2P C/U CON APOYO', '8500.00', 6),
(149, 148, 1, 'ABDOMEN SIMPLRE', '208.00', 7),
(150, 149, 1, 'HON. MED. Y TEC. ABDOMEN SIMPLE', '4792.00', 7),
(151, 150, 1, 'ABDOMEN SIMPLE DE PIE Y ACOSTADO', '325.00', 7),
(152, 151, 1, 'HON. MED. Y TEC. ABDOMEN. SIMP. DE PIE Y ACOSTADO', '6175.00', 7),
(153, 152, 1, 'ESOFAGO ESTOMAGO Y DUODENO ADULTO', '19900.00', 7),
(154, 153, 1, 'TRANSITO INTESTINAL ADULTO', '19900.00', 7),
(155, 154, 1, 'COLON POR ENEMA', '21100.00', 7),
(156, 155, 1, 'COLON POR ENEMA POR COLOSTOMIA', '23700.00', 7),
(157, 156, 1, 'ESOFAGOGRAMA', '15900.00', 7),
(158, 157, 1, 'FISTULOGRAFIA', '15900.00', 7),
(159, 158, 1, 'URETROCISTOGRAFIA RETROGRADA', '19700.00', 7),
(160, 159, 1, 'PELVIMETRI CON EDAD OSEA FETAL', '475.00', 8),
(161, 160, 1, 'HON. MED. Y TEC. PELVIMETRIA CON EDAD OSEA FETAL', '7525.00', 8),
(162, 161, 1, 'HISTEROSALPINGOGRAFIA 5P', '19700.00', 8),
(163, 162, 1, 'UROGRAFIA CON TOMOGRAFIA INCLUIDA 6P', '19900.00', 8),
(164, 163, 1, 'CISTOGRAFIA 4P', '19900.00', 8),
(165, 164, 1, 'URETROCISTOGRAFIA', '19700.00', 8),
(166, 165, 1, 'ESOFAGO PEDIATRICO 4P', '20900.00', 1),
(167, 166, 1, 'ESOFAGO ESTOMAGO Y DUODENO PED.', '20900.00', 1),
(168, 167, 1, 'TRANSITO INTESTINAL PEDIATRICO', '20600.00', 1),
(169, 168, 1, 'COLON POR ENEMA PEDIATRICO', '20600.00', 1),
(170, 169, 1, 'UROGRAFIA DE ELIMINACION PEDIATRICA', '20900.00', 1),
(171, 170, 1, 'URETROCISTOGRAFIA PEDIATRICA', '20900.00', 1),
(172, 171, 1, 'CISTROGRAFIA PEDIATRICA', '20700.00', 1),
(173, 172, 1, 'TRANSITO + E.E.D', '20900.00', 1),
(174, 173, 1, 'BARIO ORAL', '1100.00', 10),
(175, 174, 1, 'EQUIPO DE COLON POR ENEMA', '1400.00', 10),
(176, 175, 1, 'CONSTRASTE HIDROSOLUBLE', '1300.00', 10),
(177, 176, 1, 'ULTRASONIDO GINECOLOGICO', '7500.00', 9),
(178, 177, 1, 'ULTRASONIDO ABDOMINAL', '7500.00', 9),
(179, 178, 1, 'ULTRASONIDO OBSTETRICO', '7500.00', 9),
(180, 179, 1, 'ULTRASONIDO  RENAL', '7500.00', 9),
(181, 180, 1, 'ULTRASONIDO MAMARIO', '7500.00', 9),
(182, 181, 1, 'ULTRASONIDO TIROIDEO', '7500.00', 9),
(183, 182, 1, 'ULTRASONIDO  PAROTIDEO', '7500.00', 9),
(184, 183, 1, 'ULTRASONIDO TESTICULAR', '7500.00', 9),
(185, 184, 1, 'ULTRASONIDO PROSTATICO', '7500.00', 9),
(186, 185, 1, 'ULTRASONIDO PELVICO', '7500.00', 9),
(187, 186, 1, 'ULTRASONIDO PARTES BLANDAS', '7500.00', 9),
(188, 187, 1, 'ULTRASONIDO TRANSVAGINAL', '7500.00', 9),
(189, 188, 1, 'ULTRASONIDO TRANSRECTAL', '7500.00', 9),
(190, 189, 1, 'ULTRASONIDO FONTANELARES', '7500.00', 9),
(191, 190, 1, 'ULTRASONIDO TORAXICO', '7500.00', 9),
(192, 191, 1, 'ULTRASONIDO  ABDOMINAL', '7500.00', 9),
(193, 192, 1, 'ULTRASONIDO  PELVICO', '7500.00', 9),
(194, 193, 1, 'ULTRASONIDO  CEREBRAL', '7500.00', 9),
(195, 194, 1, 'ULTRASONIDO ABDOM/ENFASIS RENAL', '7500.00', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `numeroFactura` int(11) NOT NULL,
  `numeroControl` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `razonSocial` varchar(80) COLLATE utf8_spanish2_ci NOT NULL,
  `rifCedula` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `iva` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `descuento` decimal(10,2) NOT NULL,
  `observaciones` varchar(120) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `numeroSolicitud` int(11) NOT NULL,
  `alicuota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impresora`
--

CREATE TABLE IF NOT EXISTS `impresora` (
  `codigoImpresora` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(500) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `impresora`
--

INSERT INTO `impresora` (`codigoImpresora`, `nombre`, `direccion`) VALUES
(1, 'ETIQUETAS', 'LPT1'),
(2, 'RECIBOS', 'LPT2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `institucion`
--

CREATE TABLE IF NOT EXISTS `institucion` (
  `codigoInstitucion` int(11) NOT NULL,
  `nombreInstitucion` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `rif` varchar(35) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `contactoOrganizacion` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `telefonoContacto` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `cargoContacto` varchar(45) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `institucion`
--

INSERT INTO `institucion` (`codigoInstitucion`, `nombreInstitucion`, `rif`, `direccion`, `telefono`, `contactoOrganizacion`, `telefonoContacto`, `cargoContacto`) VALUES
(1, 'PRIVADOS AMBULATORIOS', 'J-00000-0', '**', '**', 'DR CARRASQUEL', '**', '**');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numerocontrol`
--

CREATE TABLE IF NOT EXISTS `numerocontrol` (
  `numeroControl` bigint(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `numerocontrol`
--

INSERT INTO `numerocontrol` (`numeroControl`) VALUES
(28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `codigoPaciente` int(11) NOT NULL,
  `Cedula` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `nombres` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidos` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefono` varchar(70) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish2_ci NOT NULL,
  `sexo` varchar(45) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`codigoPaciente`, `Cedula`, `nombres`, `apellidos`, `fechaNacimiento`, `telefono`, `direccion`, `sexo`) VALUES
(1, '19672111', 'DANNY AGUSTIN', 'CAMACARO RUIZ', '1989-12-07', '04242753198', 'BARUTA', 'MASCULINO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudestudio`
--

CREATE TABLE IF NOT EXISTS `solicitudestudio` (
  `numeroSolicitud` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `turno` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `codigoInstitucion` int(11) NOT NULL,
  `codigoPaciente` int(11) NOT NULL,
  `numeroReferencia` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `codigoUsuario` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `privilegio` varchar(45) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigoUsuario`, `nombre`, `clave`, `privilegio`) VALUES
(1, 'MERASO2015', 'MERASO', 'ADMINISTRADOR'),
(2, 'LUISANA', '12345', 'CAJA'),
(3, 'DANNY', 'CAMACARO', 'ADMINISTRADOR');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alicuota`
--
ALTER TABLE `alicuota`
 ADD PRIMARY KEY (`codigoAlicuota`);

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
 ADD PRIMARY KEY (`codigoSolicitud`);

--
-- Indices de la tabla `categoriaestudio`
--
ALTER TABLE `categoriaestudio`
 ADD PRIMARY KEY (`codigoCategoria`);

--
-- Indices de la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
 ADD PRIMARY KEY (`numeroDetalle`), ADD KEY `fk_estudioinstitucion_idx` (`numeroEstudio`);

--
-- Indices de la tabla `estudio`
--
ALTER TABLE `estudio`
 ADD PRIMARY KEY (`codigoEstudio`), ADD KEY `fk_categoria_idx` (`codigoCategoria`);

--
-- Indices de la tabla `estudioinstitucion`
--
ALTER TABLE `estudioinstitucion`
 ADD PRIMARY KEY (`numeroEstudio`), ADD KEY `fk_ins_idx` (`codigoOrganizacion`), ADD KEY `fk_cat_idx` (`categoria`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
 ADD PRIMARY KEY (`numeroFactura`), ADD KEY `fk_solicitud_idx` (`numeroSolicitud`);

--
-- Indices de la tabla `impresora`
--
ALTER TABLE `impresora`
 ADD PRIMARY KEY (`codigoImpresora`);

--
-- Indices de la tabla `institucion`
--
ALTER TABLE `institucion`
 ADD PRIMARY KEY (`codigoInstitucion`);

--
-- Indices de la tabla `numerocontrol`
--
ALTER TABLE `numerocontrol`
 ADD PRIMARY KEY (`numeroControl`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
 ADD PRIMARY KEY (`codigoPaciente`);

--
-- Indices de la tabla `solicitudestudio`
--
ALTER TABLE `solicitudestudio`
 ADD PRIMARY KEY (`numeroSolicitud`), ADD KEY `fk_paciente_idx` (`codigoPaciente`), ADD KEY `fk_institucion_idx` (`codigoInstitucion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`codigoUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
MODIFY `numeroDetalle` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
ADD CONSTRAINT `fk_estudioinstitucion` FOREIGN KEY (`numeroEstudio`) REFERENCES `estudioinstitucion` (`numeroEstudio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estudio`
--
ALTER TABLE `estudio`
ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`codigoCategoria`) REFERENCES `categoriaestudio` (`codigoCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `estudioinstitucion`
--
ALTER TABLE `estudioinstitucion`
ADD CONSTRAINT `fk_cat` FOREIGN KEY (`categoria`) REFERENCES `categoriaestudio` (`codigoCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_ins` FOREIGN KEY (`codigoOrganizacion`) REFERENCES `institucion` (`codigoInstitucion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
ADD CONSTRAINT `fk_numero_solicitud` FOREIGN KEY (`numeroSolicitud`) REFERENCES `solicitudestudio` (`numeroSolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `solicitudestudio`
--
ALTER TABLE `solicitudestudio`
ADD CONSTRAINT `fk_institucion` FOREIGN KEY (`codigoInstitucion`) REFERENCES `institucion` (`codigoInstitucion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_paciente` FOREIGN KEY (`codigoPaciente`) REFERENCES `paciente` (`codigoPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
