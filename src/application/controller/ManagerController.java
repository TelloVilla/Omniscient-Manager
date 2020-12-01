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
	private Button homeButton;
	@FXML
	private ListView<Project> projectListView;
	
	private  ObservableList<Project> projectList;

	public ManagerController(User user) {
		this.user = user;
	}
	
	public void initialize() {
		projectList = FXCollections.observableArrayList();
		projectList.clear();
		for(Project a: this.user.GetProjectList()) {
			projectList.add(a);
		}
		projectListView.getItems().setAll(projectList);
	}
	

	public void handleHome(ActionEvent e) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../Landing.fxml"));
			LandingController lc = new LandingController(this.user);
			loader.setController(lc);
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage)homeButton.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}
	/*/
	public void handlerOpen (ActionEvent e){
		System.out.println("WHYME");
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../MiniProject.fxml"));
			MiniProjectController mpc = new MiniProjectController();
			loader.setController(mpc);
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			Stage miniStage = new Stage();
			miniStage.setScene(scene);
			miniStage.show();
			
		}catch (IOException err){
			err.printStackTrace();
		}
	}
	//*/

	@Override
	public void handle(ActionEvent arg0) {
		
	}
	
}
