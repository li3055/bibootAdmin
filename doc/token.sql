/*
SQLyog Ultimate v11.22 (64 bit)
MySQL - 5.6.24 : Database - biboot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biboot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `biboot`;

/*Table structure for table `token_holder` */

DROP TABLE IF EXISTS `token_holder`;

CREATE TABLE `token_holder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collect_date_int` int(11) DEFAULT NULL COMMENT '收集时间',
  `symbol` varchar(40) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `percent` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `percent_1` double DEFAULT NULL,
  `percent_3` double DEFAULT NULL,
  `percent_7` double DEFAULT NULL,
  `percent_15` double DEFAULT NULL,
  `percent_30` double DEFAULT NULL,
  `percent_45` double DEFAULT NULL,
  `balance_1` double DEFAULT NULL,
  `balance_3` double DEFAULT NULL,
  `balance_7` double DEFAULT NULL,
  `balance_15` double DEFAULT NULL,
  `balance_30` double DEFAULT NULL,
  `balance_45` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8;

/*Data for the table `token_holder` */

insert  into `token_holder`(`id`,`collect_date_int`,`symbol`,`address`,`rank`,`percent`,`balance`,`percent_1`,`percent_3`,`percent_7`,`percent_15`,`percent_30`,`percent_45`,`balance_1`,`balance_3`,`balance_7`,`balance_15`,`balance_30`,`balance_45`) values (52,20180307,'BNB','0x00c5e04176d95a286fcce0e68c683ca0bfec8454',1,41.0415,80930777.8905,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,20180307,'BNB','0xfe9e8709d3215310075d67e3ed32a380ccf451c8',2,19.7667,38978382.2869438,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,20180307,'BNB','0x15ab2321d7e83d00c015048b567f4f6aadc1b022',3,0.8635,1702749.70558498,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,20180307,'BNB','0x2b8d5c9209fbd500fd817d960830ac6718b88112',4,0.3362,662941.47669127,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,20180307,'BNB','0x001866ae5b3de6caa5a51543fd9fb64f524f5478',5,0.2987,588951.49910461,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,20180307,'BNB','0x36e75c5f6c9ea257da03935ddc0d0cd42da0929e',6,0.2536,500003,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,20180307,'BNB','0xc76d642b90feb7e9cb40c5daa2359d7776b3ee62',7,0.2536,499999.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,20180307,'BNB','0x01cdece28afb8c2887ed1413d5889a8a1375fb7d',8,0.2454,483874.44312,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,20180307,'BNB','0x77182b0579524ce4146d78787254c628defabc60',9,0.2304,454320.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,20180307,'BNB','0x3f5ce5fbfe3e9af3971dd833d26ba9b5c936f0be',10,0.2244,442458.145715686,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,20180307,'BNB','0x5e660c9cefb1a9651971cdafc13fef604a40aa92',11,0.2054,404999.7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,20180307,'BNB','0x564286362092d8e7936f0549571a803b203aaced',12,0.1741,343307.06032039,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,20180307,'BNB','0xd551234ae421e3bcba99a0da6d736074f22192ff',13,0.1589,313251.99745605,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,20180307,'BNB','0xce67898df439190e9c487eabe35320318fdd7746',14,0.1306,257474.48024978,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,20180307,'BNB','0x2280d8be9ebf0ecc652f61bb4f439caac1109be7',15,0.1209,238503.558,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(67,20180307,'BNB','0xdd2d0fafc1bd34eb698884c21220d5bf9e5affac',16,0.0761,150008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(68,20180307,'BNB','0x0681d8db095565fe8a346fa0277bffde9c0edbbf',17,0.0733,144507.31418696,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(69,20180307,'BNB','0xf039febaca2405fc9a434e0a9c35021f52aad920',18,0.0656,129383.16901271,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(70,20180307,'BNB','0x00f9451385bf75910d80374eb42edf36d1a3f243',19,0.0649,128013.393,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(71,20180307,'BNB','0x8d12a197cb00d4747a1fe03395095ce2a5cc6819',20,0.0561,110639.801850398,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(72,20180307,'BNB','0xf2549fba1da6e17a1e82478a0b0a945adb7416c7',21,0.0522,102892.05594263,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(73,20180307,'BNB','0x81cd16ee6a008c3d12f332bdd2fd653717f71af3',22,0.0512,101028,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(74,20180307,'BNB','0x841b5b0c5f903b24b1eb98bbf282417aa68ba2b3',23,0.0507,99995,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(75,20180307,'BNB','0xdaef46f89c264182cd87ce93b620b63c7afb14f7',24,0.0507,99988.02315574,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(76,20180307,'BNB','0xda8e12cc4262e0213e037fe7335430b1d73a69ab',25,0.0502,99000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(77,20180307,'BNB','0x19575ec860760267160de1dfc5cc698b15923f0e',26,0.0474,93525.2582,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(78,20180307,'BNB','0x5203ac6f235595f0aa2309a6ea6fd33111f6e02b',27,0.0452,89147.78388,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(79,20180307,'BNB','0x924141f1df09d3d188bcee813b21544248c0bcd8',28,0.0451,88989,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(80,20180307,'BNB','0x2ba2aee80303f89de1c4721cee75a2f41f21b4a1',29,0.0433,85350.34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(152,20180307,'BNB','0xd6e371526cdaee04cd8af225d42e37bc14688d9e',51,0.0121,23949,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(153,20180307,'BNB','0xe93431fd2eee59305a1bc7e80ad925853823a31b',52,0.0117,23117.44533801,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(154,20180307,'BNB','0xa1d157e01e797e4a64606e6304f3b6288211dcfe',53,0.0114,22572.67323783,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(155,20180307,'BNB','0xe13cec7b2c10574e5e89a780582b66d2c3c71b80',54,0.0113,22222.88833134,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(156,20180307,'BNB','0xd84556ee862b7822fcce2dbe9905c0bdaab42de4',55,0.0112,22122,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(157,20180307,'BNB','0x8699cee9cca0f1e2e627059ef7dcd46e9735b9d5',56,0.0112,22093,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(158,20180307,'BNB','0x37ca9c21f9951328d78d930aa0af6beea65b4b06',57,0.0112,22000.16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(159,20180307,'BNB','0xd4b8817b45dc9cf996381ad7595d066e55a6b965',58,0.0106,21000.72349848,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(160,20180307,'BNB','0x8737305011408648c0c2fc6ff831d566fbaac483',59,0.0104,20468.68948,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(161,20180307,'BNB','0x5c9f1f84717129b42d8630018b8d46ea6a652ca0',60,0.0104,20432.676,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(162,20180307,'BNB','0xcb3ca157ccd432e5f1c4ebe2999318541aec9190',61,0.0102,20084.54920768,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(163,20180307,'BNB','0x7e73d29e6d30384b986f0394c756ddb6db941c39',62,0.0101,20000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(164,20180307,'BNB','0xfc7f34272cb8a4fe655a78de42e3d33f33633f9a',63,0.0101,20000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(165,20180307,'BNB','0xeb5e459cb3af4a3e56fb43dc1b0c948a95ab3a38',64,0.0101,20000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(166,20180307,'BNB','0xe9da0d4d2acc12bbb8543f300eaf0882ea3b4ef8',65,0.0099,19500,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(167,20180307,'BNB','0xbc085c759804c8c4d4b871e0db3e3c7e741157d6',66,0.0098,19362.02,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(168,20180307,'BNB','0x3aac5c3cb540e311316d3b0ebfe3559b586b0af5',67,0.0097,19100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(169,20180307,'BNB','0x3e5d0c6bc202421c0b06cac59bf8dfdf36991ae6',68,0.0096,19000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(170,20180307,'BNB','0xfc83b1ad1662a0071d107e84ae253a7c6aab40e7',69,0.0094,18449.37013826,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(171,20180307,'BNB','0xaeec6f5aca72f3a005af1b3420ab8c8c7009bac8',70,0.0093,18323.14225943,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(172,20180307,'BNB','0x3bc9812ed2a5bddd6d2bb3b872bbfb47c36e2bed',71,0.0092,18200.05,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(173,20180307,'BNB','0x72e1b6e5442c9a2b512c1d900fc8969bddf1deac',72,0.0092,18067,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(174,20180307,'BNB','0xc60515f9971167b594c7199ded22343a9e78012e',73,0.0091,18000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(175,20180307,'BNB','0xad640188745ff9a9fbbfd13a30e1fc48c0b93761',74,0.0091,17926.56805,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(176,20180307,'BNB','0x7b2247cb372d34f0f253d92ec88f33317fc5bf12',75,0.0089,17600.34219991,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(177,20180307,'BNB','0x34da8ad494cf29bfbbe325d3125aff16e2281b57',76,0.0089,17469,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(178,20180307,'BNB','0x839dd7995901ba79f48ebe7942b8ade2cae53978',77,0.0087,17109.79733505,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(179,20180307,'BNB','0xd75eebece0db5e544f32cf2404e7aa5509d739a5',78,0.0086,16957.83,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(180,20180307,'BNB','0x25b051e3bebcfedcf5ca6915c96eadb2ea7c9ee2',79,0.0084,16535.36,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(181,20180307,'BNB','0xaf4cef7b24757d374c71b8a48400d8115729452f',80,0.0081,15880.216,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(182,20180307,'BNB','0x5db173236a75f7bb27375fd2f60e8eaeb5a99716',81,0.008,15719.032,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(183,20180307,'BNB','0xeef213e681a33ac0a2005c07cdd50b265c220506',82,0.0078,15467,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(184,20180307,'BNB','0x0dcc42e66d87244ea9b08620f1ec60a434c35aaa',83,0.0078,15452.33313357,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(185,20180307,'BNB','0xae6f5ef778b96c8e436dddde549beccd6280a91d',84,0.0078,15400,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(186,20180307,'BNB','0xaa7494073ca3c0fc95479f45d4e1cc42500502d6',85,0.0076,15004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(187,20180307,'BNB','0xcf346f559c950b4075aa8e41813f8ae7ab81723f',86,0.0076,15000.28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(188,20180307,'BNB','0x1d428e4d7b36b4d114db519982e77d3fe3371632',87,0.0076,15000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(189,20180307,'BNB','0xf4fadc1b59fa8763c8d0da7c186abb7762d8e2a7',88,0.0076,15000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(190,20180307,'BNB','0xe3d47315ee2bd8ce82361039bfb2de13d032b53a',89,0.0076,15000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(191,20180307,'BNB','0xa1c8492b8917da9f461916b5acc00cb2e8383e35',90,0.0076,15000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(192,20180307,'BNB','0x166dbb88123ad1d19e304534a5da9ad01f6f6bcc',91,0.0076,14898.65916119,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(193,20180307,'BNB','0x9f390bcf4a2b007868ab46106da7dc3adc5a4738',92,0.0074,14495,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(194,20180307,'BNB','0x1efda7f73ad248186e312192f66453a5d39b06f5',93,0.0072,14265,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(195,20180307,'BNB','0x0cd5663e5bedcc60986e9f563a191780eea94d9c',94,0.0071,14042.13817537,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(196,20180307,'BNB','0xa06c44151e84a85456a1370cc73a23848d1802ff',95,0.0071,14000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(197,20180307,'BNB','0x30de943e634eddf795984c2e32f4b6eab20843f9',96,0.007,13780,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(198,20180307,'BNB','0x884ec4cbbcb1049db4c735760de0eca298c53bdf',97,0.0069,13694,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(199,20180307,'BNB','0xb42adf30c334d83d8295c4d43dde5de01df0f248',98,0.0068,13400.64938922,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(200,20180307,'BNB','0x79930f9e8043d7980c232b4f782626d0b0b05259',99,0.0068,13354.10970675,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201,20180307,'BNB','0x62b1339732cb91ef6a5c088a4b17db8bae87661a',100,0.0065,12745.23772044,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(202,20180307,'BNB','0xadb6efb415bebc2ae4eb922e63fb60e54f1c86be',101,0.0061,12030,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(203,20180307,'BNB','0x7dce8169b3ad548399b42ae242e008694ac77500',102,0.0061,12000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(204,20180307,'BNB','0x6d7e231d3c6330168f5eda2945e34dd5f8b362e9',103,0.006,11852,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(205,20180307,'BNB','0x9f0cb2aad40f0bb14ca05fd102bfab4d72ba2b8c',104,0.0058,11524.4233,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(206,20180307,'BNB','0xff79b6660b02b4625e4faef219f297cb58c878c6',105,0.0056,11140.1844503736,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(207,20180307,'BNB','0xe13091468a7b83494ee9e25b3ea0c1ed08f9c8d4',106,0.0056,11001.40287471,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(208,20180307,'BNB','0xf5e9d7620f9c9a0595f126f8ad87c64f7fb76a72',107,0.0056,11000.16302531,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(209,20180307,'BNB','0xc91f5b8c2782a5de950ba47b6fdf916aa22027d2',108,0.0054,10742.085,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(210,20180307,'BNB','0x9b42b9baace30b148b86ccb9ff97db875ccff6c1',109,0.0053,10427.53250843,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(211,20180307,'BNB','0x31c5cb98b46ee1fd066a39b1248f5b467fd38c11',110,0.0052,10346.823,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(212,20180307,'BNB','0xa8a92193615c5b0c3c947cea710ccc047b949791',111,0.0052,10254.62385056,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(213,20180307,'BNB','0xc839047f15327127c8683ae98b2fa36c3fe7b2bd',112,0.0051,10100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(214,20180307,'BNB','0xf81189c9152e610ac025912ccd25a500762a474d',113,0.0051,10100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(215,20180307,'BNB','0x6475b72c3b91c5510786a99e727e0cedc1784931',114,0.0051,10008.28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(216,20180307,'BNB','0x545335b2b8f7bdd3f8a6984a951b8cf128fca386',115,0.0051,10000.956,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(217,20180307,'BNB','0x634e5e85c6e6ce537268df59a8d0b0d34cc1891a',116,0.0051,10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(218,20180307,'BNB','0xeaed216f03d6339eb8e6e2fb52f09eeaaa5bfe4a',117,0.0051,10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(219,20180307,'BNB','0xd1ebae724248cb8a14483c6987feeb6c928d8172',118,0.0051,10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(220,20180307,'BNB','0x533bfc924dd17f466fc9c51bd2f4c338bb173ba1',119,0.0051,10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(221,20180307,'BNB','0xcf9b23a319b03ffb428597ef7470d78aae93f60c',120,0.0051,10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(222,20180307,'BNB','0x02632dec5fe47a2a9fe9d15761065f5cdc074503',121,0.0051,9999.24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(223,20180307,'BNB','0xa65fb0381bbc405970c945fe45c9be027193e621',122,0.0051,9999.16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(224,20180307,'BNB','0x905b982879a98b8195ac67fc2ed3e1f5f9f5d04f',123,0.0051,9999,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(225,20180307,'BNB','0x9a3dbe3d2d9e79b622fca709e1b2bcc766cd464c',124,0.0051,9958.41950609,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(226,20180307,'BNB','0x096744f1a8f8bed71244c8d5b2a86ba92e0420c0',125,0.005,9908,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(227,20180307,'BNB','0xa5176302ce2579ca89efe9ba1579ff8d3fe042c5',126,0.005,9899.54,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(228,20180307,'BNB','0x8040b137c25f4cb2d2fddd3dc16fafd96e61b390',127,0.0048,9500,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(229,20180307,'BNB','0x77ebfe95f4712ea050fbd0ca868e442ba15ac21b',128,0.0047,9296,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(230,20180307,'BNB','0xe4cba77472f36a5ee693b44c84989a1fa576992a',129,0.0047,9273.09044305,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(231,20180307,'BNB','0x92ca5d94704089bc7a75cd1df5bbdb2caa2d6855',130,0.0046,9007,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(232,20180307,'BNB','0xa594df18695a386058551b291b8c4a5b604c0fd7',131,0.0046,9000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(233,20180307,'BNB','0xabdc528381543aee7b6b0375290f7d6c4d46e074',132,0.0045,8950,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(234,20180307,'BNB','0xb6f2b6c96900b02f22cbaa38b57a79635c453493',133,0.0045,8932.50781404,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(235,20180307,'BNB','0xe069772bee9b947caccc15d48fd7a8979cf4a7f3',134,0.0045,8875.40522825,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(236,20180307,'BNB','0x111fa76223471d5fb36b56b5073c358dd1eaad7c',135,0.0044,8773.82228685536,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(237,20180307,'BNB','0x78084994dc28225b67c35c3782b34248dd51b13e',136,0.0044,8585.04724081,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(238,20180307,'BNB','0xa432aa0b6d4a4b4ae9c320706ce134325fdc4b7e',137,0.0043,8549.34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(239,20180307,'BNB','0x424dbed38cd0d83b13e2a150f86710fb445680cb',138,0.0043,8532.93,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(240,20180307,'BNB','0xe8eb838d28cfd9d0414b8dedf58e8b9103899409',139,0.0043,8523.80620161,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(241,20180307,'BNB','0xb3db2572fda5493105004e115e4d4612c0da8cbc',140,0.0043,8498.48,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(242,20180307,'BNB','0x0cabd4cccfab1f613a09610439688b5f5e637f66',141,0.0042,8374,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(243,20180307,'BNB','0xac4df5df0470aeb9bd23200754d13f97065ae9ed',142,0.0042,8233.4412791,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(244,20180307,'BNB','0xd3bf92a47f022b64fbbfc6a911040a7591b6b9e3',143,0.0041,8000.7682833,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(245,20180307,'BNB','0x8ec46618ef5d5c9243b3ab472127c174a33e66ed',144,0.0041,8000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(246,20180307,'BNB','0x9844a6ad1aa2aecff6b437a52415a77dad3eec56',145,0.0041,7999.38,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(247,20180307,'BNB','0xf244d2099f047c1c16a72da525adcacb2e339cc8',146,0.0041,7989.01060371,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(248,20180307,'BNB','0x543e991e712bb51804d7dc86924b6d4e9819542a',147,0.004,7826.7481,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(249,20180307,'BNB','0x231eb136b20c67666eec6f219d21944cbee41f00',148,0.004,7807,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(250,20180307,'BNB','0xffd7a6abb8e2514bafb853be95a6ff4dc28ea445',149,0.004,7799,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(251,20180307,'BNB','0xf336d55006a3e4f39c5adc68a89ce73fc50fe734',150,0.0038,7528.24348197,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(252,20180307,'BNB','0xc815d7b8330ec7410a11bd17dcb77b8016b0d621',151,0.0038,7454.43,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(253,20180307,'BNB','0xe9ebee76a902b6536c0bddf79ac4c4343e5bdbfb',152,0.0038,7400,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(254,20180307,'BNB','0xf8be95cd5fbfcdb8ac5b396192374badf27d44a7',153,0.0036,7108,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(255,20180307,'BNB','0x3241b1de0da69084a7d2168d6fd652ed5c16ca5b',154,0.0036,7004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(256,20180307,'BNB','0x8532325bc7b3dd89e2f5c5748e508dcd085d2409',155,0.0035,7000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(257,20180307,'BNB','0x65348b1d680837dacd8586dccc3212f059accd34',156,0.0035,6999,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(258,20180307,'BNB','0xce7087edf39f4c931070cbafc874e3864a806235',157,0.0035,6998.9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(259,20180307,'BNB','0x0be952af7144a4cd2334e517c60276c06fd5864f',158,0.0035,6996,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(260,20180307,'BNB','0x0f4c93880fa3b039e427cda1196aa7c8dba0812a',159,0.0035,6904.86894037,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(261,20180307,'BNB','0x29750db35d5d93c3f8cf0765d32014c6c73ee5ef',160,0.0033,6588.99,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(262,20180307,'BNB','0x991c9d5b37647f2f2b8ad5b96ed356af192bae46',161,0.0033,6544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(263,20180307,'BNB','0x52bdb54509c895345baf79f324c3c33ec04c8376',162,0.0033,6517.88348076925,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(264,20180307,'BNB','0x31dda9d2e7a2a59e2706fed931da36721f6310ee',163,0.0033,6458.80449407,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(265,20180307,'BNB','0x2e70d3c70b4dc4eb8df2cc9ea24c2ce663923a37',164,0.0033,6409,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(266,20180307,'BNB','0x6c1bf31fb3cc706b1cd93b5f15e93d8cede3015d',165,0.0032,6385.13251013,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(267,20180307,'BNB','0x997de76f7de53203e2eb5b22cc79c6a7707e2d76',166,0.0032,6325.87733296,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(268,20180307,'BNB','0xc6f884ccbe3052e37ecb9bea841e27e0a04336ac',167,0.0032,6323,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(269,20180307,'BNB','0x5e338f730fa85d2b3b5bf7d08f670047b76aedfc',168,0.0032,6268.51951389,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(270,20180307,'BNB','0x69fd28c6b293417ef6469002a26de60df2bf5ea3',169,0.0031,6186.58,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(271,20180307,'BNB','0xfce553ff16ad94f067f0d75f8c74735c78f1a547',170,0.0031,6120.7166,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(272,20180307,'BNB','0x630854247531dc8114c115e512618e5fd8d90ab2',171,0.0031,6099.59500786,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(273,20180307,'BNB','0xb94f92f852fe47b12fc83ea9a45d23e944b7c9bf',172,0.0031,6015.94107102,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(274,20180307,'BNB','0xd35c5b2d369cd08f79494e1f78985c9f6fef6fc1',173,0.003,6003.02,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(275,20180307,'BNB','0xfcdd391f332e9dcfb81ef5af2119c0baa5a5eb58',174,0.003,6002.88184392,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(276,20180307,'BNB','0x226f759a0023c3a09003d68158a766e2b26141cf',175,0.003,6000.63109705,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(277,20180307,'BNB','0x03324a19fdecd89b1d5f86371e062fba3787e046',176,0.003,6000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(278,20180307,'BNB','0x96d92f89666a27e4e26b056eb34129a1cfd9460e',177,0.003,5917.118781,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(279,20180307,'BNB','0xdedc9304583c258b4cd5a095f6d1338d3da61e44',178,0.0029,5798.76368397,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(280,20180307,'BNB','0x9ae2f2f3df29e9a9987008bc1fa475dda2d1b83a',179,0.0029,5765.943,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(281,20180307,'BNB','0xbf31b08008a1115a259250fdd8088ffa50274b7e',180,0.0029,5664.23796633,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(282,20180307,'BNB','0x510456bd5eb4c3a39bf723aef1d8e26487923933',181,0.0028,5615.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(283,20180307,'BNB','0x01d911eca6bee31b04b47599e1836f1bb900af33',182,0.0028,5588.465152,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(284,20180307,'BNB','0x889484cee499a0d64daeaa8578c7ada04337b1a5',183,0.0028,5502,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(285,20180307,'BNB','0x2b436807504fda94cc09c3a6c039072c937f1bfe',184,0.0028,5500,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(286,20180307,'BNB','0x7bbd854e1cc7a762ffa19dff07da7e68d997bfa2',185,0.0027,5365,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(287,20180307,'BNB','0x39d04562bcc0245af7a2c4e67d42b2f69b184a0f',186,0.0027,5350,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(288,20180307,'BNB','0x00997f6bcda82c0a5d257a60a1b6164673416777',187,0.0027,5326.49084727,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(289,20180307,'BNB','0xc1e037ce9d2ffe12fde9871b3412e395bab3965f',188,0.0026,5093,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(290,20180307,'BNB','0x21e616d330395ab9eca5bade392bcbccb3795297',189,0.0026,5060,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(291,20180307,'BNB','0x7a67f357f262a46b714f88c2e3f1ff594453f2ad',190,0.0025,5010.235,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(292,20180307,'BNB','0x0e0193a44c0d7e36b8faff8fd3d9004d5bb5ff09',191,0.0025,5009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(293,20180307,'BNB','0x5388769c224cf71ff9bf6444edd67aae0ec6f8e0',192,0.0025,5007,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(294,20180307,'BNB','0x3fcdebf30229126cbc5cde1efdbf83a732f0ee55',193,0.0025,5000.08,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(295,20180307,'BNB','0xc448e8c8fff4c14aeb1c57a75011b9e3aca46403',194,0.0025,5000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(296,20180307,'BNB','0x2147810efe4ebcd692d576bb04ef201b0cf7e0e0',195,0.0025,5000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(297,20180307,'BNB','0xb7ae6069b68eef3f8148c71824864de8be5b6691',196,0.0025,5000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(298,20180307,'BNB','0x8e357743a50017f18bd8346ce3e4406ed70b022a',197,0.0025,5000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(299,20180307,'BNB','0x83a9089c4277254b7386829075e7023c7b128871',198,0.0025,5000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(300,20180307,'BNB','0xf07e8974bf581554adc4984a3e58375bee2619da',199,0.0025,4987.28360682,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(301,20180307,'BNB','0x362394385b9261ac2a3138c2f1a301aeceafe109',200,0.0025,4986.21957476,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `token_info` */

DROP TABLE IF EXISTS `token_info`;

CREATE TABLE `token_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collect_date_int` int(11) DEFAULT NULL COMMENT '收集时间',
  `symbol` varchar(50) DEFAULT NULL,
  `total_apply` double DEFAULT NULL,
  `pre_50_percent` double DEFAULT NULL,
  `pre_100_percent` double DEFAULT NULL,
  `pre_150_percent` double DEFAULT NULL,
  `pre_200_percent` double DEFAULT NULL,
  `pre_50_d1` double DEFAULT NULL,
  `pre_50_d3` double DEFAULT NULL,
  `pre_50_d7` double DEFAULT NULL,
  `pre_50_d15` double DEFAULT NULL,
  `pre_50_d30` double DEFAULT NULL,
  `pre_50_d45` double DEFAULT NULL,
  `pre_100_d1` double DEFAULT NULL,
  `pre_100_d3` double DEFAULT NULL,
  `pre_100_d7` double DEFAULT NULL,
  `pre_100_d15` double DEFAULT NULL,
  `pre_100_d30` double DEFAULT NULL,
  `pre_100_d45` double DEFAULT NULL,
  `pre_150_d1` double DEFAULT NULL,
  `pre_150_d3` double DEFAULT NULL,
  `pre_150_d7` double DEFAULT NULL,
  `pre_150_d15` double DEFAULT NULL,
  `pre_150_d30` double DEFAULT NULL,
  `pre_150_d45` double DEFAULT NULL,
  `pre_200_d1` double DEFAULT NULL,
  `pre_200_d3` double DEFAULT NULL,
  `pre_200_d7` double DEFAULT NULL,
  `pre_200_d15` double DEFAULT NULL,
  `pre_200_d30` double DEFAULT NULL,
  `pre_200_d45` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `token_info` */

insert  into `token_info`(`id`,`collect_date_int`,`symbol`,`total_apply`,`pre_50_percent`,`pre_100_percent`,`pre_150_percent`,`pre_200_percent`,`pre_50_d1`,`pre_50_d3`,`pre_50_d7`,`pre_50_d15`,`pre_50_d30`,`pre_50_d45`,`pre_100_d1`,`pre_100_d3`,`pre_100_d7`,`pre_100_d15`,`pre_100_d30`,`pre_100_d45`,`pre_150_d1`,`pre_150_d3`,`pre_150_d7`,`pre_150_d15`,`pre_150_d30`,`pre_150_d45`,`pre_200_d1`,`pre_200_d3`,`pre_200_d7`,`pre_200_d15`,`pre_200_d30`,`pre_200_d45`) values (1,20180307,'ETH',999999.99999999,0.9999,0.9999,0.9999,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
