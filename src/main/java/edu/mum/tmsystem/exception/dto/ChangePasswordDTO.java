package edu.mum.tmsystem.exception.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordDTO {
	@NotEmpty
	private String oldpassword;
	@NotEmpty
	private String newpassword;
	@NotEmpty
	private String confirmpassword;

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
