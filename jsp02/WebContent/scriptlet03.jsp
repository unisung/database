<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>0부터10까지의 정수중 짝수만 출력하기 </title>
</head>
<body>
<!-- html페이지 자바코드 scriptlet -->
<%
	for(int i=0;i<=10;i++){
		 if(i%2==0){
			 out.print(i+"&nbsp;&nbsp;");//출력객체 out
		 }
	}
%>
</body>
</html>