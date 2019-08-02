-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2019 at 04:02 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `hranljivost`
--

CREATE TABLE `hranljivost` (
  `hranljivost_id` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `jedinica_mere` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hranljivost`
--

INSERT INTO `hranljivost` (`hranljivost_id`, `naziv`, `jedinica_mere`) VALUES
(1, 'Proteini', 'g'),
(2, 'Masti', 'g'),
(3, 'Ugljeni hidrati', 'g'),
(4, 'Fruktoza', 'g'),
(5, 'Mlecne masti', 'g');

-- --------------------------------------------------------

--
-- Table structure for table `hranljivosti_za_jela`
--

CREATE TABLE `hranljivosti_za_jela` (
  `id` int(11) NOT NULL,
  `jelo_id` int(11) NOT NULL,
  `hranljivost_id` int(11) NOT NULL,
  `vrednost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hranljivosti_za_jela`
--

INSERT INTO `hranljivosti_za_jela` (`id`, `jelo_id`, `hranljivost_id`, `vrednost`) VALUES
(1, 1, 1, 50),
(2, 1, 2, 6),
(3, 1, 3, 120),
(4, 2, 1, 20),
(5, 2, 2, 2),
(6, 2, 3, 10),
(7, 2, 4, 5),
(8, 3, 1, 15),
(9, 3, 5, 5),
(10, 3, 3, 50),
(11, 4, 1, 50),
(12, 4, 2, 5),
(13, 4, 3, 120),
(14, 5, 1, 40),
(15, 5, 2, 5),
(16, 5, 3, 120),
(17, 6, 1, 70),
(18, 6, 2, 15),
(19, 6, 3, 170),
(20, 7, 1, 0),
(21, 7, 5, 1),
(22, 7, 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `jelo`
--

CREATE TABLE `jelo` (
  `jelo_id` int(11) NOT NULL,
  `ime_jela` varchar(100) NOT NULL,
  `opis_jela` varchar(255) NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `restoran_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jelo`
--

INSERT INTO `jelo` (`jelo_id`, `ime_jela`, `opis_jela`, `cena`, `img_url`, `restoran_id`) VALUES
(1, 'Azijsko jelo', 'Azisko jelo specijal sa opisom', '390', 'https://www.asia-food-palace.de/wp-content/uploads/motopress-slider/import/Fotolia_96654135_M.jpg', 1),
(2, 'Vocna salata', 'Salata od voca sa opisom', '290', 'http://images.media-allrecipes.com/userphotos/960x960/4518422.jpg', 3),
(3, 'Salata od povrca', 'Salata od povrca sa opisom', '290', 'https://nourisheveryday.com/wp-content/uploads/2018/01/Broccoli-Buckwheat-Salad-Semi-Dried-Tomatoes-6-500x500.jpg', 3),
(4, 'Di Napoli', 'Pizza specijal kuce', '480', 'https://citymagazine.rs/wp-content/uploads/2016/06/10349145_680633112032721_4057936102251390000_n-660x439.jpg', 2),
(5, 'Pesto Genovese', 'Pasta specijal kuce sa opisom', '310', 'https://fastly.4sqi.net/img/general/600x600/45444351_qrGOyur23QlmQ_rn699xbQ2R6cGmPKCR5zOHFPwfV54.jpg', 2),
(6, 'Big Burger', 'Burger specijal sa opisom', '470', 'https://miro.medium.com/max/1200/0*yEjZaSvj7LdZ4THY', 4),
(7, 'Sladoled Stracatela', 'Dve kugle Stracatela sladoleda', '200', 'https://www.nestleusa.com/asset-library/PublishingImages/Brands/2019/Ice%20Cream/haagen-dazs-button-2019.jpg', 5);

-- --------------------------------------------------------

--
-- Table structure for table `restoran`
--

CREATE TABLE `restoran` (
  `restoran_id` int(11) NOT NULL,
  `ime_restorana` varchar(50) NOT NULL,
  `opis_restorana` varchar(255) NOT NULL,
  `adresa` varchar(255) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `telefon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restoran`
--

INSERT INTO `restoran` (`restoran_id`, `ime_restorana`, `opis_restorana`, `adresa`, `img_url`, `telefon`) VALUES
(1, 'Asia Food', 'Restoran azijske hrane', 'Brankova 7', 'http://asiafood-bg.com/media/prazno.jpg', '063/132-1354'),
(2, 'Dinapoli', 'Italijanska kuhinja', 'Bulevar Zorana Djindjica 12E', 'http://dinapoli.rs/wp-content/uploads/2015/04/DSC08284-min.jpg', '011/123-398'),
(3, 'Voce i povrce', 'Obrok salate od voca i povrca', 'Nemanjina 34a', 'https://tangerineuk.net/wp-content/uploads/2015/06/Barratt-Web-Roundels-Fruit-Salad.jpg', '064/789-1234'),
(4, 'Rostilj kod Dzoa', 'Domaci i rostilj na Americki nacin', 'Bulevar Mihajla Pupina 123', 'https://www.bijeljina.org/podaci/companydirectory/id404/935369_11602169_1373391942.jpg', '069/148-967'),
(5, 'IceBox', 'Ice cream and Frozen yogurt', 'Kneza Mihaila 53', 'http://www.icebox.rs/en/images/frozen-yogurt1.jpg', '011/284-223');

-- --------------------------------------------------------

--
-- Table structure for table `sastojak`
--

CREATE TABLE `sastojak` (
  `sastojak_id` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `jedinica_mere` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sastojak`
--

INSERT INTO `sastojak` (`sastojak_id`, `naziv`, `jedinica_mere`) VALUES
(1, 'Sargarepa', 'g'),
(4, 'Crni luk', 'g'),
(2, 'Pirinac', 'g'),
(3, 'Kukuruz', 'g'),
(5, 'Tikvica', 'g'),
(6, 'Belo meso', 'g'),
(7, 'Soja sos', 'mL'),
(8, 'Limeta', 'kriski'),
(9, 'Jagoda', 'g'),
(10, 'Borovnica', 'g'),
(11, 'Kivi', 'g'),
(12, 'Banana', 'g'),
(13, 'Jabuka', 'g'),
(14, 'Pradajz', 'g'),
(15, 'Brokoli', 'g'),
(16, 'Rukola', 'g'),
(17, 'Beli sir', 'g'),
(18, 'Semenke', 'g'),
(19, 'Testo', 'g'),
(20, 'Panna', 'g'),
(21, 'Mozzarella', 'g'),
(22, 'Sunka', 'g'),
(23, 'Parmezan', 'g'),
(24, 'Pasta', 'g'),
(25, 'Beli luk', 'g'),
(26, 'Pesto sos', 'g'),
(27, 'Maslinke', 'komada'),
(28, 'Lepinja', 'komad'),
(29, 'Pljeskavica od cistog govedjeg mesa', 'g'),
(30, 'Slanina', 'g'),
(31, 'Topljeni sir', 'g'),
(32, 'Stracatela sladoled', 'kugle');

-- --------------------------------------------------------

--
-- Table structure for table `sastojci_za_jela`
--

CREATE TABLE `sastojci_za_jela` (
  `id` int(11) NOT NULL,
  `jelo_id` int(11) NOT NULL,
  `sastojak_id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sastojci_za_jela`
--

INSERT INTO `sastojci_za_jela` (`id`, `jelo_id`, `sastojak_id`, `kolicina`) VALUES
(1, 1, 1, 20),
(2, 1, 2, 150),
(3, 1, 3, 20),
(4, 1, 4, 20),
(5, 1, 5, 20),
(6, 1, 6, 100),
(7, 1, 7, 50),
(8, 1, 8, 5),
(9, 2, 9, 30),
(10, 2, 10, 30),
(11, 2, 11, 30),
(12, 2, 12, 40),
(13, 2, 13, 30),
(14, 3, 14, 30),
(15, 3, 15, 20),
(16, 3, 16, 20),
(17, 3, 17, 20),
(18, 3, 18, 20),
(19, 3, 4, 100),
(20, 4, 19, 140),
(21, 4, 20, 30),
(22, 4, 21, 30),
(23, 4, 22, 50),
(24, 4, 23, 20),
(25, 4, 16, 20),
(26, 5, 24, 150),
(27, 5, 25, 10),
(28, 5, 23, 20),
(29, 5, 24, 30),
(30, 5, 26, 25),
(31, 5, 21, 30),
(32, 5, 27, 6),
(33, 5, 8, 5),
(34, 6, 28, 1),
(35, 6, 29, 400),
(36, 6, 30, 30),
(37, 6, 31, 40),
(38, 7, 32, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hranljivost`
--
ALTER TABLE `hranljivost`
  ADD PRIMARY KEY (`hranljivost_id`),
  ADD KEY `hranljivostId` (`hranljivost_id`);

--
-- Indexes for table `hranljivosti_za_jela`
--
ALTER TABLE `hranljivosti_za_jela`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jeloId` (`jelo_id`),
  ADD KEY `hranjivostId` (`hranljivost_id`);

--
-- Indexes for table `jelo`
--
ALTER TABLE `jelo`
  ADD PRIMARY KEY (`jelo_id`),
  ADD KEY `jeloId` (`jelo_id`),
  ADD KEY `restoranId` (`restoran_id`);

--
-- Indexes for table `restoran`
--
ALTER TABLE `restoran`
  ADD PRIMARY KEY (`restoran_id`),
  ADD KEY `restoranId` (`restoran_id`);

--
-- Indexes for table `sastojak`
--
ALTER TABLE `sastojak`
  ADD PRIMARY KEY (`sastojak_id`);

--
-- Indexes for table `sastojci_za_jela`
--
ALTER TABLE `sastojci_za_jela`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jeloId` (`jelo_id`),
  ADD KEY `sastojakId` (`sastojak_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hranljivost`
--
ALTER TABLE `hranljivost`
  MODIFY `hranljivost_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `hranljivosti_za_jela`
--
ALTER TABLE `hranljivosti_za_jela`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `jelo`
--
ALTER TABLE `jelo`
  MODIFY `jelo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `restoran`
--
ALTER TABLE `restoran`
  MODIFY `restoran_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sastojak`
--
ALTER TABLE `sastojak`
  MODIFY `sastojak_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `sastojci_za_jela`
--
ALTER TABLE `sastojci_za_jela`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
