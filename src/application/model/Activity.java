package application.model;

import java.time.LocalDate;
/**
 * Class representing the Activity object
 * @author quw884
 *
 */
public class Activity extends Note{
	private LocalDate beginDate;
	private LocalDate endDate;
	
	/**
	 * Constructor: Take in 5 strings and 2 LocalDate of information
	 * @param creationDate
	 * @param title
	 * @param content
	 * @param ownerName
	 * @param projectName
	 * @param beginDate
	 * @param endDate
	 */
	public Activity(LocalDate creationDate, String title, String content, String ownerName, String projectName, LocalDate beginDate, LocalDate endDate) {
		super(creationDate, title, content, ownerName, projectName);
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	/**
	 * Gets the begin date
	 * @return LocalDate beginning date
	 */
	public LocalDate getBeginDate() {
		return this.beginDate;
	}
	/**
	 * Gets the end date
	 * @return LocalDate ending date
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}
	/**
	 * Gets Activity info in string format
	 * @return String activity info
	 */
	@Override
	public String toString() {
		return this.getTitle() + " : " + this.getBeginDate() + " - " + this.getEndDate();
	}

}
