--1.사원들의 입사년도와 입사한 달,substr()
--yy-mm-dd
select hiredate, substr(hiredate,1,2),substr(hiredate,4,2),
       to_char(hiredate,'YY'),
       to_char(hiredate,'MM')
  from employee;
  
--2. 4월에 입사한 사원 정보
select * from employee where substr(hiredate,4,2)='04';  
select * from employee where to_char(hiredate,'mm')='04';

--3.mod, 사원번호가 짝수 mod(사번,2)=0
select * from employee where mod(eno,2)=0;
select * from employee where mod(eno,2)!=0;

--4.연도2자리(yy),월숫자(mm), 요일 약어(dy)
select eno,ename, 
       to_char(hiredate,'yy'),
       to_char(hiredate,'mm'),
       to_char(hiredate,'dy')
 from employee order by eno;
  
--5. 날짜 계산 
select sysdate,
       trunc(sysdate,'yy'),  
      trunc(sysdate - trunc(sysdate,'yy')) 
from dual; 

--6. 사원들의 상관 사원번호 출력null인경우 0을 대체
select eno, ename, nvl(manager,0) from employee order by eno;


--7. decode함수, 
select eno, ename, job, salary, 
       salary+(decode(job,
                          'ANALYST',200,
                          'SALESMAN',180,
                          'MANAGER',150,
                          'CLERK',100,
                           0)--default값
               ) AS update_salary
  from employee 
  order by eno;
  