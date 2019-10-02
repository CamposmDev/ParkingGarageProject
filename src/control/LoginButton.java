package control;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import userData.UserData;

public class LoginButton extends Button {
	private ArrayList<UserData> userList;
	
	public LoginButton() {
		super("Login");
		super.setOnAction(new LoginHandler());
	}
	
	private class LoginHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
		}
	}
}
