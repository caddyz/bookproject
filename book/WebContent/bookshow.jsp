<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书店商场</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<style type="text/css">
	div{
		text-align: center;	
	}
	table{
		margin: 0 auto;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<div>
		<h1 style="color: red;font-size: 45px">kai的书城</h1>
		<form action="PageServlet" method="post">筛选：价格
		<input type="number" name="start" id="startPrice" style="width: 45px"/>
		-<input type="number" name="end" id="endPrice" style="width: 45px"/>
			<input type="submit" value="搜索"/>
		</form>
		<table>
			<c:forEach items="${list}" var="book">
				<tr>
					<td><a href="BookDetailedInfoServlet?name=${book.title}">${book.title}</a></td>
					<td rowspan="2">${book.price}</td>
					<td rowspan="2"><a href="#">添加到购物车</a></td>
				</tr>
				<tr>
					<td>${book.author}</td>
				</tr>
			</c:forEach>
		</table>
		<p>共${pageNum}页 当前${pageNow}页
			<c:if test="${pageNow>1}">
				<a href="FirstServlet?num=1">首页</a>
				<a href="FirstServlet?num=${pageNow-1}">上一页</a>
			</c:if>
			<c:if test="${pageNow < pageNum }">
				<a href="FirstServlet?num=${pageNow+1}">下一页</a>
				<a href="FirstServlet?num=${pageNum}">尾页</a>
			</c:if>
			跳转到<input type="number" id="skip" style="width: 45px"/>页
			<button type="button" onclick="skip()">GO</button>
		</p>
	</div>
	<script type="text/javascript">
		function search() {
			var startNum = $("#startPrice").val();
			var endNum = $("#endPrice").val();
			if(startNum>0&&endNum>=startNum){
				location.href="SearchServlet"
			}else{
				alert("输入有误，请重来！")
			}
		}
	</script>
</body>
</html>