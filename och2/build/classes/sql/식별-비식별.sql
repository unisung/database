select * from customer7;

select * from user_tables where table_name like 'CUSTOM%';

select * from product2;

select * from orders;
--주문테이블에 값 입력
--ORA-02291: integrity constraint (HR.FK_PRODUCT2_TO_ORDERS) violated - parent key not found
insert into orders values(1,10,1,sysdate,'hong','P1212');
--부모테이블의 기본키값 등록(도메인)
insert into customer7 values('hong','홍길동','1234','서울시','010-111-1234',sysdate);
--부모테이블의 기본키값 등록(도메인)
insert into product2 values('P1212','새우깡',2000,2300,10,sysdate);

--비 식별관계 -부모테이블의 기본키가 자식테이블의 일반속성으로 참조되는 관계(키가 아님)
insert into orders values(2,10,1,sysdate,'hong','P1212');

select * from orders2;
select * from customer8;
select * from product3;

-- 식별관계
--부모테이블의 기본키값 등록(도메인)
insert into customer8 values('hong','홍길동','1234','서울시','010-111-1234',sysdate);
--부모테이블의 기본키값 등록(도메인)
insert into product3 values('P1212','새우깡',2000,2300,10,sysdate);
--- orders테이블에 'hong','P1212'가 키
insert into orders2 values('hong','P1212',5,1,sysdate);
select * from orders2;
--식별관계 -부모테이블의 기본키가 자식테이블의 속성으로 참조되는경우
--      - 참조되는 속성이 자식테이블의 기본키로 사용되는 경우 식별관계임.
-- ORA-00001: unique constraint (HR.PK_ORDERS2) violated
insert into orders2 values('hong','P1212',5,1,sysdate);



