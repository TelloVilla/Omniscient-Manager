package application.controller;

import java.io.IOException;

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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class LandingController implements EventHandler<ActionEvent>{
	
	private User user;
	
	@FXML
	private ListView<String> activityListView;
	@FXML
	private Button addButton;
	@FXML
	public void initialize() {
		this.user.loadUser();
		for(Activity a: this.user.GetActivityList()) {
			activityListView.getItems().add(a.getTitle() + "    Due " + a.getEndDate());
		}
		
	}
	
	public LandingController(User user) {
		this.user = user;
	}
	public void handleAdd(ActionEvent e) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../Creator.fxml"));
			CreatorController cc = new CreatorController(this.user);
			loader.setController(cc);
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage)addButton.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}
	@Override
	public void handle(ActionEvent e) {
		
	}

}
