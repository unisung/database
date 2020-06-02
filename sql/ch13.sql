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
      