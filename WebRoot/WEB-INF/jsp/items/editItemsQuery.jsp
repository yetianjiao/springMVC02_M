<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
	<form name="itemsForm"
		action="${pageContext.request.contextPath }/items/editItemsQuerySubmit.action"
		method="post">
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期<br />日期格式："yyyy-MM-dd HH:mm:ss"
				</td>
				<td>商品描述</td>
			</tr>
			<c:forEach items="${itemsList}" var="item" varStatus="status">
				<tr>
					<td><input name="itemsList[${status.index}].name" type="text"
						value="${item.name }" /></td>
					<td><input name="itemsList[${status.index}].price" type="text"
						value="${item.price }" /></td>
					<td><input name="itemsList[${status.index}].createtime"
						type="text"
						value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />" /></td>
					<td><input name="itemsList[${status.index}].detail"
						type="text" value="${item.detail}"></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="确认修改"></td>
			</tr>
		</table>
	</form>
</body>

</html>