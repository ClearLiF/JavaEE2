<%--
  Created by IntelliJ IDEA.
  User: 李琪
  Date: 2019/11/9
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
</head>
<%String path=request.getContextPath();




%>
<body>
<%--第三种方式--%>
<%--<form action="${pageContext.request.contextPath}/login2.action">
    <input type="text" name="user.username">
    <input type="password" name="user.password">
    <input type="submit" name="登录">
</form>--%>
<s:form action="login" namespace="/loginName" id="myform">
    <s:textfield name="username" value="" label="用户名"></s:textfield>
    <s:password label="密码" name="password"></s:password>

    <s:submit name="submit" label="登录" method="login"></s:submit>
    <s:submit name="submit" method="register"><label>注册</label></s:submit>
    <input name="query_s" type="button" value="查询" onclick = "login()">
</s:form>
<s:debug></s:debug>
<form action="${pageContext.request.contextPath}/login3.action">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" name="登录">

</form>

</body>

</html>
<script type="text/javascript">


    function login(){


        window.location.href =<%=path%>/register.jsp;
    }
</script>