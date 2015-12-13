package edu.mum.tmsystem.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckingHours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Date checkingDate;
	private Integer availableSeats;

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

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

}
