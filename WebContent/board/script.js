/**
 * 게시판
 */


var msg_writer = "작성자를 입력하세요";
var msg_subject = "제목을 입력하세요";
var msg_content = "내용을 입력하세요";
var msg_passwd = "비밀번호를 입력하세요";

var writeerror = "글쓰기에 실패했습니다.\n잠시 후 다시 시도하세요";
var passwderror = "입력하신 비밀번호가 다릅니다.\n다시 확인하세요";
var updateerror = "글 수정에 실패했습니다.\n잠시 후 다시 시도하세요"	;
var deleteerror = "글 삭제에 실패했습니다.\n잠시 후 다시 시도하세요"	;
var replyerror = "답글이 있는 글은  삭제가 불가능합니다";
var loginerror = "로그인이 필요 합니다";

// 에러 경고창
function erroralert( msg ){
	alert(msg);
	history.back();
}

//-- 글쓰기 --//
function wirtefocus(){
	writeform.subject.focus();
}

// 글쓸때 널을 방지하는 거
function writecheck(){
	if ( ! writeform.subject.value ){
		alert( msg_subject );
		writeform.subject.focus();
		return false;
	} else if( ! writeform.content.value ){
		alert( msg_content );
		writeform.content.focus();
		return false;
	} else if( ! writeform.passwd.value ){
		alert( msg_passwd );
		writeform.passwd.focus();
		return false;
	}
} 

//-- 글 수정 --//
function modifyformfouce(){
	passwdform.passwd.focus();
}
// 비밀번호 체크
function passwdcheck(){
	if( ! passwdform.passwd.value ){
		alert( msg_passwd );
		passwdform.passwd.focus();
		return false;
	}
}

// 수정 내용에 포커스
function modifyviewfouce(){
	modifyform.subject.focus();
}

// 수정 내용 미입력 체크
function modifyview(){
	if( ! modifyform.subject.value ){
		alert( msg_subject );
		modifyform.subject.focus();
		return false;
	}else if ( ! modifyform.content.value ){
		alert( msg_content );
		modifyform.content.focus();
		return false;
	}else if( ! modifyform.passwd.value ){
		alert( msg_passwd );
		modifyform.passwd.focus();
		return false;
	}
}

//-- 글 삭제 --//
function deleteformfouse(){
	deleteform.passwd.focus();
}

function deletecheck(){
	if( ! deleteform.passwd.value ){
		alert( msg_passwd );
		deleteform.passwd.focus();
		return false;
	}
}