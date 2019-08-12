create table patent(
    num number(5),
    patentnum VARCHAR2(20) PRIMARY key,
    title VARCHAR2(30),
    content VARCHAR2(500)
);

create SEQUENCE patent_seq start with 1 INCREMENT by 1;

commit;