<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbDingdan" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>

<%String path=request.getContextPath();

    ActionContext context = ActionContext.getContext();
  ArrayList<TbDingdan> objects = (ArrayList<TbDingdan>)context.getSession().get("dingdan");
  if(objects==null){
	  objects= new ArrayList<TbDingdan>();
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/styles.css" charset=UTF-8">
</head>
<body>
<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
	
<tr>
<th>订单号</th><th>订单是否已付款</th><th>收货地址</th><th>订单金额</th><th>收货时间</th><th>删除订单</th><th>发货</th>
</tr>
<% 
for(int i=0;i<objects.size();i++){
    TbDingdan object = objects.get(i);
	%>
<tr  style=background-color:<%=object.getZt().equals(new String("买家已付款"))?"#ffff66":"#00B81C"%>  onmouseout="<%=object.getZt().equals(new String("买家已付款"))?"this.style.backgroundColor='#ffff66';":"this.style.backgroundColor='#00B81C';" %>" onmouseover="this.style.backgroundColor='#d4e3e5';">
<td><%=object.getDingdanhao() %></td><td><%=object.getZt()%></td><td><%=object.getDizhi() %></td>
<td><%=object.getTotal() %>￥</td><td><%=object.getShsj() %></td><td><a href="javascript:delect(<%=object.getId() %>)">删除</a></td>
<td><a href="javascript:send(<%=object.getId() %>,<%=object.getZt().equals(new String("买家已付款"))?"0":"1"%>)">发货</a></td>

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
	window.location.href = "<%=path%>/dingdanDelectServlet?id="+id;
	
	alert("删除成功");
	
	
	}
	
}
function send(id,type){
	
	if(confirm("确认要执行此操作吗?"))
	{
		if(type==0){
			window.location.href = "<%=path%>/manage/sendDingDan?id="+id;
			
			alert("发货成功");
		}else{
			
			alert("已发货");
		}
		
		
	
	
	}
	
}


</script>