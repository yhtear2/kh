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
	<!-- 폼 이름 정해주기 -->
	<form name="introduceForm">
		<table border="0" cellspacing="0" width="100%">
			<tr>
				<th>
					<div>
						<!-- 처음 보여지는 디폴트 값 -->
						<div id="sub_name"  class="subject">
							<div id="sub_name_1" class="subject">자기소개</div>
							<div class="subject"><input type="button" value="변경" onclick="sub_name_modify()"></div>
						</div>	
						<!-- 변경을 누르면 나타나는 입력 폼 -->
						<div id="sub_change" class="subject">
							<input type="text" name="sub_change_name" autofocus="autofocus" style="background: #f2f7ff; border: 1px;">
							<input type="button" value="확인" onclick="sub_name_ok()">
							<input type="button" value="취소" onclick="sub_name_cancel()">
						</div>
					</div>
				</th>
			</tr>
			<tr>
				<!-- 내용 입력하는 곳 -->
				<td>
					<textarea name="contents[]" rows="17" cols="100%"></textarea>
				</td>
		</table>
	</form>
	</div>
</div>
