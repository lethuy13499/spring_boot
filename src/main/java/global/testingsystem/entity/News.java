/**
 * 
 */
package global.testingsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author User
 *
 */
@Entity
@Table(name = "news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int newsId;

	@Column(name = "title")
	private String title;

	@Column(name = "theDescription")
	private String description;

	@Column(name = "content")
	private String content;

	@Column(name = "createDate", columnDefinition = "DateTime")
	private Date createDate;

	@Column(name = "confirmDate",columnDefinition = "DateTime")
	private Date confirmDate;

	@Column(name = "pinned", columnDefinition = "INT(11) default 0")
	private boolean pinned;

	@Column(name = "activeStatus", columnDefinition = "INT(11) default 1")
	private boolean active;

	@Column(name = "upStatus",columnDefinition = "VARCHAR(255) default 'pending'")
	private String upStatus;
	
	@Column(name = "imgUrl")
	private String imgUrl;
//	@Column(name = "IsShow")
//	private boolean show;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="creator", referencedColumnName = "id")
	private Users users_creator;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="confirmLeader", referencedColumnName = "id")
	private Users users_confirm;
	
		
	//Mr Duc



	public Users getUsers_creator() {
		return users_creator;
	}


	public void setUsers_creator(Users users_creator) {
		this.users_creator = users_creator;
	}


	public Users getUsers_confirm() {
		return users_confirm;
	}


	public void setUsers_confirm(Users users_confirm) {
		this.users_confirm = users_confirm;
	}

	public News() {
		super();
	}

	
	public int getNewsId() {
		return newsId;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUpStatus() {
		return upStatus;
	}

	public void setUpStatus(String upStatus) {
		this.upStatus = upStatus;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public JSONObject convertToJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", newsId + "");
		obj.put("title", title + "");
		obj.put("description", description + "");
		obj.put("content", content + "");
		obj.put("createDate", createDate + "");
		obj.put("confirmDate", (null != confirmDate ? confirmDate : "") + "");
		obj.put("pinned", pinned + "");
		obj.put("upStatus", upStatus + "");
		obj.put("activeStatus", active + "");
		obj.put("creator", (null != users_creator ? users_creator.getFullname() : "") + "");
		obj.put("confirmLeader", (null != users_confirm ? users_confirm.getFullname() : "") + "");
		obj.put("linkimage",imgUrl+"" );


		return obj;
	}


	public News(String title, String description, String content, String upStatus, String imgUrl) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.upStatus = upStatus;
		this.imgUrl = imgUrl;
	}





}
