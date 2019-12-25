<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbShangpin" %>
<%@ page import="model.TbPinglun" %>
<!DOCTYPE html>
<%String path=request.getContextPath();
	TbShangpin item = (TbShangpin)session.getAttribute("Goodmore");
	ArrayList<TbPinglun>  comments = (ArrayList<TbPinglun> )session.getAttribute("GoodComment");
	String path2="/images/";
	session.removeAttribute("Goodmore");
	if(item==null){
	  item= new TbShangpin();
	}else if(comments==null){
		comments=new ArrayList<TbPinglun>();
	}

%>

<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/styles.css" charset=UTF-8">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="tb_table" width="400" height="100" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td height="25" colspan="2" class="tb_shower" align="center">
					物品的详细信息
				</td>
			</tr>	
			<tr>
                 <td rowspan="5" class="tb_name" colspan="1"><div>
             <dl>
               <dt>
                <img src="<%=path2+item.getTupian()%>" width="60" height="50" border="1"/>
               </dt>
               <dd class="dd_name"><%=item.getMingcheng() %></dd> 
               <dd class="dd_city">型号:<%=item.getXinghao() %>  商场价格:￥ <%=item.getShichangjia() %></dd> 
             </dl>
          </div></td>

				<td class="tb_name">名称:<%=item.getMingcheng() %></></div>
           </tr>
          	<tr><td class="tb_name">销售数量:<%=item.getShuliang() %></td></tr>
          	<tr><td class="tb_name">:<%=item.getTuijian()==1?"不推荐":"推荐" %></td></tr>
          	<tr><td class="tb_name2">商品特价:￥<%=item.getTejia() %></td></tr>
          	<tr><td class="tb_name2">商品会员价:￥<%=item.getHuiyuanjia() %></td></tr>
          	<tr id="price" style="display:none"><td  class="tb_name" colspan="2">简介：<%=item.getJianjie() %></td></tr>
          	<tr id="price2" style="display:none"><td class="tb_name">添加时间：<%=item.getAddtime() %></td><td  class="tb_name">购买次数：<%=item.getCishu() %></td></tr>
  			<tr id="price3" style="display:none"><td  class="tb_name">品牌：<%=item.getPinpai() %></td><td  class="tb_name">文件位置：<%=item.getTupian() %></td></tr>
          	
          	<tr><td class="tb_name"><button id="morebutton" onclick="moreInfomation()">查看更多</button></td><td class="tb_name"><button id="editbutton" onclick="javascript:window.location.href='<%=path%>/manage/defineGoodRedirect?id=<%=item.getId() %>'">修改商品信息</button></td><td><button id="editbutton" onclick="delect(<%=item.getId() %>)">删除商品</button></td></tr>
          	
	</table>
	<script>
	function delect(id){
		if(confirm("确定要删除该商品？"+id)){

			window.location.href = "<%=path%>/manage/deleteGood?id="+id;
			

			}
	}
	function moreInfomation(){
		
// 		 td.setAttribute("class", "tb_name"); 
<%-- 		var textnode=document.createTextNode("添加时间:"+<%=item.getAddtime()%>);   --%>
// 		 td.appendChild(textnode);
		
		
// 		 var tds=document.createElement("td");
// 		 tds.setAttribute("class", "tb_name"); 
<%-- 		 var textnodes=document.createTextNode("购买次数:"+<%=item.getCishu()%>); --%>
// 		 tds.appendChild(textnodes);
// 		 tr.appendChild(td);
// 		 tr.appendChild(tds)
		 
// 		 document.getElementById("tb_table").appendChild(tr);
// 		 var price=document.getElementById("price");
		 
		 if(document.getElementById('morebutton').value == '收起'){
			 price.style.display = 'none';
			 price2.style.display = 'none';
			 price3.style.display = 'none';
			 document.getElementById('morebutton').value ='更多信息';
			 
		 }else{
			 price.style.display = '';
			 price2.style.display = '';
			 price3.style.display = '';
			 document.getElementById('morebutton').value = '收起';
		 }
		 
		 
	
		
	}
	
	
	
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
	<table class="hovertable" align="center" width="400" height="100" border="0" cellpadding="0"
			cellspacing="0" >
	
<tr>
<th>标题</th><th>评论内容</th><th>评论时间</th>
</tr>
<% 
for(int i=0;i<comments.size();i++){
	TbPinglun good = comments.get(i);
	%>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
<td><%=good.getTitle() %></td><td><%=good.getContent() %></td><td><%=good.getTime() %></td>
</tr>
<%} %>
<!-- <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';"> -->
<!-- <td>Item 2A</td><td>Item 2B</td><td>Item 2C</td> -->
<!-- </tr> -->
<!-- <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';"> -->
<!-- <td>Item 3A</td><td>Item 3B</td><td>Item 3C</td> -->
<!-- </tr> -->
<!-- <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';"> -->
<!-- <td>Item 4A</td><td>Item 4B</td><td>Item 4C</td> -->
<!-- </tr> -->
<!-- <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';"> -->
<!-- <td>Item 5A</td><td>Item 5B</td><td>Item 5C</td> -->
<!-- </tr> -->
</table>
</body>
</html>