<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
  Created by IntelliJ IDEA.
  User: 李琪
  Date: 2019/12/26
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%
    ActionContext context = ActionContext.getContext();
    String s= (String)context.getSession().get("err");
    if(s!=null){
        out.print("<script type='text/javascript'>alert('密码或验证码错误');</script>");
    }

%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Theme Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--<button type="button" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
</button>-->

<ul class="nav nav-tabs">
    <li role="presentation" ><a href="<s:url namespace="/logins" action="manageHome"/>">Home</a></li>
    <li role="presentation" class="active"><a href="login.html">详情</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
</ul>

<div class="fors">
    <div  class="container" style="width: 300px">
        <form action="<s:url namespace="/logins" action="manageLogin"/>" method="post" name="form" >
            <div class="form-group">
                <label>Username</label>
                <label>
                    <input type="text" class="form-control" name="username" />
                </label>
            </div>
            <div class="form-group">
                <label>password</label>
                <label>
                    <input type="password" class="form-control" name="password" />
                </label>
            </div>
            <div class="form-group">
                <label>captchar</label>
                <label>
                    <input type="captchar" class="form-control" name="captchar" />
                </label>
            </div>
            <div class="form-group">
                <img style="vertical-align: middle;" id="checkimg" class="checkImg" alt="" src='<s:url namespace="/pach" action="chechcode"/>'
                     onclick="change()" title="点击更换验证码" />
                <label>点击更换验证码</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </form>

    </div > <!-- /container -->
</div>




<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="../js/jquery-3.1.1.min.js"></script>
<!--试一下这个js检验表单-->
<script src="../js/bootstrapValidator.min.js"></script>
<link href="../css/bootstrapValidator.min.css" rel="stylesheet" />
</body>

<script type="text/javascript">

    $(function () {
        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                captchar:{
                    validators: {
                        notEmpty: {
                            message: '验证码不能为空'
                        }
                    }

                }
            }
        });
    });


    function change() {
        var img1 = document.getElementById("checkimg");
        img1.src ="${pageContext.request.contextPath}/pach/chechcode?"+new Date().getTime() ;


    }
</script>

</html>