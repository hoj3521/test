<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 추가 회원가입 폼에서 넘오는 한글 데이터 깨지지 않게 하기 위해서 -->
<%request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="mem" class="member.DBBean"/>
<jsp:setProperty name="mem" property="*"/>

<%
	String action = request.getParameter("action");
	
	
	if(action.equals("insert")) {
		if(mem.insertDB()){  // 정상 입력
			response.sendRedirect("welcome.jsp");
			//System.out.println("member 테이블에 데이터 입력 성공!!");	
		}else { // 입력 실패!!
			response.sendRedirect("member_Form.jsp");
			//System.out.println("member 테이블에 데이터 입력 실패!!");	
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_control.jsp 페이지 => MVC 패턴의 Controller 역할</title>
</head>
<body>

</body>
</html>