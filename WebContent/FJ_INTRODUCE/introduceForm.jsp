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
	<form name="introduceForm" id="introduceFormID">
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
							<input type="text" id="change_name"  name="sub_change_name" autofocus="autofocus" 
									style="background: #f2f7ff; border: 1px;"
									title="Must be at least 8 characters.">
							<input type="button" value="확인" onclick="sub_name_ok()">
							<input type="button" value="취소" onclick="sub_name_cancel()">
							<input type="text" id="tooltip" title="이렇게 사용하면 됩니다" />
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

http://jquerytools.github.io/demos/tooltip/form.html

http://annotations.tistory.com/66

번호를 매겨서
1번이면 자기소개서
2번이면 성장과정
3번이면 등등등....
이렇게 기본적으로 써지게 하자
