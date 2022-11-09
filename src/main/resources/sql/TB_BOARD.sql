
-- 시퀀스 생성
CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

-- TB_BOARD 테이블 생성 및 코멘트 추가
CREATE TABLE BOARD
(
    BOARD_SEQ NUMBER NOT NULL '게시글 번호'
    , BOARD_RE_REF NUMBER '글의 그룹 번호'
    , BOARD_RE_LEV NUMBER '답변 글의 깊이'
    , BOARD_RE_SEQ NUMBER '답변 글의 순서'
    , BOARD_WRITER VARCHAR2(20) '게시글의 작성자'
    , BOARD_SUBJECT VARCHAR2(50) '게시글의 제목'
    , BOARD_CONTENT VARCHAR2(2000) '게시글의 내용'
    , BOARD_HITS NUMBER DEFAULT '0'  /** '게시글의 조회수' */
    , DEL_YN VARCHAR(1) DEFAULT 'N' /** 삭제유무 */
    , INS_USER_ID VARCHAR2(20) '입력자ID'
    , INS_DATE DATE ' 입력일시'
    , UPD_USER_ID VARCHAR2(20) '수정자ID'
    , UPD_DATE DATE '수정일시'
    , CONSTRAINT TABLE1_PK PRIMARY KEY
    (
     BOARD_SEQ
        )
    ENABLE
);
-- 저장하기 위한 commit
commit;

-- BOARD 테이블 샘플 데이터 입력
INSERT INTO BOARD (BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_WRITER, BOARD_SUBJECT, BOARD_CONTENT, INS_USER_ID, INS_DATE)
            VALUES (0, 0, 0, '게시글 작성자_1', '게시글 제목_1', '게시글 내용_1', 'NONMEMBER', sysdate, 'NONMEMBER', sysdate);

-- BOARD 테이블 샘플 데이터 조회
SELECT * FROM BOARD;



-- BOARD 테이블 삭제
DROP TABLE board;