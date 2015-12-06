package edu.mum.tmsystem.domain;

import edu.mum.tmsystem.enums.CheckingType;

public class AvailableEntry {
	private Integer id;
	private CheckingType checkingType;
	private TMChecker addedBy;
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
