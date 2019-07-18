/*
Navicat MySQL Data Transfer

Source Server         : HCJ
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : mavendemo

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-09-25 16:53:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) DEFAULT NULL,
  `upassword` varchar(64) DEFAULT NULL,
  `uemail` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', 'admin@126.com');
INSERT INTO `user` VALUES ('2', 'zhangsan', 'zhangsan123', 'zs123@126.com');
