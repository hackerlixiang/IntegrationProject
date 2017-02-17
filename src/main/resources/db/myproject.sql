/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-02-16 18:02:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `regist_ip` varchar(255) DEFAULT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `head_portrait` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('31', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027880', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034910', '565180710@qq.com', '15982554540', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('32', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027881', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034911', '565180711@qq.com', '15982554541', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('33', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027882', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034912', '565180712@qq.com', '15982554542', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('34', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027883', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034913', '565180713@qq.com', '15982554543', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('35', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027884', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034914', '565180714@qq.com', '15982554544', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('36', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027885', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034915', '565180715@qq.com', '15982554545', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('37', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027886', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034916', '565180716@qq.com', '15982554546', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('38', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027887', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034917', '565180717@qq.com', '15982554547', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('39', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027888', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034918', '565180718@qq.com', '15982554548', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('40', '2017-02-16 16:03:44', '2017-02-16 16:03:44', 'lx027889', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034919', '565180719@qq.com', '15982554549', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('41', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278820', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034920', '5651807120@qq.com', '15982554520', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('42', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278821', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034921', '5651807121@qq.com', '15982554521', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('43', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278822', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034922', '5651807122@qq.com', '15982554522', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('44', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278823', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034923', '5651807123@qq.com', '15982554523', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('45', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278824', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034924', '5651807124@qq.com', '15982554524', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('46', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278825', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034925', '5651807125@qq.com', '15982554525', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('47', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278826', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034926', '5651807126@qq.com', '15982554526', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('48', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278827', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034927', '5651807127@qq.com', '15982554527', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('49', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278828', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034928', '5651807128@qq.com', '15982554528', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('50', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278829', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034929', '5651807129@qq.com', '15982554529', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('51', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278830', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034930', '5651807130@qq.com', '15982554530', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('52', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278831', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034931', '5651807131@qq.com', '15982554531', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('53', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278832', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034932', '5651807132@qq.com', '15982554532', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('54', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278833', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034933', '5651807133@qq.com', '15982554533', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('55', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278834', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034934', '5651807134@qq.com', '15982554534', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('56', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278835', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034935', '5651807135@qq.com', '15982554535', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('57', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278836', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034936', '5651807136@qq.com', '15982554536', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('58', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278837', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034937', '5651807137@qq.com', '15982554537', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('59', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278838', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034938', '5651807138@qq.com', '15982554538', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('60', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278839', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'MAN', '510124199107034939', '5651807139@qq.com', '15982554539', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('61', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278840', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034940', '5651807140@qq.com', '15982554540', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('62', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278841', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034941', '5651807141@qq.com', '15982554541', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('63', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278842', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034942', '5651807142@qq.com', '15982554542', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('64', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278843', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034943', '5651807143@qq.com', '15982554543', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('65', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278844', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034944', '5651807144@qq.com', '15982554544', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('66', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278845', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034945', '5651807145@qq.com', '15982554545', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('67', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278846', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034946', '5651807146@qq.com', '15982554546', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('68', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278847', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034947', '5651807147@qq.com', '15982554547', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('69', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278848', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034948', '5651807148@qq.com', '15982554548', '192.168.151.22', null, null);
INSERT INTO `t_admin` VALUES ('70', '2017-02-16 16:04:45', '2017-02-16 16:04:45', 'lx0278849', 'f6e9864aaf2f396e0d7c926ee4426800', '阿萨德', '~A屌屌屌A~', '1991-07-03 00:00:00', '26', 'WOMAN', '510124199107034949', '5651807149@qq.com', '15982554549', '192.168.151.22', null, null);

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
INSERT INTO `t_data_dictionary` VALUES ('1', '2017-01-06 18:28:24', '2017-01-06 18:28:24', 'SEX', '性别');

-- ----------------------------
-- Table structure for t_data_dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `t_data_dictionary_item`;
CREATE TABLE `t_data_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `data_dictionary_code` varchar(255) NOT NULL,
  `data_dictionary_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `data_dictionary_id` (`data_dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_dictionary_item
-- ----------------------------
INSERT INTO `t_data_dictionary_item` VALUES ('1', '2017-01-10 13:48:11', '2017-01-10 13:48:11', 'SECRECY', '保密', 'SEX', '1');
INSERT INTO `t_data_dictionary_item` VALUES ('2', '2017-01-10 13:48:33', '2017-01-10 13:48:33', 'MAN', '男', 'SEX', '1');
INSERT INTO `t_data_dictionary_item` VALUES ('3', '2017-01-10 13:48:50', '2017-01-10 13:48:50', 'WOMAN', '女', 'SEX', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('19', 'yyyyy', '/jjj/kkkk', 'icon-won', null, null, '5', null, null);
INSERT INTO `t_menu` VALUES ('20', 'ssss', '/dasdd/ssssss', 'icon-yen', null, null, null, null, null);
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
INSERT INTO `t_menu` VALUES ('51', 'asd', '/das', 'icon-exchange', null, null, null, '2017-02-04 09:51:04', '2017-02-04 09:51:04');
INSERT INTO `t_menu` VALUES ('52', 'asd1', '/sss', 'icon-external-link', null, null, null, '2017-02-04 09:51:54', '2017-02-04 09:51:54');
INSERT INTO `t_menu` VALUES ('53', '1111', '/asd', 'icon-exchange', null, null, null, '2017-02-10 14:53:26', '2017-02-10 14:53:26');

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
