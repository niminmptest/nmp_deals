package com.bigsavings.deals.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DEAL")
@XmlRootElement(name = "Deal")
public class Deal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -155751833592666988L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DEAL_ID", unique = true, nullable = false)
	private Long dealId;
	
	@Column(name = "DEAL_TITLE", unique = true, nullable = false)
	private String title;
	
	@Column(name = "DEAL_DESC", unique = true, nullable = false)
	private String description;
	
	@Column(name = "DEAL_PRODUCT_TYPE", unique = false, nullable = false)
	private String productType;
	
	@Column(name = "DEAL_SITE_REF", unique = false, nullable = false)
	private String siteReference;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEAL_POSTED_DATE", unique = false, nullable = false)
	private Date postedDate;
	
	@Column(name = "DEAL_LIKE_COUNT", unique = false, nullable = false)
	private int likeCount;
	
	@OneToMany(targetEntity=Comment.class, mappedBy="deal", fetch = FetchType.EAGER)
	private Set<Comment> comments = new HashSet<Comment>(0);
	
	
	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
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

	
	public String getSiteReference() {
		return siteReference;
	}

	public void setSiteReference(String siteReference) {
		this.siteReference = siteReference;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
