package application.model;

import java.time.LocalDate;
/**
 * Class representing the Note object
 * @author quw884
 *
 */
public class Note {
	private String title;
	private String content;
	private LocalDate creationDate;
	private String ownerName;
	private String projectName;
	/**
	 * Constructor: Take in LocalDate and 4 strings of info
	 * @param creationDate LocalDate of creation
	 * @param title Title of note
	 * @param content Content of note
	 * @param ownerName Owner of note
	 * @param projectName project that note is assigned
	 */
	public Note(LocalDate creationDate, String title, String content, String ownerName, String projectName) {
		this.creationDate = creationDate;
		this.title = title;
		this.content = content;
		this.ownerName = ownerName;
		this.projectName = projectName;
		
	}
	/**
	 * Get title of Note
	 * @return String title of note
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * Set title of Note
	 * @param title Title to set for Note
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Get content of Note
	 * @return Strong content of Note
	 */
	public String getContent() {
		return this.content;
	}
	/**
	 * Set content of Note
	 * @param content Content to set for Note
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Get creation date of Note
	 * @return LocalDate creation date of Note
	 */
	public LocalDate getCreationDate() {
		return this.creationDate;
	}
	/**
	 * Set creation date of Note
	 * @param creation Creation date to set for Note
	 */
	public void setCreationDate(LocalDate creation) {
		this.creationDate = creation;
	}
	/**
	 * Get owner of Note
	 * @return String name of owner of Note
	 */
	public String getOwnerName() {
		return this.ownerName;
	}
	/**
	 * Set owner of Note
	 * @param owner Owner to set for this Note
	 */
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}
	/**
	 * Get project attached to this Note
	 * @return String name of project attached to this Note
	 */
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * Set project attached to this Note
	 * @param project Project name to set for this Note
	 */
	public void setProjectName(String project) {
		this.projectName = project;
	}
	/**
	 * Get Project info in string format
	 * @returns String Project info
	 */
	@Override
	public String toString() {
		return this.content;
	}
	

}
