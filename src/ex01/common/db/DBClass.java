package ex01.common.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {

	//static : 협업자 모두 사용하기 때문에 static으로 접근 가능하게끔 설정
	public static Connection conn;
	
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
	
}
