<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书详细信息</title>
<style type="text/css">
	div{
		text-align: center;	
	}
	table{
		margin: 0 auto;
		width: 285px;border: 1px solid gray;border-collapse: collapse;
	}
	th,td{
		text-align: center;
		line-height: 55px;text-align: center;border: 1px solid gray;
	}
</style>
</head>
<body>
	<div>
		<h2>图书详细信息</h2>
		<table>
			<tr>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>出版时间</th>
				<th>销量</th>
				<th>库存</th>
				<th>备注</th>
			</tr>
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.publishingdate}</td>
				<td>${book.salesamount}</td>
				<td>${book.storenumber}</td>
				<td>${book.remark}</td>
			</tr>
		</table>
	</div>
</body>
</html>