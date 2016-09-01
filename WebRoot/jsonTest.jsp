<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jason交互测试</title>
<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
function requestJson(){
	
	$.ajax({
		type:'post',//请求方式post
		url:'${pageContext.request.contextPath }/requestJson.action',
		contentType:'application/json;charset=utf-8',
		//注意，此处数据格式是json串,json:{键值对}
		data:'{"name":"mobile","price":999}',
		//执行完成以后返回一个结果
		success:function(data){//返回结果：
			alert(data);}
	});
	
}
function responseJson(){
	$.ajax({
		type:'post',//请求方式post
		url:'${pageContext.request.contextPath }/responseJson.action',
		//此处不需要指定ContentType，因为默认就是key/value类型
		data:'name=手机&&price=999',
		//执行完成以后返回一个结果
		success:function(data){//返回结果：
			alert(data);}
	});
}
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求js，返回js"/>
<br/>
<input type="button" onclick="responseJson()" value="请求js，返回js"/>
</body>
</html>