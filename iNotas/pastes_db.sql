/*
Navicat MySQL Data Transfer

Source Server         : AsfoDB
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2011-12-13 13:25:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pastes`
-- ----------------------------
DROP TABLE IF EXISTS `pastes`;
CREATE TABLE `pastes` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `paste` text NOT NULL,
  `lenguaje` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pastes
-- ----------------------------
