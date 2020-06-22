<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>선언부:전역변수 및 메소드 선언</title>
</head>
<body>
<%
    /* a 와 b는 로컬변수, 선언 및 초기화 후 사용  */
	int a=10;//로컬변수
    int b=a+data;

    out.println(b);
%>
<!-- 전역변수 흐름의 후반에 작성해도 됨. 
 초기화를 하지않아도 데이타의 기본값으로 초기화 
 : 전역변수 -->
<%! int data; %>
</body>
</html>