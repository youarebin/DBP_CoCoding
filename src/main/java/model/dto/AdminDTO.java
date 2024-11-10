package model.dto;

public class AdminDTO {
	private String id;
	private String password;
	private String name;
	private String email;
	private String status;
	private String lastLoginTme;
	private String phoneNumber;
	private String role;
	
	public AdminDTO() {}
	
	public AdminDTO(String id, String password, String name, String email, String status, String lastLoginTme, String phoneNumber, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.status = status;
		this.lastLoginTme = lastLoginTme;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastLoginTme() {
		return lastLoginTme;
	}

	public void setLastLoginTme(String lastLoginTme) {
		this.lastLoginTme = lastLoginTme;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}