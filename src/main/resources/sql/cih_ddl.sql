drop table tb_admins;
drop table tb_area_code;
drop table tb_church_code;
drop table tb_origin_vid;
drop table tb_pastor;
drop table tb_shorts_ccm;
drop table tb_youtube_celeb;
drop table tb_youtube_mercy;
drop table tb_youtube_pastor;
drop table tb_youtube_sermon;


-- cihdb.tb_admins definition

CREATE TABLE `tb_admins` (
  `uid` varchar(5) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `admin_level` varchar(100) NOT NULL DEFAULT 'admin',
  `c_code` varchar(5) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL COMMENT '닉네임',
  `comment` varchar(500) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `token` varchar(500) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `updid` varchar(100) DEFAULT NULL,
  `upddate` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_area_code definition

CREATE TABLE `tb_area_code` (
  `a_code` varchar(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `alias_code` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`a_code`)
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
  `channel_id` varchar(200) NOT NULL COMMENT '채널아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `description` varchar(4000) DEFAULT NULL COMMENT '설명',
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`channel_id`)
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


-- cihdb.tb_shorts_ccm definition
-- cihdb.tb_shorts_ccm definition

CREATE TABLE `tb_shorts_ccm` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `comment` varchar(4000) DEFAULT NULL COMMENT '자체코멘트',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` int(11) DEFAULT NULL,
  `nextPageToken` int(11) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_youtube_celeb definition

CREATE TABLE `tb_youtube_celeb` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `comment` varchar(4000) DEFAULT NULL COMMENT '자체코멘트',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` int(11) DEFAULT NULL,
  `nextPageToken` int(11) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_youtube_mercy definition

CREATE TABLE `tb_youtube_mercy` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `comment` varchar(4000) DEFAULT NULL COMMENT '자체코멘트',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` int(11) DEFAULT NULL,
  `nextPageToken` int(11) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_youtube_pastor definition

CREATE TABLE `tb_youtube_pastor` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `p_code` varchar(7) NOT NULL COMMENT '목사 코드',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` varchar(200) DEFAULT NULL,
  `nextPageToken` varchar(200) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_youtube_sermon definition

CREATE TABLE `tb_youtube_sermon` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `comment` varchar(4000) DEFAULT NULL COMMENT '자체코멘트',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` int(11) DEFAULT NULL,
  `nextPageToken` int(11) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `tb_youtube_faith` (
  `vid` varchar(30) NOT NULL COMMENT '비디오 id',
  `channel_id` varchar(100) NOT NULL COMMENT '채널 아이디',
  `title` varchar(500) NOT NULL COMMENT '제목',
  `channel_title` varchar(500) NOT NULL COMMENT '채널 타이틀',
  `thumbnail_d` varchar(200) NOT NULL COMMENT '썸네일small url',
  `thumbnail_m` varchar(200) DEFAULT NULL COMMENT '썸네일 중간 url',
  `thumbnail_h` varchar(200) DEFAULT NULL COMMENT '썸네일 high url',
  `grade` varchar(1) DEFAULT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `comment` varchar(4000) DEFAULT NULL COMMENT '자체코멘트',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `publishedAt` varchar(50) DEFAULT NULL,
  `prevPageToken` varchar(200) DEFAULT NULL,
  `nextPageToken` varchar(200) DEFAULT NULL,
  `totalResults` int(11) DEFAULT NULL,
  `itemNo` int(11) DEFAULT NULL,
  `qSignal` varchar(200) DEFAULT NULL,
  `shorts` varchar(1) DEFAULT 'N',
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  `del_yn` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_comments definition

CREATE TABLE `tb_comments` (
  `category` varchar(100) NOT NULL,
  `vid` varchar(30) NOT NULL,
  `commentId` int(11) NOT NULL,
  `comment` varchar(2000) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `nickName` varchar(200) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `regdt` datetime NOT NULL DEFAULT current_timestamp(),
  `upddt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`category`,`vid`,`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_statics definition

CREATE TABLE `tb_statics` (
  `category` varchar(100) NOT NULL,
  `vid` varchar(30) NOT NULL,
  `likes` int(11) NOT NULL DEFAULT 0,
  `hates` int(11) NOT NULL DEFAULT 0,
  `regdt` datetime NOT NULL DEFAULT current_timestamp(),
  `upddt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`vid`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cihdb.tb_users definition

CREATE TABLE `tb_users` (
  `uid` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `nickName` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `grade` varchar(1) NOT NULL DEFAULT 'u',
  `delYn` varchar(1) DEFAULT 'N',
  `last` datetime DEFAULT current_timestamp(),
  `regdt` datetime DEFAULT current_timestamp(),
  `upddt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;