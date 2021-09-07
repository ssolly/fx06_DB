package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.AA.LoginService;
import ex01.AA.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	Parent root;
	//public static DBClass db;			//공통사용
	private ex01.common.db.DBClass comDB;
	private LoginService ls;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	//	db = new DBClass();				//객체 생성
		comDB = new ex01.common.db.DBClass();
		ls = new LoginServiceImpl();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void membership() {
		
		TextField id = (TextField)root.lookup("#memberId");
		TextField name = (TextField)root.lookup("#memberName");
		TextField pwd = (TextField)root.lookup("#memberPwd");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPwd(pwd.getText());
		dto.setName(name.getText());

		int result = db.insert(dto);
		if(result==1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입 완료");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입 실패 : 동일 아이디 존재");
			alert.show();
		}
	}
	
	public void login() {
		
		//협업시 AA사람 작업
		ls.loginChk(root);
		
		
		/* 단일 생성시
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		
		MemberDTO dto = db.loginChk(id.getText());
		if(dto==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("로그인 실패 : 존재하지 않는 아이디");
			alert.show();
		} else {
			if(dto.getPwd().equals(pwd.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("로그인 완료");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("로그인 실패 : 비밀번호 오류");
				alert.show();
			}
		}
		*/
	}
	
	
}
