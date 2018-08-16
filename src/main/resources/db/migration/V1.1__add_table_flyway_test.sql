/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50625
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 50625
 File Encoding         : 65001

 Date: 16/08/2018 11:37:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flyway_test
-- ----------------------------
DROP TABLE IF EXISTS `flyway_test`;
CREATE TABLE `flyway_test`  (
  `id` int(11) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '测试flyway' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of flyway_test
-- ----------------------------
INSERT INTO `flyway_test` VALUES (1, 'test');

SET FOREIGN_KEY_CHECKS = 1;
