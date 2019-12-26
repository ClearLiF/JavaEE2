<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbShangpin" %>
<%@ page import="model.TbType" %>
<%@ page import="model.TbType2" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path=request.getContextPath();
    TbShangpin item = (TbShangpin)session.getAttribute("Goodmore");
    String path2="/images/";

    ArrayList<TbType> listType1 = (ArrayList<TbType>) session.getAttribute("alltype");
	session.removeAttribute("alltype");
    session.removeAttribute("Goodmore");
	if(item==null){
	  item= new TbShangpin();
	}
	session.setAttribute("add", "add");
    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css2/define.css" charset=UTF-8">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<div style="text-align: center ;width: 60%">

<form action="<s:url namespace="/manage" action="addGood"/>" method="post" name="frm" class="smart-green" enctype="multipart/form-data" >
	<h1>商品
        <span>添加页面.</span>
    </h1>
    <input type="file" name="file" value="" onchange='checkFileType(this.value);'><img src="<%=path2+item.getTupian()%>" width="60" height="50" border="1"/>
	<div class="">
		<label class="">名称</label>
		<div>
			<input type="text" name="mingcheng" placeholder="请添加名称" value="">
		</div>
	</div>
	<div class="">
		<label class="">简介</label>
		<div>
			<input type="text" name="jianjie" placeholder="请添加简介" value="">
		</div>
	</div>
	
	 <div class="">
    <label class="">等级</label>
    <div class="">
      <select name="dengji" >
        <option value=""></option>
        <option value="0">差</option>
        <option value="1" selected>中</option>
        <option value="2">优</option>
       
      </select>
    </div>
  </div>
  <div class="">
		<label class="">型号</label>
		<div>
			<input type="text" name="xinghao" placeholder="添加型号" value="">
		</div>
	</div>
	<div class="">
		<label class="">品牌</label>
		<div>
			<input type="text" name="pinpai" placeholder="请添加品牌" value="">
		</div>
	</div>
	<div class="">
		<label class="">数量</label>
		<div>
			<input type="text" name="shuliang" placeholder="请添加数量" value="">
		</div>
	</div>
	<div>
	<tr><td><input type="radio" name="tuijian" value="0" checked>推荐<input type=radio name="tuijian" value="1" >不推荐</td><tr>
	<tr><td><select name="typeid" id="typeid" onChange="changeType()">
				<option value="" selected>请选择你要的类型</option>
        <%for(int i=0;i<listType1.size();i++) {%>
        		<option value="<%=listType1.get(i).getId()%>"><%=listType1.get(i).getTypename() %></option>
        		
       <%} %>
      </select></td><td><select id="type2Id" name="type2Id">
        <option value=" cs" ></option>
        
       
      </select></td></tr>
	
	
	
	
	</div>
	<div class="">
		<label class="">市场价</label>
		<div>
			<input type="text" name="shichangjia" placeholder="请写入市场价" value="">
		</div>
	</div>
	<div class="">
		<label class="">会员价</label>
		<div>
			<input type="text" name="huiyuanjia" placeholder="会员价" value="">
		</div>
	</div>
	<div class="">
		<label class="">特价</label>
		<div>
			<tr><td><input type="radio" name="tejia" value="0" checked>特价<input type=radio name="tejia" value="1" >不特价</td><tr>
		</div>
	</div>
	<tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="button"  value="取消添加" onclick="cancle()"><input type="submit"  value="提交" onclick="return check();"></td></tr>
</form>

</div>
</body>
</html>
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
<script language="javaScript">
function check(){


	if(frm.file.value===""){
		 
		alert("请选择对应的照片");
			frm.file.focus();
			return false;
		
	}
	
	if(frm.mingcheng.value===""){
		alert("名称不为空");
		frm.mingcheng.focus();
		return false;
	}
	
	if(frm.jianjie.value===""){
		alert("简介不为空");
		frm.jianjie.focus();
		return false;
	}
	if(frm.xinghao.value===""||!IsInt(frm.xinghao.value)){
		alert("型号不为空且为数值");
		frm.xinghao.focus();
		return false;
	}
	if(frm.pinpai.value===""){
		alert("品牌不为空");
		frm.pinpai.focus();
		return false;
	}
	
 
	if(frm.typeid.value===""){
		alert("请选择型号");
		frm.typeid.focus();
		return false;
	}

	if(frm.shuliang.value===""||!IsInt(frm.shuliang.value)){
		alert("数量不能为空 且为数值");
		frm.shuliang.focus();
		return false;
		}
 if(frm.shichangjia.value===""||!IsInt(frm.shichangjia.value)){
		alert("市场价不能为空 且为数值")
		frm.shichangjia.focus();
		return false;
		}
	 if(frm.huiyuanjia.value===""||!IsInt(frm.huiyuanjia.value)){
		alert("会员价不能为空 且为数值")
		frm.huiyuanjia.focus();
		return false;
		}
 if(frm.tejia.value===""||!IsInt(frm.tejia.value)){
		alert("数量不能为空 且为数值")
		frm.tejia.focus();
		return false;
		}

	return true;
}
function checkFileType(str){  
    var pos = str.lastIndexOf(".");  
    var lastname = str.substring(pos,str.length);  
    var resultName=lastname.toLowerCase();  
    if ('.png'!=resultName.toString()&&'.jpg'!=resultName.toString()){alert('只能上传png,jpg文件，您上传的文件类型为'+lastname+'，请重新上传');  
    frm.file.value="";
    
    }  
} 
function cancle(){
	
	if(confirm("确认要取消添加吗?"))
	{
	window.location.href = "<%=path%>/GoodListServlet";
	}
	
}


function changeType()
{

	var type = document.getElementById('typeid');
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