package application.model;

import java.time.LocalDate;

public class Activity extends Note{
	private LocalDate beginDate;
	private LocalDate endDate;
	

	public Activity(LocalDate creationDate, String title, String content, String ownerName, String projectName, LocalDate beginDate, LocalDate endDate) {
		super(creationDate, title, content, ownerName, projectName);
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public LocalDate getBeginDate() {
		return this.beginDate;
	}
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	@Override
	public String toString() {
		return this.getTitle() + " : " + this.getBeginDate() + " - " + this.getEndDate();
	}

}
