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

@Entity
@Table(name = "cv")
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cv_id")
	private int cvId;

	@Column(name = "applicant_name", columnDefinition = "nvarchar(200)", nullable = false)
	private String applicantName;

	@Column(name = "email", columnDefinition = "varchar(200)", nullable = false)
	private String email;

	@Column(name = "phone", columnDefinition = "varchar(50)", nullable = false)
	private String phone;

	@Column(name = "createdDate", columnDefinition = "DateTime")
	private Date createdDate;

	@Column(name = "files", columnDefinition = "varchar(200)")
	private String files;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "status", columnDefinition = "INT(11) default 0")
	private int status;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	public CV() {
		// TODO Auto-generated constructor stub
	}

	public int getCvId() {
		return cvId;
	}

	public void setCvId(int cvId) {
		this.cvId = cvId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CV(int cvId, String applicantName, String email, String phone, Date createdDate, String files, int status) {
		super();
		this.cvId = cvId;
		this.applicantName = applicantName;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
		this.files = files;
		this.status = status;
	}

}
