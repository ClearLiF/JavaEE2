<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="model.TbShangpin" %>
<!DOCTYPE html>
<%String path=request.getContextPath();
String path2="/images/";
  ArrayList<TbShangpin> goodslist = (ArrayList<TbShangpin>)session.getAttribute("GoodList");
  session.removeAttribute("GoodList");
  if(goodslist==null){
	  goodslist= new ArrayList<TbShangpin>();
  }
 

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/styles.css" charset=UTF-8">
</head>
<body>
<h1  style="font-size:15px">商品详情</h1>
<hr>
    <center>
    <div  style="height: 400px;overflow-x:scroll;">
      <table style="height: 600px;margin-top: 20px;" width="900px" height="400" cellpadding="0" cellspacing="0" border="0">
      <tr><td class="tb_shower" height="50">商品显示</td></tr>
     
      <tr><td height="150" >
      

           <% 
              
              
	               for(int i=0;i<goodslist.size();i++)
	               {
	                  TbShangpin item = goodslist.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="javascript:doPost('<%=path%>/manage/getGoodMore', {'id':'<%=item.getId()%>'})"><img src="<%=path2+item.getTupian()%>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=item.getMingcheng() %></dd> 
               <dd class="dd_city">型号:<%=item.getXinghao() %>  价格:￥ <%=item.getShichangjia() %></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              
          %>


      </td></tr>
     
      </table>
      
      
      </div>
      </center>
      <script>
        function doPost(to, p) {  // to:提交动作（action）,p:参数
        	var myForm = document.createElement("form");     
        	myForm.method = "post";
        	myForm.action = to; 
		for (var i in p){    
                	var myInput = document.createElement("input");     
                	myInput.setAttribute("name", i);  // 为input对象设置name
                	myInput.setAttribute("value", p[i]);  // 为input对象设置value
                	myForm.appendChild(myInput);
                }   
                document.body.appendChild(myForm);   
                myForm.submit(); 
                document.body.removeChild(myForm);  // 提交后移除创建的form
        }
    </script>


	
</body>
</html>