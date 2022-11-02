drop table users;

CREATE TABLE USERS
(
    user_idx    number       Not null,
    mentorRoomNo number,
    user_role   NUMBER       NOT NULL,
    user_name   VARCHAR2(10) NOT NULL,
    user_id     VARCHAR2(30) NOT NULL primary key,
    user_pw     VARCHAR2(35) NOT NULL,
    user_pw2    VARCHAR2(35) NOT NULL,
    user_email  VARCHAR2(30) NOT NULL,
    user_phone  VARCHAR2(30) NOT NULL,
    user_gender NUMBER NOT NULL,
    user_school VARCHAR2(30) NOT NULL
);

commit;

select * from users;