# springboot_ReadAndWriteSplit
一主一从mysql，在代码层面实现读写分离


#####################主数据库###############################
/*
 Navicat MySQL Data Transfer

 Source Server         : 172.16.3.179主
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 172.16.3.179:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 25/01/2019 13:45:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (2, 'wen', 24);
INSERT INTO `member` VALUES (3, 'jie', 25);
INSERT INTO `member` VALUES (4, 'yangwenjie', 25);

SET FOREIGN_KEY_CHECKS = 1;




######################从数据库##############################
/*
 Navicat MySQL Data Transfer

 Source Server         : 172.16.3.180从
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 172.16.3.180:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 25/01/2019 13:44:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (2, 'wen', 24);
INSERT INTO `member` VALUES (3, 'jie', 25);
INSERT INTO `member` VALUES (4, 'yangwenjie', 25);

SET FOREIGN_KEY_CHECKS = 1;
