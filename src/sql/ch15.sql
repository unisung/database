--프로시져 -명령문을 모아서 하나의 그룹으로 처리하기위한 객체
--create or replace procedure 프로시져명 is 변수 begin~~end;
create or replace procedure sp_salary
is
v_salary employee.ename%type;
begin
	select salary into v_salary from employee where ename='SCOTT';
	dbms_output.put_line('SCOTT의 급여는 '||v_salary);
end; 

--user_source에 객체로 저장
select name, text from user_source where name='SP_SALARY';

--실행 --command|sqlplus에서 실행
execute sp_salary;

--삭제
--drop procedure 프로시져명
drop procedure sp_salary;


--매개변수를 받는 프로시져
create or replace procedure sp_salary_ename(
v_ename in employee.ename%type--아규먼트 선언 값을 읽어들이는 모드
)
is
v_salary employee.salary%type;--변수선언
begin
	select salary into v_salary from employee where ename=v_ename;
	dbms_output.put_line(v_ename||'의 급여는 '||v_salary);
end; 

--프로시져 소스확인
select name,text from user_source where name ='SP_SALARY_ENAME';
--프로시져 상태 확인 status-valid
select object_name,object_type, status 
  from user_objects where object_name='SP_SALARY_ENAME';

--out 매개변수 
create or replace procedure sp_salary_ename2(
v_ename in employee.ename%type,
v_salary out employee.salary%type
)
as
begin
	select salary into v_salary from employee where ename=v_ename;
end; 

--실행
--out모드의 변수 값 받기 위한 변수 선언
-- variable 변수명 타입; 
variable v_salary varchar2(14);
--실행
--execute 프로시명(입력값, :출력변수)
execute sp_salary_ename2('SCOTT',:v_salary);
--변수값 console에 출력
--print 변수
print v_salary;







