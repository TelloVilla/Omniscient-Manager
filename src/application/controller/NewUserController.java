package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Activity;
import application.model.Note;
import application.model.User;
import application.model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUserController implements EventHandler<ActionEvent> {
	private User user;
	private User newUser;
	
	@FXML
	private Button ReturnButton;
	@FXML
	private Button ConfirmButton;
	@FXML
	private TextField NewUsername;
	@FXML
	private PasswordField NewPassword;
	
	
	

public void handleReturn(ActionEvent e){
	try{
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Main.class.getResource("../Login.fxml"));
	Parent root = (Parent) loader.load();
	Scene scene = new Scene(root);
	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
	Stage primaryStage = (Stage)ReturnButton.getScene().getWindow();
	primaryStage.setScene(scene);
	primaryStage.show();
	} catch (IOException err){
		err.printStackTrace();
	}
}

public void handleConfirmButton(ActionEvent e){
	User user = User.verify(NewUsername.getText(), NewPassword.getText());
	if (user == null){
		try{
		User newUser = new User(NewUsername.getText(),NewPassword.getText());
		newUser.saveUser();
		System.out.println("TestReturn");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../Login.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)ConfirmButton.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch (IOException err){
			err.printStackTrace();
		}
		
	}
		
}


@Override
public void handle(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}


	

}
