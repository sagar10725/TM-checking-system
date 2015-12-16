package edu.mum.tmsystem.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.TMStatusType;

@Entity
public class TMHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date signUpDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date checkedDate;

	@Enumerated(EnumType.STRING)
	private TMStatusType status;

	@Enumerated(EnumType.STRING)
	private CheckingType checkingType;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "checkedBy")
	private TMChecker checkedBy;

	@OneToOne
	@JoinColumn(name = "checking_hour_id")
	private CheckingHours checkingHours;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

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

	public CheckingHours getCheckingHours() {
		return checkingHours;
	}

	public void setCheckingHours(CheckingHours checkingHours) {
		this.checkingHours = checkingHours;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
