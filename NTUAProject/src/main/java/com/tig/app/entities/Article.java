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
@Table(name="ARTICLES")
public class Article {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="ARTICLEID")
	private String articleId;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHORNAME")
	private String authorName;
	@Column(name="PUBLISHDATE")
	private Date timestamp;
	@Column(name="SITELINK")
	private String siteLink;
	@Column(name="SEARCHINDEX")
	private int searchIndex;
	
	
	public Article() {
		
	}

	public Article(Integer id, String articleId, String title, String authorName, Date timestamp, String siteLink, int searchIndex) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.title = title;
		this.authorName = authorName;
		this.timestamp = timestamp;
		this.siteLink = siteLink;
		this.searchIndex = searchIndex;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSiteLink() {
		return siteLink;
	}

	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}

	public int getSearchIndex() {
		return searchIndex;
	}

	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}

}