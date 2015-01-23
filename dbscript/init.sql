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
-- Table structure for sys_code 区域类型
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `VALUE` varchar(128) NOT NULL,
  `CODE` varchar(64) DEFAULT NULL,
  `IS_DELETED` int(11) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `PARENT` varchar(128) DEFAULT NULL,
  `TYPE` varchar(128) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`VALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code 数据字典
-- ----------------------------
INSERT INTO `sys_code` VALUES ('10001', '10', '0', '工作区域', '', '', '1');
INSERT INTO `sys_code` VALUES ('10001-10', '10', '0', '黄浦区', '10001', '10001', '1');
INSERT INTO `sys_code` VALUES ('10001-100', '100', '0', '闵行区', '10001', '10001', '10');
INSERT INTO `sys_code` VALUES ('10001-110', '110', '0', '嘉定区', '10001', '10001', '11');
INSERT INTO `sys_code` VALUES ('10001-120', '120', '0', '浦东新区', '10001', '10001', '12');
INSERT INTO `sys_code` VALUES ('10001-130', '130', '0', '松江区', '10001', '10001', '13');
INSERT INTO `sys_code` VALUES ('10001-140', '140', '0', '金山区', '10001', '10001', '14');
INSERT INTO `sys_code` VALUES ('10001-150', '150', '0', '青浦区', '10001', '10001', '15');
INSERT INTO `sys_code` VALUES ('10001-160', '160', '0', '奉贤区', '10001', '10001', '16');
INSERT INTO `sys_code` VALUES ('10001-170', '170', '0', '崇明县', '10001', '10001', '17');
INSERT INTO `sys_code` VALUES ('10001-20', '20', '0', '徐汇区', '10001', '10001', '2');
INSERT INTO `sys_code` VALUES ('10001-30', '30', '0', '长宁区', '10001', '10001', '3');
INSERT INTO `sys_code` VALUES ('10001-40', '40', '0', '静安区', '10001', '10001', '4');
INSERT INTO `sys_code` VALUES ('10001-50', '50', '0', '普陀区', '10001', '10001', '5');
INSERT INTO `sys_code` VALUES ('10001-60', '60', '0', '闸北区', '10001', '10001', '6');
INSERT INTO `sys_code` VALUES ('10001-70', '70', '0', '虹口区', '10001', '10001', '7');
INSERT INTO `sys_code` VALUES ('10001-80', '80', '0', '杨浦区', '10001', '10001', '8');
INSERT INTO `sys_code` VALUES ('10001-90', '90', '0', '宝山区', '10001', '10001', '9');

alter table news2 add imgPath varchar(255);
alter table tcardcx add xzId int(11);
alter table tcardcxtx add xzId int(11);
alter table users add phone_code varchar(10);
alter table zpdw add locate varchar(20);