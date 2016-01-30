<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<%@ include file="setting.jsp"%>
<link href="${project}style.css" rel="stylesheet" type="text/css">
<script src="${project}script.js"></script>

<h2>${page_modify}</h2>

<c:if test="${ resultCheck == 1 }"> 
		<body onload="modifyforcus()">
			<form method="post" action="member_modifyPro.do" name="modifyform" onsubmit="return modifycheck()">
				<table>
					<tr>
						<th colspan="2"> ${msg_modify} </th>
					</tr>
					<tr>
						<th> ${str_id} </th>
						<td> ${dto.id} </td>
					</tr>
					<tr>
						<th rowspan="2"> ${str_passwd}</th>
						<td>
							<input type="password" class="input" name="passwd" maxlength="20" value="${dto.passwd}">
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" class="input" name="repasswd" maxlength="20" value="${dto.passwd}">
						</td>
					</tr>
					<tr>
						<th> ${str_name} </th>
						<td>
							<input type="text" class="input" name="name" maxlength="20" value="${dto.name}">
						</td>
					</tr>
					<tr>
						<th> ${str_jumin} </th>
						<td>
						${dto.jumin1} - ${dto.jumin2}
						</td>
					</tr>
					<tr>
						<th> ${str_tel} </th>
						<td>
						<c:if test='${ dto.tel == null || dto.tel == "" }'>
								<input class="input" type="text" style="width:30px" name="tel1" maxlength="3">
								- <input class="input" type="text" style="width:30px" name="tel2" maxlength="4">
								- <input class="input" type="text" style="width:30px" name="tel3" maxlength="4">
						</c:if>
						<c:if test='${ dto.tel != null && dto.tel != "" }'>
							<c:set var="t" value='${fnc:split( dto.tel, "-" ) }' />
								<input class="input" type="text" style="width:30px" 
									name="tel1" maxlength="3" value="${t[0]}">
								- <input class="input" type="text" style="width:40px" 
									name="tel2" maxlength="4" value="${t[1]}">
								- <input class="input" type="text" style="width:40px" 
									name="tel3" maxlength="4" value="${t[2]}">
						</c:if>
						</td>
					</tr>
					<tr>
						<th> ${str_email} </th>
						<td>
						<c:if test='${ dto.email == null || dto.email == "" }'>
									<input class="input" type="text" name="email1" style="width:100px"
										maxlength="25"> 
									@
									<input class="input" type="text" name="email2" style="width:100px"
										maxlength="25"> 
									
						</c:if>
						
						<c:if test='${ dto.email != null && dto.email != "" }'>
							<c:set var="e" value='${fnc:split( dto.email, "@" ) }' />
									<input class="input" type="text" name="email1" style="width:100px"
										maxlength="25" value="${e[0]}"> 
									@
									<input class="input" type="text" name="email2" style="width:100px"
										maxlength="25" value="${e[1]}">							
							</c:if>
						</td>
					</tr>
					<tr>
						<th> ${str_date} </th>
						<td>
							<fmt:formatDate value="${dto.reg_date}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
					<tr>
						<th colspan="2">
							<input class="inputbutton" type="submit" value="${btn_modify}">
							<input class="inputbutton" type="reset" value="${btn_cancel}">
							<input class="inputbutton" type="button" value="${btn_modify_cancel}"
								onclick="window.location='main.do'">
						</th>
					</tr>
				</table>
			</form>
		</body>

</c:if>

<c:if test="${ resultCheck != 1 }">
	<script type="text/javascript">
	<!--
		erroralert(passwderror);		
	//-->
	</script>
</c:if>