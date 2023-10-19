CREATE DATABASE `salem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

-- salem.area_code definition

CREATE TABLE `area_code` (
  `code` varchar(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `alias_code` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- salem.church_code definition

CREATE TABLE `church_code` (
  `c_code` varchar(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- salem.intro definition

CREATE TABLE `intro` (
  `c_code` varchar(5) NOT NULL,
  `opt` varchar(2) NOT NULL,
  `seq` int(5) NOT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `cont_text` text DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  `updid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_code`,`opt`,`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- salem.`position` definition

CREATE TABLE `position` (
  `p_code` varchar(4) NOT NULL,
  `name` varchar(100) NOT NULL,
  `level1` varchar(100) DEFAULT NULL,
  `level2` varchar(100) DEFAULT NULL,
  `level3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`p_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- salem.saint definition

CREATE TABLE `saint` (
  `c_code` varchar(5) NOT NULL,
  `s_code` varchar(20) NOT NULL,
  `p_code` varchar(4) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `male` varchar(1) DEFAULT NULL,
  `birth` varchar(10) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  `updid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_code`,`s_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- salem.serving definition

CREATE TABLE `serving` (
  `c_code` varchar(5) NOT NULL,
  `p_code` varchar(4) NOT NULL,
  `name` varchar(100) NOT NULL,
  `work` varchar(500) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `work_period` varchar(200) DEFAULT NULL,
  `appoint_date` varchar(10) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  `updid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_code`,`p_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 추가
-- salem.admin_user definition

CREATE TABLE `admin_user` (
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) NOT NULL,
  `regdate` datetime DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  `c_code` varchar(5) NOT NULL,
  `admin_level` varchar(100) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

