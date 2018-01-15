CREATE TABLE `record_log` (
  `id` int(8) NOT NULL,
  `type` varchar(255) COLLATE utf8_danish_ci NOT NULL COMMENT '类型',
  `source` varchar(255) COLLATE utf8_danish_ci NOT NULL COMMENT '来源 ios android',
  `exeResult` int(255) DEFAULT NULL COMMENT '执行结果 1成功 2失败',
  `log1` varchar(5000) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '日志内容',
  `log2` varchar(5000) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '日志内容',
  `log3` varchar(5000) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '日志内容',
  `log4` varchar(5000) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '日志内容',
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

CREATE TABLE `wxcm_info` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `type` varchar(500) NOT NULL,
  `requestUrl` varchar(5000) NOT NULL,
  `responseData` varchar(5000) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;


CREATE TABLE `qtt_user_day_gold_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL,
  `activateDate` datetime DEFAULT NULL,
  `originalGolds` int(8) DEFAULT '0',
  `newGolds` int(8) DEFAULT '0',
  `getGolds` int(8) DEFAULT '0',
  `usedTime` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `qtt_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL,
  `pwd` varchar(50) NOT NULL DEFAULT '987654321',
  `imei` varchar(50) DEFAULT NULL,
  `lastActivate` datetime DEFAULT CURRENT_TIMESTAMP,
  `balance` decimal(8,2) DEFAULT '0.00',
  `sumGetGolds` int(8) DEFAULT '0',
  `singDate` datetime DEFAULT NULL,
  `valid` varchar(1) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


CREATE TABLE `qtt_imei_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) DEFAULT NULL,
  `imei` varchar(32) NOT NULL,
  `usedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `find_coordinate_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `longitude` varchar(50) COLLATE utf8_danish_ci NOT NULL DEFAULT '',
  `latitude` varchar(50) COLLATE utf8_danish_ci NOT NULL DEFAULT '',
  `addcount` int(32) DEFAULT '0',
  `currentcount` int(32) DEFAULT '0',
  `maxlongitude` varchar(50) COLLATE utf8_danish_ci DEFAULT '',
  `maxlatitude` varchar(50) COLLATE utf8_danish_ci DEFAULT '',
  `findid` int(32) NOT NULL,
  `minlongitude` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `minlatitude` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `avgdistance` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;


CREATE TABLE `ele_shop_activitie` (
  `attribute` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon_color` varchar(255) DEFAULT NULL,
  `icon_name` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `is_exclusive_with_food_activity` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `shop_id` varchar(255) DEFAULT NULL,
  `activitie_id` int(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`activitie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5220 DEFAULT CHARSET=utf8mb4 COMMENT='商铺活动';


CREATE TABLE `ele_shop` (
  `id` int(32) DEFAULT '0',
  `address` varchar(50) DEFAULT '' COMMENT '地址',
  `authentic_id` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT '',
  `distance` varchar(255) DEFAULT '',
  `favored` varchar(255) DEFAULT '',
  `float_delivery_fee` varchar(255) DEFAULT '' COMMENT '配送费',
  `float_minimum_order_amount` varchar(255) DEFAULT '' COMMENT '起送价格',
  `is_new` varchar(255) DEFAULT '' COMMENT '是否是新店',
  `is_premium` varchar(255) DEFAULT '',
  `is_stock_empty` varchar(255) DEFAULT '',
  `is_valid` varchar(255) DEFAULT '',
  `latitude` varchar(255) DEFAULT '',
  `list_quality_icon` varchar(255) DEFAULT '',
  `longitude` varchar(255) DEFAULT '',
  `max_applied_quantity_per_order` varchar(255) DEFAULT '',
  `name` varchar(255) DEFAULT '',
  `next_business_time` varchar(255) DEFAULT '',
  `only_use_poi` varchar(255) DEFAULT '',
  `order_lead_time` varchar(255) DEFAULT '',
  `phone` varchar(255) DEFAULT '',
  `rating` varchar(255) DEFAULT '',
  `rating_count` varchar(255) DEFAULT '',
  `recent_order_num` varchar(255) DEFAULT '',
  `status` varchar(255) DEFAULT '',
  `type` varchar(255) DEFAULT '',
  `image_path` varchar(255) DEFAULT '',
  `promotion_info` varchar(255) DEFAULT '',
  `regular_customer_count` varchar(255) DEFAULT '',
  `shop_id` int(8) NOT NULL AUTO_INCREMENT,
  `json` varchar(5000) DEFAULT NULL,
  `findid` int(32) DEFAULT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9772 DEFAULT CHARSET=utf8;


CREATE TABLE `ele_menu_specfood` (
  `checkout_mode` varchar(255) DEFAULT NULL,
  `food_id` varchar(255) DEFAULT NULL,
  `is_essential` varchar(255) DEFAULT NULL,
  `item_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `original_price` varchar(255) DEFAULT NULL,
  `packing_fee` varchar(255) DEFAULT NULL,
  `partial_reduce_activity_id` varchar(255) DEFAULT NULL,
  `pinyin_name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `promotion_stock` varchar(255) DEFAULT NULL,
  `recent_popularity` varchar(255) DEFAULT NULL,
  `recent_rating` varchar(255) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  `sku_id` varchar(255) DEFAULT NULL,
  `sold_out` varchar(255) DEFAULT NULL,
  `specs` varchar(255) DEFAULT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `virtual_food_id` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `foodId` varchar(255) DEFAULT NULL,
  `specfood_id` int(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`specfood_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100183 DEFAULT CHARSET=utf8mb4 COMMENT='规格食物列表';


CREATE TABLE `ele_menu_food` (
  `attribute` varchar(255) DEFAULT NULL,
  `attributes` varchar(255) DEFAULT NULL,
  `attrs` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `cold_box` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `display_times` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `is_essential` varchar(255) DEFAULT NULL,
  `is_featured` varchar(255) DEFAULT NULL,
  `item_id` varchar(255) DEFAULT NULL,
  `limitation` varchar(255) DEFAULT NULL,
  `min_purchase` varchar(255) DEFAULT NULL,
  `month_sales` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pinyin_name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `rating_count` varchar(255) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  `satisfy_count` varchar(255) DEFAULT NULL,
  `satisfy_rate` varchar(255) DEFAULT NULL,
  `server_utc` varchar(255) DEFAULT NULL,
  `specifications` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  `virtual_food_id` varchar(255) DEFAULT NULL,
  `menu_id` varchar(255) DEFAULT NULL,
  `food_id` int(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85212 DEFAULT CHARSET=utf8mb4 COMMENT='食物列表';


CREATE TABLE `ele_menu` (
  `attribute` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `grey_icon_url` varchar(255) DEFAULT NULL,
  `icon_url` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `is_activity` varchar(255) DEFAULT NULL,
  `is_selected` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `shop_id` varchar(255) DEFAULT NULL,
  `menu_id` int(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10067 DEFAULT CHARSET=utf8mb4 COMMENT='菜单列表';