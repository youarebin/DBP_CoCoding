package model.domain;

public class ApplicationEntity {
	private int bookId;
	private int customerId;
	private String applicationDate;
	private String notes;
	private String desiredLocation;
	private String proposedPrice;
	
	public ApplicationEntity() {}

	public ApplicationEntity(int bookId, int customerId, String applicationDate, String notes, String desiredLocation, String proposedPrice) {
		this.bookId = bookId;
		this.customerId = customerId;
		this.applicationDate = applicationDate;
		this.notes = notes;
		this.desiredLocation = desiredLocation;
		this.proposedPrice = proposedPrice;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDesiredLocation() {
		return desiredLocation;
	}

	public void setDesiredLocation(String desiredLocation) {
		this.desiredLocation = desiredLocation;
	}

	public String getProposedPrice() {
		return proposedPrice;
	}

	public void setProposedPrice(String proposedPrice) {
		this.proposedPrice = proposedPrice;
	}
}