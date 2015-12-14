package com.bigsavings.deals.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320721119905335143L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COMMENT_ID", unique = true, nullable = false)
	private Long commentId;
	
	@Column(name = "COMMENT_DESC", unique = true, nullable = false)
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMENT_POSTED_DATE", unique = false, nullable = false)
	private Date postedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEAL_ID", nullable = false)
	private Deal deal;
	
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@XmlTransient
	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

}
