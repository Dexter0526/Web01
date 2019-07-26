create table member(
    name varchar2(10),
    email varchar2(30),
    pwd varchar2(10),
    phone char(13),
    admin number(1) DEFAULT 0,
    primary key(email)
);

INSERT INTO "ADMIN"."MEMBER" (NAME, EMAIL, PWD, PHONE, ADMIN) VALUES ('°ü¸®ÀÚ', 'admin@dexterweb.co.kr', '0526', '010-1234-5678', '1');
commit;
