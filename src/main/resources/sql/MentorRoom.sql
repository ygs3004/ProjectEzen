-- 멘토룸 테이블 삭제(초기화)
drop table MENTORROOM;
drop sequence mentor_room_seq;

-- 시퀀스, 테이블 생성
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

-- 테스트용 더미
INSERT INTO MENTORROOM ( num, user_id, title, studyPeriod, studyWeekly, studytimestart, studyTimeEnd, capacity, nowcapacity, career, school, content)
values ( mentor_room_seq.nextval, 'user01','StudyName','2022/11/01 - 2022/11/02', '1,5', '09:00', '18:00',  30, 0, 1, '서울대학교', '열공을 하는 모임입니다.');
commit;