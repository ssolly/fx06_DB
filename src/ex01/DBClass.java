package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClass {

	public Connection conn;

	/* 단일 생성시
	public DBClass() {
		try {
			//oracle 연결 드라이브 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//orcale과 연결된 객체를 가져온다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","idid","idid");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public int insert(MemberDTO dto) {
		String sql = "insert into FX_MEMBER(id,pwd,name) values(?,?,?)";
		int result = 0;
		try {
			//연결된 객체(conn)를 이용해서 쿼리문(명령어) 전송할 수 있는 전송객체 얻어옴
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//쿼리문의 물음표 자리에 값을 채워넣음
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			
			//전송객체를 이용해서 명령어 실행(DB에 명령어 전송), 성공:1,실패:0 결과값 돌려줌
			//보편적으로 select를 제외한 나머지 명령어는 executeUpdate를 사용
			result = ps.executeUpdate();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* 단일 작업시
	public MemberDTO loginChk(String inputId) {
		//select * from FX_MEMBER where id = ' ';
		String sql = "select * from FX_MEMBER where id = ?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inputId);
			
			//ResultSet는 배열과 비슷한 방식으로 가져온다
			//ResultSet는 select문에서 무조건 사용한다
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	*/
}
