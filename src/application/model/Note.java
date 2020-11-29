package application.model;

import java.time.LocalDate;

public class Note {
	private String title;
	private String content;
	private LocalDate creationDate;
	private String ownerName;
	private String projectName;
	
	public Note(LocalDate creationDate, String title, String content, String ownerName, String projectName) {
		this.creationDate = creationDate;
		this.title = title;
		this.content = content;
		this.ownerName = ownerName;
		this.projectName = projectName;
		
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getCreationDate() {
		return this.creationDate;
	}
	public void setCreationDate(LocalDate creation) {
		this.creationDate = creation;
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}
	public String getProjectName() {
		return this.projectName;
	}
	public void setProjectName(String project) {
		this.projectName = project;
	}
	
	@Override
	public String toString() {
		return this.content;
	}
	

}
