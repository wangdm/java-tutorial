package com.wangdm.tutorial.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
    private Integer id;
	
	@Column(name="title", nullable=false, length=100)
    private String title;
	
	@ManyToOne
	@JoinColumn(name="categoryId", nullable=false)
    private Category category;

	@Column(name="status", nullable=false)
	private Integer status;

}
