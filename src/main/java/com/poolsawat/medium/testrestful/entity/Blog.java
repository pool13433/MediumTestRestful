package com.poolsawat.medium.testrestful.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6833355522200232153L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	private String title;
	
	private String content;
	
	private String author;
	

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(Long id, String title, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + "]";
	}
	
	
}
