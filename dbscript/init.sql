---------- card 数据库-------------------
------- area 地区表    ------------------
------- branch 商户分店表    ------------------
------- mer_fl 商户分类表    ------------------
------- merchants 商户表    ------------------

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


					--   电话                        logo地址                    简介         简介详情    地址--
alter table merchants add tel varchar(20),add logo_path varchar(255),add about varchar(255),add about_detail varchar(255),add address varchar(255);


---------- ttzc 数据库-------------------
------- zpdw 招聘单位表    ------------------
------- zphy 招聘行业表    ------------------
------- zpzw 招聘职位表    ------------------

-- 招聘单位   所属区域--
alter table zpdw add locate varchar(20);
-- 单位介绍 --
alter table zpdw add union_about varchar(20);
--联系电话--
alter table zpdw add tel varchar(20);
--职位详情  描述--
alter table zpzw add job_detail varchar(20);


------ zgh1 数据库----------------
------剩余其他表都在这个数据库 ------------------------
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


--- 图片新闻     图片地址 --
alter table news2 add imgPath varchar(255);


-----------------------------------------
--------------互助保障----------------------
CREATE TABLE `xz_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 在职、 退休、     zxId关联 xz_type的id ---
alter table tcardcx add xzId int(11);
alter table tcardcxtx add xzId int(11);




--相关下载表    logo图片地址  应用名称  应用大小 得分（0-5）描述    安卓下载地址   ios id--
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

--用户表--
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

-- 手机验证码  --
alter table users add phone_code varchar(10);


-- ----------------------------
-- 城市表
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `AREA_ID` int(11) DEFAULT NULL,
  `AREA_SUB_ID` int(11) DEFAULT NULL,
  `AREA_NAME` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('110000', null, '北京市', '1');
INSERT INTO `city` VALUES ('120000', null, '天津市', '2');
INSERT INTO `city` VALUES ('130000', null, '河北省', '3');
INSERT INTO `city` VALUES ('140000', null, '山西省', '4');
INSERT INTO `city` VALUES ('150000', null, '内蒙古自治区', '5');
INSERT INTO `city` VALUES ('210000', null, '辽宁省', '6');
INSERT INTO `city` VALUES ('220000', null, '吉林省', '7');
INSERT INTO `city` VALUES ('230000', null, '黑龙江省', '8');
INSERT INTO `city` VALUES ('310000', null, '上海市', '9');
INSERT INTO `city` VALUES ('320000', null, '江苏省', '10');
INSERT INTO `city` VALUES ('330000', null, '浙江省', '11');
INSERT INTO `city` VALUES ('340000', null, '安徽省', '12');
INSERT INTO `city` VALUES ('350000', null, '福建省', '13');
INSERT INTO `city` VALUES ('360000', null, '江西省', '14');
INSERT INTO `city` VALUES ('370000', null, '山东省', '15');
INSERT INTO `city` VALUES ('410000', null, '河南省', '16');
INSERT INTO `city` VALUES ('420000', null, '湖北省', '17');
INSERT INTO `city` VALUES ('430000', null, '湖南省', '18');
INSERT INTO `city` VALUES ('440000', null, '广东省', '19');
INSERT INTO `city` VALUES ('450000', null, '广西壮族自治区', '20');
INSERT INTO `city` VALUES ('460000', null, '海南省', '21');
INSERT INTO `city` VALUES ('500000', null, '重庆市', '22');
INSERT INTO `city` VALUES ('510000', null, '四川省', '23');
INSERT INTO `city` VALUES ('520000', null, '贵州省', '24');
INSERT INTO `city` VALUES ('530000', null, '云南省', '25');
INSERT INTO `city` VALUES ('540000', null, '西藏自治区', '26');
INSERT INTO `city` VALUES ('610000', null, '陕西省', '27');
INSERT INTO `city` VALUES ('620000', null, '甘肃省', '28');
INSERT INTO `city` VALUES ('630000', null, '青海省', '29');
INSERT INTO `city` VALUES ('640000', null, '宁夏回族自治区', '30');
INSERT INTO `city` VALUES ('650000', null, '新疆维吾尔自治区', '31');
INSERT INTO `city` VALUES ('710000', null, '台湾省', '32');
INSERT INTO `city` VALUES ('810000', null, '香港', '33');
INSERT INTO `city` VALUES ('820000', null, '澳门', '34');
INSERT INTO `city` VALUES ('632100', '630000', '海东地区', '35');
INSERT INTO `city` VALUES ('632200', '630000', '海北藏族自治州', '36');
INSERT INTO `city` VALUES ('632300', '630000', '黄南藏族自治州', '37');
INSERT INTO `city` VALUES ('632500', '630000', '海南藏族自治州', '38');
INSERT INTO `city` VALUES ('632600', '630000', '果洛藏族自治州', '39');
INSERT INTO `city` VALUES ('632700', '630000', '玉树藏族自治州', '40');
INSERT INTO `city` VALUES ('632800', '630000', '海西蒙古族藏族自治州', '41');
INSERT INTO `city` VALUES ('640100', '640000', '银川市', '42');
INSERT INTO `city` VALUES ('640200', '640000', '石嘴山市', '43');
INSERT INTO `city` VALUES ('640300', '640000', '吴忠市', '44');
INSERT INTO `city` VALUES ('640400', '640000', '固原市', '45');
INSERT INTO `city` VALUES ('640500', '640000', '中卫市', '46');
INSERT INTO `city` VALUES ('650100', '650000', '乌鲁木齐市', '47');
INSERT INTO `city` VALUES ('650200', '650000', '克拉玛依市', '48');
INSERT INTO `city` VALUES ('652100', '650000', '吐鲁番地区', '49');
INSERT INTO `city` VALUES ('652200', '650000', '哈密地区', '50');
INSERT INTO `city` VALUES ('652300', '650000', '昌吉回族自治州', '51');
INSERT INTO `city` VALUES ('652700', '650000', '博尔塔拉蒙古自治州', '52');
INSERT INTO `city` VALUES ('652800', '650000', '巴音郭楞蒙古自治州', '53');
INSERT INTO `city` VALUES ('652900', '650000', '阿克苏地区', '54');
INSERT INTO `city` VALUES ('653100', '650000', '喀什地区', '55');
INSERT INTO `city` VALUES ('653200', '650000', '和田地区', '56');
INSERT INTO `city` VALUES ('654000', '650000', '伊犁哈萨克自治州', '57');
INSERT INTO `city` VALUES ('654200', '650000', '塔城地区', '58');
INSERT INTO `city` VALUES ('654300', '650000', '阿勒泰地区', '59');
INSERT INTO `city` VALUES ('810100', '810000', '香港', '60');
INSERT INTO `city` VALUES ('653000', '650000', '克州', '61');
INSERT INTO `city` VALUES ('522300', '520000', '黔西南', '62');
INSERT INTO `city` VALUES ('659000', '650000', '省直辖县级行政单位', '63');
INSERT INTO `city` VALUES ('419000', '410000', '省直辖县级行政单位', '64');
INSERT INTO `city` VALUES ('500100', '500000', '重庆市', '65');
INSERT INTO `city` VALUES ('520600', '520000', '铜仁市', '66');
INSERT INTO `city` VALUES ('130100', '130000', '石家庄市', '67');
INSERT INTO `city` VALUES ('130200', '130000', '唐山市', '68');
INSERT INTO `city` VALUES ('130300', '130000', '秦皇岛市', '69');
INSERT INTO `city` VALUES ('130400', '130000', '邯郸市', '70');
INSERT INTO `city` VALUES ('130500', '130000', '邢台市', '71');
INSERT INTO `city` VALUES ('130600', '130000', '保定市', '72');
INSERT INTO `city` VALUES ('130700', '130000', '张家口市', '73');
INSERT INTO `city` VALUES ('130800', '130000', '承德市', '74');
INSERT INTO `city` VALUES ('130900', '130000', '沧州市', '75');
INSERT INTO `city` VALUES ('131000', '130000', '廊坊市', '76');
INSERT INTO `city` VALUES ('131100', '130000', '衡水市', '77');
INSERT INTO `city` VALUES ('140100', '140000', '太原市', '78');
INSERT INTO `city` VALUES ('140200', '140000', '大同市', '79');
INSERT INTO `city` VALUES ('140300', '140000', '阳泉市', '80');
INSERT INTO `city` VALUES ('140400', '140000', '长治市', '81');
INSERT INTO `city` VALUES ('140500', '140000', '晋城市', '82');
INSERT INTO `city` VALUES ('140600', '140000', '朔州市', '83');
INSERT INTO `city` VALUES ('140700', '140000', '晋中市', '84');
INSERT INTO `city` VALUES ('140800', '140000', '运城市', '85');
INSERT INTO `city` VALUES ('140900', '140000', '忻州市', '86');
INSERT INTO `city` VALUES ('141000', '140000', '临汾市', '87');
INSERT INTO `city` VALUES ('141100', '140000', '吕梁市', '88');
INSERT INTO `city` VALUES ('150100', '150000', '呼和浩特市', '89');
INSERT INTO `city` VALUES ('150200', '150000', '包头市', '90');
INSERT INTO `city` VALUES ('150300', '150000', '乌海市', '91');
INSERT INTO `city` VALUES ('150400', '150000', '赤峰市', '92');
INSERT INTO `city` VALUES ('150500', '150000', '通辽市', '93');
INSERT INTO `city` VALUES ('150600', '150000', '鄂尔多斯市', '94');
INSERT INTO `city` VALUES ('150700', '150000', '呼伦贝尔市', '95');
INSERT INTO `city` VALUES ('150800', '150000', '巴彦淖尔市', '96');
INSERT INTO `city` VALUES ('150900', '150000', '乌兰察布市', '97');
INSERT INTO `city` VALUES ('152200', '150000', '兴安盟', '98');
INSERT INTO `city` VALUES ('152500', '150000', '锡林郭勒盟', '99');
INSERT INTO `city` VALUES ('152900', '150000', '阿拉善盟', '100');
INSERT INTO `city` VALUES ('210100', '210000', '沈阳市', '101');
INSERT INTO `city` VALUES ('210200', '210000', '大连市', '102');
INSERT INTO `city` VALUES ('210300', '210000', '鞍山市', '103');
INSERT INTO `city` VALUES ('210400', '210000', '抚顺市', '104');
INSERT INTO `city` VALUES ('210500', '210000', '本溪市', '105');
INSERT INTO `city` VALUES ('210600', '210000', '丹东市', '106');
INSERT INTO `city` VALUES ('210700', '210000', '锦州市', '107');
INSERT INTO `city` VALUES ('210800', '210000', '营口市', '108');
INSERT INTO `city` VALUES ('210900', '210000', '阜新市', '109');
INSERT INTO `city` VALUES ('211000', '210000', '辽阳市', '110');
INSERT INTO `city` VALUES ('211100', '210000', '盘锦市', '111');
INSERT INTO `city` VALUES ('211200', '210000', '铁岭市', '112');
INSERT INTO `city` VALUES ('211300', '210000', '朝阳市', '113');
INSERT INTO `city` VALUES ('211400', '210000', '葫芦岛市', '114');
INSERT INTO `city` VALUES ('220100', '220000', '长春市', '115');
INSERT INTO `city` VALUES ('220200', '220000', '吉林市', '116');
INSERT INTO `city` VALUES ('220300', '220000', '四平市', '117');
INSERT INTO `city` VALUES ('220400', '220000', '辽源市', '118');
INSERT INTO `city` VALUES ('220500', '220000', '通化市', '119');
INSERT INTO `city` VALUES ('220600', '220000', '白山市', '120');
INSERT INTO `city` VALUES ('220700', '220000', '松原市', '121');
INSERT INTO `city` VALUES ('220800', '220000', '白城市', '122');
INSERT INTO `city` VALUES ('222400', '220000', '延边朝鲜族自治州', '123');
INSERT INTO `city` VALUES ('230100', '230000', '哈尔滨市', '124');
INSERT INTO `city` VALUES ('230200', '230000', '齐齐哈尔市', '125');
INSERT INTO `city` VALUES ('230300', '230000', '鸡西市', '126');
INSERT INTO `city` VALUES ('230400', '230000', '鹤岗市', '127');
INSERT INTO `city` VALUES ('230500', '230000', '双鸭山市', '128');
INSERT INTO `city` VALUES ('230600', '230000', '大庆市', '129');
INSERT INTO `city` VALUES ('230700', '230000', '伊春市', '130');
INSERT INTO `city` VALUES ('230800', '230000', '佳木斯市', '131');
INSERT INTO `city` VALUES ('230900', '230000', '七台河市', '132');
INSERT INTO `city` VALUES ('231000', '230000', '牡丹江市', '133');
INSERT INTO `city` VALUES ('231100', '230000', '黑河市', '134');
INSERT INTO `city` VALUES ('231200', '230000', '绥化市', '135');
INSERT INTO `city` VALUES ('232700', '230000', '大兴安岭地区', '136');
INSERT INTO `city` VALUES ('320100', '320000', '南京市', '137');
INSERT INTO `city` VALUES ('320200', '320000', '无锡市', '138');
INSERT INTO `city` VALUES ('320300', '320000', '徐州市', '139');
INSERT INTO `city` VALUES ('320400', '320000', '常州市', '140');
INSERT INTO `city` VALUES ('320500', '320000', '苏州市', '141');
INSERT INTO `city` VALUES ('320600', '320000', '南通市', '142');
INSERT INTO `city` VALUES ('320700', '320000', '连云港市', '143');
INSERT INTO `city` VALUES ('320800', '320000', '淮安市', '144');
INSERT INTO `city` VALUES ('320900', '320000', '盐城市', '145');
INSERT INTO `city` VALUES ('321000', '320000', '扬州市', '146');
INSERT INTO `city` VALUES ('321100', '320000', '镇江市', '147');
INSERT INTO `city` VALUES ('321200', '320000', '泰州市', '148');
INSERT INTO `city` VALUES ('321300', '320000', '宿迁市', '149');
INSERT INTO `city` VALUES ('330100', '330000', '杭州市', '150');
INSERT INTO `city` VALUES ('330200', '330000', '宁波市', '151');
INSERT INTO `city` VALUES ('330300', '330000', '温州市', '152');
INSERT INTO `city` VALUES ('330400', '330000', '嘉兴市', '153');
INSERT INTO `city` VALUES ('330500', '330000', '湖州市', '154');
INSERT INTO `city` VALUES ('330600', '330000', '绍兴市', '155');
INSERT INTO `city` VALUES ('330700', '330000', '金华市', '156');
INSERT INTO `city` VALUES ('330800', '330000', '衢州市', '157');
INSERT INTO `city` VALUES ('330900', '330000', '舟山市', '158');
INSERT INTO `city` VALUES ('331000', '330000', '台州市', '159');
INSERT INTO `city` VALUES ('331100', '330000', '丽水市', '160');
INSERT INTO `city` VALUES ('340100', '340000', '合肥市', '161');
INSERT INTO `city` VALUES ('340200', '340000', '芜湖市', '162');
INSERT INTO `city` VALUES ('340300', '340000', '蚌埠市', '163');
INSERT INTO `city` VALUES ('340400', '340000', '淮南市', '164');
INSERT INTO `city` VALUES ('340500', '340000', '马鞍山市', '165');
INSERT INTO `city` VALUES ('340600', '340000', '淮北市', '166');
INSERT INTO `city` VALUES ('340700', '340000', '铜陵市', '167');
INSERT INTO `city` VALUES ('340800', '340000', '安庆市', '168');
INSERT INTO `city` VALUES ('341000', '340000', '黄山市', '169');
INSERT INTO `city` VALUES ('341100', '340000', '滁州市', '170');
INSERT INTO `city` VALUES ('341200', '340000', '阜阳市', '171');
INSERT INTO `city` VALUES ('341300', '340000', '宿州市', '172');
INSERT INTO `city` VALUES ('341400', '340000', '巢湖市', '173');
INSERT INTO `city` VALUES ('341500', '340000', '六安市', '174');
INSERT INTO `city` VALUES ('341600', '340000', '亳州市', '175');
INSERT INTO `city` VALUES ('341700', '340000', '池州市', '176');
INSERT INTO `city` VALUES ('341800', '340000', '宣城市', '177');
INSERT INTO `city` VALUES ('350100', '350000', '福州市', '178');
INSERT INTO `city` VALUES ('350200', '350000', '厦门市', '179');
INSERT INTO `city` VALUES ('350300', '350000', '莆田市', '180');
INSERT INTO `city` VALUES ('350400', '350000', '三明市', '181');
INSERT INTO `city` VALUES ('350500', '350000', '泉州市', '182');
INSERT INTO `city` VALUES ('350600', '350000', '漳州市', '183');
INSERT INTO `city` VALUES ('350700', '350000', '南平市', '184');
INSERT INTO `city` VALUES ('350800', '350000', '龙岩市', '185');
INSERT INTO `city` VALUES ('350900', '350000', '宁德市', '186');
INSERT INTO `city` VALUES ('360100', '360000', '南昌市', '187');
INSERT INTO `city` VALUES ('360200', '360000', '景德镇市', '188');
INSERT INTO `city` VALUES ('360300', '360000', '萍乡市', '189');
INSERT INTO `city` VALUES ('360400', '360000', '九江市', '190');
INSERT INTO `city` VALUES ('360500', '360000', '新余市', '191');
INSERT INTO `city` VALUES ('360600', '360000', '鹰潭市', '192');
INSERT INTO `city` VALUES ('360700', '360000', '赣州市', '193');
INSERT INTO `city` VALUES ('360800', '360000', '吉安市', '194');
INSERT INTO `city` VALUES ('360900', '360000', '宜春市', '195');
INSERT INTO `city` VALUES ('361000', '360000', '抚州市', '196');
INSERT INTO `city` VALUES ('361100', '360000', '上饶市', '197');
INSERT INTO `city` VALUES ('370100', '370000', '济南市', '198');
INSERT INTO `city` VALUES ('370200', '370000', '青岛市', '199');
INSERT INTO `city` VALUES ('370300', '370000', '淄博市', '200');
INSERT INTO `city` VALUES ('370400', '370000', '枣庄市', '201');
INSERT INTO `city` VALUES ('370500', '370000', '东营市', '202');
INSERT INTO `city` VALUES ('370600', '370000', '烟台市', '203');
INSERT INTO `city` VALUES ('370700', '370000', '潍坊市', '204');
INSERT INTO `city` VALUES ('370800', '370000', '济宁市', '205');
INSERT INTO `city` VALUES ('370900', '370000', '泰安市', '206');
INSERT INTO `city` VALUES ('371000', '370000', '威海市', '207');
INSERT INTO `city` VALUES ('371100', '370000', '日照市', '208');
INSERT INTO `city` VALUES ('371200', '370000', '莱芜市', '209');
INSERT INTO `city` VALUES ('371300', '370000', '临沂市', '210');
INSERT INTO `city` VALUES ('371400', '370000', '德州市', '211');
INSERT INTO `city` VALUES ('371500', '370000', '聊城市', '212');
INSERT INTO `city` VALUES ('371600', '370000', '滨州市', '213');
INSERT INTO `city` VALUES ('371700', '370000', '菏泽市', '214');
INSERT INTO `city` VALUES ('410100', '410000', '郑州市', '215');
INSERT INTO `city` VALUES ('410200', '410000', '开封市', '216');
INSERT INTO `city` VALUES ('410300', '410000', '洛阳市', '217');
INSERT INTO `city` VALUES ('410400', '410000', '平顶山市', '218');
INSERT INTO `city` VALUES ('410500', '410000', '安阳市', '219');
INSERT INTO `city` VALUES ('410600', '410000', '鹤壁市', '220');
INSERT INTO `city` VALUES ('410700', '410000', '新乡市', '221');
INSERT INTO `city` VALUES ('410800', '410000', '焦作市', '222');
INSERT INTO `city` VALUES ('410900', '410000', '濮阳市', '223');
INSERT INTO `city` VALUES ('411000', '410000', '许昌市', '224');
INSERT INTO `city` VALUES ('411100', '410000', '漯河市', '225');
INSERT INTO `city` VALUES ('411200', '410000', '三门峡市', '226');
INSERT INTO `city` VALUES ('411300', '410000', '南阳市', '227');
INSERT INTO `city` VALUES ('411400', '410000', '商丘市', '228');
INSERT INTO `city` VALUES ('411500', '410000', '信阳市', '229');
INSERT INTO `city` VALUES ('411600', '410000', '周口市', '230');
INSERT INTO `city` VALUES ('411700', '410000', '驻马店市', '231');
INSERT INTO `city` VALUES ('411900', '410000', '济源市', '232');
INSERT INTO `city` VALUES ('420100', '420000', '武汉市', '233');
INSERT INTO `city` VALUES ('420200', '420000', '黄石市', '234');
INSERT INTO `city` VALUES ('420300', '420000', '十堰市', '235');
INSERT INTO `city` VALUES ('420500', '420000', '宜昌市', '236');
INSERT INTO `city` VALUES ('420600', '420000', '襄樊市', '237');
INSERT INTO `city` VALUES ('420700', '420000', '鄂州市', '238');
INSERT INTO `city` VALUES ('420800', '420000', '荆门市', '239');
INSERT INTO `city` VALUES ('420900', '420000', '孝感市', '240');
INSERT INTO `city` VALUES ('421000', '420000', '荆州市', '241');
INSERT INTO `city` VALUES ('421100', '420000', '黄冈市', '242');
INSERT INTO `city` VALUES ('421200', '420000', '咸宁市', '243');
INSERT INTO `city` VALUES ('421300', '420000', '随州市', '244');
INSERT INTO `city` VALUES ('422800', '420000', '恩施土家族苗族自治州', '245');
INSERT INTO `city` VALUES ('429000', '420000', '省直辖县级行政单位', '246');
INSERT INTO `city` VALUES ('430100', '430000', '长沙市', '247');
INSERT INTO `city` VALUES ('430200', '430000', '株洲市', '248');
INSERT INTO `city` VALUES ('430300', '430000', '湘潭市', '249');
INSERT INTO `city` VALUES ('430400', '430000', '衡阳市', '250');
INSERT INTO `city` VALUES ('430500', '430000', '邵阳市', '251');
INSERT INTO `city` VALUES ('430600', '430000', '岳阳市', '252');
INSERT INTO `city` VALUES ('430700', '430000', '常德市', '253');
INSERT INTO `city` VALUES ('430800', '430000', '张家界市', '254');
INSERT INTO `city` VALUES ('430900', '430000', '益阳市', '255');
INSERT INTO `city` VALUES ('431000', '430000', '郴州市', '256');
INSERT INTO `city` VALUES ('431100', '430000', '永州市', '257');
INSERT INTO `city` VALUES ('431200', '430000', '怀化市', '258');
INSERT INTO `city` VALUES ('431300', '430000', '娄底市', '259');
INSERT INTO `city` VALUES ('433100', '430000', '湘西土家族苗族自治州', '260');
INSERT INTO `city` VALUES ('440100', '440000', '广州市', '261');
INSERT INTO `city` VALUES ('440200', '440000', '韶关市', '262');
INSERT INTO `city` VALUES ('440300', '440000', '深圳市', '263');
INSERT INTO `city` VALUES ('440400', '440000', '珠海市', '264');
INSERT INTO `city` VALUES ('440500', '440000', '汕头市', '265');
INSERT INTO `city` VALUES ('440600', '440000', '佛山市', '266');
INSERT INTO `city` VALUES ('440700', '440000', '江门市', '267');
INSERT INTO `city` VALUES ('440800', '440000', '湛江市', '268');
INSERT INTO `city` VALUES ('440900', '440000', '茂名市', '269');
INSERT INTO `city` VALUES ('441200', '440000', '肇庆市', '270');
INSERT INTO `city` VALUES ('441300', '440000', '惠州市', '271');
INSERT INTO `city` VALUES ('441400', '440000', '梅州市', '272');
INSERT INTO `city` VALUES ('441500', '440000', '汕尾市', '273');
INSERT INTO `city` VALUES ('441600', '440000', '河源市', '274');
INSERT INTO `city` VALUES ('441700', '440000', '阳江市', '275');
INSERT INTO `city` VALUES ('441800', '440000', '清远市', '276');
INSERT INTO `city` VALUES ('441900', '440000', '东莞市', '277');
INSERT INTO `city` VALUES ('442000', '440000', '中山市', '278');
INSERT INTO `city` VALUES ('445100', '440000', '潮州市', '279');
INSERT INTO `city` VALUES ('445200', '440000', '揭阳市', '280');
INSERT INTO `city` VALUES ('445300', '440000', '云浮市', '281');
INSERT INTO `city` VALUES ('450100', '450000', '南宁市', '282');
INSERT INTO `city` VALUES ('450200', '450000', '柳州市', '283');
INSERT INTO `city` VALUES ('450300', '450000', '桂林市', '284');
INSERT INTO `city` VALUES ('450400', '450000', '梧州市', '285');
INSERT INTO `city` VALUES ('450500', '450000', '北海市', '286');
INSERT INTO `city` VALUES ('450600', '450000', '防城港市', '287');
INSERT INTO `city` VALUES ('450700', '450000', '钦州市', '288');
INSERT INTO `city` VALUES ('450800', '450000', '贵港市', '289');
INSERT INTO `city` VALUES ('450900', '450000', '玉林市', '290');
INSERT INTO `city` VALUES ('451000', '450000', '百色市', '291');
INSERT INTO `city` VALUES ('451100', '450000', '贺州市', '292');
INSERT INTO `city` VALUES ('451200', '450000', '河池市', '293');
INSERT INTO `city` VALUES ('451300', '450000', '来宾市', '294');
INSERT INTO `city` VALUES ('451400', '450000', '崇左市', '295');
INSERT INTO `city` VALUES ('460100', '460000', '海口市', '296');
INSERT INTO `city` VALUES ('460200', '460000', '三亚市', '297');
INSERT INTO `city` VALUES ('469000', '460000', '省直辖县级行政单位', '298');
INSERT INTO `city` VALUES ('510100', '510000', '成都市', '299');
INSERT INTO `city` VALUES ('510300', '510000', '自贡市', '300');
INSERT INTO `city` VALUES ('510400', '510000', '攀枝花市', '301');
INSERT INTO `city` VALUES ('510500', '510000', '泸州市', '302');
INSERT INTO `city` VALUES ('510600', '510000', '德阳市', '303');
INSERT INTO `city` VALUES ('510700', '510000', '绵阳市', '304');
INSERT INTO `city` VALUES ('510800', '510000', '广元市', '305');
INSERT INTO `city` VALUES ('510900', '510000', '遂宁市', '306');
INSERT INTO `city` VALUES ('511000', '510000', '内江市', '307');
INSERT INTO `city` VALUES ('511100', '510000', '乐山市', '308');
INSERT INTO `city` VALUES ('511300', '510000', '南充市', '309');
INSERT INTO `city` VALUES ('511400', '510000', '眉山市', '310');
INSERT INTO `city` VALUES ('511500', '510000', '宜宾市', '311');
INSERT INTO `city` VALUES ('511600', '510000', '广安市', '312');
INSERT INTO `city` VALUES ('511700', '510000', '达州市', '313');
INSERT INTO `city` VALUES ('511800', '510000', '雅安市', '314');
INSERT INTO `city` VALUES ('511900', '510000', '巴中市', '315');
INSERT INTO `city` VALUES ('512000', '510000', '资阳市', '316');
INSERT INTO `city` VALUES ('513200', '510000', '阿坝藏族羌族自治州', '317');
INSERT INTO `city` VALUES ('513300', '510000', '甘孜藏族自治州', '318');
INSERT INTO `city` VALUES ('513400', '510000', '凉山彝族自治州', '319');
INSERT INTO `city` VALUES ('520100', '520000', '贵阳市', '320');
INSERT INTO `city` VALUES ('520200', '520000', '六盘水市', '321');
INSERT INTO `city` VALUES ('520300', '520000', '遵义市', '322');
INSERT INTO `city` VALUES ('520400', '520000', '安顺市', '323');
INSERT INTO `city` VALUES ('522200', '520000', '铜仁市', '324');
INSERT INTO `city` VALUES ('520500', '520000', '毕节市', '325');
INSERT INTO `city` VALUES ('522600', '520000', '黔东南苗族侗族自治州', '326');
INSERT INTO `city` VALUES ('522700', '520000', '黔南布依族苗族自治州', '327');
INSERT INTO `city` VALUES ('530100', '530000', '昆明市', '328');
INSERT INTO `city` VALUES ('530300', '530000', '曲靖市', '329');
INSERT INTO `city` VALUES ('530400', '530000', '玉溪市', '330');
INSERT INTO `city` VALUES ('530500', '530000', '保山市', '331');
INSERT INTO `city` VALUES ('530600', '530000', '昭通市', '332');
INSERT INTO `city` VALUES ('530700', '530000', '丽江市', '333');
INSERT INTO `city` VALUES ('530800', '530000', '普洱市', '334');
INSERT INTO `city` VALUES ('530900', '530000', '临沧市', '335');
INSERT INTO `city` VALUES ('532300', '530000', '楚雄彝族自治州', '336');
INSERT INTO `city` VALUES ('532500', '530000', '红河哈尼族彝族自治州', '337');
INSERT INTO `city` VALUES ('532600', '530000', '文山壮族苗族自治州', '338');
INSERT INTO `city` VALUES ('532800', '530000', '西双版纳傣族自治州', '339');
INSERT INTO `city` VALUES ('532900', '530000', '大理白族自治州', '340');
INSERT INTO `city` VALUES ('533100', '530000', '德宏傣族景颇族自治州', '341');
INSERT INTO `city` VALUES ('533300', '530000', '怒江傈僳族自治州', '342');
INSERT INTO `city` VALUES ('533400', '530000', '迪庆藏族自治州', '343');
INSERT INTO `city` VALUES ('540100', '540000', '拉萨市', '344');
INSERT INTO `city` VALUES ('542100', '540000', '昌都地区', '345');
INSERT INTO `city` VALUES ('542200', '540000', '山南地区', '346');
INSERT INTO `city` VALUES ('542300', '540000', '日喀则地区', '347');
INSERT INTO `city` VALUES ('542400', '540000', '那曲地区', '348');
INSERT INTO `city` VALUES ('542500', '540000', '阿里地区', '349');
INSERT INTO `city` VALUES ('542600', '540000', '林芝地区', '350');
INSERT INTO `city` VALUES ('610100', '610000', '西安市', '351');
INSERT INTO `city` VALUES ('610200', '610000', '铜川市', '352');
INSERT INTO `city` VALUES ('610300', '610000', '宝鸡市', '353');
INSERT INTO `city` VALUES ('610400', '610000', '咸阳市', '354');
INSERT INTO `city` VALUES ('610500', '610000', '渭南市', '355');
INSERT INTO `city` VALUES ('610600', '610000', '延安市', '356');
INSERT INTO `city` VALUES ('610700', '610000', '汉中市', '357');
INSERT INTO `city` VALUES ('610800', '610000', '榆林市', '358');
INSERT INTO `city` VALUES ('610900', '610000', '安康市', '359');
INSERT INTO `city` VALUES ('611000', '610000', '商洛市', '360');
INSERT INTO `city` VALUES ('620100', '620000', '兰州市', '361');
INSERT INTO `city` VALUES ('620200', '620000', '嘉峪关市', '362');
INSERT INTO `city` VALUES ('620300', '620000', '金昌市', '363');
INSERT INTO `city` VALUES ('620400', '620000', '白银市', '364');
INSERT INTO `city` VALUES ('620500', '620000', '天水市', '365');
INSERT INTO `city` VALUES ('620600', '620000', '武威市', '366');
INSERT INTO `city` VALUES ('620700', '620000', '张掖市', '367');
INSERT INTO `city` VALUES ('620800', '620000', '平凉市', '368');
INSERT INTO `city` VALUES ('620900', '620000', '酒泉市', '369');
INSERT INTO `city` VALUES ('621000', '620000', '庆阳市', '370');
INSERT INTO `city` VALUES ('621100', '620000', '定西市', '371');
INSERT INTO `city` VALUES ('621200', '620000', '陇南市', '372');
INSERT INTO `city` VALUES ('622900', '620000', '临夏回族自治州', '373');
INSERT INTO `city` VALUES ('623000', '620000', '甘南藏族自治州', '374');
INSERT INTO `city` VALUES ('630100', '630000', '西宁市', '375');

---版本表------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `android_version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of version
-- ----------------------------
INSERT INTO `version` VALUES ('1', '1.0');
