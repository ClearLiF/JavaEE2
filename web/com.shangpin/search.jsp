<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbType2" %>
<%@ page import="model.TbType" %>
<%

    String path=request.getContextPath();
    String path2="/images/";

    ArrayList<TbType> listType1 = (ArrayList<TbType>) session.getAttribute("alltype");
    session.removeAttribute("alltype");


	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<form action="<%=path%>/manage/searchUseString.action" method="post" name="frm"  target="down_search" class="smart-green" >
<input name="search_title" size="30" type="text" placeholder="请输入关键词">
<input type="submit"  value="提交"  style=background-image:url(images/find.png)>
<a href="<%=path %>/Goodsearch" target="down_search"><img src="<%=path%>/images/find.png" height="20" width="20"  ></a>
</form>

<form action="<%=path%>/manage/searchUseByType.action" method="post" name="typefrm" id="typefrm" target="down_search" class="smart-green">
<td><select name="typeId" id="typeId" onChange="changeType()">
				<option value="" selected>请选择你要的类型</option>
        <%for(int i=0;i<listType1.size();i++) {%>
        		<option value="<%=listType1.get(i).getId()%>"><%=listType1.get(i).getTypename() %></option>
        		
       <%} %>
      </select></td><td><select name="type2Id" id="type2Id">
        <option value="">
        </option>
        
       
      </select></td>
<input type="submit"  value="提交"  style=background-image:url(../images/find.png) onclick="return check()">
</form>
</body>
</html>
<script>

    function changeType()
    {

        var type = document.getElementById('typeId');
        var privenceArr = type.options;//选择的
        var index = type.selectedIndex;//选择的序号
        var values=type[index].value;
        var type2 = document.getElementById('type2Id');




        <%for(int i=0;i<listType1.size();i++){
            int ind =listType1.get(i).getId() ;


            %>
        var ind = <%=ind%>;
        if(values==ind){

            type2.options.length=0;

            <%
            ArrayList<TbType2> tbType2s = new ArrayList<>(listType1.get(i).getTbType2sById()) ;
            for(int j=0;j<tbType2s.size();j++ ){

                String name = tbType2s.get(j).getTypename();
                int id = tbType2s.get(j).getId();
            %>





            var option = new Option("<%=name%>","<%=id%>");
            type2.options.add(option);
            <%}%>
        }
        <%}%>

        if(index==0){

            type2.options.length=0;
        }

    }

</script>