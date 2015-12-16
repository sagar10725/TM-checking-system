package edu.mum.tmsystem.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String studentId;
/*	@NotEmpty(message="Year should not be an empty field")
	@Size(min=4,max=4,message="{Size.student.year.validation}")*/
	private Integer entryYear;
	@NotEmpty @Size(min=3, max=9, message= "{Size.student.month.validation}")
	private String entryMonth;

	@OneToOne
	@JoinColumn(name = "user_id")
	@Valid
	private User user;

	@OneToMany(mappedBy = "signUpBy", cascade = CascadeType.ALL)
	private Set<CheckingHours> checkingHours;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<TMHistory> tmHistories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(Integer entryYear) {
		this.entryYear = entryYear;
	}

	public String getEntryMonth() {
		return entryMonth;
	}

	public void setEntryMonth(String entryMonth) {
		this.entryMonth = entryMonth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CheckingHours> getCheckingHours() {
		return checkingHours;
	}

	public void setCheckingHours(Set<CheckingHours> checkingHours) {
		this.checkingHours = checkingHours;
	}

	public Set<TMHistory> getTmHistories() {
		return tmHistories;
	}

	public void setTmHistories(Set<TMHistory> tmHistories) {
		this.tmHistories = tmHistories;
	}

}
