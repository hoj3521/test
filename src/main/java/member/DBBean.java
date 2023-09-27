package member;



/*

 * 회원(member) 테이블과 관련된 클래스이다.

 */

import java.sql.*;

import java.util.*;


public class DBBean {

	//멤버변수(프로퍼티, 중간 저장소)

	private String mem_id;				//아이디

	private String mem_passwd;			//비밀번호

	private String mem_name;			//이름

	private String mem_nickname;		//닉네임

	private String mem_email_id;    	//이메일 아이디

	private String mem_email_domain;	//이메일 도메인

	private String mem_num1;			//주민번호 앞 6자리

	private String mem_num2;			//주민번호 뒤 7자리

	private String mem_phone;			//휴대폰번호

	private String mem_gender;			//성별

	private int mem_birthday1;			//출생년도

	private int mem_birthday2;			//출생월

	private int mem_birthday3;			//출생일

	private String mem_job;				//직업

	private String zipcode;				//우편번호

	private String useraddr1;			//주소

	private String useraddr2;			//상세주소

	private String useraddr3;			//참고항목

	

	//오라클 DB 연동에 관련된 객체 참조 변수 선언

	Connection			conn = null;

	PreparedStatement	pstmt = null;

	ResultSet  			rs = null;

	

	//마이sqlJDBC 연동을 위한 driver와 url

	String url = "jdbc:mysql://localhost:3306/member";
    String id = "root";   
    String pw = "asdf0420"; 
	
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";

	String jdbc_url = "jdbc:mysql://localhost:3306/member";

	

	//DB 연동 메소드 구현 //정형화된 소스패턴 ==> 암기하고 숙지하자!!!

	public void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, id,pw);

		}catch(Exception e) {

			System.out.println("connect():  " +e);			

		}		

	}

	

	//DB 연동 종료 메소드 구현

	public void disconnect() {

		try {

			pstmt.close();  //자원 해제

			conn.close();

			rs.close();

		}catch(Exception e) {

			System.out.println(e);

		}

	}

	

	//ID 중복 체크 메소드 구현

	public int confirmId(String mem_id) {

		connect();		

		 int idDuplication = 0; //id 중복 여부 체크 변수  //지역변수 초기화해줘야됨 필수!!

		

		try { //디비에서 하는 것들은 다 예외처리하자!! 

			String Confirmed_SELECT 

			      = "select * from `member` where mem_id = ?";//preparestatement방식 why??보안을 위해서 

			pstmt = conn.prepareStatement(Confirmed_SELECT);

			pstmt.setString(1, mem_id);//위에 ? 가잇어서 미결정된거를 setstring으로 정해주는거 

			rs = pstmt.executeQuery(); // select할떄는 executeQuery insert update delete할떄는 또 따로 메소드가 따로있음!

			

			if(rs.next()) {

				idDuplication = 1; //ID가 중복인 경우

			}else {

				idDuplication = -1; //사용 가능한 ID인 경우

			}			

		}catch(Exception e) {

			System.out.println("confirmId(): "+ e);

		}finally {
			disconnect();
		}

		return idDuplication;

	}	//end confirmId() 
	
	//회원가입 폼에서 입력한 데이터들을 member 테이블에 저장하는 메소드 구현 
	
	public boolean insertDB() {
		connect();
		
		try {
			String MEMBER_INSERT = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			
			String mem_email = mem_email_id + "@" + mem_email_domain; 
			
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_passwd);
			pstmt.setString(3, mem_name);
			pstmt.setString(4, mem_email);
			pstmt.setString(5, mem_num1);
			pstmt.setString(6, mem_num2);
			pstmt.setString(7, mem_id);
			pstmt.setString(8, mem_phone);
			pstmt.setString(8, mem_phone);
			pstmt.setString(9, mem_gender);
			pstmt.setInt(10, mem_birthday1);
			pstmt.setInt(11, mem_birthday2);
			pstmt.setInt(12, mem_birthday3);
			pstmt.setString(13, mem_job);
			pstmt.setString(14, zipcode);
			pstmt.setString(15, useraddr1);
			pstmt.setString(16, useraddr2);
			pstmt.setString(17, useraddr3);
			
			
			pstmt.executeUpdate(); //member 테이블에 데이터들 insert 작업이 이루어진다. 
			
			
			
		} catch (Exception e) {
			System.out.println("insertDB()" + e);
		}finally {
			disconnect();
		}
		
		return true;// 정상적으로 입력이 이루어지면 true 를 리턴한다
		
		
		
		
	}


	

	//멤버변수 하나당 getter, setter 메소드 

	public String getMem_id() {

		return mem_id;

	}

	public void setMem_id(String mem_id) {

		this.mem_id = mem_id;

	}

	public String getMem_passwd() {

		return mem_passwd;

	}

	public void setMem_passwd(String mem_passwd) {

		this.mem_passwd = mem_passwd;

	}

	public String getMem_name() {

		return mem_name;

	}

	public void setMem_name(String mem_name) {

		this.mem_name = mem_name;

	}

	public String getMem_nickname() {

		return mem_nickname;

	}

	public void setMem_nickname(String mem_nickname) {

		this.mem_nickname = mem_nickname;

	}

	public String getMem_email_id() {

		return mem_email_id;

	}

	public void setMem_email_id(String mem_email_id) {

		this.mem_email_id = mem_email_id;

	}

	public String getMem_email_domain() {

		return mem_email_domain;

	}

	public void setMem_email_domain(String mem_email_domain) {

		this.mem_email_domain = mem_email_domain;

	}

	public String getMem_num1() {

		return mem_num1;

	}

	public void setMem_num1(String mem_num1) {

		this.mem_num1 = mem_num1;

	}

	public String getMem_num2() {

		return mem_num2;

	}

	public void setMem_num2(String mem_num2) {

		this.mem_num2 = mem_num2;

	}

	public String getMem_phone() {

		return mem_phone;

	}

	public void setMem_phone(String mem_phone) {

		this.mem_phone = mem_phone;

	}

	public String getMem_gender() {

		return mem_gender;

	}

	public void setMem_gender(String mem_gender) {

		this.mem_gender = mem_gender;

	}

	public int getMem_birthday1() {

		return mem_birthday1;

	}

	public void setMem_birthday1(int mem_birthday1) {

		this.mem_birthday1 = mem_birthday1;

	}

	public int getMem_birthday2() {

		return mem_birthday2;

	}

	public void setMem_birthday2(int mem_birthday2) {

		this.mem_birthday2 = mem_birthday2;

	}

	public int getMem_birthday3() {

		return mem_birthday3;

	}

	public void setMem_birthday3(int mem_birthday3) {

		this.mem_birthday3 = mem_birthday3;

	}

	public String getMem_job() {

		return mem_job;

	}

	public void setMem_job(String mem_job) {

		this.mem_job = mem_job;

	}

	public String getZipcode() {

		return zipcode;

	}

	public void setZipcode(String zipcode) {

		this.zipcode = zipcode;

	}

	public String getUseraddr1() {

		return useraddr1;

	}

	public void setUseraddr1(String useraddr1) {

		this.useraddr1 = useraddr1;

	}

	public String getUseraddr2() {

		return useraddr2;

	}

	public void setUseraddr2(String useraddr2) {

		this.useraddr2 = useraddr2;

	}

	public String getUseraddr3() {

		return useraddr3;

	}

	public void setUseraddr3(String useraddr3) {

		this.useraddr3 = useraddr3;

	}	

}