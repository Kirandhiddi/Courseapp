package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String cdescription;
	private LocalDate created_time;
	private LocalDate updated_time;
	private String author;

	public enum skilllevel {
		Beginner, Intermediate, Advanced;
	}

	public Course(int cid, String cname, String cdescription, LocalDate created_time, LocalDate updated_time,
			String author) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdescription = cdescription;
		this.created_time = created_time;
		this.updated_time = updated_time;
		this.author = author;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "course")
	private Set<User> users;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="course")
	private Set<Topic> topics;


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public LocalDate getCreated_time() {
		return created_time;
	}

	public void setCreated_time(LocalDate created_time) {
		this.created_time = created_time;
	}

	public LocalDate getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(LocalDate updated_time) {
		this.updated_time = updated_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((cdescription == null) ? 0 : cdescription.hashCode());
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((created_time == null) ? 0 : created_time.hashCode());
		result = prime * result + ((updated_time == null) ? 0 : updated_time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (cdescription == null) {
			if (other.cdescription != null)
				return false;
		} else if (!cdescription.equals(other.cdescription))
			return false;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (updated_time == null) {
			if (other.updated_time != null)
				return false;
		} else if (!updated_time.equals(other.updated_time))
			return false;
		return true;
	}

}
