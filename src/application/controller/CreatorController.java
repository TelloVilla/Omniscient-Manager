package application.controller;

import java.io.IOException;
import java.time.LocalDate;

import application.Main;
import application.model.Activity;
import application.model.Note;
import application.model.Project;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class CreatorController implements EventHandler<ActionEvent>{
	
	private User user;
	private Activity editActivity;
	private Note editNote;
	private boolean editMode;
	
	@FXML
	private TextField titleTextField;
	@FXML
	private TextArea contentTextArea;
	@FXML
	private TextField addToProjectTextField;
	@FXML
	private DatePicker beginDatePicker;
	@FXML
	private DatePicker endDatePicker;
	@FXML
	private ToggleGroup creatorToggle;
	@FXML
	private RadioButton noteToggle;
	@FXML
	private RadioButton activityToggle;
	@FXML
	private Label toggleLabel;
	@FXML
	private Button createButton;
	@FXML
	private Button homeButton;
	
	public CreatorController(User user) {
		this.user = user;
		this.editMode = false;
		
	}
	public CreatorController(User user, Activity a) {
		this.user = user;
		this.editActivity = a;
		this.editMode = true;
	}
	public CreatorController(User user, Note n) {
		this.user = user;
		this.editNote = n;
		this.editMode = true;
	}
	
	@FXML
	public void initialize() {
		if(this.editMode == true && editActivity != null) {
			activityToggle.setSelected(true);
			titleTextField.setText(editActivity.getTitle());
			contentTextArea.setText(editActivity.getContent());
			addToProjectTextField.setText(editActivity.getProjectName());
			beginDatePicker.setValue(editActivity.getBeginDate());
			endDatePicker.setValue(editActivity.getEndDate());
		}else if(this.editMode == true && editNote != null) {
			noteToggle.setSelected(true);
			titleTextField.setText(editNote.getTitle());
			contentTextArea.setText(editNote.getContent());
			addToProjectTextField.setText(editNote.getProjectName());
		}
	}
	
	@Override
	public void handle(ActionEvent e) {
		RadioButton type = (RadioButton)creatorToggle.getSelectedToggle();
		LocalDate beginDate = beginDatePicker.getValue();
		LocalDate endDate = endDatePicker.getValue();
		String projectTitle = addToProjectTextField.getText();
		if(projectTitle.equals("")) {
			projectTitle = "none";
		}
		if(type == null) {
			toggleLabel.setText("Select Type");
			return;
		}else if(type.getText().equals("Note")) {
			LocalDate creationDate = LocalDate.now();
			Note newNote = new Note(creationDate, titleTextField.getText(), contentTextArea.getText(), this.user.getUserName(), projectTitle);
			this.user.addNoteToUser(newNote);
			this.user.save();
			
		}else if(type.getText().equals("Activity")) {
			LocalDate creationDate = LocalDate.now();
			Activity newActivity = new Activity(creationDate, titleTextField.getText(), contentTextArea.getText(), this.user.getUserName(), projectTitle, beginDate, endDate);
			this.user.addActivityToUser(newActivity);
			this.user.save();
			
		}
		else if(type.getText().equals("Project")) {
			Project newProject = new Project(titleTextField.getText(), this.user.getUserName());
			this.user.addProjectToUser(newProject);
			this.user.save();
		}
		titleTextField.clear();
		contentTextArea.clear();
		addToProjectTextField.clear();
		beginDatePicker.getEditor().clear();
		endDatePicker.getEditor().clear();
		
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

}
