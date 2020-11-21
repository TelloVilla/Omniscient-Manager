package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public String getUserName() {
		return this.username;
	}
	public void setUserName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addProjectToUser(Project p) {
		this.projects.add(p);
	}
	public void addActivityToUser(Activity a) {
		this.activites.add(a);
	}
	public void removeProjectFromUserByName(String pName) {
		for(Project p : this.projects) {
			if(p.getProjectTitle().equals(pName)) {
				this.projects.remove(p);
			}
		}
	}
	public void removeActivityFromUserByName(String aName) {
		for(Activity a : this.activites) {
			if(a.getTitle().equals(aName)) {
				this.activites.remove(a);
			}
		}
	}
	public void removeProjectFromUser(Project p) {
		this.projects.remove(p);
	}
	public ArrayList<Project> GetProjectList(){
		return this.projects;
	}
	public ArrayList<Activity> GetActivityList(){
		return this.activites;
	}
	
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
	
	
	

}
