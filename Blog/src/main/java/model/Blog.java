package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "blog")
public class Blog {
	
	private Integer blogid;
	private String title;
	private String content;
	private Date date;
	private User user;
	
	@Id
	@GeneratedValue
	public Integer getBlogid() {
		return blogid;
	}
	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Lob
	@Column(name="content", columnDefinition="CLOB", nullable=true)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne
	@JoinColumn(name="userid",referencedColumnName="userid")
	public User getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
