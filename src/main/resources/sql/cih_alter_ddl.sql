ALTER TABLE cihdb.tb_youtube_sermon ADD p_code varchar(7) NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE p_code p_code varchar(7) NULL AFTER thumbnail_d;

ALTER TABLE cihdb.tb_youtube_sermon MODIFY COLUMN prevPageToken VARCHAR(200) DEFAULT NULL NULL;
ALTER TABLE cihdb.tb_youtube_sermon MODIFY COLUMN nextPageToken VARCHAR(200) DEFAULT NULL NULL;


ALTER TABLE cihdb.tb_youtube_mercy  MODIFY COLUMN prevPageToken VARCHAR(200) DEFAULT NULL NULL;
ALTER TABLE cihdb.tb_youtube_mercy MODIFY COLUMN nextPageToken VARCHAR(200) DEFAULT NULL NULL;


ALTER TABLE cihdb.tb_youtube_celeb MODIFY COLUMN prevPageToken VARCHAR(200) DEFAULT NULL NULL;
ALTER TABLE cihdb.tb_youtube_celeb MODIFY COLUMN nextPageToken VARCHAR(200) DEFAULT NULL NULL;

ALTER TABLE cihdb.tb_shorts_ccm  MODIFY COLUMN prevPageToken VARCHAR(200) DEFAULT NULL NULL;
ALTER TABLE cihdb.tb_shorts_ccm  MODIFY COLUMN nextPageToken VARCHAR(200) DEFAULT NULL NULL;

ALTER TABLE cihdb.tb_youtube_pastor ADD shorts varchar(1) DEFAULT 'N' NULL;
ALTER TABLE cihdb.tb_youtube_pastor CHANGE shorts shorts varchar(1) DEFAULT 'N' NULL AFTER qSignal;

ALTER TABLE cihdb.tb_youtube_celeb  ADD shorts varchar(1) DEFAULT 'N' NULL;
ALTER TABLE cihdb.tb_youtube_celeb CHANGE shorts shorts varchar(1) DEFAULT 'N' NULL AFTER qSignal;

ALTER TABLE cihdb.tb_youtube_mercy  ADD shorts varchar(1) DEFAULT 'N' NULL;
ALTER TABLE cihdb.tb_youtube_mercy CHANGE shorts shorts varchar(1) DEFAULT 'N' NULL AFTER qSignal;

ALTER TABLE cihdb.tb_youtube_sermon  ADD shorts varchar(1) DEFAULT 'N' NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE shorts shorts varchar(1) DEFAULT 'N' NULL AFTER qSignal;

ALTER TABLE cihdb.tb_shorts_ccm  ADD shorts varchar(1) DEFAULT 'N' NULL;
ALTER TABLE cihdb.tb_shorts_ccm CHANGE shorts shorts varchar(1) DEFAULT 'N' NULL AFTER qSignal;