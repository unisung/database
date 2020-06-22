<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	java.util.Calendar cal = java.util.Calendar.getInstance();
%>
오늘은
<%=cal.get(java.util.Calendar.YEAR) %>년
<%=cal.get(java.util.Calendar.MONTH)+1 %>월<!--월+1  -->
<%=cal.get(java.util.Calendar.DATE) %>일
</body>
</html>