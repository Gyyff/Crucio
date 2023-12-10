/*
 Navicat Premium Data Transfer

 Source Server         : chat
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : gz-cdb-n80gj0zv.sql.tencentcdb.com:63547
 Source Schema         : chat

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 07/12/2023 11:05:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userdevice
-- ----------------------------
DROP TABLE IF EXISTS `userdevice`;
CREATE TABLE `userdevice`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `UserId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `DeviceId` varchar(64) NULL DEFAULT NULL COMMENT '设备id',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `idx_userid`(`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3;

SET FOREIGN_KEY_CHECKS = 1;
