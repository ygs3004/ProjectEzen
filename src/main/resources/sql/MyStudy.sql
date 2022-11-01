drop table MENTORROOM;
drop sequence mentor_room_seq;

create sequence mentor_room_seq;

CREATE TABLE MENTORROOM
(
    USER_ID     VARCHAR2(20),
    NUM         NUMBER        NOT NULL primary key,
    TITLE       VARCHAR2(200) NOT NULL,
    CAREER      VARCHAR2(1000),
    SCHOOL      VARCHAR2(30)  NOT NULL,
    CAPACITY    NUMBER        NOT NULL,
    NOWCAPACITY NUMBER DEFAULT 0,
    STUDYSTART  DATE          NOT NULL,
    STUDYEND    DATE          NOT NULL,
    CONTENT     VARCHAR2(1000)
);


/* 테스트 데이터 */
INSERT INTO MENTORROOM (user_id, num, title, career, school, capacity, nowcapacity, studystart, studyend, content)
values ('멘토철수', mento_room_seq.nextval, 'StudyName', '경력', '서울대학교', 30, 1, sysdate,
        SYSDATE + (INTERVAL '1' YEAR), '열공을 하는 모임입니다.');

commit;


select *
from MENTORROOM;

create sequence hw_seq start with 1 increment by 1;

drop table hwInfo;



select *
from hwInfo;

delete from hwInfo;
