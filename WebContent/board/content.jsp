<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="setting.jsp"%>
<link href="${project}style.css" rel="stylesheet" type="text/css">

<h2>${page_content}</h2>

<table>
	<tr>
		<th> ${str_num} </th>
		<td style="text-align: center;"> ${number} </td>
		<th> ${str_readcount} </th>
		<td style="text-align: center;"> ${dto.readcount} </td>
	</tr>
	<tr>
		<th> ${str_writer} </th>
		<td style="text-align: center;"> ${dto.writer} </td>
		<th> ${str_reg_date} </th>
		<td style="text-align: center;">	
		<fmt:formatDate value="${dto.reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
		</td>
	</tr>
	<tr>
		<th> ${str_subject}</th>
		<td colspan="3"> ${dto.subject}  </td>
	</tr>
	<tr>
		<th>${str_content}</th>
		<td colspan="3"><pre>${dto.content}</pre></td>
	</tr>
	<tr>
		<th colspan="4"> 
			<input class="inputbutton" type="button" value="${btn_modify}"
				onclick = "window.location='modifyView.do?num=${dto.num}&pageNum=${pageNum}'">
				
			<input class="inputbutton" type="button" value="${btn_delete}"
				onclick = "window.location='deletePro.do?num=${dto.num}&pageNum=${pageNum}'"> 
				
			<input class="inputbutton" type="button" value="${btn_reply}"
				onclick = "window.location='writeForm.do?num=${dto.num}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${dto.re_level}&pageNum=${pageNum}'">
			
			<input class="inputbutton" type="button" value="${btn_list}"
				onclick = "window.location='list.do?pageNum=${pageNum}'">
			
		</th>
	</tr>
</table>