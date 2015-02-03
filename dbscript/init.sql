-- ----------------------------
-- Table structure for activity_pics  活动图片
-- ----------------------------
DROP TABLE IF EXISTS `activity_pics`;
CREATE TABLE `activity_pics` (
  `id` int(11) NOT NULL,
  `small_pic` varchar(255) DEFAULT NULL,
  `big_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_type 险种类型
-- ----------------------------
DROP TABLE IF EXISTS `xz_type`;
CREATE TABLE `xz_type` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for area  区域
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL COMMENT '纬度',
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '上海', '1', null, null, null);
INSERT INTO `area` VALUES ('2', '黄浦区', '1', '1', '31.237373', '121.491194');
INSERT INTO `area` VALUES ('3', '徐汇区', '2', '1', '31.194908', '121.442885');
INSERT INTO `area` VALUES ('4', '长宁区', '3', '1', '31.226535', '121.430868');
INSERT INTO `area` VALUES ('5', '静安区', '4', '1', '31.229769', '121.462366');
INSERT INTO `area` VALUES ('6', '普陀区', '5', '1', '31.255102', '121.403529');
INSERT INTO `area` VALUES ('7', '闸北区', '6', '1', '31.253373', '121.465963');
INSERT INTO `area` VALUES ('8', '虹口区', '7', '1', '31.270142', '121.511735');
INSERT INTO `area` VALUES ('9', '杨浦区', '8', '1', '31.265774', '121.532291');
INSERT INTO `area` VALUES ('10', '宝山区', '9', '1', '31.410951', '121.495971');
INSERT INTO `area` VALUES ('11', '闵行区', '10', '1', '31.118509', '121.388372');
INSERT INTO `area` VALUES ('12', '嘉定区', '11', '1', '31.380474', '121.272804');
INSERT INTO `area` VALUES ('13', '浦东新区', '12', '1', '31.227384', '121.550544');
INSERT INTO `area` VALUES ('14', '松江区', '13', '1', '31.038173', '121.235413');
INSERT INTO `area` VALUES ('15', '金山区', '14', '1', '30.747991', '121.348902');
INSERT INTO `area` VALUES ('16', '青浦区', '15', '1', '31.155515', '121.130784');
INSERT INTO `area` VALUES ('17', '奉贤区', '16', '1', '30.923797', '121.480574');
INSERT INTO `area` VALUES ('18', '崇明县', '17', '1', '31.628659', '121.403855');

alter table news2 add imgPath varchar(255);
alter table tcardcx add xzId int(11);
alter table tcardcxtx add xzId int(11);
alter table users add phone_code varchar(10);
alter table zpdw add locate varchar(20);


-- ----------------------------
-- Table structure for branch 商户分店
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `locate` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `mer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


alter table merchants add tel varchar(20),add logo_path varchar(255),add about varchar(255),add about_detail varchar(255);

DROP TABLE IF EXISTS `downloads`;
CREATE TABLE `downloads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logo_file_path` varchar(100) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `app_size` float DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `android_download_path` varchar(200) DEFAULT NULL,
  `ios_app_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `labour_union_code` varchar(50) DEFAULT NULL,
  `phone_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-----------------------------------------
--------------互助保障----------------------
CREATE TABLE `xz_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

alter table zpdw add union_aboue varchar(20);
alter table zpdw add tel varchar(20);
alter table zpzw add job_detail varchar(20);