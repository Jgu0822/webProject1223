package org.project.dto1223;

public class MemberDto {
	
	private String userId;
	private String userPw;
	private String gender;
	private String hobbys;
	private String city;
	private String memo;
	
	public MemberDto(String userId, String userPw, String gender, String hobbys, String city, String memo) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.gender = gender;
		this.hobbys = hobbys;
		this.city = city;
		this.memo = memo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobbys() {
		return hobbys;
	}

	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}
