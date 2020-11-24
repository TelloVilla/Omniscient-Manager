package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
	public void addNoteToUser(Note n) {
		this.notes.add(n);
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
