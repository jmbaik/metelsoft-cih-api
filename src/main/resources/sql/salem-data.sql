INSERT INTO salem.`position` (p_code,name,level1,level2,level3) VALUES
	 ('L110','담임목사','목사','담임목사',NULL),
	 ('L120','원로목사','목사','원로목사',NULL),
	 ('L130','목사','목사','일반목사',NULL),
	 ('L210','강도사','강도사',NULL,NULL),
	 ('L310','전임전도사','전도사','전임전도사',NULL),
	 ('L320','교육전도사','전도사','교육전도사',NULL),
	 ('L910','시무장로','장로','시무장로',NULL),
	 ('L920','원로장로','장로','원로장로',NULL),
	 ('L930','은퇴장로','장로','은퇴장로',NULL);


INSERT INTO salem.area_code (code,name,alias_code) VALUES
	 ('02','서울','A'),
	 ('031','경기','B'),
	 ('032','인천','C'),
	 ('033','강원','D'),
	 ('041','충남','E'),
	 ('042','대전','F'),
	 ('043','충북','G'),
	 ('051','부산','H'),
	 ('052','울산','I'),
	 ('053','대구','J');
INSERT INTO salem.area_code (code,name,alias_code) VALUES
	 ('054','경북','K'),
	 ('055','경남','L'),
	 ('061','전남','M'),
	 ('062','광주','N'),
	 ('063','전북','O'),
	 ('064','제주','P');

-- https://t1.daumcdn.net/cfile/tistory/136DFD0A49B0BE47C4