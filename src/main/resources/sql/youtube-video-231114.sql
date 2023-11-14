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
  `grade` varchar(1) NOT NULL COMMENT '우선순위등급',
  `sort` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL COMMENT '영상 설명',
  `create_ymd` varchar(10) DEFAULT NULL COMMENT '생성일자',
  `regid` varchar(100) DEFAULT NULL COMMENT '등록자',
  `regdt` datetime DEFAULT NULL COMMENT '등록일시',
  `updid` varchar(100) DEFAULT NULL COMMENT '수정자',
  `upddt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;