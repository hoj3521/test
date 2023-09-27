/**
 * 이메일 데이터 입력 시 => 자동 완성 기능 구현 
 * 도메인을 사용자가 선택하면 text 객체 박스에 
 * 자동으로 들어가게 하는 함수
 */
function change_email(){
	let email_add = document.getElementById("email_add");
	let email_sel = document.getElementById("email_sel");
	
	let idx = email_sel.options.selectedIndex;
	let val = email_sel.options[idx].value;
	
	email_add.value = val;
	
}