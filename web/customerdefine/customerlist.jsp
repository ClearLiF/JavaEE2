<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="java.util.*"%>
<%@ page import="model.User" %>

<%String path=request.getContextPath();

  ArrayList<User> userlist = (ArrayList<User>)session.getAttribute("users");
  session.removeAttribute("users");
  if(userlist==null){
	  userlist= new ArrayList<User>();
  }
 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css2/styles.css" charset=UTF-8">
</head>
<body>
<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
	
<tr>
<th>用户名称</th><th>用户是否冻结</th><th>用户ip</th><th>删除操作</th><th>查看留言</th><th>更改冻结</th>
</tr>
<%

for(int i=0;i<userlist.size();i++){
	User user = userlist .get(i);
	%>
<tr  style=background-color:<%=user.getDongjie()==0?"#ffff66":"#ff2001"%>  onmouseout="<%=user.getDongjie()==0?"this.style.backgroundColor='#ffff66';":"this.style.backgroundColor='#ff2001';" %>" onmouseover="this.style.backgroundColor='#d4e3e5';">
<td><%=user.getName() %></td><td><%=user.getDongjie()==0?"否":"是 "%></td><td><%=user.getIp() %></td>
<td><a href="javascript:delect(<%=user.getId()%>)">删除</a></td>
<td><a href="<%=path%>/manage/getComments.action?id=<%=user.getId()%>">查看用户的留言</a></td>
<td><a href="javascript:dong(<%=user.getId()%>,<%=user.getDongjie()==0?"1":"0" %>)"><%=user.getDongjie()==0?"冻结用户":"解封用户"%></a>
<%-- <td><a href="<%=user.getDongjie()==0?path+"/GetMessage":""%>"></a></td>" --%>
</tr>
<%} %>
<!--                 <tr> -->
<%-- 					<td colspan="40"><a href="<%=path %>/crouse/course_add.jsp">添加类型</a> --%>
<!-- 				</tr> -->
		
</table>




</body>
</html>
<script language="javaScript">
function delect(id){
	
	if(confirm("确认要删除么?"))
	{
	window.location.href = "<%=path%>/manage/deleteUser?id="+id;
	
	alert("删除成功");
	
	
	}
	
}
function dong(id,type){
	
	if(confirm("确认要执行此操作吗?"))
	{
	window.location.href = "<%=path%>/manage/dongJie?id="+id+"&type="+type;
	
	alert("冻结成功");
	
	
	}
	
}


</script>