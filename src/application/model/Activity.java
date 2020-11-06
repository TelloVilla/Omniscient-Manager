package application.model;

import java.util.Date;

public class Activity extends Note{
	private Date beginDate;
	private Date endDate;
	

	public Activity(Date creationDate, String title, String content, Date beginDate, Date endDate) {
		super(creationDate, title, content);
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public Date getBeginDate() {
		return this.beginDate;
	}
	public Date getEndDate() {
		return this.endDate;
	}

}
