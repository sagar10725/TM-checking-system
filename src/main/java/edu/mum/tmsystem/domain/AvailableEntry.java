package edu.mum.tmsystem.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.tmsystem.enums.CheckingType;

@Entity
@Table(name = "available_entry")
public class AvailableEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull
	private CheckingType checkingType;
	
	private Integer availableSeats;

	@OneToOne
	@JoinColumn(name = "tm_checker_id")
	private TMChecker addedBy;

	@OneToOne
	@JoinColumn(name = "room_id")
	@NotNull
	private Room room;

	@OneToMany(mappedBy = "availableEntry", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CheckingHours> checkingHours;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Future
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date checkingDate;
	
	@Transient
	@Size(min = 1, max = 10, message = "{Size.checkingTime.validation}")
	private String[] checkingTimes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CheckingType getCheckingType() {
		return checkingType;
	}

	public void setCheckingType(CheckingType checkingType) {
		this.checkingType = checkingType;
	}
	
	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
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

	public Set<CheckingHours> getCheckingHours() {
		return checkingHours;
	}

	public void setCheckingHours(Set<CheckingHours> checkingHours) {
		this.checkingHours = checkingHours;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "AvailableEntry [id=" + id + ", checkingType=" + checkingType + ", availableSeats=" + availableSeats
				+ ", addedBy=" + addedBy + ", room=" + room + ", checkingHours="
				+ (checkingHours != null ? toString(checkingHours, maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	public Date getCheckingDate() {
		return checkingDate;
	}

	public void setCheckingDate(Date checkingDate) {
		this.checkingDate = checkingDate;
	}

	public String[] getCheckingTimes() {
		return checkingTimes;
	}

	public void setCheckingTimes(String[] checkingTimes) {
		this.checkingTimes = checkingTimes;
	}

}
