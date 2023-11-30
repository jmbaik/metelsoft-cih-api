
-- 오라클의 create table insert 유사
create table if not exists bu_youtube_pastor select * from tb_youtube_pastor ;

create table if not exists bu_youtube_pastor select * from tb_youtube_pastor ;
select * from bu_youtube_pastor ;


select * from tb_admins ;
select * from tb_area_code;
create table if not exists bu_area_code select * from tb_area_code;
select * from bu_area_code;
select * from tb_church_code;
create table if not exists bu_church_code select * from tb_church_code;
select * from tb_pastor;
create table if not exists bu_pastor select * from tb_pastor;
select * from bu_pastor;
select * from bu_youtube_pastor ;

commit;