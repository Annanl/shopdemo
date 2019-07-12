/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : shopdemo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 12/07/2019 16:21:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attribute
-- ----------------------------
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `categoryid` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attribute
-- ----------------------------
BEGIN;
INSERT INTO `attribute` VALUES (1, '尺码', '2', '160,165,170,175,180,185');
INSERT INTO `attribute` VALUES (2, '材料', '2', '棉织,丝绸');
INSERT INTO `attribute` VALUES (3, '袖长', '3', '长袖,短袖,无袖');
INSERT INTO `attribute` VALUES (4, '领型', '3', '圆领,V领,门筒领,连帽,立领');
INSERT INTO `attribute` VALUES (5, '裤长', '4', '长裤,九分裤,七分裤,五分裤,短裤');
INSERT INTO `attribute` VALUES (6, '裤型', '4', '直筒型,喇叭型,锥型,紧身型,宽松型,修身型,低裆跨裤,背带裤,工装裤,连体裤,铅笔裤');
INSERT INTO `attribute` VALUES (7, '腰型', '4', '低腰,中腰,高腰');
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(30) DEFAULT NULL,
  `goodsid` varchar(30) DEFAULT NULL,
  `number` int(30) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
INSERT INTO `cart` VALUES (1, '11', '2', 2);
INSERT INTO `cart` VALUES (2, '11', '3', 1);
INSERT INTO `cart` VALUES (3, '11', '6', 3);
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fatherid` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '0', '分类');
INSERT INTO `category` VALUES (2, '1', '服饰');
INSERT INTO `category` VALUES (3, '2', '上衣');
INSERT INTO `category` VALUES (4, '2', '裤子');
INSERT INTO `category` VALUES (5, '1', '电子产品');
COMMIT;

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `number` int(30) unsigned DEFAULT NULL,
  `price` int(30) unsigned DEFAULT NULL,
  `detail` varchar(800) DEFAULT NULL,
  `categoryid` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, '耳机1', NULL, 101, '雷蛇耳机，好吃不贵方便实惠', NULL);
INSERT INTO `goods` VALUES (2, '开心果1', NULL, 64, '开心果，好吃实惠，方便不贵', NULL);
INSERT INTO `goods` VALUES (3, '外星人笔记本', NULL, 23000, '外星人笔记本，你买不起的笔记本', NULL);
INSERT INTO `goods` VALUES (4, '败家之眼主机', NULL, 15000, '败家之眼，玩家国度', NULL);
INSERT INTO `goods` VALUES (5, '毛笔', NULL, 21, '一支毛笔', NULL);
INSERT INTO `goods` VALUES (6, '毛笔2', NULL, 23, '第二支毛笔', NULL);
INSERT INTO `goods` VALUES (7, '耳机2', NULL, 99, '九十九包邮的耳机', NULL);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(30) DEFAULT NULL,
  `goodsid` varchar(30) DEFAULT NULL,
  `number` int(30) unsigned DEFAULT NULL,
  `money` int(30) unsigned DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin3', 'admin3', '111');
INSERT INTO `user` VALUES (2, 'admin2', 'admin2', '222');
INSERT INTO `user` VALUES (3, 'user1', 'user2', '333');
INSERT INTO `user` VALUES (4, 'user2', 'user2', '444');
INSERT INTO `user` VALUES (5, 'wo', 'wommmm', '555');
INSERT INTO `user` VALUES (6, 'ni', 'nimmmm', '666');
INSERT INTO `user` VALUES (9, 'ta', 'tammmm', '777');
INSERT INTO `user` VALUES (10, '111', '111', '111');
INSERT INTO `user` VALUES (11, 'admin', 'admin', '0001');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
