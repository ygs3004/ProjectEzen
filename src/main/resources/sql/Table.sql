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


select * from hwInfo;
drop table hwInfo;

select *
from board;
select *
from reply;
select *
from users;
select *
from mentorRoom;


create sequence hw_seq start with 1 increment by 1;

drop table hwInfo;

select *
from hwInfo;

delete from hwInfo;
