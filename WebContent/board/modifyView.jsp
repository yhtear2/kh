
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<link href="${project}style.css" rel="stylesheet" type="text/css">

<h2>${page_modify}</h2>

<fmt:requestEncoding value="utf-8"/>

<c:if test="${dto1.name == dto.writer}">
	<body onload="modifyviewfouce()">
		<form method="post" name="modifyform" action="modifyPro.do" 
			onsubmit="return modifyview()">
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<table>
				<tr>
					<th colspan="2"> ${msg_modify}</th>
				</tr>
				<tr>
					<th>${str_writer}</th>
					<td>${dto.writer}</td>
				</tr>
				<tr>
					<th>${str_email}</th>
					<td>
						<c:if test='${ dto.email == null || email == "" }'>
							<input class="input" name="email" maxlength="30">
						</c:if>
						<c:if test='${ dto.email != null && email != "" }'>
							<input class="input" name="email" maxlength="30" value="${dto.email}">
						</c:if>
					</td>
				</tr>
				<tr>
					<th>${str_subject}</th>
					<td>
						<input class="input" name="subject" maxlength="50" value="${dto.subject}"
							style="width:245px;">
					</td>
				</tr>
				<tr>
					<th>${str_content}</th>
					<td>
						<textarea rows="10" cols="28" name="content">${dto.content}</textarea>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_modify}">
						<input class="inputbutton" type="reset" value="${btn_cancel}">
						<input class="inputbutton" type="button" value="${btn_modify_cancel}"
							onclick="window.location='list.do?pageNum=${pageNum}'">
					</th>
				</tr>
			</table>
		</form>
	</body>
</c:if>
					
<c:if test="${dto1.name != dto.writer}">				
	<script type="text/javascript">
		<!--
		erroralert( passwderror );
		//-->
	</script>
</c:if>