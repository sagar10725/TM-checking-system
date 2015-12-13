package edu.mum.tmsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String studentId;
	private Integer entryYear;
	private String entryMonth;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	/*@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", entryYear=" + entryYear + ", entryMonth="
				+ entryMonth + ", user=" + user + "]";
	}*/
	
	

}
