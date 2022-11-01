drop table MENTORROOM;
drop sequence mentor_room_seq;

create sequence mentor_room_seq;

CREATE TABLE MENTORROOM
(
    USER_ID         VARCHAR2(20),
    NUM             NUMBER        NOT NULL primary key,
    TITLE           VARCHAR2(200) NOT NULL,
    STUDYPERIOD     VARCHAR2(150) NOT NULL,
    STUDYWEEKLY     VARCHAR(20),
    STUDYTIMESTART  VARCHAR2(10)  NOT NULL,
    STUDYTIMEEND    VARCHAR2(10)  NOT NULL,
    CAPACITY        NUMBER        NOT NULL,
    NOWCAPACITY     NUMBER        DEFAULT 0,
    CAREER          VARCHAR2(1000),
    SCHOOL          VARCHAR2(30)  NOT NULL,
    CONTENT         VARCHAR2(1000)
);


CREATE TABLE hwInfo
(
    HWNAME     VARCHAR2(300) NOT NULL,
    HWCONTENT  VARCHAR2(300) NOT NULL,
    WRITER     VARCHAR2(50)  NOT NULL primary key ,
    HWREGDATE  DATE,
    HWDEADLINE DATE,
    CompleteMentee NUMBER DEFAULT 0
);
select * from hwInfo;
INSERT INTO hwInfo values('숙제명', '숙제내용', '멘토이륾', SYSDATE, SYSDATE + (INTERVAL '1' YEAR), 0);


/* 테스트 데이터 */
INSERT INTO MENTORROOM values ('멘토철수', mento_room_seq.nextval, 'StudyName', '경력', '서울대학교', 30, 1, sysdate,
        SYSDATE + (INTERVAL '1' YEAR), '열공을 하는 모임입니다.');


INSERT INTO MENTORROOM ( num, user_id, title, studyPeriod, studyWeekly, studytimestart, studyTimeEnd, capacity, nowcapacity, career, school, content)
values ( mentor_room_seq.nextval, 'user01','StudyName','2022/11/01 - 2022/11/02', '1,5', '09:00', '18:00',  30, 0, 1, '서울대학교', '열공을 하는 모임입니다.');

commit;

select *
from MENTORROOM;

create sequence hw_seq start with 1 increment by 1;

drop table hwInfo;



select *
from hwInfo;

delete from hwInfo;
