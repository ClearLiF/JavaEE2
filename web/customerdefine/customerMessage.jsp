<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="java.util.*"%>
<%@ page import="model.TbPinglun" %>
<%
    String path = request.getContextPath();
    ArrayList<TbPinglun> comments =(ArrayList<TbPinglun>)session.getAttribute("comments")  ;
    session.removeAttribute("comments");
    if(comments==null){
  	  comments= new ArrayList<TbPinglun>();
    }
    
    
    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css2/styles.css" charset=UTF-8">
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>

<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
	
<tr>
<th>���۱���</th><th>��������</th><th>����ʱ��</th><th>�����û�����</th>
</tr>
<tr id="price" style="<%=comments.size()!=0?"display:none":"" %>"><td  class="tb_name" colspan="2">���û���û���κ�����</td></tr>

<% 
for(int i=0;i<comments.size();i++){
	TbPinglun comment= comments.get(i);
	%>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
<td><%=comment.getTitle() %></td><td><%=comment.getContent() %></td><td><%=comment.getTime() %></td>

<td><a href="javascript:dong(<%=comment.getUser().getId() %>)">�����û�</a></td>

</tr>
<%} %>
<!--                 <tr> -->
<%-- 					<td colspan="40"><a href="<%=path %>/crouse/course_add.jsp">�������</a> --%>
<!-- 				</tr> -->
		
</table>




</body>
</html>
<script language="javaScript">
function dong(id){
	
	if(confirm("ȷ��Ҫ������û���?"))
	{
	window.location.href = "<%=path%>/manage/dongJie?id="+id+"&type=1";
	
	alert("����ɹ�");
	
	
	}
	
}


</script>