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
@Table(name="welfare")

public class Welfare {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "welfare_id" ,columnDefinition = "int", nullable = false)
private int welfareId;

@Column(name = "desciption",columnDefinition ="text" ,nullable = false)
private String desciption;

@Column(name ="createdDate",columnDefinition = "DateTime")
private Date createdDate;

@Column(name="status",columnDefinition = "INT(11) default 0")
private int status;

@Column(name="changeDate",columnDefinition = "DateTime")
private Date changeDate;

@OneToMany(mappedBy = "welfare",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
private Set<Job> welfare_job;

public Welfare() {
	// TODO Auto-generated constructor stub
}

public int getWelfareId() {
	return welfareId;
}

public void setWelfareId(int welfareId) {
	this.welfareId = welfareId;
}

public String getDesciption() {
	return desciption;
}

public void setDesciption(String desciption) {
	this.desciption = desciption;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public int isStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public Date getChangeDate() {
	return changeDate;
}

public void setChangeDate(Date changeDate) {
	this.changeDate = changeDate;
}

public int getStatus() {
	return status;
}

public Welfare(int welfareId, String desciption, Date createdDate, int status, Date changeDate) {
	super();
	this.welfareId = welfareId;
	this.desciption = desciption;
	this.createdDate = createdDate;
	this.status = status;
	this.changeDate = changeDate;
}




}




