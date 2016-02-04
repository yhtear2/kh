<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.min.css">
<link href="/SpringEx/main/defult.css" rel="stylesheet" type="text/css">

<div class="full_size">
	<div class="main_menu">
		<div class="main_logo"><img src="/SpringEx/main/images/logo.png"></div>
		<div class="main_sign">
			<div class="main_login" onclick="window.location='main.do'">Login</div>
			<div class="main_singup">SingUp</div>
		</div>
		<div class="main_submanu">MyPage</div>
		<div class="main_submanu">게시판</div>
		<div class="main_submanu">채용공고</div>
		<div class="main_submanu">QA</div>
		<!-- 2016/02/02 추가 - 송윤호 -->
		<div class="main_submanu" onclick="window.location='compInputCheck.do'">기업정보 입력</div>
		<div style="width: 150px; height: 280px;"> </div>
		<div class="main_submanu"><i class="fa fa-github"></i>Git</div>
	</div>
	<div class="main_page">
		<div>
			<jsp:include page='${page}.jsp'/>
		</div>
		<div style="font-size: small; margin-top: 50px;">Copyright © 1998-2016 KH Information Educational Institute All Right Reserved</div>
	</div>
	
</div>