-- 테이블 초기화
drop table homeWork;

-- 테이블 생성
create table homeWork(
    user_id VARCHAR2(30), -- HomeWork 제출자
    content VARCHAR2(3000),  -- 내용
    hwRegDate DATE, -- 제출일, 수정일
    uuid VARCHAR2(250), -- 파일명 중복방지 id
    filename VARCHAR2(150), -- 제출 파일 이름
    uploadPath VARCHAR2(250)-- 서버에 저장된 경로
);

select * from homeWork;



