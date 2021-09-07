package ex01.AA;

import ex01.MemberDTO;
import ex01.common.alert.AlertClass;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService {
	//DB에 접근해서 데이터 체크 필요
	
	LoginDB db;
	
	public LoginServiceImpl() {
		db = new LoginDB();
	}
	
	@Override
	public void loginChk(Parent root) {
		
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		String msg = null;
		
		MemberDTO dto = db.loginChk(id.getText());
		
		if(dto==null) {
			msg="로그인 실패 : 존재하지 않는 아이디";
		} else {
			if(dto.getPwd().equals(pwd.getText())) {
				msg="로그인 완료";
			} else {
				msg = "로그인 실패 : 비밀번호 오류";
			}
		}
		AlertClass.alert(msg);
	}

}
