-- cihdb.tb_admins definition

CREATE TABLE `tb_admins` (
  `email` varchar(200) NOT NULL,
  `c_code` varchar(5) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `admin_level` varchar(100) NOT NULL DEFAULT 'admin',
  `regdate` datetime DEFAULT NULL,
  `upddate` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`email`,`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_church_code definition

CREATE TABLE `tb_church_code` (
  `c_code` varchar(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL,
  `reg_id` varchar(100) DEFAULT NULL,
  `reg_dt` datetime DEFAULT NULL,
  `upd_id` varchar(100) DEFAULT NULL,
  `upd_dt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_origin_vid definition

CREATE TABLE `tb_origin_vid` (
  `ovid` varchar(7) NOT NULL COMMENT 'vid 출처아이디',
  `name` varchar(100) NOT NULL COMMENT '출처명',
  `title` varchar(200) NOT NULL COMMENT '제목',
  `channelurl` varchar(200) NOT NULL COMMENT '채널url',
  `comment` varchar(1000) DEFAULT NULL COMMENT '설명',
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`ovid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_pastor definition

CREATE TABLE `tb_pastor` (
  `p_code` varchar(7) NOT NULL,
  `c_code` varchar(5) NOT NULL,
  `grade` varchar(1) NOT NULL DEFAULT 'p',
  `name` varchar(200) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL,
  `reg_id` varchar(100) DEFAULT NULL,
  `reg_dt` datetime DEFAULT NULL,
  `upd_id` varchar(100) DEFAULT NULL,
  `upd_dt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`p_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_youtube_pastor definition

CREATE TABLE `tb_youtube_pastor` (
  `vid` varchar(13) NOT NULL COMMENT '비디오 id',
  `p_code` varchar(7) NOT NULL COMMENT '목사 코드',
  `title` varchar(200) NOT NULL COMMENT '제목',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `ovid` varchar(7) DEFAULT NULL COMMENT '출처 V주소',
  `youtubeid` varchar(200) NOT NULL COMMENT '유투브 아이디',
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- cihdb.tb_area_code definition

CREATE TABLE `tb_area_code` (
  `a_code` varchar(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `alias_code` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`a_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;