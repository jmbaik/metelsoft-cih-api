ALTER TABLE cihdb.tb_youtube_pastor  ADD prevPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_pastor CHANGE prevPageToken prevPageToken INT NULL AFTER publishedAt;
ALTER TABLE cihdb.tb_youtube_pastor ADD nextPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_pastor CHANGE nextPageToken nextPageToken INT NULL AFTER prevPageToken;
ALTER TABLE cihdb.tb_youtube_pastor ADD totalResults INT NULL;
ALTER TABLE cihdb.tb_youtube_pastor CHANGE totalResults totalResults INT NULL AFTER nextPageToken;
ALTER TABLE cihdb.tb_youtube_pastor ADD itemNo INT NULL;
ALTER TABLE cihdb.tb_youtube_pastor CHANGE itemNo itemNo INT NULL AFTER totalResults;

ALTER TABLE cihdb.tb_youtube_celeb  ADD prevPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_celeb CHANGE prevPageToken prevPageToken INT NULL AFTER publishedAt;
ALTER TABLE cihdb.tb_youtube_celeb ADD nextPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_celeb CHANGE nextPageToken nextPageToken INT NULL AFTER prevPageToken;
ALTER TABLE cihdb.tb_youtube_celeb ADD totalResults INT NULL;
ALTER TABLE cihdb.tb_youtube_celeb CHANGE totalResults totalResults INT NULL AFTER nextPageToken;
ALTER TABLE cihdb.tb_youtube_celeb ADD itemNo INT NULL;
ALTER TABLE cihdb.tb_youtube_celeb CHANGE itemNo itemNo INT NULL AFTER totalResults;

ALTER TABLE cihdb.tb_youtube_sermon  ADD prevPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE prevPageToken prevPageToken INT NULL AFTER publishedAt;
ALTER TABLE cihdb.tb_youtube_sermon ADD nextPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE nextPageToken nextPageToken INT NULL AFTER prevPageToken;
ALTER TABLE cihdb.tb_youtube_sermon ADD totalResults INT NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE totalResults totalResults INT NULL AFTER nextPageToken;
ALTER TABLE cihdb.tb_youtube_sermon ADD itemNo INT NULL;
ALTER TABLE cihdb.tb_youtube_sermon CHANGE itemNo itemNo INT NULL AFTER totalResults;

ALTER TABLE cihdb.tb_youtube_mercy ADD prevPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_mercy CHANGE prevPageToken prevPageToken INT NULL AFTER publishedAt;
ALTER TABLE cihdb.tb_youtube_mercy ADD nextPageToken INT NULL;
ALTER TABLE cihdb.tb_youtube_mercy CHANGE nextPageToken nextPageToken INT NULL AFTER prevPageToken;
ALTER TABLE cihdb.tb_youtube_mercy ADD totalResults INT NULL;
ALTER TABLE cihdb.tb_youtube_mercy CHANGE totalResults totalResults INT NULL AFTER nextPageToken;
ALTER TABLE cihdb.tb_youtube_mercy ADD itemNo INT NULL;
ALTER TABLE cihdb.tb_youtube_mercy CHANGE itemNo itemNo INT NULL AFTER totalResults;

ALTER TABLE cihdb.tb_shorts_ccm  ADD prevPageToken INT NULL;
ALTER TABLE cihdb.tb_shorts_ccm CHANGE prevPageToken prevPageToken INT NULL AFTER publishedAt;
ALTER TABLE cihdb.tb_shorts_ccm ADD nextPageToken INT NULL;
ALTER TABLE cihdb.tb_shorts_ccm CHANGE nextPageToken nextPageToken INT NULL AFTER prevPageToken;
ALTER TABLE cihdb.tb_shorts_ccm ADD totalResults INT NULL;
ALTER TABLE cihdb.tb_shorts_ccm CHANGE totalResults totalResults INT NULL AFTER nextPageToken;
ALTER TABLE cihdb.tb_shorts_ccm ADD itemNo INT NULL;
ALTER TABLE cihdb.tb_shorts_ccm CHANGE itemNo itemNo INT NULL AFTER totalResults;

commit;