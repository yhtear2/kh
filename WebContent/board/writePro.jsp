
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>

<h2> ${page_write} </h2>

<c:if test="${result == 0}">
	<script type="text/javascript">
		<!--
		erroralert( writeerror );
		//-->
	</script>
</c:if>

<c:if test="${result != 0}">
	<c:redirect url="list.do?pageNum=${pageNum}"/>
</c:if>