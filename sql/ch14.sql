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
--선언부 
declare
v_ename varchar2(20);--스칼라타입 선언
v_job  employee.job%type;--reference타입 선언
v_salary employee.salary%type;
v_hiredate date;
--실행부 
begin
	select ename, job, salary, hiredate
	  into v_ename, v_job, v_salary, v_hiredate
	  from employee
	 where eno=7788;
	 
	dbms_output.put_line('이름:'||v_ename);
	dbms_output.put_line('직책:'||v_job);
	dbms_output.put_line('급여:'||v_salary);
	dbms_output.put_line('입사일:'||v_hiredate);
end; 

-- structure|recored타입 변수
declare
v_empinfo employee%rowtype;--테이블 row타입
--실행부 
begin
	select *
	  into v_empinfo
	  from employee
	 where eno=7788;
	 
	dbms_output.put_line('이름:'||v_info.ename);
	dbms_output.put_line('직책:'||v_info.job);
	dbms_output.put_line('급여:'||v_info.salary);
	dbms_output.put_line('입사일:'||v_info.hiredate);
end; 


select * from employee where eno=7788;

--제어문 if-elsif-else  - end if;
declare --선언부
v_employee employee%rowtype;
temp number(4):=1;
annsal number(7,2); --전체 자리수 가 7자리, 소수점자리수 2자리,정수자리 4자리
begin--실행부
	select * 
	  into v_employee
	  from employee
	 where ename =upper('scott');
	 
	 -- if 조건 then 실행문; end if;
	 if(v_employee.commission is null) then
	    v_employee.commission :=0;
	 end if;
	 
	 annsal :=v_employee.salary*12 + v_employee.commission;
	 dbms_output.put_line('사원번호 사원이름   연봉');
	 dbms_output.put_line('-----------------');
     dbms_output.put_line(v_employee.eno||' '||
                          v_employee.ename||' '||annsal);
end;
/


--if ~ elsif ~ end if;
declare--선언부
v_eno employee.eno%type;
v_ename employee.ename%type;
v_dno employee.dno%type;
v_dname department.dname%type;
begin--실행부
	select eno,ename,dno
	  into v_eno, v_ename,v_dno
	  from employee
	 where ename=upper('scott');
	 
	 if(v_dno=10) then --값 비교: v_dno = 값
	   v_dname := 'Accounting'; -- 값 저장: v_dname :=값
	 elsif v_dno=20 then
	   v_dname := 'Research';
	 elsif v_dno=30 then
	   v_dname :='Sales';
	 elsif v_dno=40 then
	   v_dname :='Operations';
	end if;
	
	dbms_output.put_line('사번    이름   부서명');
	dbms_output.put_line(v_eno||' '||v_ename||' '||v_dname);   
end; 

-- loop문
-- 반복문
declare--선언부
v_dan number :=2; --변수선언 및 값 초기화
v_i number:=1;
begin
	loop
	dbms_output.put(v_dan || '*'||v_i||'='||(v_dan*v_i)||'  ');
	v_i:=v_i+1;--증가식
	if v_i>9 then
	  exit;
	end if;
	end loop;
	dbms_output.put_line('');
end; 


