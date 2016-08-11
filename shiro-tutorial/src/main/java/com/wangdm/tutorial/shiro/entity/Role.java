package com.wangdm.tutorial.shiro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{
    
    private static final long serialVersionUID = 6650065305311471444L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private Long id;
    
    @Column(name="name", nullable=false, length=20)
    private String name;
    
    @Column(name="description", length=200)
    private String desc;
    
}
