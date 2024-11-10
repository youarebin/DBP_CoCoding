package model.dto;

public class BookManagementDTO {
	private int bookId;
	private int adminId;
	private String notes;
	private String status;
	private String addedDate;
	private String lastUpdate;

	public BookManagementDTO() {}

	public BookManagementDTO(int bookId, int adminId, String notes, String status, String addedDate, String lastUpdate) {
		this.bookId = bookId;
		this.adminId = adminId;
		this.notes = notes;
		this.status = status;
		this.addedDate = addedDate;
		this.lastUpdate = lastUpdate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}