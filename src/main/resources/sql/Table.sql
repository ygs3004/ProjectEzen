drop table board;
drop table users;

CREATE TABLE board
(
    boardNo      NUMBER(20) primary key,
    boardTitle   VARCHAR2(200)  not null,
    boardContent VARCHAR2(3000) not null,
    user_name    VARCHAR2(50)   not null,
    regDate      DATE DEFAULT SYSDATE,
    updateDate   DATE DEFAULT SYSDATE,
    boardName    varchar2(50)   not null
);

CREATE TABLE reply
(
    replayNo number(15) primary key,
    boardNo  number(15)     not null,
    reply    varchar2(3000) not null,
    replyer  varchar2(250)  not null
);

CREATE TABLE USERS
(
    user_role   NUMBER       NOT NULL,
    user_name   VARCHAR2(10) NOT NULL,
    user_id     VARCHAR2(30) NOT NULL primary key,
    user_pw     VARCHAR2(35) NOT NULL,
    user_pw2    VARCHAR2(35) NOT NULL,
    user_email  VARCHAR2(30) NOT NULL,
    user_phone  VARCHAR2(30) NOT NULL,
    user_gender NUMBER NOT NULL,
    user_school VARCHAR2(30) NOT NULL
);

drop table users;
INSERT INTO users values (1, '윤건수', 'userid', 'userpw', 'userpw', '1@1.com', '1', '1', '1');
commit;
select * from users;

CREATE TABLE HWBOARD
(
    HWNAME     VARCHAR2(300) NOT NULL,
    HWCONTENT  VARCHAR2(300) NOT NULL,
    WRITER     VARCHAR2(50)  NOT NULL primary key ,
    HWREGDATE  DATE,
    HWDEADLINE DATE,
    CompleteMentee NUMBER DEFAULT 0
);



drop table hwboard;

select *
from board;
select *
from reply;
select *
from users;
select *
from MENTOROOM;
select*from HWBOARD;

drop table MENTOROOM;
drop sequence mento_room_seq;

create sequence mento_room_seq;

CREATE TABLE MENTOROOM
(
    USER_ID     VARCHAR2(20),
    NUM         NUMBER        NOT NULL primary key,
    TITLE       VARCHAR2(200) NOT NULL,
    NAME        VARCHAR2(15)  NOT NULL,
    CAREER      VARCHAR2(1000),
    SCHOOL      VARCHAR2(30)  NOT NULL,
    CAPACITY    NUMBER        NOT NULL,
    NOWCAPACITY NUMBER DEFAULT 0,
    STUDYSTART  DATE          NOT NULL,
    STUDYEND    DATE          NOT NULL,
    CONTENT     VARCHAR2(1000)
);

/* 테스트 데이터 */
INSERT INTO MENTOROOM (user_id, num, title, name, career, school, capacity, nowcapacity, studystart, studyend, content)
values ('user01', mento_room_seq.nextval, 'StudyName', '멘토철수', '경력', '서울대학교', 30, 1, sysdate,
        SYSDATE + (INTERVAL '1' YEAR), '열공을 하는 모임입니다.');

commit;


select *
from MENTOROOM;

create sequence hw_seq start with 1 increment by 1;

drop table hwboard;



select *
from HWBOARD;

delete from hwboard;
