create table patent(
    num number(5),
    patentnum VARCHAR2(20) PRIMARY key,
    title VARCHAR2(30),
    content VARCHAR2(500),
    readcount NUMBER(4) DEFAULT 0
);

create SEQUENCE patent_seq start with 1 INCREMENT by 1;
commit;

insert into patent(num, patentnum, title, content) values(patent_seq.nextval, '158ci', '경량알루미늄', '경량 알루미늄 연결 강도 상승 및 비선형 구조물 강도 증가');