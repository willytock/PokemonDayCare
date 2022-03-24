-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : jeu. 24 mars 2022 à 16:50
-- Version du serveur :  10.3.32-MariaDB
-- Version de PHP : 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `willytock`
--

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

CREATE TABLE `employees` (
  `name` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employees`
--

INSERT INTO `employees` (`name`, `firstName`, `role`) VALUES
('Nurse', 'Amélie', 'Nurse'),
('Nurse', 'Joëlle', 'Nurse');

-- --------------------------------------------------------

--
-- Structure de la table `institution`
--

CREATE TABLE `institution` (
  `region` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `freeRooms` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `institution`
--

INSERT INTO `institution` (`region`, `name`, `city`, `freeRooms`) VALUES
('Orre', 'SeventhGen', 'Agate Village', 40),
('Hoenn', 'ThirdGen', 'Battle Resort', 80),
('Kanto', 'FirstGen', 'Four Island ', 80),
('Hoenn', 'ThirdGen', 'Route 117', 80),
('Unova', 'FifthGen', 'Route 3', 80),
('Johto', 'SecondGen', 'Route 34', 80),
('Kanto', 'FirstGen', 'Route 5 ', 40),
('Kalos', 'SixthGen', 'Route 7', 80),
('Sinnoh', 'FourthGen', 'Solaceon Town', 80);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('willytock', 'test123');

-- --------------------------------------------------------

--
-- Structure de la table `medicine`
--

CREATE TABLE `medicine` (
  `name` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `quantities` int(11) NOT NULL,
  `expirationDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medicine`
--

INSERT INTO `medicine` (`name`, `price`, `quantities`, `expirationDate`) VALUES
('Antidote', 140, 50, '2022-08-31'),
('Burn Heal', 300, 100, '2027-10-31'),
('Full Restore', 300, 50, '2027-10-31'),
('Heal Powder', 150, 100, '2022-10-31'),
('Ice Heal', 210, 50, '2022-08-31'),
('Paralyze Heal', 100, 50, '2027-10-31'),
('Yellow Flute', 3000, 1, '2024-10-31');

-- --------------------------------------------------------

--
-- Structure de la table `pokemon`
--

CREATE TABLE `pokemon` (
  `name` varchar(20) NOT NULL,
  `size` double NOT NULL,
  `weight` double NOT NULL,
  `gender` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `room` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `pokemon`
--

INSERT INTO `pokemon` (`name`, `size`, `weight`, `gender`, `status`, `room`) VALUES
('Charizard', 1.7, 90.5, 'Male', 'Poisonned', 'Fire'),
('Gible', 0.7, 20.5, 'Male', 'Confused', 'Normal');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`firstName`);

--
-- Index pour la table `institution`
--
ALTER TABLE `institution`
  ADD PRIMARY KEY (`city`);

--
-- Index pour la table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`name`);

--
-- Index pour la table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
