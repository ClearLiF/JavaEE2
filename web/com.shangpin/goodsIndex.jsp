<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();

%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<frameset rows="15%,*" >

	<frame src ="<%=path %>/manage/search.action" name="left_navi" noresize scrolling="auto">
	<frame  src="<%=path %>/manage/getGoods.action"   name=down_search>
</frameset>
<body>

</body>
</html>