package application.model;

import java.util.ArrayList;
/**
 * Class representing the Project object
 * @author quw884
 *
 */
public class Project {
	private String projectTitle;
	private String ownerName;
	private ArrayList<Activity> activities;
	private ArrayList<Note> notes;
	/**
	 * Constructor: Take in two strings of project data
	 * @param projectTitle Title for Project
	 * @param ownerName Name of project owner
	 */
	public Project(String projectTitle, String ownerName) {
		this.projectTitle = projectTitle;
		this.ownerName = ownerName;
		this.activities = new ArrayList<Activity>();
		this.notes = new ArrayList<Note>();
	}
	/**
	 * Gets project title
	 * @return String name of project
	 */
	public String getProjectTitle() {
		return this.projectTitle;
	}
	/**
	 * Gets owner of project
	 * @return String name of project owner
	 */
	public String getOwnerName() {
		return this.ownerName;
	}
	/**
	 * Add Activity to project
	 * @param a Activity to add
	 */
	public void addActivity(Activity a) {
		this.activities.add(a);
	}
	/**
	 * Remove Activity from project
	 * @param a Activity to remove
	 */
	public void removeActivity(Activity a) {
		this.activities.remove(a);
	}
	/**
	 * Add Note to project
	 * @param n Note to add
	 */
	public void addNote(Note n) {
		this.notes.add(n);
	}
	/**
	 * Remove note from project
	 * @param n Note to remove
	 */
	public void removeNote(Note n) {
		this.notes.remove(n);
	}

}
