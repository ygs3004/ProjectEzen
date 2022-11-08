
-- user에 user_idx , 시퀀스 추가

CREATE TABLE USERS
(
    user_idx    number       Not null,
    mentorRoomNo number     ,
    user_role   NUMBER       NOT NULL,
    user_name   VARCHAR2(30) NOT NULL,
    user_id     VARCHAR2(30) NOT NULL primary key,
    user_pw     VARCHAR2(35) NOT NULL,
    user_pw2    VARCHAR2(35) NOT NULL,
    user_email  VARCHAR2(30) NOT NULL,
    user_phone  VARCHAR2(30) NOT NULL,
    user_gender NUMBER NOT NULL,
    user_school VARCHAR2(30) NOT NULL
);



commit;
-- 여기까지 ------


drop table users;
INSERT INTO users values (1, '윤건수', 'userid', 'userpw', 'userpw', '1@1.com', '1', '1', '1');
commit;
select * from users;

select *
from board;
select *
from reply;
select *
from users;
select *
from MENTOROOM;

