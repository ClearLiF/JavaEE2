<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="java.util.*"%>
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
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/typestyle.css" charset=UTF-8">
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>

<table class="hovertable" align="center" width="600" height="100" border="0" cellpadding="0"
			cellspacing="0" >
<tr>����idΪ<%=id %></tr>

<tr>
<th>����ID</th><th>��������</th><th>ɾ������</th>
</tr>
<%
	for (TbType2 type : typelist) {
%>
	<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td><%=type.getId() %>
		</td>
		<td><%=type.getTypename() %>
		</td>
		<td><a href="<%=path%>/manage/deleteType2.action?id=<%=type.getId()%>&type1="<%=id%>>ɾ��</a></td>


	</tr>
	<%} %>
                 
                 <tr id="price" style="<%=typelist.size()!=0?"display:none":"" %>"><td  class="tb_name" colspan="2">�������Ӷ�����Ʒ��Ϣ</td></tr>
                 
                 <tr>
					<td colspan="40"><a href="<%=path %>/manage/defineTypeFirst.action">����</a>
			    </tr> 
		
</table>
<div style="width:600;text-align:center ;background-color:#c3dde0">	
<form action="<%=path%>/manage/addType2.action" method="post" >
<h1>
        ����µ�����.
</h1>
<div class="tableclass">
		<label class="tableclass">��������</label>
		<div>
		 <input type="hidden" name="upjsp" value="2">
		  <input type="hidden" name="typeid" value=<%=id%>>
			<input type="text" name="typename" placeholder="����д��������" value="">
		</div>
	</div>
<tr><td colspan="2" align="center"><input type="reset"  value="����" ><input type="submit"  value="�ύ" ></td></tr>

</form>
</div>	

</body>
</html>
