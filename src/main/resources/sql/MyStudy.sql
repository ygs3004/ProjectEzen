drop table MENTOROOM;
drop sequence mento_room_seq;

create sequence mento_room_seq;

CREATE TABLE MENTOROOM
(
    USER_ID VARCHAR2(20),
    NUM NUMBER NOT NULL primary key,
    TITLE VARCHAR2(200) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    CAREER VARCHAR2(1000),
    SCHOOL VARCHAR2(30) NOT NULL,
    CAPACITY NUMBER NOT NULL,
    NOWCAPACITY NUMBER DEFAULT 0,
    STUDYSTART DATE NOT NULL,
    STUDYEND DATE NOT NULL,
    CONTENT VARCHAR2(1000)
);

/* 테스트 데이터 */
INSERT INTO MENTOROOM (user_id, num, title, name, career, school, capacity,nowcapacity, studystart, studyend, content)
values ('user01', mento_room_seq.nextval, 'StudyName', '멘토철수' ,'경력', '서울대학교', 30, 1, sysdate, SYSDATE + (INTERVAL '1' YEAR ), '열공을 하는 모임입니다.' );

commit;


select * from MENTOROOM;

CREATE TABLE HWBOARD
(
    HWNO NUMBER NOT NULL
    , HWNAME VARCHAR2(300) NOT NULL
    , HWCONTENT VARCHAR2(300) NOT NULL
    , WRITER VARCHAR2(50) NOT NULL
    , HWREGDATE DATE
    , HWDEADLINE DATE
    , CONSTRAINT HWBOARD_PK PRIMARY KEY(HWNO) ENABLE
);

select * from HWBOARD;
