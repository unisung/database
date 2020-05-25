--문자열함수
--1.대소문자 변환 함수 lower,upper,initcap
select 'Oracle Mania',
       upper('Oracle Mania'),
       lower('Oracle Mania'),
       initcap('Oracle Mania')
from dual;

--2.문자길이 확인 length(),lenthb()
--length(글자갯수)
select 'Oralce Mania', length('Oracle Mania'), length('오라클매니아')
  from dual;
--lengthb(글자바이트수)
select 'Oracle Manial',lengthb('Oracle Mania'),lengthb('오라클매니아')
  from dual;

--3.문자결합 함수-concat(문자1,문자2), 문자결합연산자(||)
select 'Oracle','mania', concat('Oracle','mania'), 'Oracle'||' mania'
  from dual;
  
select 'hello ','i am ',' dooly',
       concat(concat('hello ','i am '),' dooly'),
       'hello '||'i am '||' dooly'
  from dual;
  

 --4. 문자열 추출함수 substr(대상,시작,갯수)
 select substr('Oracle mania',4,3)--오라클 db의 index번호는 1부터 시작,
  from dual;
 select substr('Oracle mania',-4,3)--오라클 db의 index번호-이면 뒤부터시작,
  from dual;
  
--이름이 N으로 끝나는 사원
select * from employee where substr(ename,-1,1)='N';--enam의 마지막단어가 'N'
select * from employee where ename like '%N';
--87녀도에 입사한 사원
select * from employee where substr(hiredate,1,2)='87';

--문자추출 substrb(대상,시작,갯수)
select substr('Oracle mania',4,3),substrb('Oracle mania',4,3)
  from dual;
select substr('오라클매니아',3,4),substrb('오라클매니아',1,9)
  from dual;
  
  


  
  
  
  
  