package kr.go.seoul.democracy.member.model.vo;


public class MemberProfile {
	
	private String userId;
	private String profileName;
	private String profileFilePath;
	
	public MemberProfile(String userId, String profileName, String profileFilePath) {
		super();
		this.userId = userId;
		this.profileName = profileName;
		this.profileFilePath = profileFilePath;
	}

	public MemberProfile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberProfile [userId=" + userId + ", profileName=" + profileName + ", profileFilePath="
				+ profileFilePath + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileFilePath() {
		return profileFilePath;
	}

	public void setProfileFilePath(String profileFilePath) {
		this.profileFilePath = profileFilePath;
	}
	
   

}
