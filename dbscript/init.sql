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