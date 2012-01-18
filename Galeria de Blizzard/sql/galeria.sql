/*
Navicat MySQL Data Transfer

Source Server         : AsfoDB
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : galeria

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2012-01-18 00:10:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `accounts`
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID Unico',
  `user` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Nombre de usuario',
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Contrasena',
  `group` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'Grupo',
  `banned` int(10) unsigned NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'Email de contacto',
  PRIMARY KEY (`id`),
  UNIQUE KEY `a` (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Informacion de Cuentas';

-- ----------------------------
-- Records of accounts
-- ----------------------------

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) NOT NULL,
  `approved` int(2) NOT NULL DEFAULT '1',
  `description` text NOT NULL,
  `user` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 OMMENT='Imagenes';

-- ----------------------------
-- Records of image
-- ----------------------------
