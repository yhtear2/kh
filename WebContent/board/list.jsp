<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="setting.jsp"%>
<link href="${project}style.css" rel="stylesheet" type="text/css">

<h2>${page_list} ( ${str_count} : ${count} )</h2>

<table>
	<tr>
		<td style="text-align: right;" colspan="6">
			<c:if test="${sessionScope.memId == null }">
				<a href="main.do?pageNum=${pageNum}">로그인&nbsp;&nbsp;&nbsp;</a>
			</c:if>
			<c:if test="${sessionScope.memId != null }">
				<a href="logout.do?pageNum=${pageNum}">로그아웃&nbsp;&nbsp;&nbsp;</a>
			</c:if>
			<a href="writeForm.do?pageNum=${pageNum}">${str_write}</a> &nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<th style="width: 6%"> ${str_num} </th>
		<th style="width: 40%"> ${str_subject} </th>
		<th style="width: 10%"> ${str_writer} </th>
		<th style="width: 18%"> ${str_reg_date} </th>
		<th style="width: 6%"> ${str_readcount} </th>
		<th style="width: 15%"> ${str_ip} </th>
	</tr>
	
	<c:if test="${count == 0}">
		<tr>
			<td style="text-align: center;" colspan="6">
				${msg_list_x}
			</td>
		</tr>
	</c:if>
	
	<c:if test="${count != 0}">
		<c:forEach var="dto" items="${list}">
			<tr>
				<td style="text-align: center;"> 
					${number}
					<c:set var="number" value="${number -1}"/>
				</td>
				<td> 
				
					<c:set var="wid" value="${ (dto.re_level - 1) * 10}"/>
					<c:if test="${dto.re_level > 1}">
						<img src="${project}images/level.gif" border="0" width="${wid}" height="15">
					</c:if>
					
					<c:if test="${dto.re_level > 0}">
						<img src="${project}images/re.gif" border="0" width="20" height="15">
					</c:if>
					
					<a href="content.do?num=${dto.num}&pageNum=${pageNum}&number=${number+1}">
						${dto.subject}
					</a> 
					<c:if test="${dto.readcount >= 20}">
						<img src="${project}images/hot.gif" border="0" width="20" height="15">
					</c:if>
					
				</td>
				<td style="text-align: center;"> ${dto.writer} </td>
				<td style="text-align: center;"> 
					<fmt:formatDate value="${dto.reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
				<td style="text-align: center;"> ${dto.readcount} </td>
				<td style="text-align: center;"> ${dto.ip} </td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<br>
<center>
	<c:if test="${count > 0}"> 
		<c:if test="${startPage > pageBlock}">
			<a href="list.do?pageNum=1">[◀◀]</a>
			<a href="list.do?pageNum=${startPage-pageBlock}">[◀]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${ i == currentPage }">
				<b>[${i}]</b>
			</c:if>
			<c:if test="${ i != currentPage }">
				<a href="list.do?pageNum=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${ endPage < pageCount }">
			<a href="list.do?pageNum=${startPage+pageBlock}">[▶]</a>
			<a href="list.do?pageNum=${pageCount}">[▶▶]</a>
		</c:if>
		
	</c:if>
</center>
