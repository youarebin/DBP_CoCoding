package model.domain;

public class UserEntity {
	private String password;
	private String name;
	private String email;
	private String nickname;
	private String account;
	private String phoneNumber;
	private String profileImage;
	
	public UserEntity() { }
	
	public UserEntity(String password, String name, String email, String nickname, String account, String phoneNumber, String profileImage) {
		this.password =password;
		this.email = email;
		this.nickname = nickname;
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.profileImage = profileImage;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}