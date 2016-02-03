/**
 * 
 */

//******* 제목과 관련된 메소드 ****** //
// 제목 변경 버트는 누르면 실행되는 메소드
function sub_name_modify(){
	// id가 sub_name 이라는 div 사라지게함 
	$("div[id=sub_name]").css("display", "none");
	// id가 sub_change 이라는 div 나타나게 함
	$("div[id=sub_change]").css("display", "block");
	// sub_name_1 div에있는 텍스트 값 인풋폼에 등록
	introduceForm.sub_change_name.value = $("div[id=sub_name_1]").text();
}
// 확인 버튼을 누르면 실행되는 메소드
function sub_name_ok(){
	// div를 받아옴
	var sub_name = document.getElementById("sub_name_1");
	// innerHTML을 이용해 인풋폼에 있는 내용으로 변경
	sub_name.innerHTML = $("input[name=sub_change_name").val();
	// 인풋폼 초기화
	introduceForm.sub_change_name.value = "";
	// 위에설명 참고
	$("div[id=sub_name]").css("display", "block");
	$("div[id=sub_change]").css("display", "none");
}	
// 취소 버튼을 누르면 실행되는 메소드
function sub_name_cancel(){
	//위에 설명 참고
	$("div[id=sub_name]").css("display", "block");
	$("div[id=sub_change]").css("display", "none");
}
//******				******//


