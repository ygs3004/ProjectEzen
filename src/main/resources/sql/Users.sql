--테이블 초기화 용
drop table users;
drop sequence user_seq;

-- 테이블 , 시퀀스 생성
create sequence user_seq start with 1 increment by 1;
CREATE TABLE USERS
(
    user_idx    number       Not null,
    mentorRoomNo number,
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

-- 테이블 확인용
select * from users;

SELECT user_idx.currval FROM DUAL;

-- 테스트용
-- 멘토 테스트, mentoRoom 넘버 임의로 1로 넣어뒀음
insert into users(user_idx, mentorRoomNo, user_role, user_name, user_id, user_pw, user_pw2, user_email, user_phone, user_gender, user_school)
values (user_idx.nextval, 1, 1, '김이름', '김멘토', '1234', '1234', 'ygs3004@naver.com',  '01011112222', 1, '서울대학교');

-- 멘티 테스트용, mentoRoom 넘버 1인상태
insert into users(user_idx, mentorRoomNo, user_role, user_name, user_id, user_pw, user_pw2, user_email, user_phone, user_gender, user_school)
values (user_idx.nextval, 1, 2, '김제자', 'JEJA', '1234', '1234', 'student@naver.com',  '01022223333', 2, '서울고등학교');

-- 정상 회원가입햇을 때(멘토/멘티)
insert into users
    (user_idx, mentorRoomNo, user_role, user_name, user_id, user_pw, user_pw2,
     user_email, user_phone, user_gender, user_school)
    values (user_idx_seq.nextval, 0, 1, '멘토', 'mentor_id', '1234', '1234', 'mentor@com', '010-111-1111', 1, '멘토대학교');
insert into users
    (user_idx,mentorRoomNo,  user_role, user_name, user_id, user_pw, user_pw2,
    user_email, user_phone, user_gender, user_school)
    values (user_idx_seq.nextval, 0, 2, '멘티', 'mentee_id', '1234', '1234', 'mentee@com', '010-222-2222', 2, '멘티고등학교');

-- 커밋
commit;



