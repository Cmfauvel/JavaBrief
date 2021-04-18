-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 18 avr. 2021 à 15:12
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_comptes_bancaires`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `numero_compte` int NOT NULL AUTO_INCREMENT,
  `code_type_compte` char(1) DEFAULT NULL,
  `code_titulaire` int DEFAULT NULL,
  `solde_compte` float NOT NULL,
  PRIMARY KEY (`numero_compte`),
  KEY `code_titulaire` (`code_titulaire`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`numero_compte`, `code_type_compte`, `code_titulaire`, `solde_compte`) VALUES
(1, 'c', 3, 0.98),
(2, 'a', 5, 1.01),
(3, 'b', 8, 6.4),
(4, 'a', 9, 2.2),
(5, 'c', 1, 6.84),
(6, 'b', 11, 1.3),
(7, 'b', 3, 3.73),
(8, 'b', 11, 6.48),
(9, 'c', 6, 7.55),
(10, 'a', 14, 4.47);

-- --------------------------------------------------------

--
-- Structure de la table `operations`
--

DROP TABLE IF EXISTS `operations`;
CREATE TABLE IF NOT EXISTS `operations` (
  `numero_operation` int NOT NULL AUTO_INCREMENT,
  `numero_compte` int DEFAULT NULL,
  `date_operation` date DEFAULT NULL,
  `libelle_operation` varchar(32) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `type_operation` char(1) DEFAULT NULL,
  PRIMARY KEY (`numero_operation`),
  KEY `numero_compte` (`numero_compte`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `operations`
--

INSERT INTO `operations` (`numero_operation`, `numero_compte`, `date_operation`, `libelle_operation`, `montant`, `type_operation`) VALUES
(2, 2, '2020-10-13', 'Canapé', -626.5, 'd'),
(3, 9, '2021-02-08', 'Prime', 161.99, 'c'),
(6, 2, '2021-01-23', 'Salaire', 1235, 'c'),
(4, 10, '2021-01-23', 'Salaire', 2455, 'c'),
(1, 7, '2021-01-23', 'Salaire', 2455, 'c'),
(8, 2, '2021-02-08', 'CartePokemon', -5, 'd'),
(5, 2, '2021-02-07', 'UberEat', -18, 'd'),
(9, 3, '2021-02-07', 'UberEat', -18, 'd'),
(7, 2, '2021-02-07', 'UberEat', -18, 'd'),
(23, 3, '2021-04-11', 'Jean', -50, 'd'),
(24, 3, '2021-04-11', 'Jean', -50, 'd');

-- --------------------------------------------------------

--
-- Structure de la table `titulaire`
--

DROP TABLE IF EXISTS `titulaire`;
CREATE TABLE IF NOT EXISTS `titulaire` (
  `code_titulaire` int NOT NULL,
  `prenom_titulaire` varchar(32) DEFAULT NULL,
  `nom_titulaire` varchar(32) DEFAULT NULL,
  `adresse_titulaire` varchar(32) DEFAULT NULL,
  `code_postal_titulaire` char(5) DEFAULT NULL,
  PRIMARY KEY (`code_titulaire`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `titulaire`
--

INSERT INTO `titulaire` (`code_titulaire`, `prenom_titulaire`, `nom_titulaire`, `adresse_titulaire`, `code_postal_titulaire`) VALUES
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
(15, 'Stesha', 'MacGebenay', '8 Dexter Avenue', '08072');

-- --------------------------------------------------------

--
-- Structure de la table `typecompte`
--

DROP TABLE IF EXISTS `typecompte`;
CREATE TABLE IF NOT EXISTS `typecompte` (
  `code_type_compte` char(1) NOT NULL,
  `intitule_compte` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`code_type_compte`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `typecompte`
--

INSERT INTO `typecompte` (`code_type_compte`, `intitule_compte`) VALUES
('a', 'mastercard'),
('b', 'jcb'),
('c', 'maestro');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
