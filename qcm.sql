-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 16 jan. 2021 à 12:44
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `qcm`
--

-- --------------------------------------------------------

--
-- Structure de la table `bd`
--

DROP TABLE IF EXISTS `bd`;
CREATE TABLE IF NOT EXISTS `bd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `choix1` text NOT NULL,
  `choix2` text NOT NULL,
  `choix3` text NOT NULL,
  `choix4` text NOT NULL,
  `reponse` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `bd`
--

INSERT INTO `bd` (`id`, `question`, `choix1`, `choix2`, `choix3`, `choix4`, `reponse`) VALUES
(1, 'MySQL est un système de gestion de base de données ........?', 'Orienté objet', 'Hiérarchique', 'Relationnel', 'Réseau', 'Relationnel'),
(2, 'À quoi correspondent les données d’une base de données MySQL?', 'Objets', 'Tables', 'Réseaux', 'Systèmes de fichiers', 'Tables'),
(3, 'Comment la communication est-elle établie avec le serveur MySQL ?', 'SQL', 'Des appels réseau', 'Un langage de programmation comme C ++', 'APIs', 'SQL'),
(4, 'Qu’est-ce qu’un tuple dans une base de données relationnelle ?', 'Table', 'Ligne', 'Colonne', 'Objet', 'Ligne'),
(5, 'Qu’est-ce qui représente un attribut dans une base de données relationnelle ?', 'Table', 'Ligne', 'Colonne', 'Objet', 'Colonne'),
(6, 'Quelle instruction est utilisée pour sélectionner une base de données par défaut?', 'USE', 'CREATE', 'DROP', 'SCHEMA', 'USE\r\n\r\n'),
(7, 'Quel mot-clé est le synonyme de DATABASE?', 'TABLE', 'OBJECT', 'DB', 'SCHEMA', 'SCHEMA'),
(8, 'Quel mot clé est utilisé pour créer une base de données?', 'CREATE', 'SET', 'SETUP', 'LINK', 'CREATE'),
(9, 'Le fichier créé par le serveur pour stocker les attributs de la base de données est .....?', 'db.otp', 'dp.zip', 'db.opt', 'db.cls', 'db.opt'),
(10, 'Pour vérifier comment MySQL exécutera une requête SELECT, quelle instruction est utilisée?', 'TELL', 'SHOW', 'DISPLAY', 'EXPLAIN', 'EXPLAIN'),
(11, 'Pour effectuer l’analyse des valeurs clés par le serveur, l’instruction utilisée est ........?', 'PERFORM TABLE ANALYSIS', 'ANALYZE TABLE\r\n\r\n', 'PERFORM ANALYSIS', 'Autre', 'ANALYZE TABLE\r\n\r\n'),
(12, 'Quelle variable système indique jusqu’où l’optimiseur doit-il chercher, dans le reste de chaque plan incomplet, pour déterminer s’il doit être étendu davantage?', 'optimizer_prune_level', 'optimizer_search_depth', 'optimizer_search', 'optimizer_prune', 'optimizer_search_depth'),
(13, 'Quelle variable système indique à l’optimiseur d’ignorer certains plans en fonction des estimations du nombre de lignes accédées pour chaque table?', 'optimizer_prune_level', 'optimizer_search_depth', 'optimizer_search', 'optimizer_prune', 'optimizer_prune_level'),
(14, 'Quels sont les résultats des requêtes suivantes si ‘col’ est une colonne déclarée INTEGER ?\r\nSELECT * FROM ma_table WHERE col = \'8\';\r\nSELECT * FROM ma_table WHERE col = 8;', 'Les deux sont identiques', 'Les deux sont différents', 'La première requête produit une erreur', 'La deuxième requête produit une erreur', 'Les deux sont identiques'),
(15, 'Laquelle des clauses WHERE suivantes est la plus rapide?\r\nWHERE col * 2 < 4\r\nWHERE col < 4 / 2', 'La première requête', 'La deuxième requête', 'Les deux ont la même vitesse', 'Dépend du système d’exploitation', 'La deuxième requête'),
(16, 'Laquelle de ces comparaisons est lente?', 'INT/INT\r\n', 'INT/BIGINT', 'BIGINT/BIGINT', 'Tous sont de même vitesse', 'INT/BIGINT'),
(17, 'Quelle instruction est utilisée pour forcer l’optimiseur à utiliser des tables dans un ordre particulier?', 'FORCE INDEX', 'USE INDEX', 'IGNORE INDEX', 'STRAIGHT_JOIN', 'STRAIGHT_JOIN'),
(18, 'Quelle instruction est utilisée pour vérifier le fonctionnement de l’optimiseur?', 'ANALYZE', 'VERIFY', 'EXPLAIN', 'SHOW', 'EXPLAIN'),
(19, 'Quelle déclaration n’utilise pas le même nombre d’octets et l’utilisation d’octets dépend des données d’entrée ?', 'Varchar', 'Char', 'Les deux Varchar et Char', 'Aucun de ces réponses', 'Varchar'),
(20, 'Pour créer une base de données seulement si elle n’existe pas déjà, quelle clause est utilisée?', 'IF EXISTS', 'IF NOT EXISTS', 'CREATE EXISTS', 'EXISTS IF', 'IF NOT EXISTS'),
(21, 'Que représente « salaire » dans l’extrait de code suivant?\r\nCREATE TABLE demoTbl\r\n(\r\n  id number not null,\r\n  salaire number(9,3),\r\n  date_embauche DATE,\r\n  dateNaiss DATE\r\n)', 'Une table', 'Une ligne', 'Une colonne', 'Un objet', 'Une colonne'),
(22, 'Quelle est l’instance de MySQL responsable du traitement des données?', 'Le client MySQL', 'Le serveur MySQL', 'SQL', 'Programme daemon', 'Le serveur MySQL'),
(23, 'Quel est le programme qui représente le serveur MySQL ?', 'mysqla', 'mysqlb', 'mysqlc', 'mysqld', 'mysqld'),
(24, 'Quelle instruction est utilisée pour voir la définition d’une base de données existante?', 'SHOW CREATE DATABASE', 'SHOW DATABASE', 'SHOW CREATE', 'SHOW CREATE DATABASE TABLE', 'SHOW CREATE DATABASE'),
(25, 'Dans les bases de données MySQL, la structure représentant les vues organisationnelles de l’ensemble des bases de données est ?', 'Un schéma', 'Une vue', 'Une instance', 'Une table', 'Un schéma'),
(26, 'Quel est le format par défaut pour le type de données « Date »?', 'YYYY-MM-DD', 'MM-YYYY-DD', 'DD-MM-YYYY', 'Aucun de ces réponses', 'YYYY-MM-DD'),
(27, 'Quelle valeur affiche une erreur quand elle est stockée dans float (4,2)?', '12.11', '13.1', '1.12', '123.44', '123.44'),
(28, 'Est-ce que « Datetime » et « Timestamp » sont de même type de données?', 'Oui', 'Non', 'Dépend de SGBD', 'Aucune de ces réponses', 'Aucune de ces réponses'),
(29, 'Quel est le format par défaut pour le type de données « Time »?', 'HHH:MI:SS', 'SS:MI:HHH', 'MI:SS:HHH', 'Aucune de ces réponses', 'HHH:MI:SS'),
(30, 'Parmi les propositions suivantes, laquelle est la représentation correcte de « float (5,0) »?', '12345.123', '12345.1', '12345', '123.123', '12345');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
