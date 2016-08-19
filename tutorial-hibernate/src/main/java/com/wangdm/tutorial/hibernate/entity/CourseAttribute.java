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
@Table(name = "courseattribute")
public class CourseAttribute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
    private Integer id;

	@ManyToOne
	@JoinColumn(name="courseId")
    private Course course;

	@ManyToOne
	@JoinColumn(name="attributenameId")
    private AttributeName name;

	@ManyToOne
	@JoinColumn(name="attributevalueId")
    private AttributeValue value;
}
