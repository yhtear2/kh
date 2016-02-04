<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<link href="${project}style.css" rel="stylesheet" type="text/css">

<h2>${page_delete}</h2>

<body onload="deleteformfouse()">
	<form method="post" action="deletePro.do" name="deleteform"
		onsubmit="return deletecheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<table>
			<tr>
				<th colspan="2"> ${msg_passwd} </th>
			</tr>
			<tr>
				<th> ${str_passwd} </th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="15">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_delete}">
					<input class="inputbutton" type="button" value="${btn_delete_cancel}"
						onclick="window.location='list.do?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form>
</body>
