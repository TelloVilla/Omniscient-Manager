package application.model;

import java.util.ArrayList;

public class Project {
	private String projectTitle;
	private String ownerName;
	private ArrayList<Activity> activities;
	private ArrayList<Note> notes;
	
	public Project(String projectTitle, String ownerName) {
		this.projectTitle = projectTitle;
		this.ownerName = ownerName;
		this.activities = new ArrayList<Activity>();
		this.notes = new ArrayList<Note>();
	}
	public String getProjectTitle() {
		return this.projectTitle;
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public void addActivity(Activity a) {
		this.activities.add(a);
	}
	public void removeActivity(Activity a) {
		this.activities.remove(a);
	}
	public void addNote(Note n) {
		this.notes.add(n);
	}
	public void removeNote(Note n) {
		this.notes.remove(n);
	}

}
