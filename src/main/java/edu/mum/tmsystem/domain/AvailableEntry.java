package edu.mum.tmsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mum.tmsystem.enums.CheckingType;

@Entity
@Table(name="available_entry")
public class AvailableEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CheckingType checkingType;
	
	@OneToOne
	@JoinColumn(name="tm_checker_id")
	private TMChecker addedBy;
	
	@OneToOne
	@JoinColumn(name="room_id")
	private Room room;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CheckingType getCheckingType() {
		return checkingType;
	}

	public void setCheckingType(CheckingType checkingType) {
		this.checkingType = checkingType;
	}

	public TMChecker getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(TMChecker addedBy) {
		this.addedBy = addedBy;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
