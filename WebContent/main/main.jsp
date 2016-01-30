<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.min.css">
<link href="/ProjectEx/main/defult.css" rel="stylesheet" type="text/css">

<div class="full_size">
	<div class="main_menu">
		<div class="main_logo"><img src="/ProjectEx/main/images/logo.png"></div>
		<div class="main_sign">
			<div class="main_login" onclick="window.location='main.do'">Login</div>
			<div class="main_singup">SingUp</div>
		</div>
		<div class="main_submanu"
			onmouseover="this.style.background='A8D8F0'"
			onmouseout="this.style.background='4878A8'">MyPage</div>
		<div class="main_submanu"
			onmouseover="this.style.background='A8D8F0'"
			onmouseout="this.style.background='4878A8'"
			onclick="window.location='list.do'">게시판</div>
		<div class="main_submanu"
			onmouseover="this.style.background='A8D8F0'"
			onmouseout="this.style.background='4878A8'">채용공고</div>
		<div class="main_submanu"
			onmouseover="this.style.background='A8D8F0'"
			onmouseout="this.style.background='4878A8'">QA</div>
		<div style="width: 150px; height: 280px;"> </div>
		<div class="main_submanu"
			onmouseover="this.style.background='A8D8F0'"
			onmouseout="this.style.background='4878A8'"><i class="fa fa-github"></i>Git</div>
	</div>
	<div class="main_page">
		<div>
			<jsp:include page='${page}.jsp'/>
		</div>
		<div style="font-size: small; margin-top: 50px;">Copyright © 1998-2016 KH Information Educational Institute All Right Reserved</div>
	</div>
	
</div>