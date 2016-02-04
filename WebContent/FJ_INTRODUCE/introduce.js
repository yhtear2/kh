/**
 *	제목 변경
 */
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

/**
 * 	자기소개서 추가 삭제하기
 */
// 자기소개서 추가 메소드
function add_introduce(){
    var standardLength = $('.standard').length;
    var standardDiv = $('div[id=standardID').clone();
    var subject = ['자기소개서', '성장과정', '성격', '장단점', '지원동기'];
    
    
    /*
     * 현재 div에 추가되는거 까지는 됨
     * 아이디 변화 줬음
     * 문제는 안에있는 폼들의 이름을 바꿔줘야함
     * 그래서... 위에 이름 바꾸는 메소드까지 다 바뀜
     * 천천히 고민합시다~
     * 
    if ( standardLength < 10 ) {
    	for(var i=0; i<standardLength; i++){
    		if( i == standardLength ){
    			$(standardDiv).select('sub_name_1').innerHTML = subject[i];
    			('.standard').appendTo(standardDiv);
    		}
    	}
    }else{
    	alert('작성 가능한 자소서항목은 최대 10개입니다.');
    }
   */
    
    standardDiv.attr(
    	{
    		'id' : function(index){ return standardID + index; }
    	}		
    );
	$(standardDiv).appendTo('div[id=introduces]');
    
    
    
}



$("#tooltip").tooltipsy({
    css: {
        'padding': '10px',
        'max-width': '200px',
        'color': '#303030',
        'background-color': '#ffffff',
        'border': '2px solid #4893BA',
        '-moz-box-shadow': '0 0 10px rgba(0, 0, 0, .5)',
        '-webkit-box-shadow': '0 0 10px rgba(0, 0, 0, .5)',
        'box-shadow': '0 0 10px rgba(0, 0, 0, .5)',
        'text-shadow': 'none'
    }
});












/**
 * Resume Introduce JavaScript
 * 
 * @requires prototype-1.6.1.js, scriptaculous.js, slider.js
 * @version $Id$ 
 * @copyright (c) 2008-2011 SaraminHR Co., Inc.
 *--------------------------------------------------------------------------

if (!Introduce) { 
    var Introduce = { Version: '0.9' };
    Introduce.prototype = {};
}

//트림함수 정의
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

//Resume 기본 Class
Introduce = Class.create();
Introduce.prototype = {
    initialize : function () {
        this.save_status        = '';
        this.currentPopLayer    = '';
        this.changeTemplateName = '';
        this.resIdx             = $F('res_idx');
        this.currentTemplate    = document.getElementById('current_template').value;
        this.contentsRsCount    = document.getElementById('contents_rs_count').value;
        this.writeMode          = document.getElementById('write_mode').value;
        this.editingFl          = false;
        this.completeLayerFl    = false;
        
        var tooltipOptions = {
            iframe_id : 'layer_bg_iframe',
            arrow_id : 'arrow_layer'
        };
        
        this.toolTip = new Saramin.ToolTip(695, tooltipOptions);
        
        this.variableAssignment();
    },
    
    // 변수 assign
    variableAssignment : function () {
        this.timer                = $('timer');
        this.autoSave             = $('auto_save');
        this.saveTime             = $('save_time');
        this.introTemplate        = document.getElementsByName('intro_template');
        this.currentMessageLength = document.getElementById('current_message_length');
        this.currentMessageByte   = document.getElementById('current_message_byte');
        this.jumpLevel            = $('jump_level');
        this.contentsForm         = $('contents_form');
        this.transSeqImage        = $('trans_seq_image');
        this.lastContents         = $('last_contents');
        this.lastContentsTitle    = $('last_contents_title');
    },

/**
 * row 추가
 * 
 * @param object element object {el}
 * @param string add element id {addEl}
 
addRow : function (el, addEl) {
    // 수정 완료 레이어가 열려 있으면 닫는다.
    this.hideCompleteLayer();
    
    var tmpContents    = $('template').down('#' + addEl).innerHTML;
    var contentsLength = $(el).select('.contents').length;
    
    if ( $(el) && contentsLength < 10 ) {
        new Insertion.Bottom($(el), tmpContents);
        
        this.controlAddDelButton(el, 1, '', 'none');
        
        this.calcTextLength($(el).down('.introduce-contents', contentsLength));
        $(el).down('.tmp-contents-title', contentsLength).focus();
        $(el).down('.tmp-contents-title', contentsLength).select();
    } else {
        alert('작성 가능한 자소서항목은 최대 10개입니다.');
    }
},

/**
 * row 삭제
 * 
 * @param object element object {el}
 
delRow : function (el, eventEl) {
    // 수정 완료 레이어가 열려 있으면 닫는다.
    this.hideCompleteLayer();
    
    var contentsLength = $(el).select('.contents').length;
    var contentsEl     = $(eventEl).up('.contents');
    
    if ( contentsLength > 2 ) {
        var cancelDelete = false;
        
        if ( contentsEl.down('.introduce-contents') && contentsEl.down('.introduce-contents').value != '' ) {
            if ( !confirm('항목 삭제시 해당 항목에 작성된 내용이 사라집니다. 정말로 삭제하시겠습니까?') ) {
                cancelDelete = true;
            }
        }
        
        if ( cancelDelete == true ) {
            return;
        }
        
        this.hideLayer();
        
        contentsEl.remove();
        
        if ( contentsLength == 3 ) {
            this.controlAddDelButton(el, 1, '', '');
            this.controlAddDelButton(el, 1, 1, 'none');
        }
    }
},
}
*/