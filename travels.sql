/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : travels

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 11/12/2021 16:54:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_place
-- ----------------------------
DROP TABLE IF EXISTS `t_place`;
CREATE TABLE `t_place`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picpath` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `hottime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotticket` double(7, 2) NULL DEFAULT NULL,
  `dimticket` double(7, 2) NULL DEFAULT NULL,
  `placedes` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `provinceid` int(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_place
-- ----------------------------
INSERT INTO `t_place` VALUES (13, '成都大熊猫繁育研究基地', '20211010145637.jpg', '6月', 87.00, 10.84, '位于成都北郊斧头山，距市区10公里，有一条宽阔的熊猫大道与市区相连，大熊猫博物馆内珍贵的资料、丰富的展品举世无双，是认识大熊猫、回归大自然、观光旅游、休闲娱乐的极佳场所。大熊猫、小熊猫、黑颈鹤等珍稀濒危动物在这里悠然自得地生息繁衍。', 33);
INSERT INTO `t_place` VALUES (14, '峨眉山', '20211010145605.jpg', '8月', 0.00, 0.00, '峨眉山位于中国四川峨眉山市境内，景区面积154平方公里，最高峰万佛顶海拔3099米。地势陡峭，风景秀丽，有“秀甲天下”之美誉。', 33);
INSERT INTO `t_place` VALUES (15, '九寨沟自然保护区', '20211010144908.jpg', '8月', 90.00, 40.00, '九寨沟因沟内分布着9个藏族村寨而得名，海拔2000～3000米，属高山深谷碳酸盐堰塞地貌，以翠海（高山湖泊）、叠海、彩林、雪山、藏情“五绝”驰名中外，被誉为“梦仙境”和“童话世界”。', 33);
INSERT INTO `t_place` VALUES (16, '文殊院', '20211010145921.jpg', '9月', 82.00, 42.00, '文殊院地处我国四川省成都，是远近闻名的佛教寺院。文殊院曾经名为圆塔院，宋朝时期改名为信相寺，后于清朝康熙年间重建，并改名号为文殊院', 33);
INSERT INTO `t_place` VALUES (17, '青城山', '20211006215653.jpg', '8月', 143.99, 89.99, '我国著名的四大道教名山之一--青城山，地处四川省都江堰。青城山称得上是一座山奇水秀、风光绮丽的绝色美景佳地，这里被群峰环抱，浓荫覆地，一年四季都山林耸翠，因而被人们赋予青城的美称。', 33);
INSERT INTO `t_place` VALUES (18, '锦里步行街', '20211010150004.jpg', '8月', 75.00, 22.96, '锦里步行街是西蜀历史上最古老、最具有商业气息的街道之一，早在秦汉、三国时期便闻名全国。', 33);
INSERT INTO `t_place` VALUES (20, '丽江古城', '20211010120029.jpg', '6月', 75.00, 45.00, '座落于丽江坝', 35);

-- ----------------------------
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tags` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `placecounts` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES (33, '四川', '大熊猫、峨嵋派、杜甫草堂', 6);
INSERT INTO `t_province` VALUES (35, '云南', '丽江古城', 1);
INSERT INTO `t_province` VALUES (36, '江苏', '苏州园林', 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'jiuyu', 'jiuyu123', 'jiuyu@163.com');
INSERT INTO `t_user` VALUES (2, 'cidy', 'cidy', 'cidy@163.com');
INSERT INTO `t_user` VALUES (3, 'windy', 'windy', 'windy@qq.com');
INSERT INTO `t_user` VALUES (4, 'ketty', 'ketty', 'ketty@126.com');

SET FOREIGN_KEY_CHECKS = 1;
