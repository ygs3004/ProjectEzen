-- 테이블 삭제(초기화용)
drop table hwInfo;
drop sequence hw_seq;

-- 테이블 생성(생성용)
create sequence hw_seq start with 1 increment by 1;
CREATE TABLE hwInfo
(
    HWNAME     VARCHAR2(300) NOT NULL,
    HWCONTENT  VARCHAR2(300) NOT NULL,
    WRITER     VARCHAR2(50)  NOT NULL primary key ,
    HWREGDATE  DATE,
    HWDEADLINE DATE,
    CompleteMentee NUMBER DEFAULT 0
);

-- 테이블 확인
select * from hwInfo;

-- 가짜 데이터 테스트용
INSERT INTO hwInfo values('숙제명', '숙제내용', '김멘토', SYSDATE, SYSDATE + (INTERVAL '1' YEAR), 0);

--커밋
commit;



select count(*) from HWINFO where writer = '김멘토' ;