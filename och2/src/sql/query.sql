select job,salary,hiredate from employee where ename='SMITH';
select ename,job,salary,hiredate from employee where dno=10;
select * from dept;
insert into dept values(60,'SALES','NEW YORK');
update dept set loc='DALLAS' where dno=60;
select * from user_triggers where table_name ='DEPT';
alter trigger trigger_sample1 disable;
delete from dept where dno=60;

select dno,dname,loc from dept;
select * from employee where eno=7788;

select * from dept where dno=10;