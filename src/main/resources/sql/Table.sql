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
    user_email  VARCHAR2(15) NOT NULL,
    user_phone  VARCHAR2(30) NOT NULL,
    user_gender VARCHAR2(30) NOT NULL,
    user_school VARCHAR2(30) NOT NULL
);

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

CREATE TABLE HWBOARD
(
    HWNO       NUMBER        NOT NULL,
    HWNAME     VARCHAR2(300) NOT NULL,
    HWCONTENT  VARCHAR2(300) NOT NULL,
    WRITER     VARCHAR2(50)  NOT NULL,
    HWREGDATE  DATE,
    HWDEADLINE DATE,
    CONSTRAINT HWBOARD_PK PRIMARY KEY (HWNO) ENABLE
);

select *
from board;
select *
from reply;
select *
from users;
select *
from MENTOROOM;
select*from HWBOARD;


