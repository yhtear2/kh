<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<%@ include file="setting.jsp"%>
<link href="${project}style.css" rel="stylesheet" type="text/css">
<script src="${project}script.js"></script>

<h2> ${page_confirm}</h2>
 
<c:if test="${result == 0}">
	<table>
		<tr>
			<td align="center">
				<span>${id}</span>${msg_id_o}
			</td>
		</tr>
		<tr>
			<th>
				${msg_id_ok}&nbsp;&nbsp;&nbsp;
				<input class="inputbutton" type="button" value="${btn_ok}" onclick="setid('${id}')">
				</th>
			</tr>
	</table>
</c:if>

<c:if test="${result != 0}">
	<body onload="fonfirmfocus()">
		<form method="post" action="confirmId.do"
			name="confirmform" onsubmit="return confirmcheck()">
			<table>
				<tr>
					<th colspan="2">
						<span>${id}</span>${msg_id_x}
					</th>
				</tr>
				<tr>
					<th> ${str_id}</th>
					<td>
						<input class="input" type="text" name="id" maxlength="20">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_ok}">
						<input class="inputbutton" type="button" value="${btn_ok_cancel}" onclick="self.close()">
					</th>
				</tr>					
			</table>
		</form>
	</body>
</c:if>
 

 
