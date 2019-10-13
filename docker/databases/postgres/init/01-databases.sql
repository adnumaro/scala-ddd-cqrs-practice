CREATE DATABASE IF NOT EXISTS `aphex_api`;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'toor';
GRANT ALL ON *.* TO 'root'@'%';
