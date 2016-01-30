<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<link href="${project}style.css" rel="stylesheet" type="text/css">

<h2>${page_modify}</h2>

<body onload="modifyformfouce()">
	<form method="post" action="modifyView.do" name="passwdform"
		onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<table>
			<tr>
				<th colspan="2"> ${msg_passwd} </th>
			</tr>
			<tr>
				<th> ${str_passwd} </th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="12">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_modify}">
					<input class="inputbutton" type="button" value="${btn_modify_cancel}"
						onclick="window.location='list.do?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form> 
</body>