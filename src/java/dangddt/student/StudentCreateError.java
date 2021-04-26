package dangddt.student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class StudentCreateError implements Serializable{
	private String usernameLengthErr;
	private String passwordLengthErr;
	private String fullnameLengthErr;
	private String confirmNotMatch;
	private String usernameIsExisted;

	public StudentCreateError() {
	}

	public StudentCreateError(String usernameLengthErr, String passwordLengthErr, String fullnameLengthErr, String confirmNotMatch, String usernameIsExisted) {
		this.usernameLengthErr = usernameLengthErr;
		this.passwordLengthErr = passwordLengthErr;
		this.fullnameLengthErr = fullnameLengthErr;
		this.confirmNotMatch = confirmNotMatch;
		this.usernameIsExisted = usernameIsExisted;
	}

	public String getUsernameLengthErr() {
		return usernameLengthErr;
	}

	public void setUsernameLengthErr(String usernameLengthErr) {
		this.usernameLengthErr = usernameLengthErr;
	}

	public String getPasswordLengthErr() {
		return passwordLengthErr;
	}

	public void setPasswordLengthErr(String passwordLengthErr) {
		this.passwordLengthErr = passwordLengthErr;
	}

	public String getFullnameLengthErr() {
		return fullnameLengthErr;
	}

	public void setFullnameLengthErr(String fullnameLengthErr) {
		this.fullnameLengthErr = fullnameLengthErr;
	}

	public String getConfirmNotMatch() {
		return confirmNotMatch;
	}

	public void setConfirmNotMatch(String confirmNotMatch) {
		this.confirmNotMatch = confirmNotMatch;
	}

	public String getUsernameIsExisted() {
		return usernameIsExisted;
	}

	public void setUsernameIsExisted(String usernameIsExisted) {
		this.usernameIsExisted = usernameIsExisted;
	}
	
	
	
}