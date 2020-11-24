package main.model.cookie;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import main.model.user.User;

@Entity
public class CookieDetails implements Persistable<Integer> {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int cookieId;
	private Date startDate;
	private Date endDate;
	@Transient
	private boolean isNew = true;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userEmail")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCookieId() {
		return cookieId;
	}
	
	public void setCookieId(int cookieId) {
		this.cookieId = cookieId;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getId() {
		return this.cookieId;
	}

	public boolean isNew() {
		return this.isNew;
	}
	
	@PrePersist
	@PostLoad
	public void markNotNew() {
		this.isNew = false;
	}
	
}
