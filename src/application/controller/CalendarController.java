package application.controller;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalendarController implements EventHandler<ActionEvent>{
	
	private User user;
	private Calendar calendar;
	private enum Month{Janurary, Feburary, March, Arpil, May, June, July, August, September, October, November, December};
	
	@FXML
	private Label calendarLabel;
	@FXML
	private Label userLabel;
	
	public CalendarController(User user) {
		this.user = user;
		this.calendar = Calendar.getInstance();
	}
	@FXML
	public void initialize() {
		System.out.println(this.calendar.get(Calendar.MONTH));
		calendarLabel.setText(getMonth(this.calendar.get(Calendar.MONTH)));
		userLabel.setText(this.user.getUserName() + " is logged in");
		
	}
	public String getMonth(int m) {
		return new DateFormatSymbols().getMonths()[m-1];
	}
	
	
	
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Test");
	}

}
