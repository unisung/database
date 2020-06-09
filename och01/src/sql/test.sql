select * from employees;
select * from DEPARTMENTS;

create or replace procedure prc()
as
begin
select ename into name from employees;
dbms_output.put(name);
end;