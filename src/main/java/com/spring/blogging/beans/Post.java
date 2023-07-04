package com.spring.blogging.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "post_title")
	private String title;
	@Column(name = "post_description")
	private String about;
	
	@CreationTimestamp()
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_on;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "category_id")
	private Category category;

}
