package com.wangdm.tutorial.shiro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
    
    private static final long serialVersionUID = -2373734406726264823L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private Long id;
    
    @Column(name="username", nullable=false, unique=true, length=40)
    private String username;

    @Column(name="password", nullable=false, length=40)
    private String password;

}
