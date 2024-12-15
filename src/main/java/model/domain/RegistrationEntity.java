package model.domain;

public class RegistrationEntity {
	private int bookId;
	private int customerId;
	private String registrationDate;
	private String desiredLocation;
	private String usagePeriod;
	private String desiredPrice;
	
	public RegistrationEntity() {}
	
	public RegistrationEntity(int bookId, int customerId, String registrationDate, String desiredLocation, String usagePeriod, String desiredPrice) {
		this.bookId = bookId;
		this.customerId = customerId;
		this.registrationDate = registrationDate;
		this.desiredLocation = desiredLocation;
		this.usagePeriod = usagePeriod;
		this.desiredPrice = desiredPrice;
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
	
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDesiredLocation() {
		return desiredLocation;
	}

	public void setDesiredLocation(String desiredLocation) {
		this.desiredLocation = desiredLocation;
	}

	public String getUsagePeriod() {
		return usagePeriod;
	}

	public void setUsagePeriod(String usagePeriod) {
		this.usagePeriod = usagePeriod;
	}

	public String getDesiredPrice() {
		return desiredPrice;
	}

	public void setDesiredPrice(String desiredPrice) {
		this.desiredPrice = desiredPrice;
	}
}