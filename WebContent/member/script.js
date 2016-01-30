/**
 * 회원 관리
 */

// <!--

var msg_id = "아이디를 입력하세요";
var msg_passwd = "비밀번호를 입력하세요";
var msg_repasswd = "비밀번호가 일치하지 않습니다";
var msg_name = "이름을 입력해 주세요";
var msg_jumin = "주민번호를 입력해주세요";
var msg_tel = "전화번호를 입력해주세요";
var msg_email = "이메일 형식에 맞지 않습니다";
var msg_confirm = "아이디 중복검사를 해주세요";

var inputerror = "회원 가입에 실패했습니다.\n잠시 후 다시 시도하세요";
var iderror = "입력하신 아이디가 없습니다.\n다시 확인하세요.";
var passwderror = "입력하신 비밀번호가 다릅니다.\n다시 확인하세요."
var deleteerror = "회원 탈퇴에 실패했습니다.\n잠시 후 다시 시도하세요.";
var modifyerror = "회원 정보 수정에 실패했습니다.\n잠시 후 다시 시도하세요.";

function erroralert(msg){
	alert(msg);
	history.back();
}


/////// 회원정보 수정 ///////
function modifyforcus(){
	modifyform.passwd.focus();
}

function modifycheck(){
	if(! modifyform.passwd.value ){
		alert( msg_passwd );
		modifyform.passwd.focus();
		return false;
	} else if( modifyform.passwd.value != modifyform.repasswd.value ){
		alert( msg_repasswd );
		modifyform.repasswd.focus();
		return false;
	} else if( ! modifyform.name.value ){
		alert( msg_name );
		modifyform.name.focus();
		return false;
	} else if( modifyform.tel1.value || modifyform.tel2.value || modifyform.tel3.value){
		if( modifyform.tel1.value.length !=3 || modifyform.tel2.value.length !=4 || modifyform.tel3.value.length !=4 ){
			alert( msg_tel );
			modifyform.tel1.focus();
			return false;
		}
	}
	if(modifyform.email1.value || modifyform.email2.value){
		if( !modifyform.email1.value || !modifyform.email2.value){
			alert( msg_email );
			modifyform.email1.focus();
			return false;
		}else if( modifyform.email1.value.indexOf("@") != -1 || modifyform.email2.value.indexOf("@") != -1){
			alert( msg_email );
			modifyform.email1.focus();
			return false;
		}else if ( modifyform.email2.value.indexOf(".") == -1){
			alert( msg_email );
			modifyform.email1.focus();
			return false;
		}
	}
}

/////// 회원탈퇴 ///////
function passwdforcus(){
	passwdform.passwd.focus();
		
}

function passwdchech(){
	if( ! passwdform.passwd.value ){
		alert( msg_passwd );
		passwdform.passwd.focus();
		return false;
	}
}


/////// 아이디 중복 확인 ///////
function confirmid(){
	if( ! inputform.id.value){
		alert( msg_id );
		inputform.id.focus();
		return;
	}
	// 창에 써있는 변수를 받아서 id정보를 넘긴다
	// 자주 사용하지는 않지만 강제로 화인을 해준다.
	var url = "confirmId.do?id="+inputform.id.value;
	open( url, "confrimWindow", 
		"menubar=no, statusbar=no, scrollbar=no, toolbar=no, width=300, height=200");
}
function fonfirmfocus(){
	confirmform.id.focus();
}
function confirmcheck(){
	if( ! confirmform.id.value ){
		alert( msg_id );
		confirmform.id.focus();
		return false;
	} 
	
}
function setid( id ){
	// jsp에서 자바 스크립트로 넘겨받는건 종종 할꺼야~
	// 기억해둬! 이거야!!
	opener.document.inputform.id.value = id;
	opener.document.inputform.confirm.value = "1";
	window.close();
	opener.document.inputform.passwd.focus();
}


/////// 회원가입 페이지 /////// 
function inputfocus(){
	inputform.id.focus();
}

function inputcheck(){
	if( ! inputform.id.value ){
		alert( msg_id );
		inputform.id.focus();
		return false;
	} else if(! inputform.passwd.value ){
		alert( msg_passwd );
		inputform.passwd.focus();
		return false;
	} else if( inputform.passwd.value != inputform.repasswd.value ){
		alert( msg_repasswd );
		inputform.repasswd.focus();
		return false;
	} else if( ! inputform.name.value ){
		alert( msg_name );
		inputform.name.focus();
		return false;
	} else if( ! inputform.jumin1.value || ! inputform.jumin2.value ){
		alert( msg_jumin );
		inputform.jumin1.focus();
		return false;
	} else if( inputform.tel1.value || inputform.tel2.value || inputform.tel3.value){
		if( inputform.tel1.value.length !=3 || inputform.tel2.value.length !=4 || inputform.tel3.value.length !=4 ){
			alert( msg_tel );
			inputform.tel1.focus();
			return false;
		}
	} 
	
	if( inputform.email1.value ){
		if( inputform.email2.value == "0"){
			if(inputform.email1.value.indexOf("@") == -1 ){
				alert( msg_email );
				inputform.email1.focus();
				return false;
			}
		}else{
			if(inputform.email1.value.indexOf("@") != -1 ){
				alert( msg_email );
				inputform.email1.focus();
				return false;
			}
		}
		// 숙제~~ //
	} else if( inputform.confirm.value == "0"){
		alert( msg_confirm );
		inputform.btuconfirmid.focus();
		return false;
	}
	
		
}

function nextjumin1(){
	if(inputform.jumin1.value.length >5 ){
		inputform.jumin2.focus();
	}
}
function nextjumin2(){
	if(inputform.jumin2.value.length >6 ){
		inputform.tel1.focus();
	}
}
function nexttel1(){
	if(inputform.tel1.value.length >2 ){
		inputform.tel2.focus();
	}
}
function nexttel2(){
	if(inputform.tel2.value.length >3 ){
		inputform.tel3.focus();
	}
}
function nexttel3(){
	if(inputform.tel3.value.length >3 ){
		inputform.email1.focus();
	}
}

/////// 메인 페이지 ///////
function mainfocus(){
	mainform.id.focus();
}

// 아이디랑 비밀번호를 확인
function maincheck(){
	if(! mainform.id.value ){
		alert( msg_id );
		mainform.id.focus();
		return false; // 자바스크립트에서는 이벤트 처리를 하지 말라는 의미
				// 메인에다가 return을 써줘야 그 리턴값(넘어가지마) 라는걸 사용한다
	} else if(! mainform.passwd.value ){
		alert( msg_passwd );
		mainform.passwd.focus();
		return false;
	}
}

// -->