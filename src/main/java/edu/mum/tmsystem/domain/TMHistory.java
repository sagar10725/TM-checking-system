package edu.mum.tmsystem.domain;

import java.util.Date;

import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.TMStatusType;

public class TMHistory {
	private Integer id;
	private Date signUpDate;
	private Date checkedDate;
	private TMStatusType status;
	private CheckingType checkingType;
	private TMChecker checkedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public Date getCheckedDate() {
		return checkedDate;
	}

	public void setCheckedDate(Date checkedDate) {
		this.checkedDate = checkedDate;
	}

	public TMStatusType getStatus() {
		return status;
	}

	public void setStatus(TMStatusType status) {
		this.status = status;
	}

	public CheckingType getCheckingType() {
		return checkingType;
	}

	public void setCheckingType(CheckingType checkingType) {
		this.checkingType = checkingType;
	}

	public TMChecker getCheckedBy() {
		return checkedBy;
	}

	public void setCheckedBy(TMChecker checkedBy) {
		this.checkedBy = checkedBy;
	}

}
