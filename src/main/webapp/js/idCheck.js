function idCheck(id) {

	if(id == "") {

		alert('아이디를 입력하세요!!')

	}else{

		url = "IdCheck.jsp?mem_id="+id;

		window.open(url,"getid","width=350, height=150");

	}

}