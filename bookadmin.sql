/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : bookadmin

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-12-02 10:17:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(500) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `publisher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book_category` (`category_id`),
  KEY `FK_book_publisher` (`publisher_id`),
  CONSTRAINT `FK_book_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_book_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9', '活着', 'LZCG9', '余华', '31', '1');
INSERT INTO `book` VALUES ('10', '哈利波特', 'YCTJ10', 'J.K罗琳', '36', '6');
INSERT INTO `book` VALUES ('11', '你当像鸟飞往你的山', 'RWYSK11', '塔拉', '1', '6');
INSERT INTO `book` VALUES ('12', '追风筝的人', 'KPBK12', '胡尼塞', '32', '5');
INSERT INTO `book` VALUES ('13', '亲爱的小孩 我把世界读给你听', 'RWYSK13', '沈蕾娜', '1', '5');
INSERT INTO `book` VALUES ('14', '余华作品：活着', 'RWYSK14', '余华', '1', '9');
INSERT INTO `book` VALUES ('15', '三体', 'KHXS15', '刘慈欣', '36', '10');
INSERT INTO `book` VALUES ('16', '朗文·外研社·新概念英语1：英语初阶 ', 'YWQK16', '[英]亚历山大，何其莘', '35', '11');
INSERT INTO `book` VALUES ('17', '人间失格', 'RWYSK17', '[日] 太宰治 著，烨伊 译', '1', '12');
INSERT INTO `book` VALUES ('18', '菊与刀', 'RWYSK18', '[美] 本尼迪克特 著，秦墨 译', '1', '13');
INSERT INTO `book` VALUES ('19', '窗边的小豆豆（2018版）（爱心树童书）', 'ETWX19', '[日] 黑柳彻子 著', '37', '14');
INSERT INTO `book` VALUES ('20', '爸爸的声音 最好的胎教', 'YCTJ20', '汉竹', '33', '15');
INSERT INTO `book` VALUES ('21', '美国陷阱', 'ZLGL21', '弗雷德里克·皮耶鲁齐（Frédéric Pierucci），马修·阿伦（Matthieu Aron）', '38', '16');
INSERT INTO `book` VALUES ('22', '心 稻盛和夫的一生嘱托', 'ZHGY22', '稻盛和夫', '39', '17');

-- ----------------------------
-- Table structure for bookstock
-- ----------------------------
DROP TABLE IF EXISTS `bookstock`;
CREATE TABLE `bookstock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `stock` int DEFAULT NULL,
  `total_stock` int DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book_bookstock` (`book_id`),
  CONSTRAINT `FK_book_bookstock` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of bookstock
-- ----------------------------
INSERT INTO `bookstock` VALUES ('6', '6', '6', '9');
INSERT INTO `bookstock` VALUES ('7', '9', '9', '10');
INSERT INTO `bookstock` VALUES ('8', '100', '100', '11');
INSERT INTO `bookstock` VALUES ('9', '9', '9', '12');
INSERT INTO `bookstock` VALUES ('10', '9', '9', '13');
INSERT INTO `bookstock` VALUES ('11', '9', '9', '14');
INSERT INTO `bookstock` VALUES ('12', '9', '9', '15');
INSERT INTO `bookstock` VALUES ('13', '9', '9', '16');
INSERT INTO `bookstock` VALUES ('14', '9', '9', '17');
INSERT INTO `bookstock` VALUES ('15', '9', '9', '18');
INSERT INTO `bookstock` VALUES ('16', '18', '18', '19');
INSERT INTO `bookstock` VALUES ('17', '9', '9', '20');
INSERT INTO `bookstock` VALUES ('18', '9', '9', '21');
INSERT INTO `bookstock` VALUES ('19', '9', '9', '22');

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `status` smallint DEFAULT NULL COMMENT '状态: 0:冻结 1:启动',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of borrower
-- ----------------------------
INSERT INTO `borrower` VALUES ('1', '张三', '123', '123', '2020-11-30 21:58:52', '0');
INSERT INTO `borrower` VALUES ('2', '李四', '123', '123', '2020-10-15 21:58:56', '1');
INSERT INTO `borrower` VALUES ('3', '王五', '123', '123', '2020-09-18 21:59:17', '0');
INSERT INTO `borrower` VALUES ('4', 'test1', '123', '123', '2020-11-12 21:59:51', '0');
INSERT INTO `borrower` VALUES ('5', 'test2', '123', '123', '2020-12-01 17:05:44', '0');
INSERT INTO `borrower` VALUES ('6', 'dwq', '123', '123', '2020-11-21 17:08:08', '0');
INSERT INTO `borrower` VALUES ('7', 'dwqs', '123', '123', '2020-12-17 17:08:12', '0');
INSERT INTO `borrower` VALUES ('8', 'zxcx', '123', '123', '2020-12-27 17:08:15', '0');
INSERT INTO `borrower` VALUES ('9', 'sad', '123', '123', '2020-12-16 17:08:17', '0');
INSERT INTO `borrower` VALUES ('10', 'asds', '123', '123', '2020-12-10 17:08:20', '0');
INSERT INTO `borrower` VALUES ('11', 'xc', '123', '123', '2020-12-10 17:08:23', '0');
INSERT INTO `borrower` VALUES ('12', 'xczx', '123', '123', '2020-11-13 17:08:26', '0');
INSERT INTO `borrower` VALUES ('13', 'xzc', '123', '123', '2020-10-14 17:08:29', '0');
INSERT INTO `borrower` VALUES ('14', 'sadsa', '123', '123', '2020-10-10 17:08:34', '0');
INSERT INTO `borrower` VALUES ('15', 'cac', '123', '123', '2020-12-10 17:08:47', '0');
INSERT INTO `borrower` VALUES ('16', 'ccxz', '123', '123', '2020-12-12 17:08:51', '0');

-- ----------------------------
-- Table structure for borrowing
-- ----------------------------
DROP TABLE IF EXISTS `borrowing`;
CREATE TABLE `borrowing` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `borrow_time` datetime DEFAULT NULL COMMENT '借阅时间',
  `return_time` datetime DEFAULT NULL COMMENT '归还时间',
  `status` smallint DEFAULT NULL COMMENT '状态: 1.借阅中. 2已归还 3.超时借阅 4.意外丢失/损坏',
  `borrower_id` bigint DEFAULT NULL COMMENT '借阅人',
  `book_id` bigint DEFAULT NULL COMMENT '借阅的图书',
  PRIMARY KEY (`id`),
  KEY `FK_borrower_borrowing` (`borrower_id`),
  KEY `FK_book_borrowing` (`book_id`),
  CONSTRAINT `FK_book_borrowing` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_borrower_borrowing` FOREIGN KEY (`borrower_id`) REFERENCES `borrower` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of borrowing
-- ----------------------------
INSERT INTO `borrowing` VALUES ('9', '2020-12-01 17:09:01', null, '1', '4', '11');
INSERT INTO `borrowing` VALUES ('10', '2020-11-20 17:09:17', null, '1', '2', '10');
INSERT INTO `borrowing` VALUES ('11', '2020-12-09 17:11:32', null, '1', '5', '11');
INSERT INTO `borrowing` VALUES ('12', '2020-12-11 17:11:35', null, '1', '6', '10');
INSERT INTO `borrowing` VALUES ('13', '2020-12-13 17:11:38', null, '1', '7', '10');
INSERT INTO `borrowing` VALUES ('14', '2020-12-18 17:11:42', null, '1', '7', '9');
INSERT INTO `borrowing` VALUES ('15', '2020-12-17 17:11:44', null, '1', '3', '10');
INSERT INTO `borrowing` VALUES ('16', '2020-12-03 17:11:48', null, '1', '14', '11');
INSERT INTO `borrowing` VALUES ('17', '2020-12-04 17:11:50', null, '1', '6', '9');
INSERT INTO `borrowing` VALUES ('18', '2020-12-05 17:11:53', null, '1', '4', '11');
INSERT INTO `borrowing` VALUES ('19', '2020-12-01 17:14:02', '2020-12-04 17:14:02', '2', '2', '10');
INSERT INTO `borrowing` VALUES ('20', '2020-12-01 17:14:02', '2020-12-04 17:14:02', '2', '5', '11');
INSERT INTO `borrowing` VALUES ('21', '2020-12-01 17:14:02', '2020-12-04 17:14:02', '2', '6', '10');
INSERT INTO `borrowing` VALUES ('22', '2020-12-01 17:14:02', '2020-12-04 17:14:02', '2', '7', '10');
INSERT INTO `borrowing` VALUES ('23', '2020-12-01 17:14:02', '2020-12-04 17:14:02', '2', '7', '9');
INSERT INTO `borrowing` VALUES ('26', '2020-12-20 17:16:14', null, '1', '2', '9');
INSERT INTO `borrowing` VALUES ('27', '2020-12-16 17:16:17', null, '1', '3', '13');
INSERT INTO `borrowing` VALUES ('28', '2020-12-16 17:17:51', null, '3', '6', '13');
INSERT INTO `borrowing` VALUES ('29', '2020-12-25 17:17:53', null, '3', '8', '12');
INSERT INTO `borrowing` VALUES ('30', '2020-12-13 17:17:55', null, '3', '4', '12');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '人文与社科', 'RWYSK');
INSERT INTO `category` VALUES ('2', '计算机科学', 'JSJKX');
INSERT INTO `category` VALUES ('31', '励志成功', 'LZCG');
INSERT INTO `category` VALUES ('32', '科普百科', 'KPBK');
INSERT INTO `category` VALUES ('33', '孕产胎教', 'YCTJ');
INSERT INTO `category` VALUES ('34', '编程语言', 'BCYY');
INSERT INTO `category` VALUES ('35', '英文期刊', 'YWQK');
INSERT INTO `category` VALUES ('36', '科幻小说', 'KHXS');
INSERT INTO `category` VALUES ('37', '儿童文学', 'ETWX');
INSERT INTO `category` VALUES ('38', '战略管理', 'ZLGL');
INSERT INTO `category` VALUES ('39', '智慧格言', 'ZHGY');

-- ----------------------------
-- Table structure for publisher
-- ----------------------------
DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of publisher
-- ----------------------------
INSERT INTO `publisher` VALUES ('1', '清华大学出版社', 'QHDX');
INSERT INTO `publisher` VALUES ('4', '浙江大学出版社', 'ZJDX');
INSERT INTO `publisher` VALUES ('5', '电子工业出版社', 'DZGY');
INSERT INTO `publisher` VALUES ('6', '中国工信出版社', 'ZGGX');
INSERT INTO `publisher` VALUES ('8', '自卑与超越', '阿德勒');
INSERT INTO `publisher` VALUES ('9', '作家出版社', 'ZJ');
INSERT INTO `publisher` VALUES ('10', '重庆出版社', 'CQ');
INSERT INTO `publisher` VALUES ('11', '外语教学与研究出版社', 'WYJXYJ');
INSERT INTO `publisher` VALUES ('12', '武汉出版社', 'WH');
INSERT INTO `publisher` VALUES ('13', '开明出版社', 'KM');
INSERT INTO `publisher` VALUES ('14', '南海出版公司', 'NHCB');
INSERT INTO `publisher` VALUES ('15', '江苏凤凰科学技术出版社', 'JSFH');
INSERT INTO `publisher` VALUES ('16', '中信出版集团', 'ZXCB');
INSERT INTO `publisher` VALUES ('17', '人民邮电出版社', 'RMYD');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级用户', 'ROOT');
INSERT INTO `role` VALUES ('2', '图书管理员', 'BOOK');
INSERT INTO `role` VALUES ('3', '系统管理员', 'SYSTEM');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '状态: 0: 启动 1: 禁用',
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_user` (`role_id`),
  CONSTRAINT `FK_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', '$2a$10$n0phapzVQNu20xjBSupT2.Q019h1exaQ5/bI6UX4gcwXx8P1VMHwu', '0', '2');
INSERT INTO `user` VALUES ('4', 'micheal', '$2a$10$bH07AtBUmD/rKqvNHVUINuo5dkDqm271KAMTN4MG1nOwZ5iKcq.66', '0', '3');
INSERT INTO `user` VALUES ('6', 'root', '$2a$10$bH07AtBUmD/rKqvNHVUINuo5dkDqm271KAMTN4MG1nOwZ5iKcq.66', '0', '1');
INSERT INTO `user` VALUES ('7', 'aa', '$2a$10$7YmZ43ZBWXwadIGE64pTYO2JnCA6tp5qda/2x91dU3LX67sl/n69a', '0', '3');
INSERT INTO `user` VALUES ('8', 'bb', '$2a$10$fPwK1e.6q4kn.4llOQV0qORPCaEnVU/yY7W27FktEk73/HItBV.fK', '0', '2');
INSERT INTO `user` VALUES ('11', 'ccc', '$2a$10$9LbRB7t3.0bZf0QeczPOBehrDcDpcoOhgC4ynm5dLlS3w0ruFJvfK', '0', '2');
