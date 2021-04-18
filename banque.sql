-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 18, 2021 at 03:06 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banque`
--

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

CREATE TABLE `compte` (
  `NUMEROCOMPTE` int(5) NOT NULL,
  `CODETYPECOMPTE` char(1) NOT NULL,
  `CODETITULAIRE` int(4) NOT NULL,
  `SOLDECOMPTE` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `compte`
--

INSERT INTO `compte` (`NUMEROCOMPTE`, `CODETYPECOMPTE`, `CODETITULAIRE`, `SOLDECOMPTE`) VALUES
(1, 'c', 3, 0.98),
(2, 'a', 5, 1.01),
(3, 'b', 8, 6.40),
(4, 'a', 9, 2.20),
(5, 'c', 1, 6.84),
(6, 'b', 11, 1.30),
(7, 'b', 3, 3.73),
(8, 'b', 11, 6.48),
(9, 'c', 6, 7.55),
(10, 'b', 14, 6.03);

-- --------------------------------------------------------

--
-- Table structure for table `operations`
--

CREATE TABLE `operations` (
  `NUMEROOPERATION` int(11) NOT NULL,
  `NUMEROCOMPTE` int(5) NOT NULL,
  `DATEOPERATION` date NOT NULL,
  `LIBELLEOPERATION` varchar(32) NOT NULL,
  `MONTANT` float(10,2) NOT NULL,
  `TYPEOPERATION` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `operations`
--

INSERT INTO `operations` (`NUMEROOPERATION`, `NUMEROCOMPTE`, `DATEOPERATION`, `LIBELLEOPERATION`, `MONTANT`, `TYPEOPERATION`) VALUES
(1, 4, '2021-05-12', 'NovemberUniform', 75.00, 'd'),
(2, 2, '2020-09-02', 'KilouluFoxtrot', 626.50, 'd'),
(3, 9, '2020-12-01', 'Mikechar', 161.99, 'c');

-- --------------------------------------------------------

--
-- Table structure for table `titulaire`
--

CREATE TABLE `titulaire` (
  `CODETITULAIRE` int(4) NOT NULL,
  `PRENOMTITULAIRE` varchar(32) NOT NULL,
  `NOMTITULAIRE` varchar(32) NOT NULL,
  `ADRESSETITULAIRE` varchar(32) NOT NULL,
  `CODEPOSTALTITULAIRE` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `titulaire`
--

INSERT INTO `titulaire` (`CODETITULAIRE`, `PRENOMTITULAIRE`, `NOMTITULAIRE`, `ADRESSETITULAIRE`, `CODEPOSTALTITULAIRE`) VALUES
(1, 'Susanetta', 'Jervoise', '52 Merchant Hill', '25632'),
(2, 'Tait', 'Hissett', '153 Warner Alley', '51202'),
(3, 'Jeffy', 'Dooler', '81831 Stephen Avenue', '78965'),
(4, 'Jeffie', 'Gerkens', '3 Sunnyside Avenue', '06801'),
(5, 'Arnuad', 'Tanby', '12728 Reindahl Drive', '45632'),
(6, 'Simon', 'Whymark', '4 Columbus Road', '28050'),
(7, 'Bobbye', 'Colegrove', '50 Fisk Court', '92061'),
(8, 'Ilise', 'Hayfield', '433 Talisman Plaza', '12345'),
(9, 'Christie', 'Hearne', '902 Redwing Avenue', '75369'),
(10, 'Carney', 'Coysh', '1804 Saint Paul Alley', '73009'),
(11, 'Mickey', 'McIlwrath', '09 Vernon Junction', '25869'),
(12, 'Alicia', 'Rusling', '31 Comanche Hill', '45628'),
(13, 'Lise', 'Styan', '72467 Prairieview Circle', '73700'),
(14, 'Temp', 'Haugg', '97 Moose Lane', '29830'),
(15, 'Stesha', 'MacGebenay', '8 Dexter Avenue', '08072'),
(16, 'David', 'Da silva', '12 Allée cochin', '93390');

-- --------------------------------------------------------

--
-- Table structure for table `typecompte`
--

CREATE TABLE `typecompte` (
  `CODETYPECOMPTE` char(1) NOT NULL,
  `INTITULECOMPTE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `typecompte`
--

INSERT INTO `typecompte` (`CODETYPECOMPTE`, `INTITULECOMPTE`) VALUES
('a', 'mastercard'),
('b', 'jcb'),
('c', 'maestro');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`NUMEROCOMPTE`),
  ADD KEY `CODETITULAIRE` (`CODETITULAIRE`);

--
-- Indexes for table `operations`
--
ALTER TABLE `operations`
  ADD PRIMARY KEY (`NUMEROOPERATION`);

--
-- Indexes for table `titulaire`
--
ALTER TABLE `titulaire`
  ADD PRIMARY KEY (`CODETITULAIRE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `operations`
--
ALTER TABLE `operations`
  MODIFY `NUMEROOPERATION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `titulaire`
--
ALTER TABLE `titulaire`
  MODIFY `CODETITULAIRE` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`CODETITULAIRE`) REFERENCES `titulaire` (`CODETITULAIRE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
