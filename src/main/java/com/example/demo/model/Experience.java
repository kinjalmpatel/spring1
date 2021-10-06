package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "experience")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;

	@Column(name = "company_name")
	private String companyname;

	@Column(name = "experience_in_years")
	private String experienceinyears;

	@Column(name = "position")
	private String position;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "exp_id")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private Employee employees;

	public long getId() {
		return eid;
	}

	public void setId(long eid) {
		this.eid = eid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getExperienceinyears() {
		return experienceinyears;
	}

	public void setExperienceinyears(String experienceinyears) {
		this.experienceinyears = experienceinyears;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Experience [eid=");
		builder.append(eid);
		builder.append(", companyname=");
		builder.append(companyname);
		builder.append(", experienceinyears=");
		builder.append(experienceinyears);
		builder.append(", position=");
		builder.append(position);
		builder.append(", employees=");
		builder.append(employees);
		builder.append("]");
		return builder.toString();
	}

	public Experience(long eid, String companyname, String experienceinyears, String position, Employee employees) {
		super();
		this.eid = eid;
		this.companyname = companyname;
		this.experienceinyears = experienceinyears;
		this.position = position;
		this.employees = employees;
	}
	
	public Experience() {}
}
