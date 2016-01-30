<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<link href="${project}style.css" rel="stylesheet" type="text/css">


<h2>${page_write}</h2>

<c:if test="${sessionScope.memId == null }">
	"로그인이 필요 합니다"
	<script type="text/javascript">
		erroralert( loginerror )
	</script>
	

</c:if>

<c:if test="${sessionScope.memId != null }">	
<body onload="wirtefocus()">
	<form method="post" action="writePro.do"
		name="writeform" onsubmit="return writecheck()">
		
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		
		<table>
			<tr>
				<th colspan="2" style="text-align: right">
					<a href="list.do"> ${str_list} </a> &nbsp;&nbsp;&nbsp;
				</th>
			</tr>
			<tr>
				<th> ${str_writer} </th>
				<td>
					${dto.name}
				</td>
			</tr>
			<tr>
				<th> ${str_email} </th>
				<td>
					${dto.email}
				</td>
			</tr>
			<tr>
				<th> ${str_subject} </th>
				<td>
					<input class="input" name="subject" type="text" maxlength="50"
						style="width:100%;">
				</td>
			</tr> 
			<tr>
				<th> ${str_content} </th>
				<td>
					<textarea name="content" rows="10" cols="37"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_write}">
					<input class="inputbutton" type="reset" value="${btn_cancel}">
					<input class="inputbutton" type="button" value="${btn_list}"
						onclick="window.location='list.do?pageNum=${pageNum}'">
				</th> 
			</tr>
		</table>
	</form>
</body>
</c:if>