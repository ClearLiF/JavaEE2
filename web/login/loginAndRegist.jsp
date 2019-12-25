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
<s:form action="submit" namespace="/loginName" id="myform" >
    <s:textfield name="username" value="" label="用户名"></s:textfield>
    <s:password label="密码" name="password"></s:password>

    <s:submit name="登录"    ></s:submit>
    <s:submit name="注册" method="register2"></s:submit>

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

    function login2() {
        document.form.action="submit_login.action";
    }
    function register2() {
        document.form.action="submit_register.action";
    }


</script>