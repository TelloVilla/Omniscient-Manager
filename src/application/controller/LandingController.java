package application.controller;

import java.io.IOException;

import com.sun.javafx.scene.control.skin.LabeledText;

import application.Main;
import application.model.Activity;
import application.model.Note;
import application.model.User;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LandingController implements EventHandler<ActionEvent>{
	
	private User user;
	
	@FXML
	private ListView<Note> activityListView;
	@FXML
	private ObservableList<Note> activityList;
	@FXML
	private Button addButton;
	@FXML
	private TextArea infoTextArea;
	@FXML
	private Button projectButton;
	@FXML
	public void initialize() {
		activityList = FXCollections.observableArrayList();
		activityList.clear();
		for(Activity a: this.user.GetActivityList()) {
			activityList.add(a);
		}
		for(Note n: this.user.GetNoteList()) {
			activityList.add(n);
		}
		activityListView.getItems().setAll(activityList);		
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
	public void handleProject(ActionEvent e){
		try{
			
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../Projects.fxml"));
		ManagerController mc = new ManagerController(this.user);
		loader.setController(mc);
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)projectButton.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		//*/
	} catch (IOException err) {
		err.printStackTrace();
	}
	}
	public void handleInfoClick(MouseEvent e) {
		ObservableList<Note> selected = activityListView.getSelectionModel().getSelectedItems();
		if(selected.get(0) instanceof Activity) {
			Activity selectedA = (Activity)selected.get(0);
			infoTextArea.setText(selectedA.getTitle() + "\n" + selectedA.getContent() + "\n" + selectedA.getBeginDate() + " - " + selectedA.getEndDate());
		}else if(selected.get(0) instanceof Note) {
			Note selectedN = (Note)selected.get(0);
			infoTextArea.setText(selectedN.getTitle() + "\n" + selectedN.getContent());
		}
	}
	public void handleDelete() {
		ObservableList<Note> selected = activityListView.getSelectionModel().getSelectedItems();
		if(selected.get(0) instanceof Activity) {
			Activity selectedA = (Activity)selected.get(0);
			this.user.removeActivityFromUser(selectedA);
		}else if(selected.get(0) instanceof Note) {
			Note selectedN = (Note)selected.get(0);
			this.user.removeNoteFromUser(selectedN);
		}
		this.user.save();
		this.initialize();
	}
	public void handleEdit() {
		ObservableList<Note> selected = activityListView.getSelectionModel().getSelectedItems();
		if(selected.get(0) instanceof Activity) {
			Activity selectedA = (Activity)selected.get(0);
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("../Creator.fxml"));
				CreatorController cc = new CreatorController(this.user, selectedA);
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
			
		}else if(selected.get(0) instanceof Note) {
			Note selectedN = (Note)selected.get(0);
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("../Creator.fxml"));
				CreatorController cc = new CreatorController(this.user, selectedN);
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
	}
	@Override
	public void handle(ActionEvent e) {
		
	}

}
