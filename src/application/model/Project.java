package application.model;

import java.util.ArrayList;

public class Project {
	private String projectTitle;
	private ArrayList<Activity> activities;
	private ArrayList<Note> notes;
	
	public Project(String projectTitle) {
		this.projectTitle = projectTitle;
		this.activities = new ArrayList<Activity>();
		this.notes = new ArrayList<Note>();
	}
	public String getProjectTitle() {
		return this.projectTitle;
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
