package com.estsoft.guestbook.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "guestbook")
public class Guestbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "message", nullable = false)
	@Lob
	private String message;
	
	@Column(name = "passwd", nullable = false, length = 32)
	private String password;

	@Column(name = "regDate", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Column(name = "gender", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private Gender gender;
	
	public Guestbook(){		}
	
	public Guestbook(Long no, String name, String message, String password, Date regDate, Gender gender) {
		this.no = no;
		this.name = name;
		this.message = message;
		this.password = password;
		this.regDate = regDate;
		this.gender = gender;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Guestbook [no=" + no + ", name=" + name + ", message=" + message + ", password=" + password
				+ ", regDate=" + regDate + ", gender=" + gender + "]";
	}
	

	// mapping XXX
//	@Transient
//	private int temp;
	
}
