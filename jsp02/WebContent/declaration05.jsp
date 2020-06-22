<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>선언부:전역변수 및 함수 선언</title>
</head>
<body>
<!-- 두개의 정수를 입력받아서  덧셈결과를 출력하는 add()메소드 -->
<%!
    int add(int x, int y){
	   int result=x+y;
	   return result;
}
%>
<!-- 두개의 정수를 입력받아서 뺄셈결과를 출력하는 sub()메소드 선언하고 -->
<%! 
    int sub(int x,int y){
	   int result=x-y;
	   return result;
}
%>
<!-- 두 변수는 전역변수(맴버변수)로 선언 하고 첫번째 값은 10, 두번째 값은 20으로 초기화 -->
<%! 
	int x=10;
    int y=20;
%>
<!-- 스크립틀릿에서 결과를 출력  -->
<%  out.print(add(x,y));
    out.print("<br>");//html의 줄바꿈태그
    out.print(sub(x,y));
%>
<br>
<%=add(x,y) %><br><%=sub(x,y) %>
</body>
</html>