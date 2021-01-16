-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  lun. 29 juin 2020 à 15:12
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

-- --------------------------------------------------------

--
-- Structure de la table `bd_etudiant`
--

DROP TABLE IF EXISTS `bd_etudiant`;
CREATE TABLE IF NOT EXISTS `bd_etudiant` (
  `cne` varchar(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `bd_etudiant`
--

INSERT INTO `bd_etudiant` (`cne`, `nom`, `prenom`) VALUES
('R131358259', 'Ikharrazen', 'Meriem');

-- --------------------------------------------------------

--
-- Structure de la table `bd_note`
--

DROP TABLE IF EXISTS `bd_note`;
CREATE TABLE IF NOT EXISTS `bd_note` (
  `cne` varchar(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `matiere` varchar(20) NOT NULL,
  `note` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `html`
--

DROP TABLE IF EXISTS `html`;
CREATE TABLE IF NOT EXISTS `html` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `choix1` text NOT NULL,
  `choix2` text NOT NULL,
  `choix3` text NOT NULL,
  `choix4` text NOT NULL,
  `reponse` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `html`
--

INSERT INTO `html` (`id`, `question`, `choix1`, `choix2`, `choix3`, `choix4`, `reponse`) VALUES
(1, 'Quel est l\'attribut à inclure dans la balise BODY pour changer la couleur des\r\nliens?', 'LINK', 'VLINK', 'ALINK', 'TEXT', 'LINK'),
(2, 'Quel est l\'attribut à inclure dans la balise BODY pour changer la couleur des\r\nliens déjà visités?', 'LINK', 'ALINK', 'TEXT', 'VLINK', 'VLINK'),
(3, 'Que veut dire le mot HTML?', 'Home Tool Markup Language', 'Hyperlinks and Text Markup Language', 'Hyper Text Markup Language', 'Hyper Text machine Language', 'Hyper Text Markup Language'),
(4, 'Quelle balise te permettra d\'insérer correctement une image de fond dans ta page\r\nHTML?', '<BODY BACKGROUND=\"image.gif\">', '<IMG SRC=\"image.gif\" BACKGROUND>', '<BACKGROUND IMG=\"image.gif\">', '<IMG SRC=\"image.gif\" TYPE=\"background\">', '<BACKGROUND IMG=\"image.gif\">'),
(5, 'Dans quel ordre devez-vous placer correctement les balises dans une page\r\nHTML?', ' <HTML><TITLE><TITLE><BODY></BODY></HTML>', ' <HTML><TITLE></TITLE><BODY></BODY></HTML>', ' <HTML><TITLE></TITLE><BODY></HTML>', ' <HTML><HEAD></TITLE><BODY></BODY></HTML>', ' <HTML><TITLE></TITLE><BODY></BODY></HTML>'),
(6, 'Quel attribut de la balise <BODY..> établit la couleur de fond d\'une page web?', 'BACKGROUND', 'BACKCOLOR', 'BGCOLOR', 'BCOLOR', 'BGCOLOR'),
(7, 'Parmi les choix suivants, lequel n\'est pas un attribut de la balise <BODY>?', 'BACKGROUND\r\n', 'BGCOLOR', 'TEXT', 'FONT', 'FONT'),
(8, 'Une paire de balises HTML doit être utilisé dans vos pages web, une au début et\r\nl\'autre sur la dernière ligne. De quelle paire s\'agit-il?', ' <HTML> et </HTML>', ' <BODY> et </BODY>', ' <HEAD> et </HEAD>', ' <TITLE> et </TITLE>', ' <HTML> et </HTML>'),
(9, 'La partie HEAD d\'un fichier HTML contient. . ', 'Toutes les balises d\'un fichier HTML', 'Les balises du BODY', 'La balise TITLE', 'Aucune de ces réponses', 'La balise TITLE'),
(10, 'Quand vous utilisez la balise <TITLE>, où est affiché le texte? ', 'Le titre est placé au début de la page HTML.', 'Le titre est placé au début de chaque paragraphe. ', 'Le titre est affiché dans le haut des navigateurs.', 'Toutes les réponses ci-dessus ', 'Le titre est affiché dans le haut des navigateurs.'),
(11, 'Quelle est la balise encadrant les infomations qui ne seront pas éditées à l\'écran:', ' <HTML> et </HTML>', ' <HEAD> et </HEAD>', ' <TITLE> et </TITLE>', ' <BODY> et </BODY>', ' <HEAD> et </HEAD>'),
(12, 'La majorité des informations d\'une page Web se trouve dans:', 'La balise HEAD', 'La balise TITLE', 'La balise BODY', 'La balise des commentaires <!-- ... -->\r\n', 'La balise BODY'),
(13, 'Indiquez une balise obligatoire pour fabriquer une page web?', ' <HTML>', '<META>', '<A>', '<TABLE>', ' <HTML>'),
(14, 'Si vous voulez utiliser une image comme fond d\'écran, dans quelle balise devezvous l\'inclure?', '<BKG>', '<HEAD>', '<BODY>', '<BACKGROUND>', '<BODY>'),
(15, 'Que signifie l\'attribut BGCOLOR de la balise <BODY>?\r\n', 'Couleur du texte', 'Couleur de l\'arrière plan.', 'Couleur de la cellule', 'Couleur des images.\r\n', 'Couleur de l\'arrière plan.'),
(16, 'Pour éviter que le fond de l\'écran ne bouge avec le texte via la barre de\r\ndéfilement, il faut utiliser ...', 'BGPROPERTIES = \"nomove\"', 'BGPROPERTIES = \"stop\"', 'BGPROPERTIES = \"stick\"', 'BGPROPERTIES = \"fixed\"', 'BGPROPERTIES = \"fixed\"'),
(17, 'Un fichier HTML est:', 'Un document texte', 'Une présentation multimédia\r\n', 'Un logiciel', 'Une base de données relationnelle', 'Un document texte'),
(18, 'Le HTML est une langage utilisé pour créer...', 'Des images', 'De l\'audio', 'Des vidéos', 'Des pages web', 'Des pages web'),
(19, 'Quand vous enregistrez vos pages HTML, quelle extension devez-vous utiliser?.', 'txt.\r\n', 'html', 'web', 'www', 'html'),
(20, 'Quel organisme est responsable des standards du langage HTML?', 'The World Wide Web Consortium', 'Microsoft', 'Netscape', 'Intel', 'The World Wide Web Consortium'),
(21, 'Quel est l\'attribut à inclure dans la balise BODY pour changer la couleur des\r\nliens?', 'LINK=\"#RRVVBB\"', 'VLINK=\"#RRVVBB\"', 'ALINK=\"#RRVVBB\"', 'TEXT=\"#RRVVBB\"', 'LINK=\"#RRVVBB\"'),
(22, 'Quel est l\'attribut à inclure dans la balise BODY pour changer la couleur des\r\nliens déjà visités?', 'LINK=\"#RRVVBB\"', 'VLINK=\"#RRVVBB\"', 'ALINK=\"#RRVVBB\"', 'TEXT=\"#RRVVBB\"', 'VLINK=\"#RRVVBB\"'),
(23, 'Quelle est la bonne façon, selon les règles du langage HTML, de mettre de la\r\ncouleur jaune sur le fond de notre page Web?', '<BACKGROUND>yellow</BACKGROUND>', '<BODY COLOR=\"yellow\">', '<BODY BGCOLOR=\"yellow\">', '<BODY BGCOLOR=\"jaune\">', '<BODY BGCOLOR=\"yellow\">'),
(24, 'Que veulent dire les lettres HTML?', 'Hyper Text Markup Lingo', 'Hyper Temporary Markup Language', 'Hyper Text Marking Language', 'Hyper Text Markup Language', 'Hyper Text Markup Language'),
(25, 'L\'attribut de la balise <BODY> pour la couleur de fond est. . .', 'BACKCOLOR', 'BGCOLOR', 'BACKGROUND', 'BCOLOR', 'BGCOLOR'),
(26, 'Lequel de ces attributs n\'est pas valables pour BODY?', 'BACKGROUND', 'ALINK', 'COLOR', 'BGCOLOR', 'COLOR'),
(27, 'Où sont normalement placées les balises <HTML> et </HTML> dans un\r\ndocument HTML?', 'N\'importe où', 'Dans l\'entête <HEAD>', 'Dans le corps <BODY>', 'Au début et à la fin du document', 'Au début et à la fin du document'),
(28, 'Dans quelle paire de balises HTML trouve-t-on la majorité des autres balises qui\r\ncomposent un document HTML?\r\n', ' <HTML> et </HTML', ' <BODY> et </BODY>\r\n', '<HEAD> et </HEAD>\r\n', ' <TITLE> et </TITLE>', ' <BODY> et </BODY>'),
(29, 'Dans quelle paire de balises HTML place-t-on le texte qui doit apparaître dans la\r\nbarre colorée bleue des navigateurs?\r\n', ' <HTML> et </HTML>', ' <BODY> et </BODY>\r\n', ' <HEAD> et </HEAD>', ' <TITLE> et </TITLE>', ' <TITLE> et </TITLE>'),
(30, 'La balise TITLE doit se trouver à l\'intérieur de:', 'La balise HEAD\r\n', ' La balise TITLE', 'La balise BODY', 'La balise des commentaires <!-- ... -->', 'La balise HEAD');

-- --------------------------------------------------------

--
-- Structure de la table `java`
--

DROP TABLE IF EXISTS `java`;
CREATE TABLE IF NOT EXISTS `java` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `choix1` text NOT NULL,
  `choix2` text NOT NULL,
  `choix3` text NOT NULL,
  `choix4` text NOT NULL,
  `reponse` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `java`
--

INSERT INTO `java` (`id`, `question`, `choix1`, `choix2`, `choix3`, `choix4`, `reponse`) VALUES
(1, 'Java est un langage', 'Compilé', 'Interprété', 'Compilé et interprété', 'Ni compilé ni interprété', 'Compilé et interprété'),
(2, 'Java est un langage développé par', 'Hewlett-Packard', 'Sun Microsystems', 'Microsoft', 'Oracle', 'Sun Microsystems'),
(3, 'Combien d’instances de la classe A crée le code suivant?\r\nA x,u,v;\r\nx=new A();\r\nA y=x;\r\nA z=new A();', 'Aucune', 'Cinq', 'Trois', 'Deux', 'Deux'),
(4, 'Pour la classe B définie comme suit:\r\nclass B {\r\npublic B(){System.out.print(”Ciao”);};\r\npublic B(int i) {this(); System.out.println(”Bonjour ”+i);};\r\n}\r\nqu’affichera l’instruction suivante?\r\nB monB=new B(2003);', 'Erreur de compilation', 'Erreur d’exécution', 'CiaoBonjour 2003\r\n', 'Bonjour 2003', 'CiaoBonjour 2003\r\n'),
(5, 'La liaison tardive est essentielle pour assurer', 'l’encapsulation', 'le polymorphisme', ' l’héritage', 'la marginalisation', 'le polymorphisme'),
(6, 'Pour transformer un code lisible en code compréhensible par la machine, on utilise :', 'Un compilateur', 'Un exécuteur', 'Un transformateur', 'Un traducteur ', 'Un compilateur'),
(7, 'Quelle est la valeur de « nbr » après l’exécution de ce code?\r\nint nbr = 0;\r\nint number2 = 12;\r\nwhile (nbr < nbr2)\r\n{\r\n   nbr = nbr + 1;\r\n}\r\n', '5', '12', '13', '21', '12'),
(8, 'Quelle est la plage de valeurs autorisée pour une variable déclarée avec le type byte?', '[0, 255]', ' [0, 256]', '[-128, 127]', '[-127, 128]', ' [-128, 127]'),
(9, 'Ce que s’affiche lorsque le programme suivant est exécuté?\r\npublic class test {\r\n  public static void main(String args[]) {\r\n     int a,b;\r\n     a = 3 & 5;\r\n     b = 3 | 5;\r\n     System.out.println(a + \" \" + b);\r\n  }\r\n}', '7 1', '3 7', '1 7', '1 3', '1 7'),
(10, 'Nommez le modificateur d’accès qui, lorsqu’il est utilisé avec une méthode, le rend accessible à toutes les classes du même package et à toutes les sous-classes de la classe.', 'public', 'private', 'protected', 'default', 'protected'),
(11, 'Étant donné l’extrait de code suivant; Quelle est la valeur de students [3]?\r\nint students[];\r\nint i = 0;\r\nstudents = new int students[4];\r\nwhile (index < 4)\r\n{\r\n   students[i] = 10000;\r\n   i++;\r\n}', '40000', '50000', '15000', '10000', '10000'),
(12, 'La longueur d’une variable de type double en Java est ......?', 'Dépend du compilateur', '64 bits', '128 bits', '8 bits', '64 bits'),
(13, 'Ce que s’affiche lorsque le programme suivant est compilé et exécuté?\r\npublic class TestIncrement {\r\n    public static void main(String args[]) {\r\n          int i , j;\r\n          i = j = 3;\r\n          int n = 2 * ++i;\r\n          int m = 2 * j++;\r\n          System.out.println(i + \" \" + j + \" \" + n + \" \" + m);\r\n    }\r\n}', '4 4 8 6', '4 4 8 8', '4 4 6 6', '4 3 8 6', '4 4 8 6'),
(14, 'Quel est le type de données pour stocké la date dans une base de données?', 'java.util.DateTime\r\n', 'java.sql.DateTime\r\n', 'java.util.Date\r\n\r\n', 'java.sql.Date', 'java.sql.Date'),
(15, 'Quel est l’alternative de la bibliothèque de temps « joda » dans java 8?', 'java.jodaTime', 'java.date (JSR-310)', 'java.time (JSR-310)', 'java.joda', 'java.time (JSR-310)'),
(16, 'Comment mettre en forme la date dans un formulaire?', 'SimpleFormat', 'DateConverter', 'DateFormat', 'SimpleDateFormat', 'SimpleDateFormat'),
(17, 'Comment identifier si un fuseau horaire est admissible pour DayLight Saving?', 'utiliser useDaylightTime () de la classe DateTime', 'utiliser useDaylightTime () de la classe TimeZone', 'utiliser useDaylightTime () de la classe Date', 'utiliser useDaylightTime () de la classe Time', 'utiliser useDaylightTime () de la classe TimeZone'),
(18, 'Que représente LocalTime?', 'Date sans heure', 'Date et heure', 'Heure sans date', 'Date et heure avec fuseau horaire', 'Heure sans date'),
(19, 'Comment obtenir l’heure UTC?', 'Instant.now();', 'TimeZone.getUTC();', 'Date.getUTC();', ' Time.getUTC();', 'Instant.now();'),
(20, 'Quand les exceptions surviennent-elles dans un code Java?', 'Au moment de l’exécution', 'Le moment de compilation', 'Peut survenir à tout moment', 'Aucune de ces réponses n’est vraie.', 'Au moment de l’exécution'),
(21, 'Lequel de ces mots clés ne fait pas partie du gestion d’exceptions?', 'catch', 'thrown', 'finally', 'try', 'thrown'),
(22, 'Exception est une .............', 'Classe', 'Interface', 'Classe abstraite', 'Autres', 'Classe'),
(23, 'Exception se trouve dans quel package en Java?', 'java.lang', 'java.util', 'java.io', 'java.awt', 'java.lang'),
(24, 'Exception a été introduite dans quelle version Java?', 'Java 1', 'Java 2', 'Java 3', 'Java 4', 'Java 1'),
(25, 'Laquelle de ces classes est la plus élevée dans la hiérarchie en Java?', 'java.lang.Exception', 'java.lang.Object', 'java.lang.Throwable', 'java.lang.Error', 'java.lang.Object'),
(26, ' Lequel des éléments suivants est une classe mère de Error ?', 'Iterable', 'Throwable', 'Exception', 'throws\r\n\r\n', 'Throwable'),
(27, 'Laquelle des affirmations suivantes est correcte?\r\n1-L’exception est irrécupérable.\r\n2-L’erreur est récupérable par débogage.', '1', '2', '1 et 2', 'ni 1 ni 2', 'ni 1 ni 2'),
(28, 'Supposons que la valeur 8918.72 est de type « float ». Comment assigner cette valeur après avoir déclaré la variable res de type float?', 'res = 8918.72', 'res = (Float)8918.72', 'res = 8918.72 (float)', 'res = 8918.72f', 'res = 8918.72f'),
(29, 'Quelle classe stocke les éléments sous forme de paire clé-valeur?', 'Arraylist', 'LinkedHashSet', 'TreeMap', 'TreeSet', 'TreeMap'),
(30, 'Quel est le plus rapide et utilise moins de mémoire?', 'ListEnumeration', 'Iterator', 'ListIterator', 'Enumeration', 'Enumeration'),
(31, 'Laquelle de celles-ci est une forme incorrecte d’utilisation de la méthode max() pour obtenir l’élément maximum?', 'max(Collection c, Comparator comp)', 'max(Collection c)', 'max(Comparator comp)', 'max(List c)', 'max(Comparator comp)'),
(32, 'Laquelle de ces méthodes peut mélanger tous les éléments d’une liste?', 'rand()', 'srand()', 'randomize()', 'shuffle()\r\n\r\n', 'shuffle()\r\n\r\n'),
(33, 'Laquelle de ces méthodes peut convertir un objet en liste?', 'SetList()', 'ConvertList()', 'singletonList()', 'CopyList()', 'CopyList()');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
