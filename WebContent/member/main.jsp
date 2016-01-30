<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<%@ include file="setting.jsp"%>
<link href="${project}style.css" rel="stylesheet" type="text/css">
<script src="${project}script.js"></script>
<h2> ${page_main} </h2>


<c:if test="${sessionScope.memId == null }">
	<body onload ="mainfocus()">
		<form name="mainform" method="post" action="loginPro.do" 
			onsubmit="return maincheck()">
			<table>
				<tr>
					<th> ${str_id} </th>
					<td>
						<input class="input" type="text" name="id" maxlength="20"> 
					</td>
				</tr>
				<tr>
					<th> ${str_passwd}</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="20">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_login}">
						<input class="inputbutton" type="reset" value="${btn_cancel}">
						<input class="inputbutton" type="button" value="${btn_input_member}"
							onclick="window.location='inputForm.do'">
						<input class="inputbutton" type="button" value="${btn_list}"
							onclick="window.location='list.do'">
					</th>
				</tr>
			</table>
		</form>
	</body>
</c:if>		

<c:if test="${sessionScope.memId != null }">
	<table>
	  <tr>
	    <td align="center">
	    	<span>${sessionScope.memId}</span>${msg_login}
	    </td>
	  </tr>
	  <tr>
	    <th>
	    	<input class="inputbutton" type="button" value="${btn_logout}"
	    		onclick="window.location='logout.do'">
	    	<input class="inputbutton" type="button" value="${btn_modify_member}"
	    		onclick="window.location='member_modifyForm.do'">
	    	<input class="inputbutton" type="button" value="${btn_delete_member}"
	    		onclick="window.location='member_deleteForm.do'">
	    	<input class="inputbutton" type="button" value="${btn_list}"
							onclick="window.location='list.do'">
	    </th>
	  </tr>
	</table>
</c:if>		


