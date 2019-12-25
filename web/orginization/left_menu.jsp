<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%String path=request.getContextPath(); %>
<html>
<head>

<title>Insert title here</title>
</head>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path%>/Css/menu_style.css" type="text/css" charset=UTF-8">
<TITLE>menu</TITLE>
</HEAD>
<script>
	  var classCount = 3; // 菜单大类的个数
	  function Show(theId) {
	  	theTr = eval("tr_" + theId);
			//document.getElementById('tr_0');
		if (theTr.style.display == "none") {
			theTr.style.display = "block";
		}
		else {
			theTr.style.display = "none";
		}
		for (i = 0; i < classCount; i++) {
			if (i == theId)
				continue;
			theTr = eval("tr_" + i);
			theTr.style.display = "none";
		}
	  }
var menuList={
0:{1:"商品类型管理","一级商品":"<%=path%>/manage/defineTypeFirst.action"},
1:{1:"商品管理","商品信息":"<%=path%>/manage/goodIndex.action","商品添加":"<%=path%>/manage/addGoodDirect","订单管理":"<%=path%>/dingdanListServlet?type=1"},
2:{1:"用户管理","用户信息":"<%=path%>/manage/userGetAll.action"}
};
function createMenu(){	
	for( menu in menuList){
    	document.write('<TR><TD  id="td_'+menu+'"  align="center" width="90%" bgColor="#1f65c2" ><A  href="javascript:Show('+menu+')">'+menuList[menu][1]+'</A></TD></TR>');
		document.write(' <TR id=tr_'+menu+' style="DISPLAY: none;cursor:hand">');
		document.write(' 	<TD  width="100%" align="center"  bgColor="#4c84ce" height="50">');
		document.write(' 		<table align="center" border="0" width="90%">');
	    for(submenu in menuList[menu]){
            if(submenu==1){
				continue;
		    }
		    document.write('<tr><td width="150" align="center" ><A href="'+menuList[menu][submenu]+'" target="right_workspace">'+submenu+'</A> </td><tr>');
		}
		document.write(' </table> </TD> </TR>');	
	}
}
</script>
<BODY class="BODY" background="images/welcome.png">
<table class="someclass" width="100%">
<script>
createMenu();
</script>

</table>
</BODY>
</html>