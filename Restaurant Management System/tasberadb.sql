-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 27, 2019 at 11:16 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tasberadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `CLIENTNAME` varchar(300) NOT NULL,
  `CLIENTADDRESS` varchar(400) NOT NULL,
  `CLIENTPHONE` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`CLIENTNAME`, `CLIENTADDRESS`, `CLIENTPHONE`) VALUES
('احمد', '8 ش حسن اقلاطون', '01224165153'),
('Uber Eats', '...', '1'),
('احمد', 'fdgfdgfd', '01224165153'),
('ddf', 'dfdf', '012554');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `ITEMNAME` varchar(300) NOT NULL,
  `ITEMCATEGORY` varchar(300) NOT NULL,
  `CATEGORYPARENT` varchar(400) NOT NULL,
  `ITEMPRICE` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`ITEMNAME`, `ITEMCATEGORY`, `CATEGORYPARENT`, `ITEMPRICE`) VALUES
('لحمة 3', 'test', 'اطلب', 60),
('فراخ', 'وجبات', 'الكل', 50);

-- --------------------------------------------------------

--
-- Table structure for table `menucategories`
--

DROP TABLE IF EXISTS `menucategories`;
CREATE TABLE IF NOT EXISTS `menucategories` (
  `CATEGORYNAME` varchar(300) NOT NULL,
  `CATEGORYPARENT` varchar(300) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menucategories`
--

INSERT INTO `menucategories` (`CATEGORYNAME`, `CATEGORYPARENT`) VALUES
('سندوتشات', 'Otlob'),
('حاجة', 'UberEats'),
('وجبات', 'الكل'),
('سندوتشات', 'الكل'),
('test', 'اطلب');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `ID` double NOT NULL,
  `ORDERTYPE` varchar(200) NOT NULL,
  `CLIENTNAME` varchar(300) CHARACTER SET ucs2 NOT NULL,
  `CLIENTADDRESS` varchar(400) NOT NULL,
  `CLIENTPHONE` varchar(200) NOT NULL,
  `DATE` date NOT NULL,
  `ITEMNAME` varchar(300) NOT NULL,
  `ITEMPRICE` double NOT NULL,
  `ITEMQUANTITY` int(11) NOT NULL,
  `DISCOUNT` double NOT NULL,
  `ORDERTOTAL` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ID`, `ORDERTYPE`, `CLIENTNAME`, `CLIENTADDRESS`, `CLIENTPHONE`, `DATE`, `ITEMNAME`, `ITEMPRICE`, `ITEMQUANTITY`, `DISCOUNT`, `ORDERTOTAL`) VALUES
(2, '', 'أحمد', '8 شارع حسن افلاطون', '01224165153', '2019-01-12', 'Chicken Panee', 23.5, 2, 0, 47),
(2, '', 'أحمد', '8 شارع حسن افلاطون', '01224165153', '2019-01-12', 'Chicken Panee', 23.5, 2, 0, 47),
(2, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test4', 12, 1, 0, 12),
(2, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(2, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 10, 2, 0, 20),
(5, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(5, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(5, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test4', 12, 1, 0, 12),
(8, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(8, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(8, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 90, 1, 0, 90),
(11, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(11, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(13, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(13, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 90, 1, 0, 90),
(13, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(16, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(16, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(16, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 90, 1, 0, 90),
(16, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test5', 65, 1, 0, 65),
(16, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test4', 12, 1, 0, 12),
(21, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test5', 65, 1, 0, 65),
(21, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 90, 1, 0, 90),
(23, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(23, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(25, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test3', 45, 1, 0, 45),
(25, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test2', 24, 1, 0, 24),
(25, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test6', 90, 1, 0, 90),
(25, 'Catering', 'احمد', '8 ش حسن اقلاطون', '01224165153', '2019-01-13', 'test5', 65, 1, 0, 65),
(29, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test3', 45, 1, 0, 45),
(29, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test2', 24, 1, 0, 24),
(29, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test6', 90, 1, 0, 90),
(32, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test3', 45, 1, 0, 45),
(33, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test3', 45, 1, 0, 45),
(34, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test3', 45, 1, 0, 45),
(34, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test2', 24, 1, 0, 24),
(36, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test3', 45, 1, 0, 45),
(36, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test2', 24, 1, 0, 24),
(36, 'Catering', 'Uber Eats', '...', '1', '2019-01-14', 'test6', 90, 1, 0, 90),
(39, 'Catering', 'احمد', 'fdgfdgfd', '01224165153', '2019-01-14', 'chicken panee', 50, 3, 0, 150),
(39, 'Catering', 'احمد', 'fdgfdgfd', '01224165153', '2019-01-14', 'test2', 24, 1, 0, 24),
(41, 'Catering', 'ddf', 'dfdf', '012554', '2019-01-14', 'test2', 24, 1, 0, 24),
(41, 'Catering', 'ddf', 'dfdf', '012554', '2019-01-14', 'test6', 90, 1, 0, 90),
(41, 'Catering', 'ddf', 'dfdf', '012554', '2019-01-14', 'test9', 1, 1, 0, 1),
(17, 'كاترنج', 'Uber Eats', '...', '1', '2019-01-26', 'فراخ', 50, 1, 0, 50),
(18, 'كاترنج', 'Uber Eats', '...', '1', '2019-01-26', 'فراخ', 50, 1, 0, 50);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
