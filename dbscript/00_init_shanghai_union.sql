/*
Source Database       : shanghai_union

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001
*/

DROP DATABASE IF EXISTS shanghai_union;
CREATE DATABASE shanghai_union DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE shanghai_union;

SET FOREIGN_KEY_CHECKS=0;



-- ----------------------------
-- Records of t_app_activation
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_aroundcampus`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_aroundcampus`;
CREATE TABLE `t_app_aroundcampus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aroundcampusName` varchar(32) NOT NULL COMMENT '商铺名称',
  `aroundcampusType` tinyint(2) NOT NULL COMMENT '商铺类型（1:food、2:sports、3:drink、4:other）',
  `aroundcampusAddress` varchar(64) NOT NULL COMMENT '商铺文本地址',
  `aroundcampusLongitude` varchar(16) NOT NULL COMMENT '商铺地址（经度）',
  `aroundcampusLatitude` varchar(16) NOT NULL COMMENT '商铺地址（纬度）',
  `aroundcampusStartHour` varchar(2) NOT NULL COMMENT '商铺营业时（开始）',
  `aroundcampusStartMinute` varchar(2) NOT NULL COMMENT '商铺营业分（开始）',
  `aroundcampusFinshHour` varchar(2) NOT NULL COMMENT '商铺营业时（结束）',
  `aroundcampusFinshMinute` varchar(2) NOT NULL COMMENT '商铺营业分（结束）',
  `aroundcampusPhone` varchar(16) NOT NULL COMMENT '联系电话',
  `aroundcampusIntroduction` varchar(128) NOT NULL COMMENT '商铺简介',
  `aroundcampusIntroductionShort` varchar(64) NOT NULL COMMENT '店铺摘要',
  `aroundcampusStatus` tinyint(2) NOT NULL DEFAULT 1 COMMENT '商铺状态（1待审核2已审核3审核未通过4删除）',
  `aroundcampusIsTop` tinyint(2) NOT NULL DEFAULT 1 COMMENT '置顶状态（1未置顶2已置顶）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商铺信息表';

-- ----------------------------
-- Records of t_app_aroundcampus
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_check`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_check`;
CREATE TABLE `t_app_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foreignId` int(11) NOT NULL COMMENT '商铺/活动（外键id）',
  `foreignType` tinyint(2) NOT NULL COMMENT '类型（1商铺2活动）',
  `checkOpinion` varchar(128) NOT NULL COMMENT '审核意见（审核未通过原因）',
  `createTime` datetime NOT NULL COMMENT '审核时间',
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核意见信息表';

-- ----------------------------
-- Records of t_app_check
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_directory`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_directory`;
CREATE TABLE `t_app_directory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `directoryName` varchar(16) NOT NULL COMMENT '目录名称',
  `directoryParentId` int(11) NOT NULL COMMENT '上级目录（外键）',
  `directoryType` tinyint(2) NOT NULL COMMENT '目录类型（1代表PreArrival、2代表Arrival、3代表campus）',
  `directorySortNumber` int(11) NOT NULL COMMENT '排序号码',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录信息表';

-- ----------------------------
-- Records of t_app_directory
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_directory_content`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_directory_content`;
CREATE TABLE `t_app_directory_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `directoryId` int(11) NOT NULL COMMENT '目录id（外键）',
  `contentTitle` varchar(32) NOT NULL COMMENT '内容标题',
  `contentText` text NOT NULL COMMENT '内容文本',
  `contentSortNumber` int(11) NOT NULL COMMENT '排序号码',
  `directoryType` tinyint(2) NOT NULL COMMENT '内容类型（1代表PreArrival、2代表Arrival、3代表campus）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录内容信息表';

-- ----------------------------
-- Records of t_app_directory_content
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_events`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_events`;
CREATE TABLE `t_app_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eventsName` varchar(32) NOT NULL COMMENT '活动名称',
  `eventsType` tinyint(2) NOT NULL COMMENT '活动类型（lecture:1、traveling:2、sports:3、ceremony:4、school club:5、forum:6、literature and art:7、entertainment:8、other:9）',
  `eventsAddress` varchar(64) NOT NULL COMMENT '活动地址',
  `eventsStartTime` datetime NOT NULL COMMENT '活动时间（开始）',
  `eventsFinshTime` datetime NOT NULL COMMENT '活动时间（结束）',
  `eventsCostMoney` double NOT NULL COMMENT '活动花费（元）',
  `eventsPhone` varchar(16) NOT NULL COMMENT '联系电话',
  `eventsIntroduction` varchar(512) NOT NULL COMMENT '活动简介',
  `eventsIntroductionShort` varchar(64) NOT NULL COMMENT '活动摘要',
  `eventsStatus` tinyint(2) NOT NULL DEFAULT 1 COMMENT '活动状态（1待审核2已审核3审核未通过4删除）',
  `createTime` datetime DEFAULT NULL COMMENT '活动创建时间',
  `createUser` varchar(32) DEFAULT NULL COMMENT '活动创建人',
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动信息表';

-- ----------------------------
-- Records of t_app_events
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_events_joiner`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_events_joiner`;
CREATE TABLE `t_app_events_joiner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eventsId` int(11) NOT NULL COMMENT '活动id（外键）',
  `studentId` int(11) NOT NULL COMMENT '学生id（外键）',
  `createTime` datetime DEFAULT NULL COMMENT '报名时间',
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动报名信息表';

-- ----------------------------
-- Records of t_app_events_joiner
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_events_reader`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_events_reader`;
CREATE TABLE `t_app_events_reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eventsId` int(11) NOT NULL COMMENT '活动id（外键）',
  `studentId` int(11) NOT NULL COMMENT '学生id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动已读信息表';

-- ----------------------------
-- Records of t_app_events_reader
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_notification`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_notification`;
CREATE TABLE `t_app_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notificationTitle` varchar(32) NOT NULL COMMENT '通知标题',
  `notificationContent` varchar(1024) NOT NULL COMMENT '通知内容',
  `notificationShortContent` varchar(64) NOT NULL COMMENT '通知简要内容',
  `notificationType` tinyint(2) NOT NULL COMMENT '通知类型（1普通2活动）',
  `eventsId` int(11) DEFAULT NULL COMMENT '活动id（外键）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(32) NOT NULL COMMENT '发送人',
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知信息表';

-- ----------------------------
-- Records of t_app_notification
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_notification_receiver`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_notification_receiver`;
CREATE TABLE `t_app_notification_receiver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notificationId` int(11) NOT NULL COMMENT '通知id（外键）',
  `studentId` int(11) NOT NULL COMMENT '学生id（外键）',
  `notificationIsRead` tinyint(2) NOT NULL DEFAULT 1 COMMENT '是否已读(1未读2已读)',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知接收者关联信息表';

-- ----------------------------
-- Records of t_app_notification_receiver
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_picture`;
CREATE TABLE `t_app_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pictureLargeFilePath` varchar(128) NOT NULL COMMENT '大图（相对路径）',
  `pictureSmallFilePath` varchar(128) NOT NULL COMMENT '小图（相对路径）',
  `foreignId` int(11) NOT NULL COMMENT '通知、内容、店铺、活动（外键id）',
  `foreignType` tinyint(2) NOT NULL COMMENT '类型(1通知、2内容、3店铺、4活动)',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片信息表';

-- ----------------------------
-- Records of t_app_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `t_app_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_student`;
CREATE TABLE `t_app_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键（自动增长）',
  `studentEmail` varchar(64) NOT NULL COMMENT 'Email（唯一帐号）',
  `studentPassword` varchar(64) NOT NULL COMMENT '密码（MD5）',
  `pushChannelId` varchar(64) DEFAULT NULL COMMENT '推送通道ID',
  `pushUserId` varchar(64) DEFAULT NULL COMMENT '推送应用的用户ID',
  `pushDeviceType` tinyint(2) DEFAULT NULL COMMENT '设备类型3:Android、4:IOS',
  `pushDeviceToken` varchar(64) DEFAULT NULL COMMENT '设备唯一标识',
  `activationCode` varchar(8) NOT NULL COMMENT '激活码（注册APP验证用）',
  `studentStatus` tinyint(2) NOT NULL DEFAULT 1 COMMENT '用户状态（1待激活2正常3过期）',
  `studentMobilePhone` varchar(16) DEFAULT NULL COMMENT '手机号码（中国的）',

  `chineseName` varchar(32) DEFAULT NULL COMMENT '中文名称',
  `englishName` varchar(64) NOT NULL COMMENT '英文姓名（护照名）',
  `sexuality` tinyint(2) NOT NULL COMMENT '性别男1女2',
  `nationality` varchar(32) NOT NULL COMMENT '国籍',
  `maritalStatus` tinyint(2) NOT NULL COMMENT '婚姻状况（已婚2或单身1）',
  `birthCountry` varchar(32) DEFAULT NULL COMMENT '出生国家',
  `birthCity` varchar(64) NOT NULL COMMENT '出生城市',
  `birthDate` datetime NOT NULL COMMENT '出生日期',
  `religion` tinyint(2) NOT NULL COMMENT '宗教信仰',
  `passportNumber` varchar(64) NOT NULL COMMENT '护照号码',
  `passportExpireDate` datetime DEFAULT NULL COMMENT '护照到期日期',
  `passportPhotoFile` varchar(128) DEFAULT NULL COMMENT '护照照片',
  `visaNumber` varchar(64) DEFAULT NULL COMMENT '签证号码',
  `visaExpireDate` datetime DEFAULT NULL COMMENT '签证到期日期',
  `visaPhotoFile` varchar(128) DEFAULT NULL COMMENT '签证照片',
  `highestDegree` tinyint(2) NOT NULL COMMENT '最后学历',

  `studyPlanTermId` int(11) DEFAULT NULL COMMENT '学期选择(外键id)',

  `languageChineseAbility` tinyint(2) NOT NULL COMMENT '汉语能力',
  `languageChineseLevel` tinyint(2) DEFAULT NULL COMMENT '汉语能力级别',
  `languageEnglishAbility` tinyint(2) NOT NULL COMMENT '英语能力',
  `languageEnglishLevel` tinyint(2) DEFAULT NULL COMMENT '英语能力级别',
  `economyGuarantor` varchar(32) NOT NULL COMMENT '担保人（经济担保）',
  `economyGuarantorRelation` tinyint(2) DEFAULT NULL COMMENT '双方关系（经济担保）',
  `economyGuarantorPhone` varchar(32) NOT NULL COMMENT '联系电话（经济担保）',
  `economyGuarantorAddress` varchar(128) DEFAULT NULL COMMENT '住址（经济担保）',
  `emergencyContactor` varchar(32) DEFAULT NULL COMMENT '姓名（紧急联系人）',
  `emergencyContactorEmail` varchar(64) DEFAULT NULL COMMENT 'Email（紧急联系人）',
  `emergencyContactorPhone` varchar(32) NOT NULL COMMENT '联系电话（紧急联系人）',
  `emergencyContactorAddress` varchar(128) NOT NULL COMMENT '住址（紧急联系人）',
  `homeMobilePhone` varchar(16) DEFAULT NULL COMMENT '手机（本国联系方式）',
  `homeAddress` varchar(128) NOT NULL COMMENT '住址（本国联系方式）',
  `homePhone` varchar(32) NOT NULL COMMENT '联系电话（本国联系方式）',
  `homePostcode` varchar(16) DEFAULT NULL COMMENT '邮编（本国联系方式）',
  `applyBookFile` varchar(128) DEFAULT NULL COMMENT '志愿书（上传签名）',
  `applyNumber` varchar(32) DEFAULT NULL COMMENT '申请编号',
  `applyTime` datetime NOT NULL COMMENT '申请时间',
  `applyStatus` tinyint(2) DEFAULT NULL COMMENT '申请状态',

  `createTime` datetime NOT NULL COMMENT '注册时间',
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_studentEmail` (`studentEmail`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册学生信息表';

-- ----------------------------
-- Records of t_app_student
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_enum`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_enum`;
CREATE TABLE `t_sys_enum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enumTextName` varchar(32) NOT NULL COMMENT '枚举文本名称',
  `enumCodeType` varchar(32) NOT NULL COMMENT '枚举编码类型',
  `enumElementName` varchar(16) NOT NULL COMMENT '枚举标签名称【下拉框/复选框】',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统枚举表';

-- ----------------------------
-- Records of t_sys_enum
-- ----------------------------
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('food', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('sports', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('drink', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('other', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('super-market', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('bank', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('post', 'aroundCampTyps', '店铺类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('hotel', 'aroundCampTyps', '店铺类型');


INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('长期', 'termType', '学期类型');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('短期', 'termType', '学期类型');

INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('好', 'languageChineseAbility', '汉语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('较好', 'languageChineseAbility', '汉语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('一般', 'languageChineseAbility', '汉语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('差', 'languageChineseAbility', '汉语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('不会', 'languageChineseAbility', '汉语能力');

INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('好', 'languageEnglishAbility', '英语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('较好', 'languageEnglishAbility', '英语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('一般', 'languageEnglishAbility', '英语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('差', 'languageEnglishAbility', '英语能力');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('不会', 'languageEnglishAbility', '英语能力');

INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('高中', 'highestDegree', '最后学历');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('大专', 'highestDegree', '最后学历');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('本科', 'highestDegree', '最后学历');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('硕士', 'highestDegree', '最后学历');

INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('无信仰', 'religion', '宗教信仰');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('佛教', 'religion', '宗教信仰');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('天主教 ', 'religion', '宗教信仰');
INSERT INTO `t_sys_enum` (enumTextName, enumCodeType, enumElementName) VALUES ('基督教', 'religion', '宗教信仰');

-- ----------------------------
-- Table structure for `t_sys_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_department`;
CREATE TABLE `t_sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(32) NOT NULL COMMENT '院系名称',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统院系信息表';

-- ----------------------------
-- Records of t_sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_major`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_major`;
CREATE TABLE `t_sys_major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `majorName` varchar(32) NOT NULL COMMENT '专业名称',
  `departmentId` int(11) NOT NULL COMMENT '院系id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统专业（学系）信息表';

-- ----------------------------
-- Records of t_sys_major
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_term`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_term`;
CREATE TABLE `t_sys_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `termName` varchar(32) NOT NULL COMMENT '学期名称',
  `majorId` int(11) NOT NULL COMMENT '专业id（外键）',
  `departmentId` int(11) NOT NULL COMMENT '院系id（冗余外键）',
  `studyCategoryId` int(11) NOT NULL COMMENT '学习（学生）类别id（外键）',
  `studyGoalId` int(11) NOT NULL COMMENT '学习目标id（冗余外键）',
  `termType` tinyint(2) NOT NULL COMMENT '学期类型1:长期、2:短期',
  `termStartTime` datetime NOT NULL COMMENT '学期开始时间',
  `termFinshTime` datetime NOT NULL COMMENT '学期结束时间',
  `openApplyStartTime` datetime NOT NULL COMMENT '申请开始时间',
  `openApplyFinshTime` datetime NOT NULL COMMENT '申请结束时间',
  `reportStartTime` datetime NOT NULL COMMENT '报到开始时间',
  `reportFinshTime` datetime NOT NULL COMMENT '报到结束时间',
  `reportLocation` varchar(128) NOT NULL COMMENT '地点',
  `noticeMaterialId` int(11) NOT NULL COMMENT '通知材料id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统学期（班级）信息表';

-- ----------------------------
-- Records of t_sys_term
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_noticeMaterial`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_noticeMaterial`;
CREATE TABLE `t_sys_noticeMaterial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materialMainName` varchar(32) NOT NULL COMMENT '通知材料主表名称',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统通知材料主表';

-- ----------------------------
-- Records of t_sys_noticeMaterial
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_noticeMaterial_sub`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_noticeMaterial_sub`;
CREATE TABLE `t_sys_noticeMaterial_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materialName` varchar(32) NOT NULL COMMENT '通知材料名称',
  `materialContent` varchar(256) NOT NULL COMMENT '通知材料内容',
  `materialId` int(11) NOT NULL COMMENT '通知材料主表id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统通知材料子表';

-- ----------------------------
-- Records of t_sys_noticeMaterial
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_studyGoal`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_studyGoal`;
CREATE TABLE `t_sys_studyGoal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studyGoalName` varchar(32) NOT NULL COMMENT '目标名称',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统学习目标信息表';

-- ----------------------------
-- Records of t_sys_studyGoal
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_studyCategory`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_studyCategory`;
CREATE TABLE `t_sys_studyCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studyCategoryName` varchar(32) NOT NULL COMMENT '类别名称',
  `studyGoalId` int(11) NOT NULL COMMENT '学习目标id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统学习（学生）类别信息表';

-- ----------------------------
-- Records of t_sys_studyCategory
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_requiredMaterial`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_requiredMaterial`;
CREATE TABLE `t_sys_requiredMaterial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materialName` varchar(32) NOT NULL COMMENT '材料名称',
  `materialDescription` varchar(512) NOT NULL COMMENT '材料说明',
  `studyCategoryId` int(11) NOT NULL COMMENT '学习（学生）类别id（外键）',
  `studyGoalId` int(11) NOT NULL COMMENT '学习目标id（冗余外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统所需材料信息表';

-- ----------------------------
-- Records of t_sys_requiredMaterial
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_version`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_version`;
CREATE TABLE `t_sys_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appVersionNumber` varchar(8) NOT NULL COMMENT '版本号',
  `appVersionUrl` varchar(128) NOT NULL COMMENT '版本URL',
  `appType` tinyint(2) NOT NULL DEFAULT 1 COMMENT 'app类型(1代表Android、2代表IOS)',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统APP版本信息表';

-- ----------------------------
-- Records of t_sys_version
-- ----------------------------
INSERT INTO `t_sys_version` (appVersionNumber, appVersionUrl, appType) VALUES (0.01, 'http://gdown.baidu.com/data/wisegame/0ef8e7b345561cbd/shoujibaidu_16786444.apk', 1);

-- ----------------------------
-- Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(16) NOT NULL COMMENT '菜单名称',
  `menuParentId` int(11) NOT NULL DEFAULT '-1' COMMENT '父菜单id',
  `menuURL` varchar(32) DEFAULT NULL COMMENT '菜单URL',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT 'system',
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', '发送通知', '-1', 'web/notification/show', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('2', '内容管理', '-1', 'contents/priArrival', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('20', 'Pre-Arrival', '2', 'contents/priArrival', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('21', 'Arrival', '2', 'contents/arrival', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('22', 'Campus', '2', 'contents/campus', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('23', 'Around Campus', '2', 'aroundcampus/1/around', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('24', 'Events', '2', 'events/events', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('3', '学生管理', '-1', 'students/list', null, 'system', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('4', '管理员管理', '-1', 'admin/0/getAdminList', null, 'system', null, null, null);

-- ----------------------------
-- Table structure for `t_sys_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin`;
CREATE TABLE `t_sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminLoginName` varchar(16) NOT NULL COMMENT '帐号',
  `adminPassword` varchar(64) NOT NULL COMMENT '密码（MD5）',
  `adminName` varchar(32) NOT NULL COMMENT '姓名',
  `adminMobilePhone` varchar(16) NOT NULL COMMENT '手机',
  `adminEmail` varchar(64) NOT NULL COMMENT 'Eamil',
  `adminType` tinyint(2) NOT NULL DEFAULT 2 COMMENT '管理员类型（1系统管理员2普通管理员）',
  `adminStatus` tinyint(2) NOT NULL DEFAULT 2 COMMENT '管理员状态（1待激活2正常3停用）',
  `termId` int(11) DEFAULT NULL COMMENT '学期（班级）id（外键）',
  `majorId` int(11) DEFAULT NULL COMMENT '专业（学系）id（外键）',
  `departmentId` int(11) DEFAULT NULL COMMENT '院系id（外键）',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_adminLoginName` (`adminLoginName`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统管理员表';

-- ----------------------------
-- Records of t_sys_admin
-- ----------------------------
INSERT INTO `t_sys_admin` VALUES (1, 'system', 'system', '超级管理员', '18912345678', 'system@163.com', 1, 2, null, null, null, null, 'system', null, null, 1);
INSERT INTO `t_sys_admin` VALUES (2, 'a', '123456', 'AAAA', '18912345678', 'aaaa@163.com', 2, 2, null, null, 1, null, 'system', null, null, 1);
INSERT INTO `t_sys_admin` VALUES (3, 'b', '123456', 'BBBB', '18912345678', 'bbbb@163.com', 2, 2, null, 1, 1, null, 'system', null, null, 1);
INSERT INTO `t_sys_admin` VALUES (4, 'c', '123456', 'CCCC', '18912345678', 'cccc@163.com', 2, 2, 1, 1, 1, null, 'system', null, null, 1);
INSERT INTO `t_sys_admin` VALUES (5, 'd', '123456', 'DDDD', '18912345678', 'dddd@163.com', 2, 2, 2, 1, 1, null, 'system', null, null, 1);

-- ----------------------------
-- Table structure for `t_sys_admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin_menu`;
CREATE TABLE `t_sys_admin_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) NOT NULL COMMENT '管理员id（外键）',
  `notificationAdd` int(11) NOT NULL DEFAULT 1 COMMENT '是否拥有notification发布权限(1没有2有)',
  `eventsAdd` int(11) NOT NULL DEFAULT 1 COMMENT '是否拥有events发布权限(1没有2有)',
  `eventsChk` int(11) NOT NULL DEFAULT 1 COMMENT '是否拥有events审核权限(1没有2有)',
  `aroundAdd` int(11) NOT NULL DEFAULT 1 COMMENT '是否拥有around发布权限(1没有2有)',
  `aroundChk` int(11) NOT NULL DEFAULT 1 COMMENT '是否拥有around审核权限(1没有2有)',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理员菜单权限表';

-- ----------------------------
-- Records of t_sys_admin_menu
-- ----------------------------
INSERT INTO `t_sys_admin_menu` (adminId, notificationAdd, eventsAdd, eventsChk, aroundAdd, aroundChk) VALUES (2, 2, 2, 2, 2, 2);
INSERT INTO `t_sys_admin_menu` (adminId, notificationAdd, eventsAdd, eventsChk, aroundAdd, aroundChk) VALUES (3, 2, 1, 1, 1, 1);
INSERT INTO `t_sys_admin_menu` (adminId, notificationAdd, eventsAdd, eventsChk, aroundAdd, aroundChk) VALUES (4, 1, 2, 2, 1, 1);
INSERT INTO `t_sys_admin_menu` (adminId, notificationAdd, eventsAdd, eventsChk, aroundAdd, aroundChk) VALUES (5, 1, 1, 1, 2, 2);


