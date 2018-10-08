/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-10-08 10:12:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(8) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1235 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '2018-08-03 13:34:59');
INSERT INTO `sys_user` VALUES ('2', 'think', '123789', '0000-00-00 00:00:00');
INSERT INTO `sys_user` VALUES ('3', 'kkk', 'lkksjs', '0000-00-00 00:00:00');
INSERT INTO `sys_user` VALUES ('123', 'test', null, '2018-10-08 10:07:27');
INSERT INTO `sys_user` VALUES ('124', null, null, '2018-10-08 10:09:29');
INSERT INTO `sys_user` VALUES ('1234', 'test1', null, '2018-10-08 10:10:24');
