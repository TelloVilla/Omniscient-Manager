package application.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Main;
import application.model.Activity;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements EventHandler<ActionEvent>{
		
	@FXML
	private Button loginButton;
	@FXML
	private TextField userTextField;
	@FXML
	private TextField passTextField;
	
	@Override
	public void handle(ActionEvent e) {
		User validUser = User.verify(userTextField.getText(), passTextField.getText());
		if(validUser != null) {
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("../Landing.fxml"));
				LandingController lc = new LandingController(validUser);
				loader.setController(lc);
				Parent root = (Parent) loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
				Stage primaryStage = (Stage)loginButton.getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException err) {
				err.printStackTrace();
			}
		}
		
	}

}
