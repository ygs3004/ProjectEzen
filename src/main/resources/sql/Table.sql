drop table board;
drop table users;

CREATE TABLE board(
    boardNo NUMBER(20) primary key ,
    title VARCHAR2(200) not null,
    content VARCHAR2(3000) not null,
    user_name VARCHAR2(50) not null,
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE,
    boardName varchar2(50) not null
);

CREATE TABLE reply(
    replayNo number(15) primary key ,
    boardNo number(15) not null,
    reply varchar2(3000) not null,
    replyer varchar2(250) not null
);

CREATE TABLE USERS
(
    USER_ROLE NUMBER NOT NULL
    , USER_NAME VARCHAR2(10) NOT NULL
    , USER_ID VARCHAR2(30) NOT NULL primary key
    , USER_PW VARCHAR2(35) NOT NULL
    , USER_PW2 VARCHAR2(35) NOT NULL
    , USER_EMAIL VARCHAR2(15) NOT NULL
    , USER_PHONE VARCHAR2(10) NOT NULL
    , USER_GENDER VARCHAR2(30) NOT NULL
    , USER_SCHOOL VARCHAR2(30) NOT NULL
);

CREATE TABLE MENTOROOM
(
    USER_ID VARCHAR2(20)
    , NUM NUMBER NOT NULL primary key
    , TITLE VARCHAR2(200) NOT NULL
    , NAME VARCHAR2(10) NOT NULL
    , CAREER VARCHAR2(1000)
    , SCHOOL VARCHAR2(30) NOT NULL
    , CAPACITY NUMBER NOT NULL
    , STUDYSTART DATE NOT NULL
    , STUDYEND DATE NOT NULL
    , CONTENT VARCHAR2(1000)
);


select * from board;
select * from reply;
select * from users;
select  * from MENTOROOM;


