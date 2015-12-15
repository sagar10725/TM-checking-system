package edu.mum.tmsystem.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CheckingHours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM/dd/yyyy hh:mm a")
	private Date checkingDate;

	@ManyToOne
	@JoinColumn(name = "available_entry_id")
	private AvailableEntry availableEntry;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student signUpBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCheckingDate() {
		return checkingDate;
	}

	public void setCheckingDate(Date checkingDate) {
		this.checkingDate = checkingDate;
	}

	public AvailableEntry getAvailableEntry() {
		return availableEntry;
	}

	public void setAvailableEntry(AvailableEntry availableEntry) {
		this.availableEntry = availableEntry;
	}

}
