-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2022 at 03:57 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- START TRANSACTION;
-- SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE Database if not exists `web_app_middle`;

--
-- Database: `web_app_middle`
--

-- --------------------------------------------------------
use `web_app_middle`;
--
-- Table structure for table `app_user`
--


--
CREATE TABLE `app_user` (
  `USER_ID` bigint(20) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `USER_NAME` varchar(36) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  `ROLE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`USER_ID`, `NAME`, `USER_NAME`, `ENCRYTED_PASSWORD`, `ENABLED`, `ROLE`) VALUES
(1, 'Admin', 'admin', '$2a$10$ND8pUhrN6pdiS.kjOmVfKuuq42bGubAjgwpxOEZbwMpTsdTJNUFD2', b'1', 'ADMIN'),
(2, 'Tran Tan Hung\r\n', 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', b'1', 'USER'),
(3, 'Tran Van A', 'vana', '$2a$10$rvlWvNsgwRXuKYsXZ1t74uwmAq3x8rNPpoosoABgWnjE5IsqyOami', b'1', 'USER'),
(4, 'Tran Van A', 'tranvana', '$2a$10$.yepXcwZPVyA7pkdR/CuHeOdUtPFEGRtLTjUYTAwud9fjHMaWekrW', b'1', 'USER'),
(5, 'Duong Van An', 'duongvanan', '$2a$10$ND8pUhrN6pdiS.kjOmVfKuuq42bGubAjgwpxOEZbwMpTsdTJNUFD2', b'1', 'USER'),
(6, 'tanhung', 'tanhung123', '$2a$10$dwrXMqopgqgc099FyMqEOuDAQy8a6NzCH8EG5iVTJNfGsHgtqjyWS', b'1', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `clothes`
--

CREATE TABLE `clothes` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `image` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clothes`
--

INSERT INTO `clothes` (`id`, `name`, `price`, `description`, `image`, `quantity`) VALUES
(42, 'Áo Polo Nam In Sọc ', 465000, '', 'Áo Polo Nam In Sọc.jpg', 20),
(43, 'Áo Polo Nam In Sọc Trắng', 465000, '', 'Áo Polo Nam In Sọc Trắng.jpg', 10),
(44, 'Áo Thun Nam In Chữ Phồng', 365000, '', 'Áo Thun Nam In Chữ Phồng.jpg', 50),
(45, 'Áo Thun Nam In Chữ', 345000, '', 'Áo Thun Nam In Chữ.jpg', 20),
(46, 'Áo Khoác Nam Dù', 545000, '', 'Áo Khoác Nam Dù.jpg', 30),
(47, 'Áo Khoác Nam', 575000, '', 'Áo Khoác Nam.jpg', 40),
(48, 'BT Lightweight Jackets', 525000, '', 'BT Lightweight Jackets.jpg', 30),
(49, 'Detail Hoodies', 450000, '', 'Detail Hoodies.jpg', 50),
(50, 'Quần Jean Dài Nam SL', 625000, '', 'Quần Jean Dài Nam SL.jpg', 10),
(51, 'Quần Jean Dài Nam SL2', 655000, '', 'Quần Jean Dài Nam SL2.jpg', 10),
(52, 'Quần Jean Dài Wash', 625000, '', 'Quần Jean Dài Wash.jpg', 10),
(53, 'Quần Tây Nam Trơn', 495000, '', 'Quần Tây Nam Trơn.jpg', 10),
(54, 'Quần Tây Nam Caro', 575000, '', 'Quần Tây Nam Caro.jpg', 40),
(55, 'Quần Tây Nam Trắng', 575000, '', 'Quần Tây Nam Trắng.jpg', 10),
(56, 'Stripe Side Tab Pants', 575000, '', 'Stripe Side Tab Pants.jpg', 10),
(57, 'Quần Tây Trơn Nâu', 625000, '', 'Quần Tây Trơn Nau.jpg', 10),
(58, 'Hight Side Tap Pants', 595000, '', 'Hight Side Tap Pants.jpg', 10),
(59, 'Quần Short Nam', 345000, '', 'Quần Short Nam.jpg', 10),
(60, 'Quần Short Thun Nam Slim Fit', 259000, '', 'Quần Short Thun Nam Slim Fit.jpg', 10),
(61, 'Col Bermuda Shorts', 200000, '', 'Col Bermuda Shorts.jpg', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `APP_USER_UK` (`USER_NAME`);

--
-- Indexes for table `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `clothes`
--
ALTER TABLE `clothes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
