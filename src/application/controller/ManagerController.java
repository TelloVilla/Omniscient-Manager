package application.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManagerController implements EventHandler<ActionEvent>  {
	
	private User user;
	
	
	@FXML
	private Button homeButton;
	@FXML
	private Accordion AccordionMenu;
	
	@FXML
	private TitledPane Accordion1,Accordion2, Accordion3;
	@FXML
	private ListView<Project> projectListView;
	
	@FXML
	private  ObservableList<Project> projectList;
	
	@FXML
	private ListView<Activity> TaskListView;
	
	@FXML
	private ObservableList<Activity>taskList;
	
	@FXML
	private TextArea ActivityNoteView;
	
	@FXML
	private CheckBox CompletedButton;

	
	
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
		
		taskList = FXCollections.observableArrayList();
		taskList.clear();
	}
	
	public void handleTasks(MouseEvent e) throws IOException {
		Project SelectedProject = projectListView.getSelectionModel().getSelectedItem();
		taskList.clear();
		TaskListView.getItems().clear();
		taskList.addAll(SelectedProject.getActivities());
		TaskListView.getItems().setAll(taskList);
	}
	
	public void handleTaskNotes(MouseEvent e) throws IOException {
		Activity SelectedTask = TaskListView.getSelectionModel().getSelectedItem();
		ActivityNoteView.setText(SelectedTask.toString()+"\n"+SelectedTask.getOwnerName()+"\n");
		if (SelectedTask.getCompletionStatus() == false){
			ActivityNoteView.appendText("Task Completed\n\n");
			CompletedButton.setIndeterminate(true);
		}
		else{
			ActivityNoteView.appendText("Incomplete\n\n");
			CompletedButton.setIndeterminate(false);
		}
		ActivityNoteView.appendText(SelectedTask.getContent().toString());
	}
	
	public void handleCOMPLETED(ActionEvent e){
		Activity MissionComplete = TaskListView.getSelectionModel().getSelectedItem();
		boolean yesno = CompletedButton.isIndeterminate();
		MissionComplete.setCompletionStatus(yesno);
		
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
			Stage primaryStage = (Stage)homeButton.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException err) {
			err.printStackTrace();
		}
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

	@Override
	public void handle(ActionEvent arg0) {
		
	}
	
}
