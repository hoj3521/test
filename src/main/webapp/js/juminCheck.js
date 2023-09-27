/**
 *  입력받은 주민번호가 정상인지 체크하는 함수 
 */

 function juminCheck(jumin1,jumin2){
	 let juminNum = jumin1 + jumin2;
	 
	 let jumin_pattern = new RegExp('^[0-9]{6}[0-9]{6}');
	 
	 if(!jumin_pattern.test(juminNum)){  /*test의 반환타입은 불린 */
		 	window.alert('주민번호가 정규표현식 패턴에 적합하지 않습니다!!')/*window 가장 최상위 객체 생략가능*/
	 }else{			//일치하는 경우
		 alert('주민번호가 정규표현식 패턴에 적합합니다!!')
		 
		 let sum = 0;
		 let temp = 0;
		 let result = 0;
		 let weight = new Array(2,3,4,5,6,7,8,9,2,3,4,5); // 가중치 값 설정
		 
		 //주민번호 체크 공식 적용
		 for(i=0; i<12; i++){
			 	sum = sum + (juminNum.charAt(i)) * weight[i];
		 }
		 
		 temp = 11-(sum%11)
		 result = temp%10;
		 if(result != juminNum.charAt(12)){
			 alert('주민번호가 정확하지 않습니다. 다시 확인하세요!!')
		 }else{
			 alert('주민번호가 정상입니다!!')
		 }
	 }  
	 	
	 
 }