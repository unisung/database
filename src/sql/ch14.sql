-- pl/sql 
--절차적 프로그래밍 기능의 sql문
--선언부, 실행부, 예외부로 구성
set serveroutput on
begin
	dbms_output.put_line('Welcome to Oracle');
end; 


set serveroutput on
declare -- 선언부
v_eno number(4); --스칼라타입 
v_ename varchar2(20);
begin--실행부
v_eno := 7788;--변수 :=값;
v_ename :='scott';
dbms_output.put_line('사원번호  사원이름');
dbms_output.put_line('------------------');
dbms_output.put_line(v_eno||'    '||v_ename);
end;
/

사원번호  사원이름
------------------
7788    scott

PL/SQL procedure successfully completed.

-- 참조변수 선언
set serveroutput on
declare
v_eno employee.eno%type;--employe테이블의 eno타입 참조
v_ename employee.ename%type;--employee테이블의 ename타입 참조
begin
v_eno:=7788;
v_ename:='scott';
dbms_output.put_line('사원번호  사원명');
dbms_output.put('---------------------');--put() 한줄출력후 해당라인에 멈춤
dbms_output.put_line('');--출력후 다음라인
dbms_output.put_line(v_eno||'  '||v_ename);
end;
/

set serveroutput on
declare
v_eno employee.eno%type;
v_ename employee.ename%type;
begin
	dbms_output.put_line('사원번호 사원명');
	dbms_output.put_line('-----------');
	
	select eno,ename
	  into v_eno, v_ename--select한 결과를 변수에 저장
	  from employee
	 where ename=upper('scott');
	
	dbms_output.put_line(v_eno||' '||v_ename);
end; 

-- 사번이 7788인 사원의 사원명, job, salary, hiredate를 출력하는 pl/sql문 작성








