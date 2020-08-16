package com.tig.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="METADATA")
public class Metadata {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="CORD_UID")
	private String cordId;
	@Column(name="TITLE")
	private String title;
	@Column(name="PMCID")
	private String pmcId;
	@Column(name="ABSTRACT")	
	private String _abstract;
	@Column(name="NEW_PUBLISH_DATE")
	private Date publishTime;
	@Column(name="AUTHORS")
	private String authors;
	@Column(name="URL")
	private String url;
	public Metadata(long id, String cordId, String title, String pmcId, String _abstract, Date publishTime,
			String authors, String url) {
		super();
		this.id = id;
		this.cordId = cordId;
		this.title = title;
		this.pmcId = pmcId;
		this._abstract = _abstract;
		this.publishTime = publishTime;
		this.authors = authors;
		this.url = url;
	}
	public Metadata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCordId() {
		return cordId;
	}
	public void setCordId(String cordId) {
		this.cordId = cordId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPmcId() {
		return pmcId;
	}
	public void setPmcId(String pmcId) {
		this.pmcId = pmcId;
	}
	public String get_abstract() {
		return _abstract;
	}
	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
			
		
}
