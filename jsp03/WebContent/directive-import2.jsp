<%@ page pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %><!-- import속성 -->
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();
%>
오늘은
<%=cal.get(Calendar.YEAR) %>년
<%=cal.get(Calendar.MONTH)+1 %>월<!--월+1  -->
<%=cal.get(Calendar.DATE) %>일
</body>
</html>