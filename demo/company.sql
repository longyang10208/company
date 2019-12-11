CREATE TABLE `company` (
  `id` bigint(20) NOT NULL ,
  `company_name` varchar(50) DEFAULT NULL,
  `legal_name` varchar(20) DEFAULT NULL,
  `legal_phone` varchar(11) DEFAULT NULL,
  `legal_id` varchar(18)  DEFAULT NULL ,

  `company_type` varchar(20) DEFAULT NULL,
  `main_work` varchar(100) DEFAULT NULL,
  `country` varchar(20)  DEFAULT NULL,
  `registered_address` varchar(20)  DEFAULT NULL,
  `company_address` varchar(100)  DEFAULT NULL,
  `zip_code` varchar(10)  DEFAULT NULL,

  `contact_name` varchar(20) DEFAULT NULL ,
   `contact_phone` varchar(20)  DEFAULT NULL,
  `account_name` varchar(20)  DEFAULT NULL,
  `account_id` varchar(20)  DEFAULT NULL,

  `license_type` varchar(20)  DEFAULT NULL,
  `Registered_captial`  varchar(20) DEFAULT NULL,
  `Social_credit_code` varchar(20)  DEFAULT NULL,
  `Expiration_date` datetime  DEFAULT NULL,
  `Business_scope` varchar(256)  DEFAULT NULL,
  `Product_category` varchar(100) DEFAULT NULL ,


  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
