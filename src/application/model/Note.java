package application.model;

import java.time.LocalDate;

public class Note {
	private String id;
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
	public String getContent() {
		return this.content;
	}
	public LocalDate getCreationDate() {
		return this.creationDate;
	}

}
