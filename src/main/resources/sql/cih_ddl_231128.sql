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
  `upddate` datetime DEFAULT NULL,
  PRIMARY KEY (`email`,`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- cihdb.tb_area_code definition

CREATE TABLE `tb_area_code` (
  `a_code` varchar(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `alias_code` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`a_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- cihdb.tb_church_code definition

CREATE TABLE `tb_church_code` (
  `c_code` varchar(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL,
  `reg_id` varchar(100) DEFAULT NULL,
  `reg_dt` datetime DEFAULT NULL,
  `upd_id` varchar(100) DEFAULT NULL,
  `upd_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


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
  `upd_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`p_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;