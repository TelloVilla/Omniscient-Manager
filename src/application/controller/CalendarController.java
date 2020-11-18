package application.controller;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CalendarController implements EventHandler<ActionEvent>{
	
	private User user;
	
	public CalendarController(User user) {
		this.user = user;
	}
	
	@Override
	public void handle(ActionEvent e) {
		
	}

}
