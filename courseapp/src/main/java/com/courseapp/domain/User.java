package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import net.minidev.json.annotate.JsonIgnore;


@Entity
@Table(name = "user")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user_name;
	private String password;
	private LocalDateTime created_datetime;
	private LocalDateTime updated_datetime;

	public User(String user_name, String password, LocalDateTime created_datetime, LocalDateTime updated_datetime) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.created_datetime = created_datetime;
		this.updated_datetime = updated_datetime;
	}

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_name"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "cid"))
	private Set<Course> courses;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(LocalDateTime created_datetime) {
		this.created_datetime = created_datetime;
	}

	public LocalDateTime getUpdated_datetime() {
		return updated_datetime;
	}

	public void setUpdated_datetime(LocalDateTime updated_datetime) {
		this.updated_datetime = updated_datetime;
	}

}
