package ex01.common.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertClass {

	//common : 공통사용
	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
}
