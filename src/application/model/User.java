package application.model;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private ArrayList<Project> projects;
	private ArrayList<Activity> activites;
	private ArrayList<Note> notes;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.projects = new ArrayList<Project>();
		this.activites = new ArrayList<Activity>();
		this.notes = new ArrayList<Note>();
	}
	

}
