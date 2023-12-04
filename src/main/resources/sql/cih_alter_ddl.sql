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

