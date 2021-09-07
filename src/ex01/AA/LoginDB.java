package ex01.AA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ex01.MemberDTO;
import ex01.common.db.DBClass;

public class LoginDB {

	public MemberDTO loginChk(String inputId) {
		//select * from FX_MEMBER where id = ' ';
		String sql = "select * from FX_MEMBER where id = ?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
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
	
}
