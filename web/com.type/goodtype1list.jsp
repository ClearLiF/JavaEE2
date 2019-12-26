<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbType" %>
<%@ page import="java.util.ArrayList" %>
<% String path;
    	path = request.getContextPath();
    	ArrayList<TbType> typelist = (ArrayList<TbType>)session.getAttribute("alltype");

    	session.removeAttribute("exception");
    	session.removeAttribute("type");
    	  if(typelist==null){
    		  typelist= new ArrayList<TbType>();
    	  }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>类型页面</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css2/typestyle.css" charset=UTF-8">
<body>
<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
	
<tr>
<th>类型ID</th><th>类型名称</th><th>删除操作</th><th>修改操作</th>
</tr>
<% 
for(int i=0;i<typelist.size();i++){
	TbType type = typelist.get(i);
	%>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
<td><%=type.getId() %></td><td><%=type.getTypename() %></td>
<td><a href="javascript:delect(<%=type.getId()%>)">删除</a></td>
<td><a href="<%=path%>/manage/defineTypeSecond.action?id=<%=type.getId()%>">修改</a></td>

</tr>
<%} %>
<!--                 <tr> -->
<%-- 					<td colspan="40"><a href="<%=path %>/crouse/course_add.jsp">添加类型</a> --%>
<!-- 				</tr> -->
		
</table>
<div style="width:100%;text-align:center ;background-color:#c3dde0">	
<form action="<%=path%>/manage/addType1.action" method="post" name="frm">
<h1>
        添加新的类型.
</h1>
<div class="tableclass">
		<label class="tableclass">类型名称</label>
		<div>
			 <input type="hidden" name="upjsp" value="1">
			<input type="text" name="typename" placeholder="请填写名称名称" value="">
		</div>
	</div>
<tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交" onclick="return check()"></td></tr>

</form>


</div>	

</body>
</html>
<script language="javaScript">
function delect( id){
	
	if(confirm("确认要删除么?"))
	{
	window.location.href = "<%=path%>/manage/deleteType1.action?id="+id;
	
	alert("删除成功");
	
	
	}
	
}
function check(){


	if(frm.typename.value===""){

		alert("请填写相应内容");
		frm.typename.focus();
		return false;

	}else {
		return true;
	}

}


</script>