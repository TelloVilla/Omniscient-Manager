package application.model;

import java.util.Date;

public class Note {
	private String id;
	private String title;
	private String content;
	private Date creationDate;
	
	public Note(Date creationDate, String title, String content) {
		this.creationDate = creationDate;
		this.title = title;
		this.content = content;
		
	}
	public String getTitle() {
		return this.title;
	}
	public String getContent() {
		return this.content;
	}
	public Date getCreationDate() {
		return this.creationDate;
	}

}
