package global.testingsystem.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javassist.tools.framedump;

@Entity
@Table(name="job")
public class Job {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "job_id")
private int jobId;

@Column(name="job_title",columnDefinition = "nvarchar(200)",nullable = false)
private String jobTitle;

@Column(name ="salary",columnDefinition = "varchar(100)",nullable = false)
private String salary;

@Column(name="decription",columnDefinition = "text",nullable = false)
private String desciption;

@Column (name="requitment",columnDefinition = "text",nullable = false)
private String requitment;

@Column (name="created",columnDefinition = "datetime",nullable = false)
private Date created;

@Column(name="status",columnDefinition = "INT(11) default 0" )
private int status; 
//@OneToMany(mappedBy = "job",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//private Set<Welfare> welfare_job;


@ManyToOne
@JoinColumn(name = "welfare_id")
private Welfare welfare;

@OneToMany(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<CV> job_cv;
public Job() {
	// TODO Auto-generated constructor stub
}

public int getJobId() {
	return jobId;
}

public void setJobId(int jobId) {
	this.jobId = jobId;
}

public String getJobTitle() {
	return jobTitle;
}

public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

public String getSalary() {
	return salary;
}

public void setSalary(String salary) {
	this.salary = salary;
}

public String getDesciption() {
	return desciption;
}

public void setDesciption(String desciption) {
	this.desciption = desciption;
}

public String getRequitment() {
	return requitment;
}

public void setRequitment(String requitment) {
	this.requitment = requitment;
}

public Date getCreated() {
	return created;
}

public void setCreated(Date created) {
	this.created = created;
}

public int isStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public Welfare getWelfare() {
	return welfare;
}

public void setWelfare(Welfare welfare) {
	this.welfare = welfare;
}








}


