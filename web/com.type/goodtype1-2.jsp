<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbType2" %>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
ArrayList<TbType2> typelist = (ArrayList<TbType2>)session.getAttribute("type");
int id = (int)session.getAttribute("typeid");
session.removeAttribute("type");
 if(typelist==null){
	  typelist= new ArrayList<TbType2>();
 }

%>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css2/typestyle.css" charset=UTF-8">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
<tr>父类id为<%=id %></tr>

<tr>
<th>类型ID</th><th>类型名称</th><th>删除操作</th>
</tr>
<%
	for (TbType2 type : typelist) {
%>
	<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td><%=type.getId() %>
		</td>
		<td><%=type.getTypename() %>
		</td>
		<td><a href="<%=path%>/manage/deleteType2.action?id=<%=type.getId()%>&type1=<%=id%>">删除</a></td>


	</tr>
	<%} %>
                 
                 <tr id="price" style="<%=typelist.size()!=0?"display:none":"" %>"><td  class="tb_name" colspan="2">请务必添加二类商品信息</td></tr>
                 
                 <tr>
					<td colspan="40"><a href="<%=path %>/manage/defineTypeFirst.action">返回</a>
			    </tr> 
		
</table>
<div style="width:600;text-align:center ;background-color:#c3dde0">	
<form action="<%=path%>/manage/addType2.action" method="post" name="frm">
<h1>
        添加新的类型.
</h1>
<div class="tableclass">
		<label class="tableclass">类型名称</label>
		<div>
		 <input type="hidden" name="upjsp" value="2">
		  <input type="hidden" name="typeid" value=<%=id%>>
			<input type="text" name="typename" placeholder="请填写名称名称" value="">
		</div>
	</div>
<tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交" onclick="return check()" ></td></tr>

</form>
</div>	

</body>
</html>
<script>


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
