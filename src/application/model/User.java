package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Class representing the user object with 2 strings and 3 ArrayLists
 * @author Anon
 *
 */
public class User {
	private String username;
	private String password;
	private ArrayList<Project> projects;
	private ArrayList<Activity> activites;
	private ArrayList<Note> notes;
	/**
	 * Constructor: Take in 2 strings of user info and initialize 3 ArrayLists
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.projects = new ArrayList<Project>();
		this.activites = new ArrayList<Activity>();
		this.notes = new ArrayList<Note>();
	}
	/**
	 * Gets name of user
	 * @return String name of user
	 */
	public String getUserName() {
		return this.username;
	}
	/**
	 * Sets name of user
	 * @param name Name to set for user
	 */
	public void setUserName(String name) {
		this.username = name;
	}
	/**
	 * Gets password of user
	 * @return String password of user
	 */
	public String getPassword() {
		return this.password;
	}
	/**
	 * Sets password of user
	 * @param password Password to set for user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Adds project to user projects
	 * @param p Project to add
	 */
	public void addProjectToUser(Project p) {
		this.projects.add(p);
	}
	/**
	 * Adds activity to user activites
	 * @param a Activity to add
	 */
	public void addActivityToUser(Activity a) {
		this.activites.add(a);
	}
	/**
	 * Adds note to user notes
	 * @param n Note to add
	 */
	public void addNoteToUser(Note n) {
		this.notes.add(n);
	}
	/**
	 * Remove Project from user based on project name
	 * @param pName Project name to search for and remove
	 */
	public void removeProjectFromUserByName(String pName) {
		for(Project p : this.projects) {
			if(p.getProjectTitle().equals(pName)) {
				this.projects.remove(p);
			}
		}
	}
	/**
	 * Remove Activity from user based on activity name
	 * @param aName Activity name to search for and remove
	 */
	public void removeActivityFromUserByName(String aName) {
		for(Activity a : this.activites) {
			if(a.getTitle().equals(aName)) {
				this.activites.remove(a);
			}
		}
	}
	/**
	 * Remove Note from user
	 * @param n Note to remove
	 */
	public void removeNoteFromUser(Note n) {
		this.notes.remove(n);
	}
	/**
	 * Remove Activity from user
	 * @param a Activity to remove
	 */
	public void removeActivityFromUser(Activity a) {
		this.activites.remove(a);
	}
	/**
	 * Remove Project from user
	 * @param p Project to remove
	 */
	public void removeProjectFromUser(Project p) {
		this.projects.remove(p);
	}
	/**
	 * Get project list of user
	 * @return ArrayList<Project> List of projects
	 */
	public ArrayList<Project> GetProjectList(){
		return this.projects;
	}
	/**
	 * Get activity list of user
	 * @return ArrayList<Activity> List of activities
	 */
	public ArrayList<Activity> GetActivityList(){
		return this.activites;
	}
	/**
	 * Get note list from user
	 * @return ArrayList<Note> List of notes
	 */
	public ArrayList<Note> GetNoteList(){
		return this.notes;
	}
	/**
	 * Verify user based on user.csv
	 * @param username Username to check
	 * @param password Password to check
	 * @return User User created from verified login data
	 */
	public static User verify(String username, String password) {
		User validUser = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader("data/users.csv"));
			try {
				String line = "";
				while((line = br.readLine()) != null){
					String[] user = line.split(",");
					if(user[0].equals(username) && user[1].equals(password)) {
						validUser = new User(user[0], user[1]);
						return validUser;
					}
				}
			}finally {
				br.close();
			}
			
		}catch(IOException e){
			System.out.println("File could not be found");
			e.printStackTrace();
		}
		return validUser;
	}
	/**
	 * Loads user data based on projects.csv, activties.csv, and notes.csv
	 */
	public void loadUser() {
		try{
			BufferedReader br = new BufferedReader(new FileReader("data/projects.csv"));
			try {
				String line = "";
				while((line = br.readLine()) != null){
					String[] project = line.split(",");
					if(project[1].equals(this.username)) {
						Project p = new Project(project[0], project[1]);
						this.projects.add(p);
					}
				}
			}finally {
				br.close();
			}
			
		}catch(IOException e){
			System.out.println("File could not be found");
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/notes.csv"));
			try {
				String line = "";
				while((line = br.readLine()) != null){
					String[] note = line.split(",");
					if(note[3].equals(this.username)) {
						boolean project = false;
						LocalDate createDate = LocalDate.parse(note[0]);
						Note n = new Note(createDate, note[1], note[2], note[3], note[4]);
						for(Project p: this.projects) {
							if(p.getProjectTitle().equals(note[4])) {
								p.addNote(n);
								project = true;
							}
						}
						if(project == false) {
							this.notes.add(n);
						}
					}
				}
			}finally {
				br.close();
			}
		}catch(IOException e){
			System.out.println("File could not be found");
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/activites.csv"));
			try {
				String line = "";
				while((line = br.readLine()) != null){
					String[] activity = line.split(",");
					if(activity[3].equals(this.username)) {
						boolean project = false;
						LocalDate createDate = LocalDate.parse(activity[0]);
						LocalDate beginDate = LocalDate.parse(activity[5]);
						LocalDate endDate = LocalDate.parse(activity[6]);
						Activity a = new Activity(createDate, activity[1], activity[2], activity[3], activity[4], beginDate, endDate);
						for(Project p: this.projects) {
							if(p.getProjectTitle().equals(activity[4])) {
								p.addActivity(a);
								project = true;
							}
						}
						if(project == false) {
							this.activites.add(a);
						}
					}
				}
			}finally {
				br.close();
			}
		}catch(IOException e){
			System.out.println("File could not be found");
			e.printStackTrace();
		}
			
		
		
	}
	/**
	 * Add new User and save to users.csv
	 */
	public void saveUser(){
		try{
			
		FileWriter fw = new FileWriter("data/users.csv",true);
		fw.append("\n");
		fw.append(this.username+","+this.password);
		fw.flush();
		fw.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	/**
	 * Save user data to projects.csv, activties.csv, and notes.csv
	 */
	public void save() {
		try {
			new FileWriter("data/projects.csv", false).close();
			FileWriter fw = new FileWriter("data/projects.csv");
			for(Project p : this.projects) {
				String project = p.getProjectTitle() + "," + p.getOwnerName();
				fw.append(project);
				fw.append("\n");
			}
			fw.flush();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			new FileWriter("data/activites.csv", false).close();
			FileWriter fw = new FileWriter("data/activites.csv");
			for(Activity a : this.activites) {
				String activity = a.getCreationDate() + "," + a.getTitle() + "," + a.getContent() + "," + a.getOwnerName() + "," + a.getProjectName() + "," + a.getBeginDate() + "," + a.getEndDate();
				fw.append(activity);
				fw.append("\n");
			}
			fw.flush();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			new FileWriter("data/notes.csv", false).close();
			FileWriter fw = new FileWriter("data/notes.csv");
			for(Note n : this.notes) {
				String note = n.getCreationDate() + "," + n.getTitle() + "," + n.getContent() + "," + n.getOwnerName() + "," + n.getProjectName();
				fw.append(note);
				fw.append("\n");
			}
			fw.flush();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
