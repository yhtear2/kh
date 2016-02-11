<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="setting.jsp"%>
<link href="${project}introduce.css" rel="stylesheet" type="text/css">
<script src="${project}introduce.js"></script>



<h2> 자기 소개서 </h2>

<!-- 자기소개서 입력 크기 잡아주기-->
<div id="introduce" class="introduce">
	<!-- 스타일 시스 먹이기 -->
	<div class="standard" id="standardID0">
		<!-- 폼 이름 정해주기 -->
			<!-- 처음 보여지는 디폴트 값 -->
			<div id="sub_name0"  class="subject"  style="display:block;">
				<div id="sub_name_0" class="subject" >자기소개</div>
				<div class="subject"><input type="button" value="변경" name="modify" onclick="sub_name_modify('0')"></div>
			</div>	
			<!-- 변경을 누르면 나타나는 입력 폼 -->
			<div id="sub_change0" class="subject" style="display:none;">
				<input type="text" name="sub_change_name0" autofocus="autofocus" 
						style="background: #f2f7ff; border: 2px;" >
				<input type="button" value="확인" onclick="sub_name_ok('0')">
				<input type="button" value="취소" onclick="sub_name_cancel('0')">
			</div>
		<!-- 내용 입력하는 곳 -->
		<div> <textarea name="contents0" rows="17" cols="100%"></textarea> </div>
		<div> 
			<input type="button" value="추가" onclick="add_introduce()">
			<input type="button" value="삭제" onclick="del_introduce('0')">
		</div>
	</div>
	<div id="introduces"><input type="button" value="저장" onclick="introducePro.do"></div>
</div>

