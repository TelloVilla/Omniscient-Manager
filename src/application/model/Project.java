package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project extends Note {
	private String projectTitle;
	private String ownerName;
	private ArrayList<Activity> activities;
	private ArrayList<Note> notes;
	
	public Project(LocalDate creationDate, String title, String content, String ownerName, String projectName, String projectTitle) {
		super(creationDate, title, content, ownerName, projectName);
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
