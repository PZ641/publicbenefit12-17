/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 21/05/2020 15:41:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(12) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8999032 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qq', 'a', 0);
INSERT INTO `user` VALUES (3, '123111', '123', 0);
INSERT INTO `user` VALUES (100, '测试', '110', NULL);
INSERT INTO `user` VALUES (333, '123111', '123', 0);
INSERT INTO `user` VALUES (803, '1', '1', 0);
INSERT INTO `user` VALUES (891, '123111', '123', 0);
INSERT INTO `user` VALUES (893, '1', '1', 0);
INSERT INTO `user` VALUES (1133, '1', '1', 0);
INSERT INTO `user` VALUES (8133, '1', '1', 0);
INSERT INTO `user` VALUES (8311, '102', '102', 102);
INSERT INTO `user` VALUES (10008, '1008', '100', 0);
INSERT INTO `user` VALUES (10303, '1010101010', '1888', NULL);
INSERT INTO `user` VALUES (11331, '11', '1', 0);
INSERT INTO `user` VALUES (87703, '1', '1', 0);
INSERT INTO `user` VALUES (89031, '11', '1', 0);
INSERT INTO `user` VALUES (89331, '11', '1', 0);
INSERT INTO `user` VALUES (811331, '11', '1', 0);
INSERT INTO `user` VALUES (890881, '11', '1', 0);
INSERT INTO `user` VALUES (899031, '11', '1', 0);
INSERT INTO `user` VALUES (8901131, '11', '1', 0);
INSERT INTO `user` VALUES (8966031, '11', '1', 0);
INSERT INTO `user` VALUES (8999031, '11', '1', 0);

SET FOREIGN_KEY_CHECKS = 1;
