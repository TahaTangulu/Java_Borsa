-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.11-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- javasql için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `javasql` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `javasql`;

-- tablo yapısı dökülüyor javasql.ogrenci
CREATE TABLE IF NOT EXISTS `ogrenci` (
  `Ad` varchar(50) NOT NULL,
  `SoyAd` varchar(50) NOT NULL,
  `Yas` int(11) NOT NULL,
  `Numara` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- javasql.ogrenci: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `ogrenci`;
/*!40000 ALTER TABLE `ogrenci` DISABLE KEYS */;
INSERT INTO `ogrenci` (`Ad`, `SoyAd`, `Yas`, `Numara`) VALUES
	('Taha', 'Tan', 25, 16260055),
	('Mehmet', 'Topal', 20, 18260030),
	('Hasan', 'Ünlü', 21, 15253440),
	('Mustafa', 'Solmaz', 18, 20260035);
/*!40000 ALTER TABLE `ogrenci` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
