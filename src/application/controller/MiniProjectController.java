/*
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
import javafx.scene.control.ListView;


	
	
public class MiniProjectController implements EventHandler<ActionEvent>  {
	
	private Project project;
	@FXML
	private ListView<Activity> TaskListView;
	
	private  ObservableList<Activity> TaskList;

	
	public MiniProjectController() {
		
	}

	public void initialize() {
		System.out.println("test");
		TaskList = FXCollections.observableArrayList();
		TaskList.clear();
		for(Activity a: this.project.GetActivitiesList()) {
			TaskList.add(a);
		}
		TaskListView.getItems().setAll(TaskList);
}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
//*/