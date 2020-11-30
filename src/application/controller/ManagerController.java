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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ManagerController implements EventHandler<ActionEvent>  {
	
	private User user;
	@FXML
	private Button returnButton;
	@FXML
	private ListView<Note> projectListView;
	@FXML
	private  ObservableList<Note> projectList;
	
	public ManagerController(User user) {
		this.user = user;
	}
	
	public void initialize() {
		projectList = FXCollections.observableArrayList();
		projectList.clear();
		for(Project a: this.user.GetProjectList()) {
			projectList.add(a);
		}
		for(Note n: this.user.GetNoteList()) {
			projectList.add(n);
		}
		projectListView.getItems().setAll(projectList);
	}
	
	public void handleReturn(ActionEvent e) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../Projects.fxml"));
			ManagerController mm = new ManagerController(this.user);
			loader.setController(mm);
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage)returnButton.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
