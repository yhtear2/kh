<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<link href="${project}introduce.css" rel="stylesheet" type="text/css">
<script src="${project}introduce.js"></script>

<h2> 자기 소개서 </h2>

<!-- 자기소개서 입력 크기 잡아주기-->
<div class="introduce">
	<!-- 스타일 시스 먹이기 -->
	<div class="standard">
		<table border="0" cellspacing="0" width="100%">
			<tr>
				<th>
					<div>
						<div id="sub_name[]"  class="subject">성장과정</div>
						<div><input type="button" value="변경" onclick="sub_name_modify()"></div>
					</div>
				</th>
			</tr>
			<tr>
				<td>
					<textarea name="contents[]" rows="17" cols="100%"></textarea>
				</td>
		</table>
	</div>
</div>
