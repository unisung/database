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


-- 프로시져
-- 전사원의 급열 5%인상후 전체 인상후 급여액 출력 
create or replace procedure pr_emp_upSal
(tot out number)--출력용 매개변수 선언
as
begin
	--급여인상 처리
	update employee
	   set salary = salary + salary*0.05;--전사원 
	 commit;--트랜잭션 처리후 db 반영처리
	 
	select sum(salary)
	  into tot
	  from employee;
end; 

--출력용 매개변수값을 받는 변수 선언 variable 변수명 타입; 
variabl v_tot number(14);
--실행 execute 프로시져명 (:변수명);
execute pr_emp_upSal(:v_tot);
--결과 출력 print 변수명;
print v_tot;

select * from employee;


--함수 
--function 실행문을 처리후 결과를 리턴하는 형식의 객체
create or replace function fn_salary_ename(
v_ename in employee.ename%type
)
return number;--리턴타입 선언
is
v_salary number(7,2);--소수점2, 정수4자리
begin
select salary into v_salary from employee where ename =v_ename;
return v_salary;--결과값 리턴
end; 

--FUNCTION 정보 조회
select object_name, status from user_objects
where object_type='FUNCTION';

--실행
--출력용 변수 선언
variable v_salary number;
--실행
-- execute :변수 :=함수명;
execute :v_salary :=fn_salary_ename('SCOTT');
--결과 출력
--print 변수명;
print v_salary;

--select문에서 실행
select ename,fn_salary_ename(ename) salary
  from employee order by eno;

-- 특정 사원의 입사일자를 구하는 함수 
create or replace function fn_hire_eno
(v_eno number)
return date
as
v_date date;
begin
	select hiredate
	  into v_date 
	  from employee
	 where eno=v_eno;
   return v_date;	 
end;
--실행
--변수 선언
variable v_hiredae varchar2(20);
--실행 및 결과 얻기
execute :v_hiredae :=to_char(fn_hire_eno(7788));
--결과 출력
print v_hiredae;
--쿼리문에서 결과 출력
select eno, fn_hire_eno(eno) from employee where eno=7788;






















