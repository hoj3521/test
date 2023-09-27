<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!-- 추가 -->

<% request.setCharacterEncoding("UTF-8"); %>  

<jsp:useBean id="mem" class="member.DBBean" scope="page"/>



<%

	String mem_id = request.getParameter("mem_id");

	int idCheck = mem.confirmId(mem_id);   //idCheck가 1인 경우 => id 중복

%>  

    

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>아이디 중복 체크 IdCheck.jsp 페이지</title>

</head>

<body>

	<table border="0" align="center">

		<tr>

			<td align="center">

				<%

					if(idCheck == 1) {  //ID가 중복인 경우

				%>

				<br>

				<%= mem_id %>는 이미 존재하는 ID 입니다.&nbsp;<br><br>

				<input type="button" value="닫기" 

				       onClick="javascript:self.close();

				       opener.document.memberForm.mem_id.focus();"/>		

				<%		

					}else{    //사용 가능한 ID인 경우

				%>

				<br>

				<%= mem_id %>는 사용 가능한 ID 입니다.&nbsp;<br><br>

				<input type="button" value="닫기" 

				       onClick="javascript:self.close();

				       opener.document.memberForm.mem_passwd.focus();"/>

				<%

					}

				%>       

			</td>

		</tr>

	</table>



</body>

</html>



