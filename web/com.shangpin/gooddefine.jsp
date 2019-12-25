<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="model.TbShangpin" %>
<%@ page import="model.TbType" %>
<%@ page import="model.TbType2" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%
    String path=request.getContextPath();

	ActionContext context = ActionContext.getContext();
    TbShangpin item = (TbShangpin )context.getSession().get("Goodmore");
	ArrayList<TbType> listType1 = (ArrayList<TbType>)context.getSession().get("alltype") ;
	session.removeAttribute("alltype");
	session.removeAttribute("Goodmore");
	if(item==null){
		item= new TbShangpin();
	}
    String path2="/images/";

    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/define.css" charset=UTF-8">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<center>

<form action="<%=path%>/manage/defineGood.action" method="post" name="frm" class="smart-green" enctype="multipart/form-data" >
	<h1>商品
        <span>修改页面.</span>
    </h1>
    <input type="file" name="file" value="" onchange='checkFileType(this.value);' ><img src="<%=path2+item.getTupian()%>" width="60" height="50" border="1"/>
	<%=item.getTupian()%>
	<input type="hidden" name="tupian" value="<%=item.getTupian()%>" >
	<div class="">
		<label class="">名称</label>
		<div>
			<input type="text" name="mingcheng" placeholder="请修改名称" value=<%=item.getMingcheng() %>>
		</div>
	</div>
	<div class="">
		<label class="">简介</label>
		<div>
			<input type="text" name="jianjie" placeholder="请修改简介" value=<%=item.getJianjie() %>>
		</div>
	</div>
	
	 <div class="">
    <label class="">等级</label>
    <div class="">
      <select name="dengji" >
        <option value=""></option>
        <option value="0"  <%=item.getDengji().equals(new String("0"))?"selected":""%>>差</option>
        <option value="1" <%=item.getDengji().equals(new String("1"))?"selected":""%>>中</option>
        <option value="2" <%=item.getDengji().equals(new String("2"))?"selected":""%>>优</option>
       
      </select>
    </div>
  </div>
  <div class="">
		<label class="">型号</label>
		<div>
			<input type="text" name="xinghao" placeholder="请修改型号" value=<%=item.getXinghao() %>>
		</div>
	</div>
	<div class="">
		<label class="">品牌</label>
		<div>
			<input type="text" name="pinpai" placeholder="请修改品牌" value=<%=item.getPinpai() %>>
		</div>
	</div>
	<div class="">
		<label class="">数量</label>
		<div>
			<input type="text" name="shuliang" placeholder="请修改名称" value=<%=item.getShuliang() %>>
		</div>
	</div>
	<div>
	<tr><td><input type="radio" name="tuijian" value="0" <%=item.getTuijian()==0?"checked":"" %>>推荐<input type=radio name="tuijian" value="1" <%=item.getTuijian()==1?"checked":"" %>>不推荐</td><tr>
		<tr><td><select name="typeid" id="typeid" onChange="changeType()">
			<option value="" selected>请选择你要的类型</option>
			<%for(int i=0;i<listType1.size();i++) {%>
			<option value="<%=listType1.get(i).getId()%>"><%=listType1.get(i).getTypename() %></option>

			<%} %>
		</select></td><td><select id="type2Id" name="type2Id">
			<option value=" cs" ></option>


		</select></td></tr>

	
	
	<input type="hidden" name="id" value=<%=item.getId() %> >
	
	</div>
	<div class="">
		<label class="">市场价</label>
		<div>
			<input type="text" name="shichangjia" placeholder="请修改市场价" value=<%=item.getShichangjia() %>>
		</div>
	</div>
	<div class="">
		<label class="">会员价</label>
		<div>
			<input type="text" name="huiyuanjia" placeholder="请修改会员价" value=<%=item.getHuiyuanjia() %>>
		</div>
	</div>
	<div class="">
		<label class="">特价</label>
		<div>
			
			<tr><td><input type="radio" name="tejia" value="0" <%=item.getTejia()==0?"checked":"" %>>特价<input type=radio name="tejia" value="1" <%=item.getTejia()==1?"checked":"" %>>不特价</td><tr>
		</div>
	</div>
	<tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交" onclick="return check();"></td></tr>
</form>
</center>
</body>
</html>
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
<script language="javaScript">
function check(){

	
	
	if(frm.name.value==""){
		alert("名称不为空");
		frm.name.focus();
		return false;
	}
	
	if(frm.jianjie.value==""){
		alert("简介不为空");
		frm.jianjie.focus();
		return false;
	}
	if(frm.xinghao.value==""||!IsInt(frm.xinghao.value)){
		alert("型号不为空且为数值");
		frm.xinghao.focus();
		return false;
	}
	if(frm.pinpai.value==""){
		alert("品牌不为空");
		frm.pinpai.focus();
		return false;
	}
	
 
	

	else if(frm.shuliang.value==""||!IsInt(frm.shuliang.value)){
		alert("数量不能为空 且为数值")
		frm.shuliang.focus();
		return false;
		}
	else if(frm.shichangjia.value==""||!IsInt(frm.shichangjia.value)){
		alert("市场价不能为空 且为数值")
		frm.shichangjia.focus();
		return false;
		}
	else if(frm.huiyuanjia.value==""||!IsInt(frm.huiyuanjia.value)){
		alert("会员价不能为空 且为数值")
		frm.huiyuanjia.focus();
		return false;
		}
	else if(frm.tejia.value==""||!IsInt(frm.tejia.value)){
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
	
	if(confirm("确认要取消修改吗?"))
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