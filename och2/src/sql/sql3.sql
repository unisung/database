select * from dept;
insert into dept values(60,'SALES','DALLAS');
insert into dept values(70,'OPERATION','L.A');
insert into dept values(80,'RESEARCH','CHICAGO');

create table account(
ano varchar2(20) primary key, 
owner varchar2(20),
balance number,
password varchar2(20),
logon char(1)--true->1, false ->0
);

select * from account;