select * from department;
insert into department values(60,'SALES','L.A');
select eno, ename, a.dno, dname
  from employee a, department b
 where a.dno=b.dno
   and a.job = 'CLERK'
   and a.dno=20;
   
 select * from employee where dno=20;  
 
select * from user_objects 
 where object_type='PROCEDURE'
 order by object_name;
 
select text from user_source where name='PR_EMP_UPSAL';

procedure pr_emp_upSal  
 (tot out number)--출력용 매개변수 선언  
 as  
 begin  
 	--급여인상 처리  
 	update employee  
 	   set salary = salary + salary*0.05;--전사원   
 	 commit;  
 	select sum(salary)  
 	  into tot  
 	  from employee;  
 end; 

select * from user_objects where object_type='FUNCTION';
select text from user_source where name='FN_SALARY_ENAME';

create or replace function fn_salary_ename(  
 v_ename in employee.ename%type  
 )  
 return number--리턴타입 선언  
 is  
 v_salary number(7,2);--소수점2, 정수4자리  
 begin  
 select salary into v_salary from employee where ename =v_ename;  
 return v_salary;--결과값 리턴  
 end;

--실행
SQL> variable v_sal number;--variable 변수 타입;
-- exec :변수 :=함수명(값);
SQL> exec :v_sal :=fn_salary_ename('SMITH');
PL/SQL procedure successfully completed.
--결과 출력 print 변수명;
SQL> print v_sal;

     V_SAL
----------
   1021.03 
 








