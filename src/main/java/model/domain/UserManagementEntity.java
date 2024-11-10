package model.domain;

public class UserManagementEntity {
	private int adminId;
	private int customerId;
	private String role;
	private String status;
	private String notes;
	private String lastUpdate;
	
	public UserManagementEntity() {}

	public UserManagementEntity(int adminId, int customerId, String role, String status, String notes, String lastUpdate) {
		this.adminId = adminId;
		this.customerId = customerId;
		this.role = role;
		this.status = status;
		this.notes = notes;
		this.lastUpdate = lastUpdate;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}	
}