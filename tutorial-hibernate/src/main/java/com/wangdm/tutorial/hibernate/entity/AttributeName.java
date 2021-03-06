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
@Table(name = "attributename")
public class AttributeName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
    private Integer id;
	
	@Column(name="name", nullable=false, length=40)
    private String name;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
    private Category category;
	
	@Column(name="idx")
	private Integer index;

}
