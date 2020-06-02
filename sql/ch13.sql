--권한(privilege),
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create user usertest01
  2  identified by pass1
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users
  6  ;

User created.

SQL> connect usertest01/pass1
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL>
--권한부여
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest01;

Grant succeeded.

SQL> connect hr/hr
Connected.
--객체 소유자가 객체 권한을 다른유저에게 부여
SQL> grant select on employee to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1
Connected.
SQL> select eno,ename, hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13
--권한 회수
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> show user
USER is "SYS"
SQL> revoke create session from usertest01;

Revoke succeeded.

SQL> connect usertest01/pass1;
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.      

--with grant option
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create user usertest02
  2  identified by pass2
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users;

User created.

SQL> grant create session, create table, create view to usertest02;

Grant succeeded.

SQL> connect usertest02/pass2;
Connected.
SQL> connect hr/hr
Connected.
SQL> grant select on employee to usertest02 with grant option;

Grant succeeded.

SQL> connect usertest02/pass2;
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL> grant select on hr.employee to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1;
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1;
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL>

-- role 생성 및 부여
SQL> connect sys as sysdba
Enter password:
Connected.
-- create role 롤명;
SQL> create role  roletest01;

Role created.
-- grant 권한 to 롤명;
SQL> grant create session, create table, create view to roletest01;

Grant succeeded.
-- grant 롤명 to 유저;
SQL> grant roletest01 to usertest01;

Grant succeeded.

-- 롤 정보 조회
select * from role_sys_privs; --롤에 부여된 시스템권한
select * from role_tab_privs; -- 롤에 부여된 테이블관련 권한
select * from user_role_privs;-- 접근가능권한
select * from user_tab_privs_made; -- 해당 사용자가 부여한 권한(table)
select * from user_tab_privs_recd; -- 사용자에에 부여된 권한(table)
select * from user_col_Privs_made; -- 해당사용자가 부여한 권한(column)
select * from user_col_privs_recd; -- 사용자에게 부여된 권한(column)

--롤 삭제
-- drop role 롤명
SQL> drop role roletest01 ;


--synonym(동의어) - 객체 별칭 붙이기
create synonym hremp for employee;
select * from hremp;
select * from employee;

--dba롤로 접속
SQL> show user;
USER is "SYS"
--hr유저의 employee 조회 가능확인
SQL> connect usertest01/pass1
Connected.
SQL> select count(*) from hr.employee;

  COUNT(*)
----------
        14
-- 개인 synonym 생성
-- create synonym 시노님명 for 유저.오브젝트
SQL> connect usertest01/pass1;
Connected.
SQL> create synonym syn_hr_emp for hr.employee;

Synonym created.
--synonym명으로 조회 
SQL> select count(*) from syn_hr_emp;

  COUNT(*)
----------
        14
-- 다른 유저에서 synonym명으로 조회 불가.
SQL> connect scott/tiger
Connected.
SQL> select count(*) from syn_hr_emp;
select count(*) from syn_hr_emp
                     *
ERROR at line 1:
ORA-00942: table or view does not exist

--scott유저에 synonym 생성권한 부여
SQL> show user;
USER is "SCOTT"
SQL> connect sys as sysdba;
Enter password:
Connected.
SQL> grant dba to scott;

Grant succeeded.

SQL> connect scott/tiger
Connected.
SQL> select count(*) from syn_hr_emp;
select count(*) from syn_hr_emp
                     *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> show user;
USER is "SCOTT"
SQL> connect usertest01/pass1
Connected.
SQL> show user;
USER is "USERTEST01"
SQL>
-- 고용synonym생성 
-- create public synonym 시노님명 for 유저.오브젝트;
SQL> create public synonym hr_syn_emp for hr.employee;

Synonym created.
-- 공용시노님 명으로 조회 
SQL> select count(*) from hr_syn_emp;

  COUNT(*)
----------
        14
-- 공용 시노님명으로 조회
SQL> connect scott/tiger
Connected.
SQL> select count(*) from hr_syn_emp;

  COUNT(*)
----------
        14




      