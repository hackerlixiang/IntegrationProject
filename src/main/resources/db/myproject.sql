/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-01-06 18:28:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_data_dictionary`;
CREATE TABLE `t_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_dictionary
-- ----------------------------
INSERT INTO `t_data_dictionary` VALUES ('1', '2017-01-06 18:28:24', '2017-01-06 18:28:24', '111', '性别');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `level` int(255) DEFAULT NULL,
  `sort` int(255) DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('18', 'hgjkkks', '/dpppss/aaas', 'icon-sort-by-attributes-alt', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('19', 'yyyyy', '/jjj/kkkk', 'icon-won', null, null, '5', null, null);
INSERT INTO `t_menu` VALUES ('20', 'ssss', '/dasdd/ssssss', 'icon-yen', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('21', 'ddds', '/dasdd/ssa', 'icon-cny', null, null, '5', null, null);
INSERT INTO `t_menu` VALUES ('22', 'dsss', '/dddpss/aaa222222', 'icon-btc', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('23', 'fdf', '/ddass/aaas', 'icon-dollar', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('24', ',', null, null, null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('27', 'sada', '/ass', '', null, null, '5', null, null);
INSERT INTO `t_menu` VALUES ('31', '子菜单31', 'sd/asd', 'icon-envelope-alt', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('32', '啊啊啊', '/hsjsj', 'icon-barcode', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('33', '吃吃吃', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('34', '吃吃吃我', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('35', '吃吃吃我的', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('36', '吃吃吃我的去', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('37', '吃吃吃我的去啊', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('38', '吃突突突', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('39', '吃突刚刚', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('40', '吃突刚去', '/fff', 'icon-bookmark', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('41', '额外人', '/ggg', 'icon-text-height', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('42', '柔柔弱弱', '/hhh', 'icon-indent-right', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('43', 'aaa', '/sad111', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('44', 'ggg', '/asdasd', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('45', 'dsasd', '/asdasdD', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('46', 'dsasdA', '/asdasdDS', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('47', 'dsasdAas', '/asdasdDSs2', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('48', 'dsaa', '/asddd', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('49', 'dsaas', '/asddd2', 'icon-exchange', null, null, null, null, null);
INSERT INTO `t_menu` VALUES ('50', 'ggg2', '/asdasdDSss', 'icon-envelope', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('', '2016-09-22 15:04:08', '2016-09-22 15:04:08', 'asdas', '11111111', null);
