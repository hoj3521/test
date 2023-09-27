/**
 * 회원가입 시 비밀번호와 비밀번호확인 값이 같은지 확인하는 함수 
 */
function pwdCheck(){
	if(document.getElementById('pwd1').value != ''&&  /*비밀번호값이 들어가 있다라는 뜻 */
	   document.getElementById('pwd2').value != ''){   /*비밀번호값이 들어가 있다라는 뜻*/
	     
		   if(document.getElementById('pwd1').value == document.getElementById('pwd2').value){
			   document.getElementById('same').innerHTML='입력하신 비밀번호와 일치합니다.'
			   document.getElementById('same').style.color='blue';
		   }else{
			    document.getElementById('same').innerHTML='입력하신 비밀번호와 다릅니다.';
			   document.getElementById('same').style.color='red';
		   }
	   }
}